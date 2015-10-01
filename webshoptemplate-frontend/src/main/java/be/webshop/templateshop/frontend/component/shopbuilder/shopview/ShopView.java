package be.webshop.templateshop.frontend.component.shopbuilder.shopview;

import com.vaadin.ui.Component;

/**
 * Created by tmaes on 19/08/2015.
 */
public interface ShopView extends Component{
	void createFilterPanel();

	void createFilterMenu(JewelShopPresenter jewelShopPresenter);
}
