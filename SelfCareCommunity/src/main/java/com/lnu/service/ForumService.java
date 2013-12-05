package com.lnu.service;

import com.lnu.bean.*;
import com.lnu.bean.Thread;
import com.lnu.bean.view.NewPost;
import com.lnu.bean.view.NewThread;
import com.lnu.bean.view.Page;

import java.util.List;
import java.util.Set;

/**
 * User: igor
 * Date: 12/4/13
 */
public interface ForumService {

    List<Category> listCategories();

    Page<Thread> listThreadsForCategory(Long categoryId,Integer pageNumber);

    Page<Post> listPostsForThread(Long threadId,Integer pageNumber);

    void createNewThread(Long categoryId, NewThread thread);

    void createNewPost(Long threadId, NewPost post);
}
