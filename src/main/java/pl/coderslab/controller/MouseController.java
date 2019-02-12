package pl.coderslab.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.MatedDao;
import pl.coderslab.dao.MouseDao;

import pl.coderslab.dao.AgeCalculator;
import pl.coderslab.model.Mated;
import pl.coderslab.model.Mouse;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@Transactional
public class MouseController {

    @Autowired
    private MouseDao mouseDao;



    @Autowired
    private MatedDao matedDao;




    Map<Mouse, Mouse> matched = new HashMap<>();


    @GetMapping(path = "/find", produces = "text/html; charset=UTF-8")
    public String showForm() {
        return "findAMatch";
    }


    @GetMapping(path = "/", produces = "text/html; charset=UTF-8")
    public String homePage() {

        List<Mouse> mouseUpdate = mouseDao.getAllActive();
        for (Mouse mouse : mouseUpdate) {
            mouse.setActiveAndAvailable(mouse);
        }
    //todo update z serwisu

        return "home";
    }

    @GetMapping(path = "/save", produces = "text/html; charset=UTF-8")
    public String saveMatch() {

        return "saveMatch";
    }


    @PostMapping(path = "/save", produces = "text/html; charset=UTF-8")
    public String saveMatchToDatabase(@RequestParam(name = "opt") String opt) {

      //todo service, compare object to value

        if (opt.equals("yes")) {

            for (Map.Entry<Mouse, Mouse> entry : matched.entrySet()) {

                Mouse f = entry.getKey();
                Mouse m = entry.getValue();
                Mated mated = new Mated();

                mated.setMotherMousePassId(f);
                mated.setFatherMousePassId(m);
                mated.setDate(LocalDate.now());
                matedDao.save(mated);

            }
        }

        if (opt.equals("no")) {
            for (Map.Entry<Mouse, Mouse> entry : matched.entrySet()) {

                Mouse f = entry.getKey();
                Mouse m = entry.getValue();
                f.setAvailable(true);
                m.setAvailable(true);
                mouseDao.update(f);
                mouseDao.update(m);

            }
        }


        return "home";
    }


    @RequestMapping(path = "/allActiveMice", method = RequestMethod.GET)
    public String showAllActiveMice(Model model) {
        model.addAttribute("mice", mouseDao.getAllActive());
        return "showAllMice";
    }

    @RequestMapping(path = "/allAvailableMice", method = RequestMethod.GET)
    public String showAllAvailableMice(Model model) {
        model.addAttribute("mice", mouseDao.getAllAvailable());
        return "showAllMice";
    }


    @RequestMapping(path = "/allMice", method = RequestMethod.GET)
    public String showAllMiceInDB(Model model) {

        model.addAttribute("mice", mouseDao.getAll());
        return "showAllMice";
    }

    @GetMapping("/mouse")
    public String addNewMouse(Model model) {
        model.addAttribute("mouse", new Mouse());
        return "addMouse";
    }

    @PostMapping("/mouse")
    public String addMouse(@Valid @ModelAttribute Mouse mouse, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addMouse";
        } else {

            this.mouseDao.saveMouse(mouse);
            mouse.setActiveAndAvailable(mouse);
            return "redirect:/allMice";
        }
    }

    @RequestMapping(path = "/mouse/edit/{id}", method = RequestMethod.GET)
    public String editMouseForm(@PathVariable long id, Model model) {
        Mouse mouse = mouseDao.findById(id);
        model.addAttribute("mouse", mouse);
        return "addMouse";
    }

    @RequestMapping(path = "/mouse/edit/{id}", method = RequestMethod.POST)
    public String editMouseForm(@ModelAttribute Mouse mouse, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addMouse";
        } else {
            this.mouseDao.update(mouse);

            return "redirect:/allMice";
        }
    }

    @RequestMapping(path = "/mouse/delete/{id}", method = RequestMethod.GET)
    public String deleteMouse(@PathVariable Long id) {
        Mouse mouse = mouseDao.findById(id);
        mouseDao.delete(mouse);
        return "redirect:/allMice";

    }

    @PostMapping(path = "/find", produces = "text/html; charset=UTF-8")
    public String findMatch(@RequestParam(name = "minAge") String minAge, @RequestParam(name = "maxAge") String maxAge, @RequestParam(name = "KO1A", required = false) String[] KO1A, @RequestParam(name = "KO1B", required = false) String[] KO1B, @RequestParam(name = "KO1D", required = false) String[] KO1D, @RequestParam(name = "KO1Am", required = false) String[] KO1Am, @RequestParam(name = "KO1Bm", required = false) String[] KO1Bm, @RequestParam(name = "KO1Dm", required = false) String[] KO1Dm, @RequestParam(name = "number") String number, Model model) throws ParseException {

        try {
            String param1 = "";
            String param2 = "";
            String param3 = "";
            String param4 = "";



            for (int i = 0; i < KO1A.length; i++) {
                param1 = KO1A[0];

                if (KO1A.length == 1) {
                    param2 = param3 = param4 = param1;
                }
                if (KO1A.length == 2) {

                    param2 = KO1A[1];
                    param3 = param4 = param1;
                }
                if (KO1A.length == 3) {

                    param2 = KO1A[1];
                    param3 = KO1A[2];
                    param4 = param1;
                }
                if (KO1A.length == 4) {

                    param2 = KO1A[1];
                    param3 = KO1A[2];
                    param4 = KO1A[3];
                }

            }

            String param1final = param1;
            String param2final = param2;
            String param3final = param3;
            String param4final = param4;

            String param1KO1B = "";
            String param2KO1B = "";
            String param3KO1B = "";
            String param4KO1B = "";

            for (int i = 0; i < KO1B.length; i++) {
                param1KO1B = KO1B[0];

                if (KO1B.length == 1) {
                    param2KO1B = param3KO1B = param4KO1B = param1KO1B;
                }
                if (KO1B.length == 2) {

                    param2KO1B = KO1B[1];
                    param3KO1B = param4KO1B = param1KO1B;
                }
                if (KO1B.length == 3) {

                    param2KO1B = KO1B[1];
                    param3KO1B = KO1B[2];
                    param4KO1B = param1KO1B;
                }
                if (KO1B.length == 4) {

                    param2KO1B = KO1B[1];
                    param3KO1B = KO1B[2];
                    param4KO1B = KO1B[3];
                }

            }

            String param1finalKO1B = param1KO1B;
            String param2finalKO1B = param2KO1B;
            String param3finalKO1B = param3KO1B;
            String param4finalKO1B = param4KO1B;


            String param1KO1D = "";
            String param2KO1D = "";
            String param3KO1D = "";
            String param4KO1D = "";

            for (int i = 0; i < KO1D.length; i++) {


                if (KO1D.length == 1) {
                    param2KO1D = param3KO1D = param4KO1D = param1KO1D = KO1D[0];
                }
                if (KO1D.length == 2) {

                    param2KO1D = KO1D[1];
                    param3KO1D = param4KO1D = param1KO1D = KO1D[0];
                }
                if (KO1D.length == 3) {

                    param2KO1D = KO1D[1];
                    param3KO1D = KO1D[2];
                    param4KO1D = param1KO1D = KO1D[0];
                }
                if (KO1D.length == 4) {

                    param2KO1D = KO1D[1];
                    param3KO1D = KO1D[2];
                    param4KO1D = KO1D[3] = KO1D[0];
                }

            }

            String param1finalKO1D = param1KO1D;
            String param2finalKO1D = param2KO1D;
            String param3finalKO1D = param3KO1D;
            String param4finalKO1D = param4KO1D;

            String param1m = "";
            String param2m = "";
            String param3m = "";
            String param4m = "";


            for (int i = 0; i < KO1Am.length; i++) {
                param1m = KO1Am[0];

                if (KO1Am.length == 1) {
                    param2m = param3m = param4m = param1m;
                }
                if (KO1Am.length == 2) {

                    param2m = KO1Am[1];
                    param3m = param4m = param1m;
                }
                if (KO1Am.length == 3) {

                    param2m = KO1Am[1];
                    param3m = KO1Am[2];
                    param4m = param1m;
                }
                if (KO1Am.length == 4) {

                    param2m = KO1Am[1];
                    param3m = KO1Am[2];
                    param4m = KO1Am[3];
                }

            }

            String param1finalm = param1m;
            String param2finalm = param2m;
            String param3finalm = param3m;
            String param4finalm = param4m;

            String param1KO1Bm = "";
            String param2KO1Bm = "";
            String param3KO1Bm = "";
            String param4KO1Bm = "";

            for (int i = 0; i < KO1Bm.length; i++) {
                param1KO1Bm = KO1Bm[0];

                if (KO1Bm.length == 1) {
                    param2KO1Bm = param3KO1Bm = param4KO1Bm = param1KO1Bm;
                }
                if (KO1Bm.length == 2) {

                    param2KO1Bm = KO1Bm[1];
                    param3KO1Bm = param4KO1Bm = param1KO1Bm;
                }
                if (KO1Bm.length == 3) {

                    param2KO1Bm = KO1Bm[1];
                    param3KO1Bm = KO1Bm[2];
                    param4KO1Bm = param1KO1Bm;
                }
                if (KO1Bm.length == 4) {

                    param2KO1Bm = KO1Bm[1];
                    param3KO1Bm = KO1Bm[2];
                    param4KO1Bm = KO1Bm[3];
                }

            }

            String param1finalKO1Bm = param1KO1Bm;
            String param2finalKO1Bm = param2KO1Bm;
            String param3finalKO1Bm = param3KO1Bm;
            String param4finalKO1Bm = param4KO1Bm;


            String param1KO1Dm = "";
            String param2KO1Dm = "";
            String param3KO1Dm = "";
            String param4KO1Dm = "";

            for (int i = 0; i < KO1Dm.length; i++) {
                param1KO1Dm = KO1Dm[0];

                if (KO1D.length == 1) {
                    param2KO1Dm = param3KO1Dm = param4KO1Dm = param1KO1Dm;
                }
                if (KO1Dm.length == 2) {

                    param2KO1Dm = KO1Dm[1];
                    param3KO1Dm = param4KO1Dm = param1KO1Dm;
                }
                if (KO1Dm.length == 3) {

                    param2KO1Dm = KO1Dm[1];
                    param3KO1Dm = KO1Dm[2];
                    param4KO1Dm = param1KO1Dm;
                }
                if (KO1Dm.length == 4) {

                    param2KO1Dm = KO1Dm[1];
                    param3KO1Dm = KO1Dm[2];
                    param4KO1Dm = KO1Dm[3];
                }

            }

            String param1finalKO1Dm = param1KO1Dm;
            String param2finalKO1Dm = param2KO1Dm;
            String param3finalKO1Dm = param3KO1Dm;
            String param4finalKO1Dm = param4KO1Dm;

            System.out.println(param1final + " " + param2final + " " + param3final + " " + param4final);

            List<Mouse> mice = mouseDao.getAllAvailable();

            List<Mouse> miceA = new ArrayList<>();


            for (Mouse m : mice) {
                LocalDate bd = m.getBirthDate();
                LocalDate today = LocalDate.now();

                if (AgeCalculator.calculateAge1(m, bd, today) > Integer.valueOf(minAge) && AgeCalculator.calculateAge1(m, bd, today) < Integer.valueOf(maxAge) ) {
                    miceA.add(m);

                }
            }
            System.out.println(miceA);


            
            List<Mouse> femaleMice = miceA.stream()
                    .filter(m -> m.getSex() == Mouse.Sex.FEMALE)
                    .filter(m -> m.getKO1A().equals(param1final) || m.getKO1A().equals(param2final) || m.getKO1A().equals(param3final) || m.getKO1A().equals(param4final))
                    .filter(m -> m.getKO1B().equals(param1finalKO1B) || m.getKO1B().equals(param2finalKO1B) || m.getKO1B().equals(param3finalKO1B) || m.getKO1B().equals(param4finalKO1B))
                    .filter(m -> m.getKO1D().equals(param1finalKO1D) || m.getKO1D().equals(param2finalKO1D) || m.getKO1D().equals(param3finalKO1D) || m.getKO1D().equals(param4finalKO1D))
                    .collect(Collectors.toList());


            model.addAttribute("femaleMice", femaleMice);


            List<Mouse> maleMice = miceA.stream()
                    .filter(m -> m.getSex() == Mouse.Sex.MALE)
                    .filter(m -> m.getKO1A().equals(param1finalm) || m.getKO1A().equals(param2finalm) || m.getKO1A().equals(param3finalm) || m.getKO1A().equals(param4finalm))
                    .filter(m -> m.getKO1B().equals(param1finalKO1Bm) || m.getKO1B().equals(param2finalKO1Bm) || m.getKO1B().equals(param3finalKO1Bm) || m.getKO1B().equals(param4finalKO1Bm))
                    .filter(m -> m.getKO1D().equals(param1finalKO1Dm) || m.getKO1D().equals(param2finalKO1Dm) || m.getKO1D().equals(param3finalKO1Dm) || m.getKO1B().equals(param4finalKO1Dm))
                    .collect(Collectors.toList());


            model.addAttribute("maleMice", maleMice);

            if (maleMice.size() == 0) {

                String noMiceWiththisParameter = "There are no mice that match your search";
                model.addAttribute("noMiceWiththisParameter", noMiceWiththisParameter);
            }
            if (femaleMice.size() == 0) {

                String noMiceWiththisParameterFemale = "There are no mice that match your search";
                model.addAttribute("noMiceWiththisParameterFemale", noMiceWiththisParameterFemale);
            }


            for (Mouse f : femaleMice) {
                for (Mouse m : maleMice) {


                    if (f.getOffspringId() != m.getOffspringId() && f.getMotherMousePassId() != m.getMotherMousePassId() && f.getFatherMousePassId() != m.getFatherMousePassId()) {
                        if (f.isAvailable() && m.isAvailable()) {
                            if (matched.size() < Integer.valueOf(number)) {
                                matched.put(f, m);
                                f.setAvailable(false);
                                m.setAvailable(false);

                            } else {
                                break;
                            }


                        }


                    }
                }
            }

            model.addAttribute("matched", matched);

            if (matched.size() < Integer.valueOf(number) && matched.size() != 0) {

                String notEnoughMice = "Amount of possible matches: " + matched.size() + ".";
                model.addAttribute("notEnoughMice", notEnoughMice);
            }
            if (matched.size() == 0) {

                String noMatches = "There are no matches, please change your search criteria.";
                model.addAttribute("noMatches", noMatches);

            }

            System.out.println("Nie dopasowano pary dla samic: ");
            for (Mouse m : femaleMice) {

                if (m.isAvailable()) {

                    System.out.println(m.getId());
                }

            }
            System.out.println("Nie dopasowano pary dla samców: ");
            for (Mouse m : maleMice) {

                if (m.isAvailable()) {

                    System.out.println(m.getId());
                }

            }


            return "match";


        } catch (NullPointerException e) {



        }
        return "findAMatch";
    }
}


