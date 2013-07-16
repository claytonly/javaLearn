import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;


import com.xensource.xenapi.*;
import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.SessionAuthenticationFailed;
import com.xensource.xenapi.Types.XenAPIException;

public class SessionStatic {
	static public Connection con;
	static{

		try {
			con = new Connection(new URL("http://"+"Lmaster"));
			try {
				Session.loginWithPassword(con, "root", "123", "1.6");
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
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
