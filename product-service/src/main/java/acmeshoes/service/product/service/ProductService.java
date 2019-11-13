package acmeshoes.service.product.service;

import acmeshoes.service.product.data.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service that retrieves product information.
 */
@Service
public class ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repo;
}
