package com.small.business.service.category;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.category.CategoryDao;
import com.small.business.model.category.Category;
import com.small.business.model.category.CategoryDetail;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private static List<Category> categoryList = new ArrayList<Category>();

    @Autowired
    CategoryDao categoryDao;

    public List<Category> getAllCategory() {
        List<Category> categoryList = categoryDao.getAllCategory();
        return categoryList;
    }

    public List<CategoryDetail> getAllCategoryDetail(Long categoryId) {
        List<CategoryDetail> categoryList = categoryDao.getAllCategoryDetail(categoryId);
        return categoryList;	
    }
    public Category getCategoryById(Long id) {
        return categoryDao.getCategoryById(id);
    }
    
    public boolean addCategory(Category Category) {

        return categoryDao.addCategory(Category);
    }

    public boolean deleteAll() {
    	categoryList.clear();
        return categoryDao.deleteAll();
    }

    public boolean updateCategory(Category Category) {
        return categoryDao.updateCategory(Category);
    }
	@Override
	public boolean deleteCategoryById(Long id) {
        boolean ret = categoryDao.deleteCategoryById(id);
        return ret;
	}

}
