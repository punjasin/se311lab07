package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Punjasin on 17/3/2558.
 */
public interface ProductRepository extends JpaRepository<Product,Long> {

}
