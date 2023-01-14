package com.taivn.fraud;

import com.taivn.fraud.messagekafka.MessageDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(
        FraudCheckService fraudCheckHistoryService,
        MessageDataSource dataSource) {

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("START - Check fraud history");
        boolean isFraudCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        log.info("END - Check fraud history");
        return new FraudCheckResponse(isFraudCustomer);
    }

    @GetMapping("/message")
    public String getMessage() {
        return dataSource.getMessageList();
    }
}
