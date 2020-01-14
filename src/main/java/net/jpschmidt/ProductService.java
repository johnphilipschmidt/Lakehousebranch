package net.jpschmidt;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
    private ProductRepository repo;
    @Autowired
    private ProductDetailRepository repoDetail;

    public List<Product> listAll () {
        List<Product> myList = repo.findAll ();
        System.out.println ("service:" + myList.size ());
        return repo.findAll (Sort.by (Sort.Order.asc ("productId")));
    }

    public Optional<ProductDetail> productDetails (Long productId) {
        return repoDetail.findById (productId);
	}

    public void save (Product product) {
		repo.save(product);
	}

    public Product get (long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
