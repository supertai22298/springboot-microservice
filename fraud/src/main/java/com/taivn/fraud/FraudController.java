package com.taivn.fraud;

import org.springframework.web.bind.annotation.*;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService fraudCheckHistoryService) {

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudCustomer);
    }
}
