package com.lnu.service;

import com.lnu.bean.*;
import com.lnu.bean.Thread;
import com.lnu.bean.view.Author;
import com.lnu.bean.view.NewPost;
import com.lnu.bean.view.NewThread;
import com.lnu.bean.view.Page;
import com.lnu.controller.json.UserJsonController;
import com.lnu.dao.ForumDao;
import com.lnu.dao.PersonalCredentialsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    public Page<Thread> listThreadsForCategory(Long categoryId, Integer pageNumber) {
        List<Thread> threads = forumDao.findThreadsForCategory(categoryId,pageNumber);
        Long count =  forumDao.countThreadsForCategory(categoryId);
        for(Thread thread: threads){
            thread.setAuthor(Author.createFromPerson(thread.getPerson()));
        }
        Boolean isLastPage =ForumDao.THREAD_PAGE_SIZE*pageNumber>=count;
        return new Page<Thread>(isLastPage,threads);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Post> listPostsForThread(Long threadId, Integer pageNumber) {
        List<Post> posts = forumDao.findPostsForThread(threadId,pageNumber);
        Long count =  forumDao.countdPostsForThread(threadId);
        Person person = userDao.findByUserName(UserJsonController.getCurrentUserName()).getPerson();
        List<Like> likes = forumDao.findLikesForPerson(person.getId());
        for(Post post: posts){
            post.setAuthor(Author.createFromPerson(post.getPerson()));
            if(likes.contains(Like.newLike(0l,post.getId()))){
                post.setCanLike(false);
                post.setCanDislike(false);
            } else{
                post.setCanLike(true);
                post.setCanDislike(true);
            }
        }
        Boolean isLastPage =ForumDao.POST_PAGE_SIZE*pageNumber>=count;
        return new Page<Post>(isLastPage,posts);
    }


    @Override
    @Transactional
    public Long createNewThread(Long categoryId, NewThread threadView) {
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
        return newThreadBean.getId();
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
        newPostBean.setDislikes(0);
        newPostBean.setContent(postView.getContent());
        newPostBean.setPerson(authorPerson);
        forumDao.savePost(newPostBean);
    }

    @Override
    @Transactional
    public void like(Long postId, boolean increaseLikes) {
        Post post = forumDao.findPostById(postId);
        if(increaseLikes){
            post.setLikes(post.getLikes()+1);
        } else {
            post.setDislikes(post.getDislikes()+1);
        }
        Person person = userDao.findByUserName(UserJsonController.getCurrentUserName()).getPerson();
        forumDao.insertLike(postId, person.getId());
        forumDao.updatePost(post);
    }
}
