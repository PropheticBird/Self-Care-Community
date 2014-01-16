package com.lnu.controller.json;

import com.lnu.bean.Person;
import com.lnu.bean.Tag;
import com.lnu.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by olga on 13.01.14.
 */
@Controller
public class MatchingJsonController {

    @Autowired
    private MatchingService matchingService;

    @ResponseBody
    @RequestMapping(value = "/service/matching/people", method = RequestMethod.GET)
    public List<Person> matchPeople() {
        return matchingService.matchRelatedPeople();
    }

    @ResponseBody
    @RequestMapping(value = "/service/matching/problems", method = RequestMethod.GET)
    public List<Person> matchProblems() {
        return matchingService.matchRelatedProblems();
    }
}
