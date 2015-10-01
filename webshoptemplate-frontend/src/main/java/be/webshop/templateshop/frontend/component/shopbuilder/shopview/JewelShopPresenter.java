package be.webshop.templateshop.frontend.component.shopbuilder.shopview;

/**
 * Created by tmaes on 19/08/2015.
 */
public class JewelShopPresenter extends ShopPresenter {
	ShopModel shopModel;
	ShopView shopView;

	public JewelShopPresenter(ShopModel shopModel, ShopView shopView) {
		this.shopModel = shopModel;
		this.shopView = shopView;

		createJewelView();
		shopView.createFilterPanel();
	}

	private void createJewelView() {
		shopView.createFilterMenu(this);
	}
}