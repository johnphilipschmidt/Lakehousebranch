package net.jpschmidt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AppController {

	@Autowired
	private OldProductService service;
	private ActivityService activityService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
//		List<OldProduct> listProducts = service.listAll ();
//		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}

	@RequestMapping("/activity/new")
	public String showNewActivityPage (Model model) {
		System.out.println ("A controller act new");
		Activity activity = new Activity ();
		model.addAttribute ("activity", activity);

		return "new_activity";
	}

	@RequestMapping("/rental/new")
	public String showNewRentalPage (Model model) {

		Rental rental = new Rental ();
		model.addAttribute ("rental", rental);

		return "new_rental";
	}
//	@RequestMapping("/new")
//	public String showNewProductPage(Model model) {
//		OldProduct product = new OldProduct ();
//		model.addAttribute("product", product);
//
//		return "new_product";
//	}


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

	public void process (
			final HttpServletRequest request, final HttpServletResponse response,
			final ServletContext servletContext, final ITemplateEngine templateEngine)
			throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd MMMM yyyy");
		Calendar cal = Calendar.getInstance ();

		WebContext ctx =
				new WebContext (request, response, servletContext, request.getLocale ());
		ctx.setVariable ("today", dateFormat.format (cal.getTime ()));

		templateEngine.process ("home", ctx, response.getWriter ());

	}
}
