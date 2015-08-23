package be.webshop.templateshop.frontend.template;

//import be.fedasil.matchit.backend.configuration.MatchitConfiguration;
//import be.fedasil.matchit.backend.facade.FacadeFactory;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

/**
 * Created by tmaes on 17/04/2015.
 *
 */


public class Footer extends CssLayout {
	public Footer() {
		
//		String version = FacadeFactory.lookupFacade(
//			MatchitConfiguration.class).getConfigurationValue("VERSION");
		
		CssLayout inner = new CssLayout();
		Label label = new Label("tacoteo webshop 001 " + /*((version != null) ? version : "") +*/ " © 2015 - Privacy");

		inner.addComponent(label);
		addComponent(inner);

		inner.setId("footer");
		setId("footer-outer");
	}
}
