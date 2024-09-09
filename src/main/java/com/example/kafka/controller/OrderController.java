package com.example.kafka.controller;

import com.example.kafka.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {


   private final KafkaTemplate<String, String> kafkaTemplate;
   private static final String TOPIC = "orders"; // topic that is going to be sent


   public OrderController(KafkaTemplate<String, String> kafkaTemplate) {
       this.kafkaTemplate = kafkaTemplate;
   }


   // When the order is called from the API
   // We will post to "orders" topic, and the message passed is orderJSON string
   // kafkaTemplate.sent(TOPIC,orderJson)
   
   @PostMapping
   public String placeOrder(@RequestBody Order order) {
       // Convert order object to JSON or any format for the Kafka message
       String orderJson = "{\"orderId\": \"" + order.getOrderId() + "\", \"product\": \"" + order.getProduct() + "\", \"quantity\": " + order.getQuantity() + "}";
       kafkaTemplate.send(TOPIC, orderJson);
       return "Order placed successfully!";
   }
}
