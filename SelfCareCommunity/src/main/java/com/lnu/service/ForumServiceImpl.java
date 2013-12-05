package com.lnu.service;

import com.lnu.bean.*;
import com.lnu.bean.Thread;
import com.lnu.bean.view.Author;
import com.lnu.bean.view.NewPost;
import com.lnu.bean.view.NewThread;
import com.lnu.controller.json.UserJsonController;
import com.lnu.dao.ForumDao;
import com.lnu.dao.PersonalCredentialsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private PersonalCredentialsDao userDao;


    @Override
    @Transactional(readOnly = true)
    public List<Category> listCategories() {
        return forumDao.findAllCategories();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Thread> listThreadsForCategory(Long categoryId) {
        List<Thread> threads = forumDao.findThreadsForCategory(categoryId);
        for(Thread thread: threads){
            thread.setAuthor(Author.createFromPerson(thread.getPerson()));
        }
        return threads;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> listPostsForThread(Long threadId) {
        List<Post> posts = forumDao.findPostsForThread(threadId);
        for(Post post: posts){
            post.setAuthor(Author.createFromPerson(post.getPerson()));
        }
        return posts;
    }

    @Override
    @Transactional
    public void createNewThread(Long categoryId, NewThread threadView) {
        Person authorPerson = userDao.findByUserName(UserJsonController.getCurrentUserName()).getPerson();
        Category category = forumDao.findCategoryById(categoryId);
        Thread newThreadBean = new Thread();
        newThreadBean.setPerson(authorPerson);
        newThreadBean.setDisplayName(threadView.getTopic());
        newThreadBean.setCategory(category);
        Post newPostBean = new Post();
        newPostBean.setPerson(authorPerson);
        newPostBean.setContent(threadView.getContent());
        newPostBean.setLikes(0);
        newPostBean.setPostedDate(new Date());
        newPostBean.setThread(newThreadBean);
        forumDao.saveThread(newThreadBean);
        forumDao.savePost(newPostBean);
    }

    @Override
    @Transactional
    public void createNewPost(Long threadId, NewPost postView) {
        Person authorPerson = userDao.findByUserName(UserJsonController.getCurrentUserName()).getPerson();
        Thread thread = forumDao.getThreadById(threadId);
        Post newPostBean = new Post();
        newPostBean.setPostedDate(new Date());
        newPostBean.setThread(thread);
        newPostBean.setLikes(0);
        newPostBean.setContent(postView.getContent());
        newPostBean.setPerson(authorPerson);
        forumDao.savePost(newPostBean);
    }
}
