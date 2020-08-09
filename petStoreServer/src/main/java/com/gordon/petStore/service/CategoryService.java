package com.gordon.petStore.service;

import com.gordon.petStore.exception.ResourceCanNotDelete;
import com.gordon.petStore.exception.ResourceNotFoundException;
import com.gordon.petStore.model.CategoryEO;
import com.gordon.petStore.request.CategoryRequest;

/**
 * @author dongchen
 * @Data 2020/7/31
 * @Time 15:04
 */
public interface CategoryService {

    void save(CategoryRequest category) throws ResourceNotFoundException;

    void delete(CategoryRequest category) throws ResourceCanNotDelete;

}
