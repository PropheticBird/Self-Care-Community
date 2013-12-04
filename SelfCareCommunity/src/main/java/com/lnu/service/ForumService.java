package com.lnu.service;

import com.lnu.bean.*;
import com.lnu.bean.collection.CategoryCollection;

import java.util.List;
import java.util.Set;

/**
 * User: igor
 * Date: 12/4/13
 */
public interface ForumService {

    List<Category> listCategories();

    Set<com.lnu.bean.Thread> listThreadsForCategory(Long categoryId);
}
