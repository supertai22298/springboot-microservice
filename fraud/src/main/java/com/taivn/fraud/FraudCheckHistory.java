package com.taivn.fraud;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fraud_check_histories")
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(name = "fraud_id_sequences", sequenceName = "fraud_id_sequences")
    @GeneratedValue(generator = "fraud_id_sequences", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

}
