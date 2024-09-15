package com.ecommerce.order.dtos;

import java.util.List;
import java.util.UUID;

public record OrderRecordDto(UUID userId,
                             List<String> items) {
}
