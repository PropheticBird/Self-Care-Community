package com.lnu.controller.json;

import com.lnu.bean.Category;
import com.lnu.bean.Post;
import com.lnu.bean.Thread;
import com.lnu.bean.view.*;
import com.lnu.service.ForumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public Result newThreadInCategory(@PathVariable("categoryId") Long categoryId, @RequestBody NewThread thread) {
        Long id;
        try {
            id = forumService.createNewThread(categoryId, thread);
            if(id == null){
                throw new Exception();
            }
        }catch (Exception e){
            return Result.FAIL;
        }
        InsertionResult result= InsertionResult.OK;
        result.setId(id);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/service/post/{postId}/like", method = RequestMethod.PUT)
    public Result like(@PathVariable("postId") Long postId) {
        try {
            forumService.like(postId,true);
        }catch (Exception e){
            return Result.FAIL;
        }
        return Result.OK;
    }

    @ResponseBody
    @RequestMapping(value = "/service/post/{postId}/like", method = RequestMethod.DELETE)
    public Result newThreadInCategory(@PathVariable("postId") Long postId) {
        try {
            forumService.like(postId,false);
        }catch (Exception e){
            return Result.FAIL;
        }
        return Result.OK;
    }

    @ResponseBody
    @RequestMapping(value = "/service/thread/{threadId}/posts/page/{pageNumber}", method = RequestMethod.GET)
    public Page<Post> getPostsForThread(@PathVariable("threadId") Long threadId,@PathVariable("pageNumber") Integer pageNumber) {
        return forumService.listPostsForThread(threadId,pageNumber);
    }



    @ResponseBody
    @RequestMapping(value = "/service/thread/{threadId}/newpost", method = RequestMethod.POST)
    public Result newPostInThread(@PathVariable("threadId") Long threadId, @RequestBody NewPost post) {
        try{
            forumService.createNewPost(threadId,post);
        }catch (Exception e){
            return Result.FAIL;
        }
        return Result.OK;
    }


}
