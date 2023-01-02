package com.taivn.fraud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService fraudCheckHistoryService) {

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("START - Check fraud history");
        boolean isFraudCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        log.info("END - Check fraud history");
        return new FraudCheckResponse(isFraudCustomer);
    }
}
