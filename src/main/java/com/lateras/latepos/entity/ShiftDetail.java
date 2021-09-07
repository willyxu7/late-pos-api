package com.lateras.latepos.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "shift_details")
public class ShiftDetail extends BaseEntity {

    @NotNull @NotEmpty @ManyToOne @JoinColumn(name = "shift_id")
    private Shift shift;

    @Min(0) @Column(name = "balance_in")
    private BigDecimal balanceIn;

    @Min(0) @Column(name = "balance_out")
    private BigDecimal balanceOut;

    @Column(name = "description")
    private String description;

}
