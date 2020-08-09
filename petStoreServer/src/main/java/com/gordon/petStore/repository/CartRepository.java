package com.gordon.petStore.repository;

import com.gordon.petStore.model.CartEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author dongchen
 * @Data 2020/8/2
 * @Time 20:02
 */
@Repository
public interface CartRepository extends JpaRepository<CartEO, Integer> {

    CartEO findByName(String name);
}
