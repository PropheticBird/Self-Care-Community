package com.lnu.controller.json;

import com.lnu.bean.Category;
import com.lnu.bean.Post;
import com.lnu.bean.Thread;
import com.lnu.bean.view.NewPost;
import com.lnu.bean.view.NewThread;
import com.lnu.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/service/category/{categoryId}/newthread", method = RequestMethod.POST)
    public String newThreadInCategory(@PathVariable("categoryId") Long categoryId, @RequestBody NewThread thread) {
        forumService.createNewThread(categoryId,thread);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value = "/service/thread/{threadId}/posts", method = RequestMethod.GET)
    public List<Post> getPostsForThread(@PathVariable("threadId") Long threadId) {
        return forumService.listPostsForThread(threadId);
    }

    @ResponseBody
    @RequestMapping(value = "/service/thread/{threadId}/newpost", method = RequestMethod.POST)
    public String newPostInThread(@PathVariable("threadId") Long threadId, @RequestBody NewPost post) {
        forumService.createNewPost(threadId,post);
        return "OK";
    }


}
