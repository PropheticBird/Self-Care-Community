package com.lnu.dao;

import com.lnu.bean.Category;
import com.lnu.bean.collection.CategoryCollection;

import java.util.List;

/**
 * User: igor
 * Date: 12/4/13
 */
public interface ForumDao {

    List<Category> findAllCategories();

    Category findCategoryById(Long categoryId);
}
