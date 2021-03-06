package be.webshop.templateshop.frontend.component.shopbuilder;

import be.webshop.templateshop.frontend.component.ComponentBuilder;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.ShopModel;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.JewelShopPresenter;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.ShopView;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.ShopViewImpl;
import com.vaadin.ui.Component;

/**
 * Created by tmaes on 19/08/2015.
 */
public class ShopBuilder implements ComponentBuilder {

	private ShopModel shopModel;

	@Override
	public Component build() {
		ShopView shopView = new ShopViewImpl();
		new JewelShopPresenter(shopModel, shopView);
		return shopView;
	}

	public ComponentBuilder addShopModelToContext(ShopModel shopModel) {
		this.shopModel=shopModel;
		return this;
	}
}
