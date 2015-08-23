/*
package WebShop001.template;

import be.fedasil.matchit.backend.logger.MatchitLogger;
import be.fedasil.matchit.backend.logger.MatchitLoggerFactory;
import be.fedasil.matchit.backend.model.*;
import be.fedasil.matchit.frontend.FedasilUI;
import be.fedasil.matchit.frontend.component.ComponentBuilder;
import be.fedasil.matchit.frontend.component.lookupplace.LookupPlaceBuilder;
import be.fedasil.matchit.frontend.component.lookupplace.LookupPlaceBuilder.LookupPlaceListener;
import be.fedasil.matchit.frontend.component.lookupplace.LookupPlaceViewImpl;
import be.fedasil.matchit.frontend.component.placemanagement.PlaceManagementTabSheetViewBuilder;
import be.fedasil.matchit.frontend.component.placemanagement.PlacesManagementGenericModel;
import be.fedasil.matchit.frontend.component.placemanagement.PlacesManagementGenericModel.EditMode;
import be.fedasil.matchit.frontend.menu.*;
import be.fedasil.matchit.frontend.util.SessionUtil;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CssLayout;

*/
/**
 * A template controls the overall page layout. It has following layout: <p/>
 * <pre>
 *  +-------------------------+
 *  |         Header          |
 *  +-------------------------+
 *  | Main Menu               |
 *  +----------+--------------+
 *  | Quick-   |              |
 *  | Search   |              |
 *  +----------+              |
 *  | SubMenu  |    Body      |
 *  |          |              |
 *  +----------+              |
 *  | Quick-   |              |
 *  |  Link    |              |
 *  +----------+--------------|
 *  |         Footer          |
 *  +-------------------------+
 * </pre>
 *
 * @author wdewit
 *//*

public class NormalPageViewImpl extends CssLayout implements PageView, View, LookupPlaceListener {
	private static final MatchitLogger logger = MatchitLoggerFactory.getLogger(NormalPageViewImpl.class);
	private static final long serialVersionUID = 2214712538561739489L;

	*/
/**
	 * Container for the body part of the view
	 *//*

	private SubMenuView subMenuPart;
	private PagePresenter pagePresenter;
	private CssLayout mainFrame;

	public NormalPageViewImpl() {
		logger.debug("New NormalPageViewImpl");
		pagePresenter = FedasilUI.get().getCurrentPagePresenter();
		if (pagePresenter == null)
			FedasilUI.get().setCurrentPagePresenter(pagePresenter = new NormalPagePresenter(this));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		logger.debug("NormalPageViewImpl.enter:" + event);

		removeAllComponents();

		LanguageBar languageBar = new LanguageBar();
		Header header = new Header();
		MainMenuView mainMenu = new MainMenuBuilder().build();
		LookupPlaceViewImpl lookupPlace = new LookupPlaceBuilder()
				.setLookupListener(this)
				.build();

		subMenuPart = new SubMenuView(pagePresenter);
		subMenuPart.setId("left-menu-container");

		CssLayout sidebar = new CssLayout();
		sidebar.setId("sidebar");
		sidebar.addComponent(lookupPlace);
		sidebar.addComponent(subMenuPart);

		mainFrame = new CssLayout();
		mainFrame.setId("main-frame");
		mainFrame.setPrimaryStyleName("clear-block");

		CssLayout mainContent = new CssLayout();
		mainContent.setId("main-content");
		mainContent.setStyleName("clear-block");
		mainContent.addComponent(sidebar);
		mainContent.addComponent(mainFrame);

		CssLayout wrapper = new CssLayout();
		wrapper.setId("wrapper");
		wrapper.addComponent(languageBar);
		wrapper.addComponent(header);
		wrapper.addComponent(mainMenu);
		wrapper.addComponent(mainContent);

		Footer footer = new Footer();
		footer.setStyleName("m-footer");

		addComponent(wrapper);
		addComponent(footer);
	}

	@Override
	public void selectedPlace(Place place) {
		putPlacesManagementModelInSession(place, place.getPlaceId(), true);
		Room room = place.getRoom();
		putPlacesManagementModelInSession(room, room.getRoomId(), false);
		Location location = room.getLocation();
		putPlacesManagementModelInSession(location, location.getLocationId(), false);
		ReceptionCenter receptionCenter = location.getReceptionCenter();
		putPlacesManagementModelInSession(receptionCenter, receptionCenter.getReceptionCenterId(), false);
				
		setBody(new PlaceManagementTabSheetViewBuilder());
	}

	@Override
	public void setCurrentMenuItem(MainMenuItem menuItem) {
		logger.debug("setCurrentMenuItem IN with:" + menuItem.getCaptionCode());
		subMenuPart.setSubMenuItems(menuItem.getSubMenuItems());
	}

	@Override
	public void setCurrentSubMenuItem(SubMenuItem subMenuItem) {
		logger.debug("setCurrentSubMenuItem IN with:" + subMenuItem.getCaptionCode());
		if (subMenuItem.getComponentBuilder() != null) {
			setBody(subMenuItem.getComponentBuilder());
		} else {
			subMenuItem.startConfigurationWindow(subMenuItem);
		}
	}

	*/
/**
	 * Replaces the body part with the Component returned by the {@link
	 * ComponentBuilder#build() builder.build()} method.
	 *
	 * @param builder required ComponentBuilder instance
	 *//*

	@Override
	public void setBody(ComponentBuilder builder) {
		mainFrame.removeAllComponents();
		mainFrame.addComponent(builder.build());
	}
	
	private void putPlacesManagementModelInSession(Object entity, Long entityPkId, boolean showEntityByDefault) {
		PlacesManagementGenericModel model = new PlacesManagementGenericModel(entity.getClass());		
		model.setEditMode(EditMode.READ);
		FindCriteria findCriteria;
		if (entity instanceof ReceptionCenter) {
			findCriteria = new ReceptionCenterFindCriteria();
		} else {
			findCriteria = new FindCriteria();	
		}
		
		findCriteria.setId(entityPkId);
		model.setFindCriteria(findCriteria);
		model.setSelectedEntity(entity);
		model.setSelectedEntityId(entityPkId);
		model.setStayOnSameTab(showEntityByDefault);
		SessionUtil.putModelInSession(model, entity.getClass());
	}
}
*/
