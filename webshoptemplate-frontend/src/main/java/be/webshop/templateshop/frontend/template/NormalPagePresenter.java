package be.webshop.templateshop.frontend.template;


import be.webshop.templateshop.frontend.component.ComponentBuilder;
import be.webshop.templateshop.frontend.menu.MainMenuItem;
import be.webshop.templateshop.frontend.menu.SubMenuItem;

public class NormalPagePresenter implements PagePresenter {
//	private static final MatchitLogger logger = MatchitLoggerFactory
//			.getLogger(NormalPagePresenter.class);
	
	private PageView view;
	
	public NormalPagePresenter(PageView view) {
		this.view=view;
	}

	public void onMenuSelected(MainMenuItem menuItem){
		view.setCurrentMenuItem(menuItem);
	}
	
	public void onSubMenuSelected(SubMenuItem subMenuItem)
	{
		// TODO check access rights for the current user
		view.setCurrentSubMenuItem(subMenuItem);
	}
	
	public void doBodyRefresh(ComponentBuilder bodyComponentBuilder) {
		view.setBody(bodyComponentBuilder);
	}

}
