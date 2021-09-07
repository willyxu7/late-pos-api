package com.lateras.latepos.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "customers")
public class Customer extends BaseEntity{
    @NotNull @NotEmpty
    private String name;
}
