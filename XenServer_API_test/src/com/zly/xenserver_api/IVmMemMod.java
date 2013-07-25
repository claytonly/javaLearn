package com.zly.xenserver_api;


import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;

/**
 * @author zenglingying
 * @version 创建时间：2013-7-16 上午10:35:47
 * 修改虚拟机内存
 */
public interface IVmMemMod {
	
	
	/**
	 * 获取当前虚拟机的内存空间
	 * @param vmUuid
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public Long getVMMemory( ) throws BadServerResponse, XenAPIException, XmlRpcException;

	/**
	 * 设置虚拟机的内存大小，以兆为单位
	 * @param vmUuid
	 * @param memorySize
	 * 需要设置的值
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean setVMMemory(long memorySize) throws BadServerResponse, XenAPIException, XmlRpcException;
	/**
	 * 增加虚拟机的内存
	 * @param vmUuid
	 * @param addMemorySize
	 * 增加的幅度
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean addVMMemory() throws BadServerResponse, XenAPIException, XmlRpcException;
	/**
	 * 减少虚拟机的内存大小
	 * @param vmUuid
	 * @param decMeomorySize
	 * 减少的幅度
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean decVMMemory() throws BadServerResponse, XenAPIException, XmlRpcException;

}
