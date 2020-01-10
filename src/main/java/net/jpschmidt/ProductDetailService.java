package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductDetailService {

    @Autowired
    private ProductDetailRepository repo;

    public List<ProductDetail> listAll () {
        return repo.findAll ();
    }

    public void save (ProductDetail productDetail) {
        repo.save (productDetail);
    }

    public ProductDetail get (long id) {
        return repo.findById (id).get ();
    }

    public void delete (long id) {
        repo.deleteById (id);
    }
}
