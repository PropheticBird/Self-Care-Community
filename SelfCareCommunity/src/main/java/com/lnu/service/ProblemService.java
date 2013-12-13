package com.lnu.service;

import com.lnu.bean.Problem;
import com.lnu.bean.Solution;
import com.lnu.bean.Tag;

import java.util.List;

/**
 * User: igor
 * Date: 12/13/13
 */
public interface ProblemService {

    List<Tag> listTags();

    List<Problem> listProblems();

    List<Solution> listSolutionsForProblem(Long problemId);
}
