package com.minres.coredsl.ui.preferences;

import com.minres.coredsl.preferences.PreferenceConstants;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

@SuppressWarnings("all")
public class CoreDSLPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
  public CoreDSLPreferencePage() {
    super(FieldEditorPreferencePage.GRID);
    final ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, PreferenceConstants.SCOPE_NAME);
    this.setPreferenceStore(store);
    this.setDescription("Code generator configuration options");
  }
  
  @Override
  public void createFieldEditors() {
    Composite _fieldEditorParent = this.getFieldEditorParent();
    DirectoryFieldEditor _directoryFieldEditor = new DirectoryFieldEditor(PreferenceConstants.P_TEMPLATE_DIR, "Template directory:", _fieldEditorParent);
    this.addField(_directoryFieldEditor);
  }
  
  @Override
  public void init(final IWorkbench workbench) {
  }
}
