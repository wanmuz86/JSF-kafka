package com.example.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {


	//THis method will pull for the message for orders topic
	// The groupId for this message is "inventory-group"
	// 1 inventory-group will only receive the message once
	// once it receives the message, i will show the record/ the message passed in the queue
   
	@KafkaListener(topics = "orders", groupId = "inventory-group")
   public void consumeOrder(ConsumerRecord<String, String> record) {
       String orderJson = record.value();
       // Simulate updating inventory based on the order details
       System.out.println("Updating inventory for order: " + orderJson);
       // Logic to update inventory would go here
       // eg: you will reduce the inventory by quantity
   }
}
