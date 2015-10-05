package be.webshop.templatewebshop.backend.facade;


import java.util.List;

public interface GenericCrudFacade<T, I> {

	T create(T entity);
	
	T update(T entity);
	
	void delete(T entity);
	
	/**
	 * Find by PK id.
	 * 
	 * @param id PK id.
	 * @return Unique result.
	 */
	T findById(I id);
	
//	List<T> find(FindCriteria findCriteria);
}
