package com.lateras.latepos.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET deleted_at = now()::timestamp WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Product extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(targetEntity = Variant.class, mappedBy = "product")
    private List<Variant> variants;

    @Column(name = "description")
    private String description;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt = null;
}
