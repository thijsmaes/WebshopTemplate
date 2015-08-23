package be.webshop.templateshop.frontend.component.shopbuilder.shoppresenter;

import be.webshop.templateshop.frontend.component.shopbuilder.shopmodel.ShopModel;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.ShopView;

/**
 * Created by tmaes on 19/08/2015.
 */
public class ShopPresenter {
	ShopModel shopModel;
	ShopView shopView;

	public ShopPresenter(ShopModel shopModel, ShopView shopView) {
		this.shopModel=shopModel;
		this.shopView=shopView;

		
	}
}
