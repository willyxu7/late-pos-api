package com.lateras.latepos.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "sale_order_details")
@SQLDelete(sql = "UPDATE sale_order_details SET deleted_at = now()::timestamp WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class SaleOrderDetail extends BaseEntity{

    @NotNull @NotEmpty @ManyToOne @JoinColumn(name = "sale_order_id")
    private SaleOrder saleOrder;

    @NotNull @NotEmpty @ManyToOne @JoinColumn(name = "product_id")
    private Product product;

    @Min(0)
    @Column(name = "price")
    private BigDecimal price;

    @Min(0)
    @Column(name = "quantity")
    private Integer quantity;

    @Min(0)
    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt = null;
}
