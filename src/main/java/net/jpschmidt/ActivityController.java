package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class ActivityController {

	@Autowired
	private ActivityService service;

	@RequestMapping("/activity")
	public String viewActivityPage(Model model) {
		List<Activity> listActivities = service.listAll();
		model.addAttribute("listActivities", listActivities);
//		model.addAttribute("standardDate", new Date());
//		model.addAttribute("localDateTime", LocalDateTime.now());
		//model.addAttribute("fromDate", LocalDate.now());
		//model.addAttribute("toDate", LocalDate.now());
//		model.addAttribute("timestamp", Instant.now());
		//listActivities.forEach(act -> System.out.println(" list controller:"+act.getFromDate()));


		return "activity";
	}

    @RequestMapping("/activity/new")
    public String showNewActivityPage (Model model) {
        //System.out.println ("A controller act new");
        Activity activity = new Activity ();
        model.addAttribute ("activity", activity);

        return "new_activity";
    }


	@RequestMapping(value = "/activity/save", method = RequestMethod.POST)
	public String saveActivity(@ModelAttribute("activity") Activity activity) {
		//System.out.println("save:+"+activity.getFromDate());
		service.save(activity);

		
		return "redirect:/activity";

	}
	
	@RequestMapping("/activity/edit/{id}")
	public ModelAndView showEditActivityPage(@PathVariable(name = "id") int id) {
		System.out.println ("Calling edit activity");
		ModelAndView mav = new ModelAndView("edit_activity");
		Activity activity = service.get(id);
		mav.addObject("activity", activity);
		
		return mav;
	}
	
	@RequestMapping("/activity/delete/{id}")
	public String deleteActivity(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/activity";
	}

	private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new Java8TimeDialect());
		engine.setTemplateResolver(templateResolver);
		return engine;
	}
}
