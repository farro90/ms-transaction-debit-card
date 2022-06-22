package com.nttdata.bc19.mstransactiondebitcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsTransactionDebitCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTransactionDebitCardApplication.class, args);
	}

}
