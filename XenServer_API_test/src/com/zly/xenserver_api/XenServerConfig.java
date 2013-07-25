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
 * @version 创建时间：2013-7-16 下午8:34:40
 * 类说明
 */
public class XenServerConfig {
	
//连接服务器信息
	final static String XenServerMaster="192.168.100.11";
	final static String userName="root";
	final static String password="123";
	final static String version="1.6";
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
