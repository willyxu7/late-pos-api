package com.lateras.latepos.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name = "shifts")
public class Shift extends BaseEntity{

    @NotNull @NotEmpty @ManyToOne @JoinColumn(name = "operator_id")
    private Operator operator;

    @NotNull @NotEmpty @Min(0)
    @Column(name = "beginning_balance")
    private BigDecimal beginningBalance;

    @NotNull @NotEmpty @Min(0)
    @Column(name = "ending_balance")
    private BigDecimal endingBalance;

    @NotNull @NotEmpty
    @Column(name = "beginning_time")
    private Time beginningTime;

    @Column(name = "ending_time")
    private Time endingTime;

    @NotNull @NotEmpty
    @Column(name = "beginning_date")
    private Date beginningDate;

    @Column(name = "ending_date")
    private Date endingDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ShiftStatus status;
}
