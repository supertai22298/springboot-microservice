package com.taivn.customer;

/**
 * @author Tai VN
 * @date 1/1/2023
 */
public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
