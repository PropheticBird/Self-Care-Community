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

    List<Category> findAllCategories();

    Category findCategoryById(Long categoryId);

    List<Thread> findThreadsForCategory(Long categoryId);

    List<Post> findPostsForThread(Long threadId);

    void saveThread(Thread thread);

    Thread getThreadById(Long threadId);

    void savePost(Post post);
}
