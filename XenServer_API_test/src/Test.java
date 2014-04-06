import java.net.MalformedURLException;
import java.nio.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.xmlrpc.XmlRpcException;

import com.xensource.xenapi.Host;
import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.XenAPIException;
import com.xensource.xenapi.VM;

public class Test extends SessionStatic{
	private static final int BSIZE=1024;
	public static void main(String[] arg) throws BadServerResponse, XenAPIException, XmlRpcException, MalformedURLException
	{

		String vmName =  "Lmaster";
		int unit = 1024*1024*1024;
		//vmResource.setVmMemory((long) 3*unit);
//		System.out.println("cpu "+vmResource.getVmCpu());
		VM vm = VM.getByNameLabel(con, vmName).iterator().next();
		//vm.setMemoryStaticMax(con, (long) (3*unit));
		//vm.setMemoryDynamicMin(con, (long) (2*unit));
		//vm.setMemoryDynamicMax(con, (long) (3*unit));
		//vm.setMemoryStaticMax(con, (long) (6*unit));
		//vm.setMemoryDynamicRange(con, (long) 2*unit, (long) 2*unit);
		//vm.setMemoryDynamicRange(con, (long)2*unit, (long) 3*unit);
		//vm.setMemoryTargetLive(con, (long) 3*unit);
		vm.setMemoryDynamicMax(con, (long) 4*unit);
		//vm.setMemoryStaticRange(con, (long)1*unit, (long) 4*unit);
		//vm.setMemoryTargetLive(con, (long) 1*unit);
		System.out.println("static min memory "+vm.getMemoryStaticMin(con)/unit+" dynamic min memory " + vm.getMemoryDynamicMin(con)/unit);
		System.out.println("static max memory "+vm.getMemoryStaticMax(con)/unit+" dynamic max memory " + vm.getMemoryDynamicMax(con)/unit);
		//vm.setMemoryDynamicRange(con, (long) 2*unit, (long) 2*unit);
		//vmResource.addVmMemory();
		System.out.println("current memory "+vm.getMetrics(con).getRecord(con).memoryActual/(1024*1024*1024));
		//vmResource.decVmCpu();
		//System.out.println("max cpu "+vm.getVCPUsMax(con));
		System.out.println("static max memory "+vm.getMemoryStaticMax(con)/unit+" dynamic max memory " + vm.getMemoryDynamicMax(con)/unit);
		//vm.setVCPUsMax(con, (long) 4);
	}
}
