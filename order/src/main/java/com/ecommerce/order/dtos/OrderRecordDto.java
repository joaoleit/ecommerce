package com.ecommerce.order.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.UUID;

public record OrderRecordDto(@NotBlank UUID userId,
                             @NotBlank List<String> items) {
}
