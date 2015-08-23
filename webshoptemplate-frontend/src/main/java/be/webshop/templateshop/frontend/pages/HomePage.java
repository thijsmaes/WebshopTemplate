package be.webshop.templateshop.frontend.pages;


import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by tmaes on 29/06/2015.
 */
public class HomePage extends Template {

	private Panel view;

	public HomePage() {

//		view = createView();
	}

	private Panel createView() {
		Panel homeView = new Panel();
		VerticalLayout vl = new VerticalLayout();
		vl.setSpacing(true);

		for (int i = 0; i < 5; i++) {
			Label label = new Label("whatever");
			vl.addComponent(label);
		}

		homeView.setContent(vl);
		return homeView;
	}

//	@Override
	public Component getBody() {
		return createView();
	}
}
