package be.webshop.templateshop.frontend.component.shopbuilder;

import be.webshop.templateshop.frontend.component.ComponentBuilder;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.*;
import com.vaadin.ui.Component;

/**
 * Created by tmaes on 19/08/2015.
 */
public class ShopBuilder2 implements ComponentBuilder{

	private ShopModel shopModel;

	@Override
	public Component build() {
		ShopView view = new ShopViewImpl();
		ShopPresenter presenter= new JewelShopPresenter(shopModel, view);

		return null;
	}

	public ShopBuilder2 addShopModelToContext(ShopModel shopModel) {
		this.shopModel = shopModel;
		return this;
	}
}
