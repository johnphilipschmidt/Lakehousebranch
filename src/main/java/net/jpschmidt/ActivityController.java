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
public class ActivityController {

	@Autowired
	private ActivityService service;
	
	@RequestMapping("/activity")
	public String viewActivityPage(Model model) {
		List<Activity> listActivities = service.listAll();
		model.addAttribute("listActivities", listActivities);
		
		return "activity";
	}
	
	@RequestMapping("/activity/new")
	public String showNewActivityPage(Model model) {
		Activity activity = new Activity();
		model.addAttribute("activity", activity);
		
		return "new_activity";
	}
	
	@RequestMapping(value = "/activity/save", method = RequestMethod.POST)
	public String saveActivity(@ModelAttribute("activity") Activity activity) {
		service.save(activity);
		
		return "redirect:/activity";
	}
	
	@RequestMapping("/activity/edit/{id}")
	public ModelAndView showEditActivityPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_activity");
		Activity activity = service.get(id);
		mav.addObject("activity", activity);
		
		return mav;
	}
	
	@RequestMapping("/activity/delete/{id}")
	public String deleteActivity(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
