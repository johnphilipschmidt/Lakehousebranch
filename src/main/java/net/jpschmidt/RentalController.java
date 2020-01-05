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
public class RentalController {

	@Autowired
    private RentalService service;
	
	@RequestMapping("/rental")
	public String viewRentalPage(Model model) {
        List<Rental> listRentals = service.listAll ();
        model.addAttribute ("listRentals", listRentals);
		
		return "rental";
	}

    @RequestMapping("/rental/new")
    public String showNewRentalPage (Model model) {
        Rental rental = new Rental ();
        model.addAttribute ("rental", rental);

        return "new_rental";
    }
	
	@RequestMapping(value = "/rental/save", method = RequestMethod.POST)
    public String saveRental (@ModelAttribute("rental") Rental rental) {
        service.save (rental);

        return "redirect:/rental";
	}
	
	@RequestMapping("/rental/edit/{id}")
    public ModelAndView showEditRentalPage (@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView ("edit_rental");
        Rental rental = service.get (id);
        mav.addObject ("rental", rental);
		
		return mav;
	}
	
	@RequestMapping("/rental/delete/{id}")
    public String deleteRental (@PathVariable(name = "id") int id) {
		service.delete(id);
        return "redirect:/rental";
	}
}
