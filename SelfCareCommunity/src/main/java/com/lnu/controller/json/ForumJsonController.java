package com.lnu.controller.json;

import com.lnu.bean.Category;
import com.lnu.bean.Post;
import com.lnu.bean.Thread;
import com.lnu.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * User: igor
 * Date: 12/4/13
 */
@Controller
public class ForumJsonController {

    @Autowired
    ForumService forumService;

    @ResponseBody
    @RequestMapping(value = "/service/categories", method = RequestMethod.GET)
    public List<Category> getCategories() {
          return forumService.listCategories();
    }

    @ResponseBody
    @RequestMapping(value = "/service/category/{categoryId}/threads", method = RequestMethod.GET)
    public List<Thread> getThreadsForCategory(@PathVariable("categoryId") Long categoryId) {
        return forumService.listThreadsForCategory(categoryId);
    }

    @ResponseBody
    @RequestMapping(value = "/service/thread/{threadId}/posts", method = RequestMethod.GET)
    public List<Post> getPostsForThread(@PathVariable("threadId") Long threadId) {
        return forumService.listPostsForThread(threadId);
    }


}
