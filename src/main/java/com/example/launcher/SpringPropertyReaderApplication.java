package com.example.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPropertyReaderApplication {

	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = SpringApplication.run(SpringPropertyReaderApplication.class, args);
		
		System.out.println("------------------------------------------------");
		System.out.println("-----Printing Bean Definition Names ------------");
		System.out.println("------------------------------------------------");
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		System.out.println("------------------------------------------------");
		System.out.println("--------------------END------------------------");
		System.out.println("------------------------------------------------");
	}
}
