package com.ecommerce.order.models;

import com.ecommerce.order.utils.StringListConverter;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID userId;
    @Convert(converter = StringListConverter.class)
    @Column(name = "items", nullable = false)
    private List<String> items = new ArrayList<>();
}
