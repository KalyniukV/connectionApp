package org.example.connectionApp.controller;

import org.example.connectionApp.dao.DbDao;
import org.example.connectionApp.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    @Qualifier("oracleDBDao")
    private DbDao oracleDBDao;

    @Autowired
    @Qualifier("firebirdDBDao")
    private DbDao firebirdDBDao;


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/oracle")
    public String connection1(Model model) {
        List<Data> dataList = oracleDBDao.getAll();
        model.addAttribute("dataList", dataList);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/firebird")
    public String connection2(Model model) {
        List<Data> dataList = firebirdDBDao.getAll();
        model.addAttribute("dataList", dataList);
        return "index";
    }

}
