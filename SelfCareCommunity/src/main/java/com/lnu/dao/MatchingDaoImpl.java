package com.lnu.dao;

import com.lnu.bean.Person;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by olga on 13.01.14.
 */
@Repository
public class MatchingDaoImpl implements MatchingDao {

    private static final String RELATED_PEOPLE_QUERY =
            "select persons.name, persons.surname, persons.disease, persons.interest, count(problems.id) similar_problems " +
            "from persons, problems " +
            "where persons.id = problems.author_id " +
                "and problems.id in " +
                "( " +
                    "select p.ID " +
                    "from problems p,problem_to_tags " +
                    "where p.id=problem_to_tags.problem_id and " +
                    "problem_to_tags.tag_id in " +
                    "( " +
                        "SELECT DISTINCT(pt.Tag_ID) " +
                        "FROM problem_to_tags pt WHERE pt.Problem_ID IN " +
                        "( " +
                            "SELECT pr.ID FROM problems pr WHERE pr.Author_ID = :authorID " +
                        ") " +
                    ") " +
                    "group by p.ID " +
                ") " +
            "group by persons.id " +
            "order by similar_problems DESC ";

    private static final String RELATED_PROBLEMS_QUERY =
            "select problems.ID,name author_name,surname author_surname,isproblem,when_,where_,how,who,why,consequences, count(Tag_ID) tags_matched \n" +
            "from problem_to_tags,problems,descriptions,persons \n" +
            "where\n" +
            "  problems.author_id=persons.id and\n" +
            "  problems.description_id=descriptions.id and\n" +
            "  problems.id = problem_to_tags.problem_id and\n" +
            "  problem_to_tags.tag_id in (\n" +
            "  SELECT DISTINCT(pt.Tag_ID) FROM problem_to_tags pt WHERE pt.Problem_ID IN\n" +
            "      (\n" +
            "           SELECT pr.ID FROM problems pr WHERE pr.Author_ID = :authorID \n" +
            "      )\n" +
            ")\n" +
            "group by problem_id\n" +
            "having tags_matched>=2\n" +
            "ORDER BY tags_matched desc;";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Person> findRelatedPeople(Person toPerson) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery(RELATED_PEOPLE_QUERY);
        sqlQuery.setParameter("authorID",toPerson.getId());
        return sqlQuery.list();
    }

    @Override
    public List<Person> findRelatedProblems(Person toPerson) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery(RELATED_PROBLEMS_QUERY);
        sqlQuery.setParameter("authorID",toPerson.getId());
        return sqlQuery.list();
    }
}
