import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.*;
import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;

//map vm to host where vm is resident
public class VmToHost {
	private Connection con;
//constructor
	//default master is 192.168.100.11
	VmToHost() throws MalformedURLException
	{
		    con = SessionStatic.con;
	}
	//specify master
	VmToHost(String master) throws MalformedURLException
	{
	    String targetHost=master;
	    con = new Connection(new URL("http://"+targetHost));
	}
	
//map vm to host,assure there are no same name_labeld vms in the cluster	
	//local host vm
	public String localToHost() throws IOException, XmlRpcException
	{
		 String localhostName = InetAddress.getLocalHost().getHostName();
		 Set<Host> hosts = Host.getByNameLabel(con, localhostName);
		 if ( hosts.size() != 1){
			 if (hosts.size() == 1)
				 System.out.printf("There are more than one %s vm in the cluster", localhostName);
			 else 
				 System.out.printf("Error:No %s vms", localhostName);
			 return null;
		 }
		 else 
			 return vmToHost(hosts.iterator().next().getUuid(con));
	}
	//arbitrary vm
	public String vmToHost(String vmUuid) 
			throws MalformedURLException, BadServerResponse, XenAPIException, XmlRpcException 
	{
	    String vmCheck = vmUuid;
	    
	    Session.loginWithPassword(con,"root","123",APIVersion.latest().toString());
	    VM vm = VM.getByUuid(con,vmCheck);
	    
	    Host host;
	    host = vm.getResidentOn(con);
	    String vmHost = vmCheck +" "+ host.getHostname(con)+" "+host.getAddress(con);

	    Session.logout(con);
	    return vmHost;
	}
	
}
