package com.lnu.dao;

import com.lnu.bean.Problem;
import com.lnu.bean.Solution;
import com.lnu.bean.Tag;

import java.util.List;

/**
 * User: igor
 * Date: 12/13/13
 */
public interface ProblemDao {

    List<Tag> findAllTags();

    List<Problem> findAllProblems();

    List<Solution> findSolutionsForProblem(Long problemId);

    Problem findProblem(Long problemId);

    Tag findTag(Long tagId);

    void insertProblem(Problem problem);

    void insertSolution(Solution solution);
}
