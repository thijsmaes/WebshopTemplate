package be.webshop.templateshop.frontend.menu;


import be.webshop.templateshop.frontend.component.ComponentBuilder;
import be.webshop.templateshop.frontend.component.shopbuilder.ShopBuilder;
import be.webshop.templateshop.frontend.component.shopbuilder.ShopBuilder2;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.ShopModel;
import be.webshop.templateshop.frontend.util.LocaleText;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;

import java.util.ArrayList;
import java.util.List;

public class MainMenuBuilder implements ComponentBuilder {
	@Override
	public MainMenuView build() {
		MainMenuView view = new MainMenuView();
		view.setMenuItems(buildMenuItems());
		return view;
	}

	private List<MainMenuItem> buildMenuItems() {
		List<MainMenuItem> items = new ArrayList<MainMenuItem>();

		MainMenuItem home = new MainMenuItem("Home");
		home.setComponentBuilder(new LabelComponentBuilder("home.welcome"));

		MainMenuItem products = new MainMenuItem("Products");
		products.setComponentBuilder(new LabelComponentBuilder("places.welcome"));
		
		SubMenuItem productType1 = new SubMenuItem();
		productType1.setCaptionCode("shoes");
		productType1.setComponentBuilder(new ShopBuilder().addShopModelToContext(new ShopModel()));
		products.getSubMenuItems().add(productType1);

		SubMenuItem productType2 = new SubMenuItem();
		productType2.setCaptionCode("jewels");
		productType2.setComponentBuilder(new ShopBuilder2().addShopModelToContext(new ShopModel()));
		products.getSubMenuItems().add(productType2);

		items.add(home);
		items.add(products);
		return items;
	}

	private class LabelComponentBuilder implements ComponentBuilder {
		private String messageCode;

		public LabelComponentBuilder(String messageCode) {
			super();
			this.messageCode = messageCode;
		}

		@Override
		public Component build() {
			return new Label(LocaleText.getCaption(messageCode));
		}
	}
}
