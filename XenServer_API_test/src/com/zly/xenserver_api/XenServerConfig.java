package com.zly.xenserver_api;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.Connection;
import com.xensource.xenapi.Session;
import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.SessionAuthenticationFailed;
import com.xensource.xenapi.Types.XenAPIException;
import com.xensource.xenapi.XenAPIObject;

/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-7-16 ����8:34:40
 * ��˵��
 */
public class XenServerConfig {
	
//���ӷ�������Ϣ
	final static String XenServerMaster="192.168.100.11";
	final static String userName="root";
	final static String password="123";
	final static String version="1.6";
//�������Դ�����ķ���������Ϣ
	final int MEMORY_INCREASE_INTERVAL = 1*1024*1024*1024;
	final int MEMORY_DECREASE_INTERVAL = 1*1024*1024*1024;
	final int CPU_INCREASE_INTERVAL = 1;
	final int CPU_DECREASE_INTERVAL = 1;
	final int CPU_MINIMUM_CORES = 1;
	final int MEMORY_MINIMUM_SIZE = 1*1024*1024*1024;
	final float CPU_HOST_PERCENT = (float) 0.8;//=�����vcpu/����cpu����ʾ�ܹ����������cpu����
	
	static public Connection con;
	
	static {
		try {
			con = new Connection(new URL("http://"+XenServerMaster));
			Session.loginWithPassword(con, userName, password, version);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadServerResponse e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SessionAuthenticationFailed e) {
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
	

}
