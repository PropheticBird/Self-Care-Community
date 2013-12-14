package com.lnu.bean.view;

import com.lnu.bean.Problem;
import com.lnu.bean.Solution;

import java.util.List;

/**
 * User: igor
 * Date: 12/14/13
 */
public class ProblemAndSolutions {

    private Problem problem;

    private List<Solution> solutions;

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}
