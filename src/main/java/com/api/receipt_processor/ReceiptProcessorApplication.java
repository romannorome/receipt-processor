package com.api.receipt_processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReceiptProcessorApplication {

	public static void main(String[] args) {

		/*
		 * Item Gatorade = new Item("Gatorade", 2.25);
		 * List<Item> items = new ArrayList<Item>();
		 * 
		 * items.add(Gatorade);
		 * items.add(Gatorade);
		 * items.add(Gatorade);
		 * items.add(Gatorade);
		 * 
		 * Receipt one = new Receipt("M&M Corner Market", "2022-03-20", "14:33", items,
		 * 9.00);
		 * 
		 * System.out.println(one.toString());
		 */

		SpringApplication.run(ReceiptProcessorApplication.class, args);

	}
}
