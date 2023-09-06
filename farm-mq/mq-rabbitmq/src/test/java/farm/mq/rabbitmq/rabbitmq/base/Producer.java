package farm.mq.rabbitmq.rabbitmq.base;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author z2yEs
 * @create 23:54
 *
 * 生产者定义
 *
 */
public class Producer {
    // 队列名称
    public static final String QUEUE_NAME = "hello";

    // 发送消息
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.24.163");
        connectionFactory.setUsername("gust");
        connectionFactory.setPassword("gust");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String message = "hello world";

        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        System.out.println("消息发送完毕");
    }

}
