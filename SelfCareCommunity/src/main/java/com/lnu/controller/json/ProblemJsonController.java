package com.lnu.controller.json;

import com.lnu.bean.*;
import com.lnu.bean.Thread;
import com.lnu.bean.view.InsertionResult;
import com.lnu.bean.view.NewThread;
import com.lnu.bean.view.Page;
import com.lnu.bean.view.Result;
import com.lnu.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: igor
 * Date: 12/13/13
 */
@Controller
public class ProblemJsonController {

    @Autowired
    private ProblemService problemService;

    @ResponseBody
    @RequestMapping(value = "/service/tags", method = RequestMethod.GET)
    public List<Tag> getTags() {
        return problemService.listTags();
    }

    @ResponseBody
    @RequestMapping(value = "/service/problems", method = RequestMethod.GET)
    public List<Problem> getProblems() {
        return problemService.listProblems();
    }

    @ResponseBody
    @RequestMapping(value = "/service/problem/{problemId}/solutions", method = RequestMethod.GET)
    public List<Solution> getSolutionsForProblem(@PathVariable("problemId") Long problemId) {
        return problemService.listSolutionsForProblem(problemId);
    }

    /*

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
    }  */
}
