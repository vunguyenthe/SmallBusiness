package com.small.business.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.small.business.model.category.Category;
import com.small.business.model.category.CategoryDetail;
import com.small.business.service.category.CategoryService;
@Controller
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public @ResponseBody List<Category> getAllCategory() {

        return categoryService.getAllCategory();
    }
    
    @RequestMapping(value = "/categoryDetail/{categoryId}", method = RequestMethod.GET)
    public @ResponseBody List<CategoryDetail> getCategoryDetail(@PathVariable("categoryId") Long categoryId) {

        return categoryService.getAllCategoryDetail(categoryId);
    }
    
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public @ResponseBody Category getCategory(@PathVariable("id") Long id) {
    	return categoryService.getCategoryById(id);
    }
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public @ResponseBody boolean addCategory(@RequestBody Category Category) {
        return categoryService.addCategory(Category);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    public @ResponseBody boolean updateCategory(@RequestBody Category Category) {
        return categoryService.updateCategory(Category);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeCategory(@PathVariable("id") Long id) {

        return categoryService.deleteCategoryById(id);
    }

    @RequestMapping(value = "/removeAllCategory", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllCategory() {

        return categoryService.deleteAll();
    }
}
