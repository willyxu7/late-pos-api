package com.lateras.latepos.respository;

import com.lateras.latepos.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariantRepository extends JpaRepository<Variant, String> {

    List<Variant> findAllByProductId(String productId);

}
