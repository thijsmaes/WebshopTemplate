package be.webshop.templateshop.frontend.pages;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by tmaes on 29/06/2015.
 */
public class Menubar {

	public Menubar(){

		createButtonView();
	}

	private HorizontalLayout createButtonView() {
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setSizeFull();
		//buttonLayout.setStyleName();
		Button home = createHomeButton();
		Button shoes = createShoesButton();

		buttonLayout.addComponent(home);
		buttonLayout.addComponent(shoes);
		return buttonLayout;
	}

	private Button createShoesButton() {
		Button shoes = new Button("!SHOES!");
		shoes.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent clickEvent) {

			}
		});
		return shoes;
	}

	private Button createHomeButton() {
		Button home = new Button("!HOME!");
		home.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent clickEvent) {

			}
		});
		return home;
	}
}
