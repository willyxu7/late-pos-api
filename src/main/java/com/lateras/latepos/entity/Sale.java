package com.lateras.latepos.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Time;

@Entity
@Data
@Table(name = "sales")
public class Sale extends BaseEntity{

    @NotNull @NotEmpty @ManyToOne @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull @NotEmpty
    @Column(name = "code")
    private String code;

    @Column(name = "is_void")
    private Boolean isVoid;

    @Min(0)
    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @Min(0)
    @Column(name = "discount")
    private BigDecimal discount;

    @Min(0)
    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "note")
    private String note;

    @Column(name = "period")
    private Time period;
}
