package com.lnu.dao;

import com.lnu.bean.*;
import com.lnu.bean.Thread;

import java.util.List;
import java.util.Set;

/**
 * User: igor
 * Date: 12/4/13
 */
public interface ForumDao {

    public static final int POST_PAGE_SIZE=5;
    public static final int THREAD_PAGE_SIZE=10;

    List<Category> findAllCategories();

    Category findCategoryById(Long categoryId);

    List<Thread> findThreadsForCategory(Long categoryId,Integer pageNumber);

    List<Post> findPostsForThread(Long threadId,Integer pageNumber);

    void saveThread(Thread thread);

    Thread getThreadById(Long threadId);

    void savePost(Post post);

    Long countdPostsForThread(Long threadId);

    Long countThreadsForCategory(Long categoryId);

    Post findPostById(Long postId);

    void updatePost(Post post);

    void insertLike(Long postId, Long id);

    List<Like> findLikesForPerson(Long personId);
}
