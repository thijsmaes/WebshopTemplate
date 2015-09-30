package be.webshop.templateshop.frontend.component.shopbuilder;

import be.webshop.templateshop.frontend.component.ComponentBuilder;
import be.webshop.templateshop.frontend.component.shopbuilder.shopmodel.ShopModel;
import com.vaadin.ui.Component;

/**
 * Created by tmaes on 19/08/2015.
 */
public class ShopBuilder2 implements ComponentBuilder{

	private ShopModel shopModel;

	@Override
	public Component build() {
		return null;
	}

	public ShopBuilder2 addShopModelToContext(ShopModel shopModel) {
		this.shopModel = shopModel;
		return this;
	}
}
