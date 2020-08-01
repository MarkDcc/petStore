package com.gordon.petStore.service;

import com.gordon.petStore.exception.ResourceCanNotDelete;
import com.gordon.petStore.exception.ResourceNotFoundException;
import com.gordon.petStore.model.CategoryEO;
import com.gordon.petStore.repository.CategoryRepository;
import com.gordon.petStore.request.CategoryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author dongchen
 * @Data 2020/7/31
 * @Time 15:04
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    private static final Logger log = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void save(CategoryRequest category) throws ResourceNotFoundException {

        if(categoryRepository.findByName(category.getName()).size() > 0){
            log.error(category.getName() + " already in repo.");
            return;
        }

        CategoryEO categoryEO = new CategoryEO();
        categoryEO.setName(category.getName());
        CategoryEO parent = categoryRepository.findByName(category.getParent()).get(0);
        if (parent == null) {
            throw new ResourceNotFoundException("Need to point parent for category.");
        }
        categoryEO.setParent(parent);
        categoryRepository.save(categoryEO);

    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void delete(CategoryRequest category) throws ResourceCanNotDelete {
        //如果没有就不删除
        if(categoryRepository.findByName(category.getName()).size() == 0){
            log.error("Repo have no this category: " + category.getName());
            return;
        }

        CategoryEO categoryEO = categoryRepository.findByName(category.getName()).get(0);
        if(categoryEO.getSubCategoryEO().size() > 0 || categoryEO.getPets().size() > 0){
            throw new ResourceCanNotDelete(category.getName(),"SubCategoryEO or Pets size not zero.");
        }
        categoryRepository.deleteByName(category.getName());
    }

}
