package com.taivn.customer;

import org.springframework.stereotype.Service;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO: Check if email valid
        // TODO: Check if email exist

        // Store customer in DB
        customerRepository.save(customer);
    }
}
