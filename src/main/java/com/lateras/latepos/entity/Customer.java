package com.lateras.latepos.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "customers")
@SQLDelete(sql = "UPDATE customers SET deleted_at = now()::timestamp WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Customer extends BaseEntity{
    @NotNull @NotEmpty
    private String name;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt = null;
}
