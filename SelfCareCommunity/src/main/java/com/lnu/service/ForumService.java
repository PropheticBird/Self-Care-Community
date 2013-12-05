package com.lnu.service;

import com.lnu.bean.*;
import com.lnu.bean.Thread;
import java.util.List;
import java.util.Set;

/**
 * User: igor
 * Date: 12/4/13
 */
public interface ForumService {

    List<Category> listCategories();

    List<Thread> listThreadsForCategory(Long categoryId);

    List<Post> listPostsForThread(Long threadId);
}
