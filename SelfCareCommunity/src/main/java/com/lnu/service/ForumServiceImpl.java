package com.lnu.service;

import com.lnu.bean.*;
import com.lnu.bean.Thread;
import com.lnu.dao.ForumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * User: igor
 * Date: 12/4/13
 */
@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDao forumDao;


    @Override
    @Transactional(readOnly = true)
    public List<Category> listCategories() {
        return forumDao.findAllCategories();
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Thread> listThreadsForCategory(Long categoryId) {
        Category category = forumDao.findCategoryById(categoryId);
        return category.getThreads();
    }
}
