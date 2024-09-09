package com.example.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

	
	// This method will listen / pull / subscribe to the orders topics
	// the groupId for this method is payment-group
	// Once the API called, for example we will process the payment

   @KafkaListener(topics = "orders", groupId = "payment-group")
   public void processPayment(ConsumerRecord<String, String> record) {
       String orderJson = record.value();
       // Simulate processing payment based on the order details
       System.out.println("Processing payment for order: " + orderJson);
       // Logic to process payment would go here
       // change the status of order to pending payment, send payment url to email etc
   }
}

