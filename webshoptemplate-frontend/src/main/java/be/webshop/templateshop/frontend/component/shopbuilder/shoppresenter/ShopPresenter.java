package be.webshop.templateshop.frontend.component.shopbuilder.shoppresenter;

import be.webshop.templateshop.frontend.component.shopbuilder.shopmodel.ShopModel;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.ShopView;

import java.util.ArrayDeque;

/**
 * Created by tmaes on 19/08/2015.
 */
public class ShopPresenter {
	ShopModel shopModel;
	ShopView shopView;

public ArrayDeque a;
	public ShopPresenter(ShopModel shopModel, ShopView shopView) {
		this.shopModel=shopModel;
		this.shopView=shopView;

		createJewelView();
		shopView.createFilterPanel();
	}

	private void createJewelView() {

	}
}
