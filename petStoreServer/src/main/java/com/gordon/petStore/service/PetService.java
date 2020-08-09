package com.gordon.petStore.service;

import com.gordon.petStore.model.PetEO;
import com.gordon.petStore.request.PetRequest;

import java.util.List;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 13:57
 */
public interface PetService {

    void addPet(PetRequest petRequest);

    void updatePet(PetRequest petRequest);

    void deletePet(PetRequest petRequest);

    List<PetEO> listPet(String category);
}
