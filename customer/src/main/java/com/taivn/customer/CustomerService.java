package com.taivn.customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    //    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public CustomerService(
            CustomerRepository customerRepository,
//                           RestTemplate restTemplate,
            FraudClient fraudClient) {
        this.customerRepository = customerRepository;
//        this.restTemplate = restTemplate;
        this.fraudClient = fraudClient;
    }

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

        // Check if fraudster using restTemplate
//        FraudCheckResponse response = restTemplate.getForObject(
//                "http://localhost:8081/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId());

        // Check if fraudster using feign client
        FraudCheckResponse response = fraudClient.checkFraud(customer.getId());

        if (response.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }

    @CircuitBreaker(name = "customerFindAllCB", fallbackMethod = "findAllFallback")
    public List<Customer> findAll() {
        FraudCheckResponse response = fraudClient.checkFraud(2);
        return customerRepository.findAll();
    }

    /**
     * This fallback is call when findAll function has error
     * @param e
     * @return
     */
    public List<Customer> findAllFallback(Exception e) {
        List<Customer> list = new ArrayList<>();
        list.add(Customer.builder().firstName("Something went wrong").build());
        return list;
    }
}
