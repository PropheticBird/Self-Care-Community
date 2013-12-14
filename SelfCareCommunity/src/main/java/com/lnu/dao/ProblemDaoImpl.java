package com.lnu.dao;

import com.lnu.bean.Problem;
import com.lnu.bean.Solution;
import com.lnu.bean.Tag;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: igor
 * Date: 12/13/13
 */
@Repository
public class ProblemDaoImpl implements ProblemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Tag> findAllTags() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Tag");
        return query.list();
    }

    @Override
    public List<Problem> findAllProblems() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Problem");
        return query.list();
    }

    @Override
    public List<Solution> findSolutionsForProblem(Long problemId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Solution where problem.id = :problem");
        query.setParameter("problem",problemId);
        return query.list();
    }

    @Override
    public Problem findProblem(Long problemId) {
        return (Problem) sessionFactory.getCurrentSession().get(Problem.class, problemId);
    }

    @Override
    public Tag findTag(Long tagId) {
        return (Tag) sessionFactory.getCurrentSession().get(Tag.class,tagId);
    }

    @Override
    public void insertProblem(Problem problem) {
        sessionFactory.getCurrentSession().save(problem);
    }

    @Override
    public void insertSolution(Solution solution) {
        sessionFactory.getCurrentSession().save(solution);
    }
}
