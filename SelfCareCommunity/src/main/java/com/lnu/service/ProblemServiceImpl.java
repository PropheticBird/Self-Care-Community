package com.lnu.service;

import com.lnu.bean.Person;
import com.lnu.bean.Problem;
import com.lnu.bean.Solution;
import com.lnu.bean.Tag;
import com.lnu.bean.view.Author;
import com.lnu.bean.view.ProblemAndSolutions;
import com.lnu.controller.json.UserJsonController;
import com.lnu.dao.PersonalCredentialsDao;
import com.lnu.dao.ProblemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: igor
 * Date: 12/13/13
 */
@Service
public class ProblemServiceImpl implements ProblemService{


    @Autowired
    private PersonalCredentialsDao userDao;

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
    public ProblemAndSolutions listSolutionsForProblem(Long problemId) {
        ProblemAndSolutions result = new ProblemAndSolutions();
        Problem problem = problemDao.findProblem(problemId);
        problem.setAuthor(Author.createFromPerson(problem.getPerson()));
        result.setProblem(problem);
        List<Solution> solutionsForProblem = problemDao.findSolutionsForProblem(problemId);
        for(Solution solution:solutionsForProblem){
            solution.setAuthor(Author.createFromPerson(solution.getPerson()));
        }
        result.setSolutions(solutionsForProblem);
        return result;
    }

    @Override
    @Transactional
    public Long createNewProblem(Problem problem) {
        Person authorPerson = userDao.findByUserName(UserJsonController.getCurrentUserName()).getPerson();
        problem.setPerson(authorPerson);

        Set<Tag> tags = problem.getTags();
        Set<Tag> persistedTags = new HashSet<Tag>();
        for (Tag tag : tags){
            persistedTags.add(problemDao.findTag(tag.getId()));
        }
        problem.setTags(persistedTags);

        problem.setPostedDate(new Date());

        problemDao.insertProblem(problem);
        return problem.getId();
    }

    @Override
    @Transactional
    public Long createNewSolutionForProblem(Long problemId, Solution solution) {
        Person authorPerson = userDao.findByUserName(UserJsonController.getCurrentUserName()).getPerson();
        solution.setPerson(authorPerson);

        Set<Tag> tags = solution.getTags();
        Set<Tag> persistedTags = new HashSet<Tag>();
        for (Tag tag : tags){
            persistedTags.add(problemDao.findTag(tag.getId()));
        }
        solution.setTags(persistedTags);

        Problem problem = problemDao.findProblem(problemId);
        solution.setProblem(problem);

        solution.setPostedDate(new Date());

        problemDao.insertSolution(solution);
        return solution.getId();
    }
}
