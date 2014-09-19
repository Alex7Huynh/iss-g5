// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SettingsActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.SettingsActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230741, "field 'et_newpass'");
    target.et_newpass = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230740, "field 'et_oldpass'");
    target.et_oldpass = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230742, "field 'et_conpass'");
    target.et_conpass = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230743, "method 'onConfirm'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onConfirm();
        }
      });
  }

  public static void reset(com.example.demomobilesecurity.SettingsActivity target) {
    target.et_newpass = null;
    target.et_oldpass = null;
    target.et_conpass = null;
  }
}
