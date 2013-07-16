package activemq.test;

import org.apache.activemq.ActiveMQConnection; 
import org.apache.activemq.ActiveMQConnectionFactory; 

import javax.jms.*; 

/** 
* ��Ϣ�������ߣ������ߣ� 
* 
* @author leizhimin 2009-8-12 11:41:33 
*/ 
public class JmsReceiver { 
        public static void main(String[] args) throws JMSException { 
                // ConnectionFactory �����ӹ�����JMS ������������ 
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( 
                                ActiveMQConnection.DEFAULT_USER, 
                                ActiveMQConnection.DEFAULT_PASSWORD, 
                                "tcp://localhost:61616"); 
                //JMS �ͻ��˵�JMS Provider ������ 
                Connection connection = connectionFactory.createConnection(); 
                connection.start(); 
                // Session�� һ�����ͻ������Ϣ���߳� 
                Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); 
                // Destination ����Ϣ��Ŀ�ĵ�;��Ϣ���͸�˭. 
                // ��ȡsessionע�����ֵxingbo.xu-queue��һ����������queue��������ActiveMq��console���� 
                Destination destination = session.createQueue("my-queue"); 
                // �����ߣ���Ϣ������ 
                MessageConsumer consumer = session.createConsumer(destination); 
                while (true) { 
                        TextMessage message = (TextMessage) consumer.receive(1000); 
                        if (null != message) 
                                System.out.println("�յ���Ϣ��" + message.getText()); 
                        else 
                                break; 
                } 
                session.close(); 
                connection.close(); 
        } 
}
