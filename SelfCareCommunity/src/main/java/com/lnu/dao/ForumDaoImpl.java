package com.lnu.dao;

import com.lnu.bean.*;
import com.lnu.bean.Thread;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
        return (Category) session.load(Category.class, categoryId);
    }

    @Override
    public List<Thread> findThreadsForCategory(Long categoryId,Integer pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Thread where category.id=:categoryId order by lastPostDate DESC");
        query.setParameter("categoryId",categoryId);
        query.setFirstResult((pageNumber-1)*THREAD_PAGE_SIZE);
        query.setMaxResults(THREAD_PAGE_SIZE);
        return query.list();
    }

    @Override
    public List<Post> findPostsForThread(Long threadId,Integer pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Post where thread.id=:threadId order by postedDate");
        query.setParameter("threadId",threadId);
        query.setFirstResult((pageNumber-1)*POST_PAGE_SIZE);
        query.setMaxResults(POST_PAGE_SIZE);
        return query.list();
    }

    @Override
    public void saveThread(Thread thread) {
        Session session = sessionFactory.getCurrentSession();
        session.save(thread);
    }

    @Override
    public Thread getThreadById(Long threadId) {
        Session session = sessionFactory.getCurrentSession();
        return (Thread) session.load(Thread.class, threadId);
    }

    @Override
    public void savePost(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.save(post);
    }

    @Override
    public Long countdPostsForThread(Long threadId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from Post where thread.id=:threadId");
        query.setParameter("threadId",threadId);
        return (Long) query.uniqueResult();
    }

    @Override
    public Long countThreadsForCategory(Long categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from Thread where category.id=:categoryId");
        query.setParameter("categoryId",categoryId);
        return (Long) query.uniqueResult();
    }

    @Override
    public Post findPostById(Long postId) {
        Session session = sessionFactory.getCurrentSession();
        return (Post) session.get(Post.class,postId);
    }

    @Override
    public void updatePost(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.update(post);
    }

    @Override
    public void insertLike(Long postId, Long personId) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("INSERT INTO LIKES_TO_USERS (Person_ID, Post_ID) VALUES ("+personId+","+postId+")");
        query.executeUpdate();
    }

    @Override
    public List<Like> findLikesForPerson(Long personId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Like where id.userID=:personId");
        query.setParameter("personId",personId);
        return query.list();
    }
}
