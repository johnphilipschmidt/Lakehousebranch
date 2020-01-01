package net.jpschmidt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private OldProductService service;
	private ActivityService activityService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<OldProduct> listProducts = service.listAll ();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}


	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		OldProduct product = new OldProduct ();
		model.addAttribute("product", product);
		
		return "new_product";
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct (@ModelAttribute("product") OldProduct product) {
		service.save(product);
		System.out.println ("I am still here after actvity");
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		OldProduct product = service.get (id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
