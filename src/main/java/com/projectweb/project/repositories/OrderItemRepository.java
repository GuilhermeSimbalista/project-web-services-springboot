package com.projectweb.project.repositories;

import com.projectweb.project.entities.OrderItem;
import com.projectweb.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
