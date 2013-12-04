package com.lnu.dao;

import com.lnu.bean.Category;
import com.lnu.bean.collection.CategoryCollection;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: igor
 * Date: 12/4/13
 */
@Repository
public class ForumDaoImpl implements ForumDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Category> findAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category");
        return query.list();
    }

    @Override
    public Category findCategoryById(Long categoryId) {
        Session session = sessionFactory.getCurrentSession();
        return (Category) session.get(Category.class,categoryId);
    }
}
