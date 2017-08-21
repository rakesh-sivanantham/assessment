package com.capgemini.assessment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {

    /**
     * Request mapping that serves the index.jsp page
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "index";
    }
}
