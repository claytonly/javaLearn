package com.zly.xenserver_api;



import java.util.Iterator;

import java.util.Set;

import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;
import com.xensource.xenapi.VM;

/**
 * @author zenglingying
 * @version 创建时间：2013-7-16 上午10:08:52 类说明
 */
public class VMResource extends VMResourceConfig implements IVmCpuMod, IVmMemMod {

	private VM vm;
	
	public VMResource() {

	}

	public VMResource(String vmName) {
		try {
			vm = getVMByName(vmName);
		} catch (BadServerResponse e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XenAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static public String getVmUuid(String vmName) throws BadServerResponse,
			XenAPIException, XmlRpcException {
		Set<VM> vmSet = VM.getByNameLabel(con, vmName);

		if (vmSet.isEmpty()) {
			System.out.println("no " + vmName + "  has been found");
			return null;
		}
		if (vmSet.size() > 1) {
			System.out.println("there are more than one " + vmName + " vm!");
			return null;
		}

		for (Iterator iterator = vmSet.iterator(); iterator.hasNext();) {
			VM vm = (VM) iterator.next();
			return vm.getUuid(con);
		}
		return null;
	}


	
	static public VM getVMByUuid(String uuid) throws BadServerResponse,
			XenAPIException, XmlRpcException {
		return VM.getByUuid(con, uuid);
	}

	static public VM getVMByName(String vmName) throws BadServerResponse,
			XenAPIException, XmlRpcException {
			String uuid = getVmUuid(vmName);
			if(null == uuid)
			{
				System.out.println("not find vm name "+ vmName);
				return null;
				
			}
			return VM.getByUuid(con, uuid);
	}

	@Override
	public boolean changeVMCpu(int cores) {
		try {
			if (isCpuValid(cores))
				vm.setVCPUsNumberLive(con, (long) cores);
			else
				return false;
		} catch (BadServerResponse e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (XenAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean addVMCpu( ) throws BadServerResponse,
			XenAPIException, XmlRpcException {
		
		int newCpuCores = getVMCpu() + CPU_INCREASE_INTERVAL;
		if (isCpuValid(newCpuCores))
			return changeVMCpu(newCpuCores);
		return false;
	}

	public int getVMCpu( ) throws BadServerResponse, XenAPIException,
			XmlRpcException {
		return new Long(vm.getMetrics(con).getVCPUsNumber(con)).intValue();
	}

	@Override
	public boolean decVMCpu() throws BadServerResponse,
			XenAPIException, XmlRpcException {
		int newCpuCores = (int) getVMCpu( ) - CPU_DECREASE_INTERVAL;
		if (isCpuValid(newCpuCores))
			return changeVMCpu(newCpuCores);
		return false;
	}

	private boolean isCpuValid(long core) throws BadServerResponse,
			XenAPIException, XmlRpcException {
		if (core > vm.getVCPUsMax(con)) {
			System.out.println("core is beyond the maximum!");
			return false;
		}
		if (core < CPU_MINIMUM_CORES) {
			System.out.println("core is less than "+CPU_MINIMUM_CORES+"!");
			return false;
		}
		return true;

	}
	private boolean setCpuMax()
	{
		try {
			int maxiMum = (int) Math.ceil(vm.getResidentOn(con).getHostCPUs(con).size()*CPU_HOST_PERCENT);
			vm.setVCPUsMax(con, (long) maxiMum);
		} catch (BadServerResponse e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (XenAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean isMemoryValid(long memorySize)
			throws BadServerResponse, XenAPIException, XmlRpcException {
		if (memorySize > vm.getMemoryStaticMax(con)) {
			System.out.println("memory size "+ memorySize + " "+vm.getMemoryDynamicMax(con));
			System.out.println("beyond the maximum memorySize");
			return false;
		}
		if (memorySize < vm.getMemoryStaticMin(con)) {
			System.out.println("less than the minimum memorySize");
			return false;
		}
		return true;
	}

	@Override
	public Long getVMMemory() throws BadServerResponse,
			XenAPIException, XmlRpcException {
		return vm.getMetrics(con).getMemoryActual(con);
	}

	@Override
	public boolean setVMMemory(long memorySize)
			throws BadServerResponse, XenAPIException, XmlRpcException {
		if (isMemoryValid(memorySize))
			vm.setMemoryDynamicRange(con, (long) memorySize, (long) memorySize);
			//vm.setMemoryTargetLive(con, memorySize);
		return true;
	}

	@Override
	public boolean addVMMemory( )
			throws BadServerResponse, XenAPIException, XmlRpcException {
		long memorySize = getVMMemory() + MEMORY_INCREASE_INTERVAL;
		if (isMemoryValid(memorySize))
			return setVMMemory(memorySize);
		return false;
	}

	@Override
	public boolean decVMMemory()
			throws BadServerResponse, XenAPIException, XmlRpcException {
		long memorySize = getVMMemory() - MEMORY_DECREASE_INTERVAL;
		if (isMemoryValid(memorySize))
			return setVMMemory(memorySize);
		return false;
	}

	public VM getVm() {
		return vm;
	}

	public void setVm(VM vm) {
		this.vm = vm;
	}
}
