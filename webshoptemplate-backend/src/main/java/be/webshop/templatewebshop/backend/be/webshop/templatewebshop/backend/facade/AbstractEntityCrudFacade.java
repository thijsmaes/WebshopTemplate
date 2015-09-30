package be.webshop.templatewebshop.backend.be.webshop.templatewebshop.backend.facade;


import be.webshop.templatewebshop.backend.entities.AbstractEntity;

public interface AbstractEntityCrudFacade<T extends AbstractEntity, I>
		extends GenericCrudFacade<T, I> {

	void deactivate(T entity);

}
