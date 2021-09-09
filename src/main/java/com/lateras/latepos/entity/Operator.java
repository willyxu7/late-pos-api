package com.lateras.latepos.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "operators")
@SQLDelete(sql = "UPDATE operators SET deleted_at = now()::timestamp WHERE id=?")
@Where(clause = "deleted_at IS NULL")
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


    @Column(name = "deleted_at")
    private LocalDateTime deletedAt = null;
}
