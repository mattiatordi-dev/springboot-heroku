package com.example.demo;

import com.example.demo.model.test;
import com.example.demo.repository.TestRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication implements Runnable{

	public static void main(String[] args) {



		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run() {
		int i = 5;
		if(i != 1 || i != 2 || i != 3){
			System.out.println("EXCEPTION");
		}
		else System.out.println("giusto");
	}
}
