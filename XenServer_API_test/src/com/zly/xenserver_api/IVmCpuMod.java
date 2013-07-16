package com.zly.xenserver_api;

import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;

/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-7-16 ����10:31:39
 * ��˵��
 */
public interface IVmCpuMod {
	/**
	 * �ı��������cpu
	 * @param vmUuid
	 * @param cores
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean changeVmCpu(int cores) throws BadServerResponse, XenAPIException, XmlRpcException;
	/**
	 * �����������cpu
	 * @param vmUuid
	 * @param core
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean addVmCpu( ) throws BadServerResponse, XenAPIException, XmlRpcException;
	/**
	 * �����������cpu
	 * @param vmUuuid
	 * @param core
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean decVmCpu( ) throws BadServerResponse, XenAPIException, XmlRpcException;
}
