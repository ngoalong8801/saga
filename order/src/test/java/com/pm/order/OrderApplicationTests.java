package com.pm.order;

import com.pm.common.model.OrderR;
import com.pm.common.repository.OrderRRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderApplicationTests {

	@Autowired
	OrderRRepository orderRRepository;

	@Test
	void checkCassandraRepository() {
		OrderR orderR = new OrderR();
		orderR.setCustomerEmail("ngoalong");
		orderRRepository.save(orderR);
	}

	@Test
	void contextLoads() {
	}

}
