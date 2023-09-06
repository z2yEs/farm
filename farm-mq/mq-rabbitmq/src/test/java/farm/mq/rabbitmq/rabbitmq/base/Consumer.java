package farm.mq.rabbitmq.rabbitmq.base;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author z2yEs
 * @create 0:14
 */
public class Consumer {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.24.163");
        connectionFactory.setUsername("gust");
        connectionFactory.setPassword("gust");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        // 接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));
        };

        // 取消消息
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费中断");
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback,cancelCallback);

    }

}
