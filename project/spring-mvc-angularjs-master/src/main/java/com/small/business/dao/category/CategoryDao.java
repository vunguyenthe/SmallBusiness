package com.small.business.dao.category;

import java.util.List;

import com.small.business.model.category.Category;
import com.small.business.model.category.CategoryDetail;

public interface CategoryDao {

    public List<Category> getAllCategory();

    public List<CategoryDetail> getAllCategoryDetail(Long categoryId);
    
    public Category getCategoryById(Long id);
    
    public boolean addCategory(Category category);

    public boolean deleteCategoryById(Long id);

    public boolean deleteAll();

    public boolean updateCategory(Category category);

}
