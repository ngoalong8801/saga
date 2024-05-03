package com.pm.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication(scanBasePackages = {"com.pm.common", "com.pm.inventory"})
@EnableCassandraRepositories(
		basePackages = "com.pm.common.repository")
@EntityScan(basePackages = {"com.pm.common.model", "com.pm.inventory.entity"})
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
