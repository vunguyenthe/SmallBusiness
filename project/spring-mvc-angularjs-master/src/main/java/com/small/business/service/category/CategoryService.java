package com.small.business.service.category;

import java.util.List;

import com.small.business.model.category.Category;
import com.small.business.model.category.CategoryDetail;


public interface CategoryService {

    public List<Category> getAllCategory();

    public List<CategoryDetail> getAllCategoryDetail(Long categoryId);
    
    public Category getCategoryById(Long id);
    
    public boolean addCategory(Category Category);

    public boolean deleteCategoryById(Long id);

    public boolean deleteAll();

    public boolean updateCategory(Category Category);
}
