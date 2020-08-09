package com.gordon.petStore.repository;

import com.gordon.petStore.model.CategoryEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author dongchen
 * @Data 2020/7/31
 * @Time 11:00
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEO,Integer> {

//    @Query("SELECT NEW CategoryEO FROM tb_category c WHERE c.name= :name")
    List<CategoryEO> findByName(String name);

    void deleteByName(String name);
}
