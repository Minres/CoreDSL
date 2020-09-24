package com.minres.coredsl.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IEclipsePreferences store = getPreferenceStore();
		String value = System.getProperty(PreferenceConstants.P_TEMPLATE_DIR);
		if(value!=null){
			store.put(PreferenceConstants.P_TEMPLATE_DIR, "byte");
		} else 
			store.put(PreferenceConstants.P_TEMPLATE_DIR, "src/templates");
	}

	public static IEclipsePreferences getPreferenceStore() {
		return DefaultScope.INSTANCE.getNode(PreferenceConstants.SCOPE_NAME);
	}

}
