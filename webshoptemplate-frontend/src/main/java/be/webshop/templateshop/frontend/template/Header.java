package be.webshop.templateshop.frontend.template;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;

/**
 * Created by tmaes on 17/04/2015.
 */
public class Header extends CssLayout {
	private static final long serialVersionUID = 3891398924518439130L;

	public Header() {
		CssLayout matchitLogoBlock = new CssLayout();
		CssLayout fedasilLogoBlock = new CssLayout();
		Image matchitLogo = new Image(null, new ThemeResource("img/logo_matchit.png"));
		Image fedasilLogo = new Image(null, new ThemeResource("img/logo_fr.png"));

		setId("header");
		setStyleName("clear-block");
		matchitLogoBlock.setId("logo1");
		fedasilLogoBlock.setId("logo2");

		addComponent(matchitLogoBlock);
		addComponent(fedasilLogoBlock);
		matchitLogoBlock.addComponent(matchitLogo);
		fedasilLogoBlock.addComponent(fedasilLogo);

		fedasilLogo.setDescription("Fedasil");
	}
}
