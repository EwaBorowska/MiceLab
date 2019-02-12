package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.MatedDao;
import pl.coderslab.dao.MouseDao;
import pl.coderslab.model.Mated;
import pl.coderslab.model.Mouse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@Transactional
public class MatedController {

    @Autowired
    private MatedDao matedDao;


    @RequestMapping(path = "/allMatches", method = RequestMethod.GET)
    public String showAllAvailableMice(Model model) {
        model.addAttribute("matches", matedDao.getAll());
        return "showMatches";
    }
}
