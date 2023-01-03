package com.taivn.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Value("${title}") // This get from config server
    String title;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("START - New customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
        log.info("End - New customer registration\n");
    }

    @GetMapping
    public String getTitle() {
        return title;
    }
}
