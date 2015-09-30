package be.webshop.templateshop.frontend.component.util;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;

/**
 * @author gvginder
 */
public abstract class TemplateShopLazyTab extends CustomComponent {
	private Component root;

	public TemplateShopLazyTab() {
		setPrimaryStyleName("m-lazy-component");
		setSizeUndefined();
	}

	public final void load() {
		if (root == null) {
			root = build();
			setCompositionRoot(root);
		}
	}

	protected abstract Component build();
}