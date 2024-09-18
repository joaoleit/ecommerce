package com.ecommerce.orchestrator.dtos;

import java.util.UUID;

public record PaymentRecordDto(UUID orderId,
                               Double amount,
                               String paymentMethod) {
}
