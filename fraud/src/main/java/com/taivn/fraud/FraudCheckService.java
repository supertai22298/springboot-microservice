package com.taivn.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Service
public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
