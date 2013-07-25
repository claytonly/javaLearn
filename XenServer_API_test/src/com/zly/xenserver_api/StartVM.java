package com.zly.xenserver_api;

import java.io.ObjectInputStream.GetField;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.Session;
import com.xensource.xenapi.Types;
import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;
import com.xensource.xenapi.VM;

/**
 * @author zeng ling ying
 * @version 创建时间：2013-7-17 下午2:24:45
 * 启动虚拟机，管理hadoop集群
 */
public class StartVM extends XenServerConfig{

	/**
	 * @param args
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	static final long MEMORY_UNIT=1024*1024;
	public static void main(String[] args) throws BadServerResponse, XenAPIException, XmlRpcException {
		// TODO Auto-generated method stub
		//startVMs(VMResource.getVMByName("Lmaster"));
		String masterName = "vmaster";
		String vmNamePrefix = "vslave";
		int clusterSize = 2;
	/*	VMResource vslave1 = new VMResource("vslave1");
		VMResource vslave2 = new VMResource("vslave2");*/
		//vslave1.setVMMemory(1024*MEMORY_UNIT);
/*		vslave1.changeVMCpu(2);
		vslave2.changeVMCpu(2);*/
		if(startLHadoop(masterName, vmNamePrefix, clusterSize))
			System.out.println("complete!");
		else
			System.out.println("not started!");
	}
	//启动hadoop集群
	static public boolean startLHadoop(String masterName,String vmNamePrefix,int clusterSize) throws BadServerResponse, XenAPIException, XmlRpcException
	{
		Set<VM> vmSet = new HashSet<VM>();
		int k;
		String VM_NAME_PREFIX=vmNamePrefix;
		String vmName;
		for(int i = 0; i < clusterSize ; i++){
			k = i+1;
			vmName = VM_NAME_PREFIX+k;
				vmSet.add(VMResource.getVMByName(vmName));
				startVMs(vmSet);
		}
	
		VM master = VMResource.getVMByName(masterName);
		master.start(con, false, false);
		System.out.println("LHadoop has been started!");
		return true;
	}
	static public boolean startVMs(VM vm)
	{
		Set vmSet = new HashSet<VM>();
		vmSet.add(vm);
		return startVMs(vmSet);
	}
	static public boolean startVMs(Set<VM> vmSet)
	{
		VM vm;
		for (Iterator iterator = vmSet.iterator(); iterator.hasNext();) {
			vm = (VM) iterator.next();
			startVM(vm);
		}
		return true;
		
	}
	static public boolean startVM(VM vm)
	{
		try {
			vm.setMemoryDynamicMax(con, vm.getMemoryStaticMax(con));
			if(vm.getPowerState(con) == Types.VmPowerState.RUNNING)
			{
				System.out.println(vm.getNameLabel(con)+" has been started already");
				return false;
			}
			vm.start(con, false, false);
			vm.setMemoryDynamicRange(con, (long)1*MEMORY_UNIT, (long)1*MEMORY_UNIT);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return true;
	}

}
