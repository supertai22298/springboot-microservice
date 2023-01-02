package com.taivn.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO: Check if email valid
        // TODO: Check if email exist

        // Store customer in DB
        customerRepository.saveAndFlush(customer);

        // TODO: Check if fraudster
        FraudCheckResponse response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());

        if (response.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
