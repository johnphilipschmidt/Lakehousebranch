package net.jpschmidt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OldProductService {

	@Autowired
	private OldProductRepository repo;

	public List<OldProduct> listAll () {
		return repo.findAll();
	}

	public void save (OldProduct product) {
		repo.save(product);
	}

	public OldProduct get (long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
