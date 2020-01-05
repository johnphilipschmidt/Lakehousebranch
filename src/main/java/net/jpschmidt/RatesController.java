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
public class RatesController {

    @Autowired
    private RatesService service;

    @RequestMapping("/rates")
    public String viewRatesPage (Model model) {
        List<Rates> listRates = service.listAll ();
        model.addAttribute ("listRates", listRates);

        return "rates";
    }

    @RequestMapping("/rates/new")
    public String showNewRatesPage (Model model) {
        System.out.println ("A controller act new");
        Rates rates = new Rates ();
        model.addAttribute ("rates", rates);

        return "new_rates";
    }


    @RequestMapping(value = "/rates/save", method = RequestMethod.POST)
    public String saveRates (@ModelAttribute("rates") Rates rates) {
        service.save (rates);

        return "redirect:/rates";

    }

    @RequestMapping("/rates/edit/{id}")
    public ModelAndView showEditRatesPage (@PathVariable(name = "id") int id) {
        System.out.println ("Calling edit rates");
        ModelAndView mav = new ModelAndView ("edit_rates");
        Rates rates = service.get (id);
        mav.addObject ("rates", rates);

        return mav;
    }

    @RequestMapping("/rates/delete/{id}")
    public String deleteRates (@PathVariable(name = "id") int id) {
        service.delete (id);
        return "redirect:/rates";
    }
}
