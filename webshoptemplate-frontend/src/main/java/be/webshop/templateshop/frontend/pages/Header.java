package be.webshop.templateshop.frontend.pages;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by tmaes on 29/06/2015.
 */
public class Header extends HorizontalLayout{
	Menubar menubar;
	Image headerImage = new Image(null, new ThemeResource("img/flowers-wallpaper-4.jpg"));

	public Header(){
		setId("header");
		VerticalLayout vl = new VerticalLayout();
		Label label = new Label("this is a great webshop");
		/*for(int i=0; i<5; i++){
			label= new Label("blabla");
			vl.addComponent(label);
		}*/
//		headerImage.set
		headerImage.setHeight("100px");
		headerImage.setWidth("950px");
		addComponent(headerImage);
	}
}
