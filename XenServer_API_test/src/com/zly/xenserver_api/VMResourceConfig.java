package com.zly.xenserver_api;

/**
 * @author zenglingying
 * @version 创建时间：2013-7-17 下午2:27:02
 * 类说明
 */
abstract public class VMResourceConfig extends XenServerConfig {

	//虚拟机资源调整的幅度配置信息
		final int MEMORY_INCREASE_INTERVAL = 1*1024*1024*1024;
		final int MEMORY_DECREASE_INTERVAL = 1*1024*1024*1024;
		final int MEMORY_UNIT = 1024*1024*1024;
		final int CPU_INCREASE_INTERVAL = 1;
		final int CPU_DECREASE_INTERVAL = 1;
		final int CPU_MINIMUM_CORES = 1;
		final int MEMORY_MINIMUM_SIZE = 1*1024*1024*1024;
		final float CPU_HOST_PERCENT = (float) 0.8;//=虚拟机vcpu/主机cpu，表示能够分配的最大的cpu核数

}
