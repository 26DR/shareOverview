package com.company.shareoverview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShareoverviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareoverviewApplication.class, args);
	}

}
