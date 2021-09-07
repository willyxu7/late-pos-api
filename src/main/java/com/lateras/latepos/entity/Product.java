package com.lateras.latepos.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "products")
public class Product extends BaseEntity{
    @NotNull @NotEmpty @Size(max = 255)
    private String name;

    @NotNull @NotEmpty @ManyToOne @JoinColumn(name = "category_id")
    private Category category;

    private String description;
}
