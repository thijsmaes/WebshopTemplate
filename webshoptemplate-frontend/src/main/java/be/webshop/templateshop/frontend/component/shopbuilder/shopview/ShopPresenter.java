package be.webshop.templateshop.frontend.component.shopbuilder.shopview;

/**
 * Created by tmaes on 1/10/2015.
 */
public abstract class ShopPresenter {

    private ShopView view;



    public ShopView getView() {
        return view;
    }

    public void setView(ShopView view) {
        this.view = view;
    }
}
