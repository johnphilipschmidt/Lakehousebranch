package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	}
	
	public Activity get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
