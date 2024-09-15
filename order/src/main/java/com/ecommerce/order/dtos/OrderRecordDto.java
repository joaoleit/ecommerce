package com.ecommerce.order.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record OrderRecordDto(@NotNull UUID userId,
                             @NotNull @NotEmpty List<@NotBlank String> items) {
}
