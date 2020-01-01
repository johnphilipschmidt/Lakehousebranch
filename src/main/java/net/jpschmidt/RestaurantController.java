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
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/restaurant")
	public String viewRestaurantPage(Model model) {
		List<Restaurant> listRestaurants = restaurantService.listAll ();
		model.addAttribute ("listRestaurants", listRestaurants);
		
		return "restaurant";
	}
	
	@RequestMapping("/restaurant/new")
	public String showNewRestaurantPage (Model model) {
		Restaurant restaurant = new Restaurant ();
		model.addAttribute ("restaurant", restaurant);

		return "new_restaurant";
	}
	
	@RequestMapping(value = "/restaurant/save", method = RequestMethod.POST)
	public String saveRestaurant (@ModelAttribute("restaurant") Restaurant restaurant) {
		restaurantService.save (restaurant);

		return "redirect:/restaurant";
	}
	
	@RequestMapping("/restaurant/edit/{id}")
	public ModelAndView showEditRestaurantPage (@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView ("edit_restaurant");
		Restaurant restaurant = restaurantService.get (id);
		mav.addObject ("restaurant", restaurant);
		
		return mav;
	}
	
	@RequestMapping("/restaurant/delete/{id}")
	public String deleteRestaurant (@PathVariable(name = "id") int id) {
		restaurantService.delete (id);
		return "redirect:/restaurant";
	}
}
