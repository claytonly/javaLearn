import org.apache.activemq.ActiveMQConnection; 
import org.apache.activemq.ActiveMQConnectionFactory; 

import javax.jms.*; 
import javax.swing.Spring;

/** 
* 
* Modify vm's configuratioins
* 
*/ 
public class Master {
		private String host;//activemq server's name or ip
		Master()
		{
			host="localhost";
		}
		Master(String host)
		{
			this.host=host;
		}
	    protected static void process(TextMessage message)
	    {
	    	
	    }
        public static void main(String[] args) throws JMSException { 
                // ConnectionFactory �����ӹ�����JMS ������������ 
        		Master master=new Master("192.168.100.254");
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( 
                                ActiveMQConnection.DEFAULT_USER, 
                                ActiveMQConnection.DEFAULT_PASSWORD, 
                                "tcp://"+master.host+":61616"); 
                //JMS �ͻ��˵�JMS Provider ������ 
                Connection connection = connectionFactory.createConnection(); 
                connection.start(); 
                // Session�� һ�����ͻ������Ϣ���߳� 
                Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); 
                // Destination ����Ϣ��Ŀ�ĵ�;��Ϣ���͸�˭. 
                // ��ȡsessionע�����ֵxingbo.xu-queue��һ����������queue��������ActiveMq��console���� 
                Destination destination = session.createQueue("vm-util-queue"); 
                // �����ߣ���Ϣ������ 
                MessageConsumer consumer = session.createConsumer(destination); 
                while (true) { 
                        TextMessage message = (TextMessage) consumer.receive(1000); 
                        if (null != message) 
                                process(message) ;
                        else 
                                break; 
                } 
                session.close(); 
                connection.close(); 
        } 
}
