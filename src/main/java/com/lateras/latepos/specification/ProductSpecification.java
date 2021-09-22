package com.lateras.latepos.specification;

import com.lateras.latepos.entity.Category_;
import com.lateras.latepos.entity.Product;
import com.lateras.latepos.entity.Product_;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> nameIsLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(Product_.name), name);
        };
    }

    public static Specification<Product> categoryNameIsLike(String categoryName) {


        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder
                    .like(root.get(Product_.category).get(Category_.name), categoryName);
        };
    }
}
