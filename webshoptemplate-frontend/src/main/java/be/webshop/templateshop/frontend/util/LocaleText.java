package be.webshop.templateshop.frontend.util;

import com.vaadin.ui.UI;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

/**
 * This helper class manages translations. UI captions are defined in properties
 * files following the resourcebundle naming conventions. CodeLabels are taken
 * from the database
 * 
 * @author tmaes
 *
 */
public class LocaleText {
//	private static final MatchitLogger logger = MatchitLoggerFactory
//			.getLogger(LocaleText.class);
	private static List<String> FORMAT_DB = Arrays.asList("db");
	private static List<Locale> SUPPORTED_LOCALES = Arrays.asList(new Locale(
			"nl", "be"), new Locale("fr", "be"), Locale.ENGLISH, Locale.ROOT);
	private static MatchitDBControl DB_CONTROL = new MatchitDBControl();
	/**
	 * Name of the resource bundle containing the UI Captions.
	 */
	private static String CAPTIONS = "be.fedasil.matchit.frontend.util.captions";

	/**
	 * Get the translated text for the specified caption key in the language of
	 * the current user.
	 * 
	 * @param key
	 *            required key of the wanted text
	 * @return
	 */
	public static String getCaption(String key) {
		return getCaption(key, new Object[] {});
	}

	/**
	 * Get the translated text for the specified caption key in the language of
	 * the current user.
	 * 
	 * @param key
	 *            required key of the wanted text
	 * @return
	 */
	public static String getCaption(String key, Object[] parameters) {
//		String translation = get(CAPTIONS, key, FedasilUI.get().getLocale());
		if (parameters != null && parameters.length != 0) {
//			translation = MessageFormat.format(translation, parameters);
		}
//		return translation;
		return "";
	}

	/**
	 * Get the translated text for the specified key in the specified language.
	 * 
	 * @param key
	 *            required key of the wanted text
	 * @param locale
	 *            required Locale
	 * @return the translation caption. If no translation can be found for the
	 *         provided key the answer is "![key]".
	 */
	public static String getCaption(String key, Locale locale) {
		return get(CAPTIONS, key, locale);
	}

	private static String get(String bundle, String key, Locale locale) {
		try {
			if (locale == null) {
//				logger.warn("No locale defined");
				return ResourceBundle.getBundle(bundle).getString(key);
			}
			return ResourceBundle.getBundle(bundle, locale).getString(key);
		} catch (Exception ex) {
			return "!MISSING[" + key + "]";
		}

	}

	/**
	 * Get the translated label of a given code of the given code type.
	 * The values are looked up in the database and cached in memory as ResourceBundles. 
	 * @param codeType required code Type
	 * @param code value of the requested code.
	 * @return translated value of the code in the language of the current user. If no translation is found, the returned value = "!MISSING[code]".
	 */
	public static String getCodeLabel(String codeType, String code) {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(codeType, UI
					.getCurrent().getLocale(), DB_CONTROL);
			return bundle.getString(code);
		} catch (Exception ex) {
//			logger.error("Problem fetching code_label: type="+codeType+", code="+code,ex);
			return "!MISSING[" + code + "]";
		}
	}

	/**
	 * Returns all codes for the given code type.
	 */
	public static List<String> getCodes(String codeType) {
		ResourceBundle bundle = ResourceBundle.getBundle(codeType, UI
				.getCurrent().getLocale(), DB_CONTROL);
		return Collections.list(bundle.getKeys());
	}

	/**
	 * ResourceBundle Control implementation which fetches the messages from the
	 * database.
	 */
	private static class MatchitDBControl extends ResourceBundle.Control {

		@Override
		public List<String> getFormats(String baseName) {
			if (baseName.startsWith("be.fedasil.matchit"))
				return ResourceBundle.Control.FORMAT_PROPERTIES;
			return FORMAT_DB;
		}

		@Override
		public List<Locale> getCandidateLocales(String baseName, Locale locale) {
			return SUPPORTED_LOCALES;
		}

		@Override
		public ResourceBundle newBundle(String baseName, Locale locale,
				String format, ClassLoader loader, boolean reload)
				throws IllegalAccessException, InstantiationException,
				IOException {
			// Load messages from database table CodeLabel using basename as
			// CodeType
//			CodeLabelFacade clf = FacadeFactory
//					.lookupFacade(CodeLabelFacade.class);
//			logger.info("Fetching code labels for basename="+baseName+", locale="+locale);
//			return new DBResourceBundle(clf.getCodeLabels(baseName,
//					locale.getLanguage()));
			return null;
		}

		@Override
		public boolean needsReload(String baseName, Locale locale,
				String format, ClassLoader loader, ResourceBundle bundle,
				long loadTime) {
			return false;
		}
		
	}

	private static class DBResourceBundle extends ListResourceBundle {
		private Object[][] content;

		public DBResourceBundle(Map<String, String> items) {
			content = new Object[items.size()][2];
			int index = 0;
			for (Map.Entry<String, String> entry : items.entrySet()) {
				content[index][0] = entry.getKey();
				content[index][1] = entry.getValue();
				index++;
			}
		}

		@Override
		protected Object[][] getContents() {
			return content;
		}

	}
}
