package com.gordon.petStore.repository;

import com.gordon.petStore.model.UserEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 19:32
 */
@Repository
public interface UserRepository extends JpaRepository<UserEO,Integer> {

}
