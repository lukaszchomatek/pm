package rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;

import domain.Car;

import java.io.IOException;

public class Recv {

  private final static String QUEUE_NAME = "hello";

  public static void main(String[] argv) throws Exception {
    
	  
	  ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          {
    	  try {
        String message = new String(body, "UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Car c = objectMapper.readValue(message, Car.class);
        System.out.println(" [x] Received '" + c + "'");
    	  }
    	  catch (IOException ioe) {
    		  System.out.println(" [x] Error while receiving message: " + ioe.getMessage());
    	  }
      }
    };
    channel.basicConsume(QUEUE_NAME, true, consumer);
  }
}