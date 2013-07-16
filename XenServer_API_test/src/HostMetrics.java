import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.*;
import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;

public class HostMetrics {
	private Connection con = SessionStatic.con;
	private Host hostRef = null;
	
//constructor
		//default master is 192.168.100.11
		HostMetrics(Host host) throws MalformedURLException, BadServerResponse, XenAPIException, XmlRpcException
		{
			    hostRef = host;
		}
		//specify master
		HostMetrics(String master, Host host) throws MalformedURLException, BadServerResponse, XenAPIException, XmlRpcException
		{
		    String targetHost=master;
		    con = new Connection(new URL("http://"+targetHost));
		    hostRef = host;
		}
				
//metrics of host 
		//number of vm resident in the host
		public int numVMResident() throws BadServerResponse, XenAPIException, XmlRpcException
		{
			return (hostRef.getResidentVMs(con).size()-1);
		}
		//cpu metrics of host
		
		public String cpuOfHost() throws BadServerResponse, XenAPIException, XmlRpcException
		{
			Set<HostCpu> hostCpus = hostRef.getHostCPUs(con);
			String util = "";
			for (HostCpu i: hostCpus)
				util += " " + i.getUtilisation(con)+" "+i.getSpeed(con);//cpu utilizaion + speed
			return util;
			
		}
		//memory of Host
		@SuppressWarnings("deprecation")
		public String memoryOfHost() throws BadServerResponse, XenAPIException, XmlRpcException
		{
			return (hostRef.getMetrics(con).getMemoryFree(con).toString()+
					" "+hostRef.getMetrics(con).getMemoryTotal(con));
		}
		//Warning: need more modification
		//pif metrics 
		public Map<String, String> pifsOfHost() throws BadServerResponse, XenAPIException, XmlRpcException
		{
			Set<PIF> pifs = hostRef.getPIFs(con);
			String pifMetrics;
			Map<String, String> pifMap = new HashMap<String, String>();
			String pifUuid;
			for (PIF i: pifs){
				pifMetrics = pifOfHost(i);
				pifUuid = i.getUuid(con).toString();
				pifMap.put(pifUuid, pifMetrics);
			}
			return pifMap;
			
		}
		public String pifOfHost(PIF pifRef) throws BadServerResponse, XenAPIException, XmlRpcException
		{

				return (pifRef.getMetrics(con).getIoReadKbs(con).toString()+" "
						+pifRef.getMetrics(con).getIoWriteKbs(con));
		}

}
