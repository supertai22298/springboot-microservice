package com.taivn.customer;

import com.taivn.customer.messagekafka.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MessageProducer messageProducer;

//    @Value("${title}") // This get from config server
    String title = "title";

    @PostMapping
    public String registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("START - New customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
        log.info("End - New customer registration\n");
        return "Register successful";
    }

    @GetMapping
    public List<Customer> getTitle() {
        return customerService.findAll();
    }

    @GetMapping("/messages/{message}")
    public String sendKafkaMessage(@PathVariable("message") String message) {
        messageProducer.sendMessage(message);
        return "SEND MESSAGE SUCCESSFUL";
    }

}
