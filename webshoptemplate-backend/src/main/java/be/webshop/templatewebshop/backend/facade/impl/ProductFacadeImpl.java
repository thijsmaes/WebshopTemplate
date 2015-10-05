package be.webshop.templatewebshop.backend.facade.impl;

import be.webshop.templatewebshop.backend.entities.Product;
import be.webshop.templatewebshop.backend.facade.ProductFacade;

import javax.ejb.Stateless;

/**
 * Created by tmaes on 2/10/2015.
 */
@Stateless
public class ProductFacadeImpl implements ProductFacade {

    @Override
    public Product create(Product entity) {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public Product findById(Long id) {
        return null;
    }
}
