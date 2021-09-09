package com.lateras.latepos.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET deleted_at = now()::timestamp WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Product extends BaseEntity{
    @NotNull @NotEmpty @Size(max = 255)
    private String name;

    @NotNull @NotEmpty @ManyToOne @JoinColumn(name = "category_id")
    private Category category;

    private String description;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt = null;
}
