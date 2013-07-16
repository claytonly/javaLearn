package activemq.test;

import org.apache.activemq.ActiveMQConnection; 
import org.apache.activemq.ActiveMQConnectionFactory; 

import javax.jms.*; 

/** 
* ��Ϣ�������ߣ������ߣ� 
* 
* 
*/ 
public class JmsSender { 
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
                // ��ȡsessionע�����ֵmy-queue��Query������ 
                Destination destination = session.createQueue("my-queue"); 
                // MessageProducer����Ϣ������ 
                MessageProducer producer = session.createProducer(destination); 
                //���ò��־û� 
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT); 
                //����һ����Ϣ 
                sendMsg(session, producer); 
                session.commit(); 
                connection.close(); 
        } 

        /** 
         * ��ָ���ĻỰ�ϣ�ͨ��ָ������Ϣ�����߷���һ����Ϣ 
         * 
         * @param session    ��Ϣ�Ự 
         * @param producer ��Ϣ������ 
         */ 
        public static void sendMsg(Session session, MessageProducer producer) throws JMSException { 
                //����һ���ı���Ϣ 
                TextMessage message = session.createTextMessage("Hello ActiveMQ��"); 
                //ͨ����Ϣ�����߷�����Ϣ 
                producer.send(message); 
                System.out.println(""); 
        } 
}