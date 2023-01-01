package com.taivn.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
