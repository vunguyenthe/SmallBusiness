package com.small.business.dao.category;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.category.CategoryDetailRowMapper;
import com.small.business.jdbc.category.CategoryRowMapper;
import com.small.business.model.category.Category;
import com.small.business.model.category.CategoryDetail;

@Service("CategoryDao")
public class CategoryDaoImpl implements CategoryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<Category> getAllCategory() {

        List<Category> categoryList = new ArrayList<Category>();
        String sql = "select * from category";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        categoryList = jdbcTemplate.query(sql, new CategoryRowMapper());
        return categoryList;        
    }
    public List<CategoryDetail> getAllCategoryDetail(Long categoryId) {
        List<CategoryDetail> categoryDetailList = new ArrayList<CategoryDetail>();
        String sql = "select * from category_detail where categoryId = " + categoryId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        categoryDetailList = jdbcTemplate.query(sql, new CategoryDetailRowMapper());
        return categoryDetailList;  
    }
    public Category getCategoryById(Long id) {
        Category Category = new Category();
        List<Category> CategoryList = new ArrayList<Category>();
        String sql = "select * from category where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        CategoryList = jdbcTemplate.query(sql, new CategoryRowMapper());
        if (CategoryList.size() > 0) {
            return CategoryList.get(0);
        }  
        return Category;
    }
    public boolean addCategory(Category category) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO category "
                    + "( name ) VALUES "
                    + "(?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		category.getName()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addCategory got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteCategoryById(Long id) {

        boolean ret = true;
        String sql = "";
        try {
            sql = "delete from category where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("deleteCategoryById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from category";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;

    }

    public boolean updateCategory(Category category) {

        boolean ret = true;
        String sql = "update category set name = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		category.getName(),
                    		category.getId() });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updateCategory got error: " + ex.getMessage());
        }
        return ret;
    }
}
