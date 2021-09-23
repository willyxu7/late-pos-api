package com.lateras.latepos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "variants")
public class Variant extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "sku")
    private String sku;

    @Column(name = "description")
    private String description;
}
