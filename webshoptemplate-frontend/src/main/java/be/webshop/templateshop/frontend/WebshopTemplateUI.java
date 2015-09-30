package be.webshop.templateshop.frontend;

import javax.servlet.annotation.WebServlet;

import be.webshop.templateshop.frontend.pages.HomePage;
import be.webshop.templateshop.frontend.pages.Template;
import be.webshop.templateshop.frontend.template.PagePresenter;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

@Theme("webshop")
@Widgetset("be.webshop.templateshop.ShopWidgetset")
@SuppressWarnings("serial")
public class WebshopTemplateUI extends UI {
	private PagePresenter currentPagePresenter;
	private static final long serialVersionUID = -7899453212774486600L;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = WebshopTemplateUI.class) //, widgetset = "WebShopTemplate.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
		private static final long serialVersionUID = -9085700359453727641L;
	}

	public static WebshopTemplateUI get() {
		return (WebshopTemplateUI) UI.getCurrent();
	}

	@Override
	protected void init(VaadinRequest request) {
		CssLayout panel = new CssLayout();
		Template homeView = new Template();
		homeView.setSizeUndefined();

		Navigator navigator = new Navigator(getUI(), panel);
		navigator.addView("home", homeView);
		navigator.navigateTo("home");

       /* final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);*/

		setId("main");
		setSizeUndefined();
		setContent(panel);
		setNavigator(navigator);
	}

	public PagePresenter getCurrentPagePresenter() {
		return currentPagePresenter;
	}

	public void setCurrentPagePresenter(PagePresenter currentPagePresenter) {
		this.currentPagePresenter = currentPagePresenter;
	}

}
