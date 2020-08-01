package com.gordon.petStore.repository;

import com.gordon.petStore.model.PetEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 14:03
 */
@Repository
public interface PetRepository extends JpaRepository<PetEO,Integer> {

    List<PetEO> findByName(String name);

    @Transactional
    @Modifying
    @Query("update PetEO pet set pet.price = :price where  pet.name = :name")
    void updatePet(@Param("price") double price,@Param("name") String name);

    void deleteByName(String name);
}
