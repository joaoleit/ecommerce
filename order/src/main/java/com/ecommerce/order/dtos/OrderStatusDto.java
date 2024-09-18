package com.ecommerce.order.dtos;

import jakarta.validation.constraints.NotEmpty;

public record OrderStatusDto(@NotEmpty String status) {
}
