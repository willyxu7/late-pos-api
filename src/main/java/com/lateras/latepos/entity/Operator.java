package com.lateras.latepos.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "operators")
public class Operator extends BaseEntity{

    @NotNull @NotEmpty
    @Column(name = "name")
    private String name;

    @NotNull @NotEmpty
    @Column(name = "email")
    private String email;

    @NotNull @NotEmpty
    @Column(name = "password")
    private String password;

    @NotNull @NotEmpty @Min(6) @Max(6)
    @Column(name = "pin")
    private Integer pin;

}
