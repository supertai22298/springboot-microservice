package com.taivn.customer;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
@Data
@Builder
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
