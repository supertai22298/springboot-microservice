package com.taivn.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tai VN
 * @date 1/2/2023
 */
@FeignClient(name = "FRAUD-SERVICE")
public interface FraudClient {
    @RequestMapping("/api/v1/fraud-check/{customerId}")
    FraudCheckResponse checkFraud(@PathVariable("customerId") Integer customerId);
}
