package com.lnu.service;

import com.lnu.bean.Problem;
import com.lnu.bean.Solution;
import com.lnu.bean.Tag;
import com.lnu.bean.view.Author;
import com.lnu.dao.ProblemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: igor
 * Date: 12/13/13
 */
@Service
public class ProblemServiceImpl implements ProblemService{


    @Autowired
    private ProblemDao problemDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tag> listTags() {
        return problemDao.findAllTags();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Problem> listProblems() {
        List<Problem> problems = problemDao.findAllProblems();
        for (Problem problem:problems){
            problem.setAuthor(Author.createFromPerson(problem.getPerson()));
        }
        return problems;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Solution> listSolutionsForProblem(Long problemId) {
        return problemDao.findSolutionsForProblem(problemId);
    }
}
