package be.webshop.templateshop.frontend.template;

import be.webshop.templateshop.frontend.util.UIHelper;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;

/**
 * Created by tmaes on 7/05/2015.
 */

public class LanguageBar extends CssLayout {
	private static ThemeResource blgLogoRes = new ThemeResource("img/blgm_beLogo.gif");

	public LanguageBar() {
		CssLayout belgiumInner = new CssLayout();
		CssLayout belgiumHeader = new CssLayout();
		CssLayout belgiumHeaderWrapper = new CssLayout();
		CssLayout block = new CssLayout();
		CssLayout switcher = new CssLayout();
		CssLayout logoWrapper = new CssLayout();
		Image logoImage = new Image(null, blgLogoRes);

		setId("federalheader-outer");
		setStyleName("clear-block");
		belgiumInner.setId("federalheader");
		belgiumHeader.setId("blgm_belgiumHeader");
		belgiumHeaderWrapper.setStyleName("blgm_wrapper");
		block.setId("block-one_i18n-0");
		switcher.setStyleName("language-switcher");
		logoWrapper.setId("blgm_beLogo");

		addComponent(belgiumInner);
		belgiumInner.addComponent(belgiumHeader);
		belgiumHeader.addComponent(belgiumHeaderWrapper);
		belgiumHeaderWrapper.addComponent(block);
		belgiumHeaderWrapper.addComponent(logoWrapper);
		block.addComponent(switcher);
		switcher.addComponent(UIHelper.languageSwitcher("nl"));
		switcher.addComponent(UIHelper.languageSwitcher("fr"));
		switcher.addComponent(UIHelper.languageSwitcher("en"));
		logoWrapper.addComponent(logoImage);
	}
}
