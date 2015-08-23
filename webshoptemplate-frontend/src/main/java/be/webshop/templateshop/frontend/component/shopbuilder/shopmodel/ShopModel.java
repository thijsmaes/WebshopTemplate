package be.webshop.templateshop.frontend.component.shopbuilder.shopmodel;

import be.webshop.templateshop.frontend.component.shopbuilder.shoppresenter.ShopPresenter;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.ShopView;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.ShopViewImpl;
import com.vaadin.ui.Component;

/**
 * Created by tmaes on 19/08/2015.
 */
public class ShopModel {

	ShopView shopView;
	ShopPresenter shopPresenter;

	public ShopModel(){
		shopView = new ShopViewImpl();
		shopPresenter = new ShopPresenter(this, shopView);
	}

	public Component getView() {
		return (ShopViewImpl) shopView;
	}
}
