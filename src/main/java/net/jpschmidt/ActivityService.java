package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class ActivityService {

	@Autowired
	private ActivityRepository repo;
	
	public List<Activity> listAll() {
		return repo.findAll();
	}
	
	public void save(Activity activity) {
		repo.save(activity);
		repo.flush();
	}
	
	public Activity get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}

}
