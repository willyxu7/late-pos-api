package com.lateras.latepos.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "variants")
public class Variant extends BaseEntity{
    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty @ManyToOne @JoinColumn(name = "product_id")
    private Product product;

    @NotNull @NotEmpty @Min(0)
    private BigDecimal price;

    private String sku;

    private String description;
}
