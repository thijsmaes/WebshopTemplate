package be.webshop.templateshop.frontend.component.util;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tmaes
 */
public class FedasilLazyTabSheet extends CssLayout {
	private final List<Tab> tabs;

	private final CssLayout captionContainer;
	private final CssLayout contentContainer;

	public FedasilLazyTabSheet() {
		tabs = new LinkedList<>();

		captionContainer = new CssLayout();
		captionContainer.setPrimaryStyleName("m-tabsheet-caption-container");

		contentContainer = new CssLayout();
		contentContainer.setPrimaryStyleName("m-tabsheet-content-container");

		setPrimaryStyleName("m-tabsheet-container");
		addComponent(captionContainer);
		addComponent(contentContainer);
	}

	public void addTab(final Component component, String caption) {
		addTab(component, caption, captionContainer.getComponentCount());
	}

	public void addTab(final Component component, String caption, int index) {
		final Tab tab = new Tab(caption, component);
		tabs.add(index, tab);

		TabButton button = new TabButton(tab);
		button.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				setSelectedTab(tab);
			}
		});

		captionContainer.addComponent(button, index);
		if (captionContainer.getComponentCount() == 1) {
			setSelectedTab(tab);
		}
	}

	public void setSelectedTab(int index) {
		if (index < tabs.size()) {
			Tab tab = tabs.get(index);
			setSelectedTab(tab);
		}
	}

	public void setSelectedTab(Component component) {
		for (Tab tab : tabs) {
			if (tab.component == component) {
				setSelectedTab(tab);
				break;
			}
		}
	}

	private void setSelectedTab(Tab tab) {
		if (tab.component instanceof FedasilLazyTab) {
			FedasilLazyTab fedasilLazyTab = (FedasilLazyTab) tab.component;
			fedasilLazyTab.load();
		}

		contentContainer.removeAllComponents();
		contentContainer.addComponent(tab.component);

		for (int index = 0; index < captionContainer.getComponentCount(); index++) {
			TabButton button = (TabButton)
					captionContainer.getComponent(index);
			if (button.tab == tab) {
				button.addStyleName("m-selected");
			} else {
				button.removeStyleName("m-selected");
			}
		}
	}

	private static class Tab {
		final String caption;
		final Component component;

		private Tab(String caption, Component component) {
			this.caption = caption;
			this.component = component;
		}
	}

	private static class TabButton extends Button {
		final Tab tab;

		public TabButton(Tab tab) {
			super(tab.caption);

			this.tab = tab;

			setPrimaryStyleName("m-tabsheet-caption");
		}
	}
}
