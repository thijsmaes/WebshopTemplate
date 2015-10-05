package be.webshop.templatewebshop.backend.facade;

import be.webshop.templatewebshop.backend.entities.Product;

import javax.ejb.Local;

/**
 * Created by tmaes on 2/10/2015.
 */
@Local
public interface ProductFacade extends GenericCrudFacade<Product, Long>{
}
