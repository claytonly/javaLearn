package com.zly.xenserver_api;

/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-7-17 ����2:27:02
 * ��˵��
 */
abstract public class VMResourceConfig extends XenServerConfig {

	//�������Դ�����ķ���������Ϣ
		final int MEMORY_INCREASE_INTERVAL = 1*1024*1024*1024;
		final int MEMORY_DECREASE_INTERVAL = 1*1024*1024*1024;
		final int MEMORY_UNIT = 1024*1024*1024;
		final int CPU_INCREASE_INTERVAL = 1;
		final int CPU_DECREASE_INTERVAL = 1;
		final int CPU_MINIMUM_CORES = 1;
		final int MEMORY_MINIMUM_SIZE = 1*1024*1024*1024;
		final float CPU_HOST_PERCENT = (float) 0.8;//=�����vcpu/����cpu����ʾ�ܹ����������cpu����

}
