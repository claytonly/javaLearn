package com.zly.xenserver_api;

import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;

/**
 * @author zenglingying
 * @version 创建时间：2013-7-16 上午10:31:39
 * 类说明
 */
public interface IVmCpuMod {
	/**
	 * 改变虚拟机的cpu
	 * @param vmUuid
	 * @param cores
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean changeVmCpu(int cores) throws BadServerResponse, XenAPIException, XmlRpcException;
	/**
	 * 增加虚拟机的cpu
	 * @param vmUuid
	 * @param core
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean addVmCpu( ) throws BadServerResponse, XenAPIException, XmlRpcException;
	/**
	 * 减少虚拟机的cpu
	 * @param vmUuuid
	 * @param core
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean decVmCpu( ) throws BadServerResponse, XenAPIException, XmlRpcException;
}
