package be.webshop.templateshop.frontend.component.shopbuilder.shopview;

/**
 * Created by tmaes on 1/10/2015.
 */
public class ShoesShopPresenter extends ShopPresenter{
    ShopModel shopModel;
    ShopView shopView;

    public ShoesShopPresenter(ShopModel shopModel, ShopView shopView) {
        this.shopModel=shopModel;
        this.shopView=shopView;

        createJewelView();
        shopView.createFilterPanel();
    }

    private void createJewelView(){}

}
