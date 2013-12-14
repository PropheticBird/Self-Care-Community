package com.lnu.controller.json;

import com.lnu.bean.*;
import com.lnu.bean.Thread;
import com.lnu.bean.view.*;
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
    public ProblemAndSolutions getSolutionsForProblem(@PathVariable("problemId") Long problemId) {
        return problemService.listSolutionsForProblem(problemId);
    }

    @ResponseBody
    @RequestMapping(value = "/service/newproblem", method = RequestMethod.POST)
    public Result newProblem(@RequestBody Problem problem) {
        Long id;
        try {
            id = problemService.createNewProblem(problem);
            if(id == null){
                throw new Exception();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.FAIL;
        }
        InsertionResult result= InsertionResult.OK;
        result.setId(id);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/service/problem/{problemId}/newsolution", method = RequestMethod.POST)
    public Result newSolution(@PathVariable("problemId") Long problemId,@RequestBody Solution solution) {
        Long id;
        try {
            id = problemService.createNewSolutionForProblem(problemId,solution);
            if(id == null){
                throw new Exception();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.FAIL;
        }
        InsertionResult result= InsertionResult.OK;
        result.setId(id);
        return result;
    }
}
