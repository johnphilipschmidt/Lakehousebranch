package net.jpschmidt;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {


}
