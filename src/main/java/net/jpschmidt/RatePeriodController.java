package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RatePeriodController {

    @Autowired
    private RatePeriodService service;

    @RequestMapping("/rateperiod")
    public String viewRatePeriodPage (Model model) {
        List<RatePeriod> listActivities = service.listAll ();
        model.addAttribute ("listActivities", listActivities);

        return "rateperiod";
    }

    @RequestMapping("/rateperiod/new")
    public String showNewRatePeriodPage (Model model) {
        System.out.println ("A controller act new");
        RatePeriod rateperiod = new RatePeriod ();
        model.addAttribute ("rateperiod", rateperiod);

        return "new_rateperiod";
    }


    @RequestMapping(value = "/rateperiod/save", method = RequestMethod.POST)
    public String saveRatePeriod (@ModelAttribute("rateperiod") RatePeriod rateperiod) {
        service.save (rateperiod);

        return "redirect:/rateperiod";

    }

    @RequestMapping("/rateperiod/edit/{id}")
    public ModelAndView showEditRatePeriodPage (@PathVariable(name = "id") int id) {
        System.out.println ("Calling edit rateperiod");
        ModelAndView mav = new ModelAndView ("edit_rateperiod");
        RatePeriod rateperiod = service.get (id);
        mav.addObject ("rateperiod", rateperiod);

        return mav;
    }

    @RequestMapping("/rateperiod/delete/{id}")
    public String deleteRatePeriod (@PathVariable(name = "id") int id) {
        service.delete (id);
        return "redirect:/rateperiod";
    }
}
