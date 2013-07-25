package com.zly.xenserver_api;


import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;

/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-7-16 ����10:35:47
 * �޸�������ڴ�
 */
public interface IVmMemMod {
	
	
	/**
	 * ��ȡ��ǰ��������ڴ�ռ�
	 * @param vmUuid
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public Long getVMMemory( ) throws BadServerResponse, XenAPIException, XmlRpcException;

	/**
	 * ������������ڴ��С������Ϊ��λ
	 * @param vmUuid
	 * @param memorySize
	 * ��Ҫ���õ�ֵ
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean setVMMemory(long memorySize) throws BadServerResponse, XenAPIException, XmlRpcException;
	/**
	 * ������������ڴ�
	 * @param vmUuid
	 * @param addMemorySize
	 * ���ӵķ���
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean addVMMemory() throws BadServerResponse, XenAPIException, XmlRpcException;
	/**
	 * ������������ڴ��С
	 * @param vmUuid
	 * @param decMeomorySize
	 * ���ٵķ���
	 * @return
	 * @throws XmlRpcException 
	 * @throws XenAPIException 
	 * @throws BadServerResponse 
	 */
	public boolean decVMMemory() throws BadServerResponse, XenAPIException, XmlRpcException;

}
