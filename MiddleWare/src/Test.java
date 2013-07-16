import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.Connection;
import com.xensource.xenapi.Session;
import com.xensource.xenapi.VIF;
import com.xensource.xenapi.Types.VmPowerState;
import com.xensource.xenapi.VM;
import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.SessionAuthenticationFailed;
import com.xensource.xenapi.Types.XenAPIException;
import com.xensource.xenapi.VMMetrics;

public class Test {
	static URL url;
	static Connection connection;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws BadServerResponse, SessionAuthenticationFailed, XenAPIException, XmlRpcException, InterruptedException
	{
		String ServerName=new String("XenServer1");
		try {
			 url = new URL("http://"+ServerName);
			 connection = new Connection(url);
			 Session.loginWithPassword(connection, "root", "123", "1.6");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*for (Host host: Host.getAllRecords(connection).keySet())
		{
			System.out.println(host.getHostname(connection));
		}*/
	//get vm 
		VM vm = VM.getByNameLabel(connection, "Lmaster").iterator().next();
		if (vm.getPowerState(connection) == VmPowerState.HALTED){
			vm.start(connection, false, false);
		}
		if (vm.getPowerState(connection) == VmPowerState.RUNNING)
			System.out.println(vm.getNameLabel(connection)+" has been started!");
		
		VMMetrics vmmetric = vm.getMetrics(connection);
		//vmmetric.getVCPUsCPU(connection);
		System.out.println("vm cpus: "+vmmetric.getVCPUsNumber(connection));
		Map<Long,Double> util = vmmetric.getVCPUsUtilisation(connection);
	//vm cpu utilizaiton
		System.out.println("size " + util.size());
		Long key;
		Double value;
		for (Map.Entry<Long, Double> mapEntry : util.entrySet()){
			 key = mapEntry.getKey();
			 value = mapEntry.getValue();
			 System.out.println("vm cpus utilization: "+key.intValue()+" "+value.doubleValue());
		}
	//vm cpu modify
		Long vcpus = vmmetric.getVCPUsNumber(connection);
		vcpus = vcpus-1;
		//vm.setVCPUsNumberLive(connection, vcpus);
		//Thread.sleep(10);
		//System.out.println("vm cpus: "+vmmetric.getVCPUsNumber(connection));
	//vm memory modify
		long target = 1024*1024*1024;
		System.out.println(target);
		vm.setMemoryDynamicRange(connection, target, target);
		System.out.println("modified memory "+vmmetric.getMemoryActual(connection));
	//vm vif
		Iterator<VIF> iterator = vm.getVIFs(connection).iterator();
		VIF vif;
		target=100;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("limits", new Long(target).toString());
		VMModify.modifyVif(vm, connection, 2000);
	//finish
		System.out.println("finished");
	}

}
