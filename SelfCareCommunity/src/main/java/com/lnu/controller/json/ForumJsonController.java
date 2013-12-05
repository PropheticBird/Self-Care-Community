package com.lnu.controller.json;

import com.lnu.bean.Category;
import com.lnu.bean.Post;
import com.lnu.bean.Thread;
import com.lnu.bean.view.NewPost;
import com.lnu.bean.view.NewThread;
import com.lnu.bean.view.Page;
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
    @RequestMapping(value = "/service/category/{categoryId}/threads/page/{pageNumber}", method = RequestMethod.GET)
    public Page<Thread> getThreadsForCategory(@PathVariable("categoryId") Long categoryId, @PathVariable("pageNumber") Integer pageNumber) {
        return forumService.listThreadsForCategory(categoryId,pageNumber);
    }

    @ResponseBody
    @RequestMapping(value = "/service/category/{categoryId}/newthread", method = RequestMethod.POST)
    public void newThreadInCategory(@PathVariable("categoryId") Long categoryId, @RequestBody NewThread thread) {
        forumService.createNewThread(categoryId,thread);
    }

    @ResponseBody
    @RequestMapping(value = "/service/thread/{threadId}/posts/page/{pageNumber}", method = RequestMethod.GET)
    public Page<Post> getPostsForThread(@PathVariable("threadId") Long threadId,@PathVariable("pageNumber") Integer pageNumber) {
        return forumService.listPostsForThread(threadId,pageNumber);
    }

    @ResponseBody
    @RequestMapping(value = "/service/thread/{threadId}/newpost", method = RequestMethod.POST)
    public void newPostInThread(@PathVariable("threadId") Long threadId, @RequestBody NewPost post) {
        forumService.createNewPost(threadId,post);
    }


}
