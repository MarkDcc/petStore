package com.gordon.petStore.service;

import com.gordon.petStore.model.PetEO;
import com.gordon.petStore.repository.CategoryRepository;
import com.gordon.petStore.repository.PetRepository;
import com.gordon.petStore.request.PetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 14:04
 */
@Service
public class PetServiceImpl implements PetService {
    private static final Logger log = LoggerFactory.getLogger(PetServiceImpl.class);
    @Autowired
    PetRepository petRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void addPet(PetRequest petRequest) {
        if(petRepository.findByName(petRequest.getName()).size() > 0){
            log.error("Already have this pet.");
            return;
        }
        PetEO petEO = new PetEO();
        petEO.setName(petRequest.getName());
        petEO.setPrice(Double.parseDouble(petRequest.getPrice()));
        petEO.setCategory(categoryRepository.findByName(petRequest.getCategory()).get(0));
        petRepository.save(petEO);
    }

    @Override
    public void updatePet(PetRequest petRequest) {
        //如果pet不存在则报错

        if(petRepository.findByName(petRequest.getName()).size() == 0){
            log.error("There have no pet: " + petRequest.getName());
            return;
        }
        //如果pet存在则更新,只更新价格

       petRepository.updatePet(Double.parseDouble(petRequest.getPrice()),petRequest.getName());

    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deletePet(PetRequest petRequest) {
        if(petRepository.findByName(petRequest.getName()).size() == 0){
            log.error("There have no pet: " + petRequest.getName());
            return;
        }
        petRepository.deleteByName(petRequest.getName());

    }
}
