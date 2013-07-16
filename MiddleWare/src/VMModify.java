import java.util.HashMap;
import java.util.Iterator;

import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.*;
import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;

public class VMModify {
	//modify cpu
	static boolean modifyCpu(VM vm, Connection con, long nums)
	{
		try {
			if (nums > vm.getVCPUsMax(con).longValue() || nums < 1)
			{
				System.out.println("vcpus number is illegal");
				return false;
			}
			vm.setVCPUsNumberLive(con, nums);
			
		} catch (BadServerResponse e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XenAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
		
	}
	//modify memory
	static boolean modifyMem(VM vm, Connection con, long target)
	{
		long max=0, min=0;
		try {
			max = vm.getMemoryDynamicMax(con);
			min=vm.getMemoryDynamicMin(con);
		} catch (XenAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ( target > max || target < min)
		{
			System.out.println(target+" beyond memory range ");
			return false;
		}
		try {
			vm.setMemoryDynamicRange(con, target, target);
		} catch (BadServerResponse e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XenAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	//modify vif
	static boolean modifyVif(VM vm, Connection con, long target) throws BadServerResponse, XenAPIException, XmlRpcException
	{
		Iterator<VIF> iterator = vm.getVIFs(con).iterator();
		VIF vif;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("kbps", new Long(target).toString());
		while (iterator.hasNext())
		{	vif = iterator.next();
			vif.setQosAlgorithmType(con, "ratelimit");
			vif.setQosAlgorithmParams(con,map);
		}
		return true;
	}
}
