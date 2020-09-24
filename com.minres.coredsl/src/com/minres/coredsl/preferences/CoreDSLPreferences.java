package com.minres.coredsl.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

public class CoreDSLPreferences {

	public static String getTemplateDir() {
		return getPreferenceStore().get(PreferenceConstants.P_TEMPLATE_DIR, System.getProperty(PreferenceConstants.P_TEMPLATE_DIR));
	}

	public static IEclipsePreferences getPreferenceStore() {
		return InstanceScope.INSTANCE.getNode(PreferenceConstants.SCOPE_NAME);
	}
}