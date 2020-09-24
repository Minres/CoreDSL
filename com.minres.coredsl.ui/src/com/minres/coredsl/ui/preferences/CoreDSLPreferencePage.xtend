package com.minres.coredsl.ui.preferences

import com.minres.coredsl.preferences.PreferenceConstants
import org.eclipse.core.runtime.preferences.InstanceScope
import org.eclipse.jface.preference.DirectoryFieldEditor
import org.eclipse.jface.preference.FieldEditorPreferencePage
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchPreferencePage
import org.eclipse.ui.preferences.ScopedPreferenceStore

class CoreDSLPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	new() {
		super(GRID)
	    val store = new ScopedPreferenceStore(InstanceScope.INSTANCE, PreferenceConstants.SCOPE_NAME);
	    setPreferenceStore(store);
	    setDescription("Code generator configuration options");
	}
	
	override createFieldEditors() {
    	addField(new DirectoryFieldEditor(PreferenceConstants.P_TEMPLATE_DIR, "Template directory:", getFieldEditorParent()));
	}
	
	override init(IWorkbench workbench) {
	}
	
}
