package com.lateras.latepos.repository;

import com.lateras.latepos.entity.Category;
import com.lateras.latepos.respository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@SpringBootTest
//@Sql(scripts = "/sql/delete-categories.sql")
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void insertCategoryTest() {
        Category category = new Category();
        category.setName("Kopi");
        category.setDescription("Insert Kopi Test");
        Assertions.assertNull(category.getId());
        categoryRepository.save(category);

        System.out.println("Nama: " + category.getName());
        System.out.println("Deskripsi: " + category.getDescription());

        Assertions.assertNotNull(category.getId());
        Assertions.assertNotNull(category.getName());
        Assertions.assertNotNull(category.getCreatedAt());
        Assertions.assertNotNull(category.getCreatedBy());
        Assertions.assertNotNull(category.getUpdatedAt());
        Assertions.assertNotNull(category.getUpdatedBy());
    }

    @Test
    public void deleteCategoryTest()
    {
        Optional deleted = categoryRepository.findById("5eef1700-bf67-4825-a5b0-7acdb35acbdd")
                .map(Category::getId);
        categoryRepository.deleteById("5eef1700-bf67-4825-a5b0-7acdb35acbdd");
        Assertions.assertNotNull(deleted);
    }
}
