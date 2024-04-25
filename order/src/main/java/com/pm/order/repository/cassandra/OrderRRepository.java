package com.pm.order.repository.cassandra;

import com.pm.common.model.OrderR;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRRepository extends CassandraRepository<OrderR, Integer> {
}
