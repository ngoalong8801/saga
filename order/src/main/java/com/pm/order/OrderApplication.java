package com.pm.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication(scanBasePackages = {"com.pm.common", "com.pm.order", "com.pm.common.model"})
@EnableCassandraRepositories(
		basePackages = "com.pm.order.repository.cassandra")
@EntityScan(basePackages = {"com.pm.common.model", "com.pm.order.entity"})
public class OrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
