package com.ecommerce.payment.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PaymentRecordDto(@NotNull UUID orderId,
                               @NotNull Double amount,
                               @NotEmpty String paymentMethod){
}
