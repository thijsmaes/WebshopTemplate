/*
package WebShop001.util;

//import be.fedasil.matchit.backend.model.*;
//import be.fedasil.matchit.frontend.FedasilUI;
//import be.fedasil.matchit.frontend.component.placemanagement.PlacesManagementGenericModel;

import WebShop001.Webshop001UI;
import com.vaadin.data.fieldgroup.BeanFieldGroup;

public class SessionUtil {

	public static PlacesManagementGenericModel getModelFromSession(Class entityClass) {
		return (PlacesManagementGenericModel) 
			Webshop001UI.get().getSession().getAttribute(
				PlacesManagementGenericModel.class.getSimpleName() + "_" + entityClass.getSimpleName());
	}
	
	public static void putModelInSession(PlacesManagementGenericModel model, Class entityClass) {
		FedasilUI.get().getSession().setAttribute(
	    	PlacesManagementGenericModel.class.getSimpleName() + "_" + entityClass.getSimpleName(), model);
	}
	
*
	 * @return Model from session (if not present : create new one).


	public static PlacesManagementGenericModel getModelCreateNewIfNotAvailable(Class entityClass) {
		PlacesManagementGenericModel model = getModelFromSession(entityClass);
		if (model == null) {
			model = initPlacesManagementGenericModel(entityClass);
		}
		return model;
	}
	
	public static PlacesManagementGenericModel initPlacesManagementGenericModel(Class entityClass) {
		PlacesManagementGenericModel model = new PlacesManagementGenericModel(entityClass);
		model.setEditMode(PlacesManagementGenericModel.EditMode.READ);		
		if (entityClass.getName().equals(ReceptionCenter.class.getName())) {
			model.setFindCriteria(new ReceptionCenterFindCriteria());
			model.setStayOnSameTab(true);
		} else {
			model.setFindCriteria(new FindCriteria());
			model.setStayOnSameTab(false);
		}
		model.setSelectedEntityId(null);
		putModelInSession(model, entityClass);
		return model;
	}
	
	public static void initPlacesManagementGenericModels() {
		initPlacesManagementGenericModel(Place.class);
		initPlacesManagementGenericModel(Room.class);
		initPlacesManagementGenericModel(Location.class);
		initPlacesManagementGenericModel(ReceptionCenter.class);
	}


	public static void putSingleBeanInSession(BeanFieldGroup<?> beanFieldGroup, Class entityClass) {
		FedasilUI.get().getSession().setAttribute(
				PlacesManagementGenericModel.class.getSimpleName() + "_" + entityClass.getSimpleName(), beanFieldGroup);
	}
}
*/
