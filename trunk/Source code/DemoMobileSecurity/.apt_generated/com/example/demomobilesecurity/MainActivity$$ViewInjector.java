// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230726, "field 'viewFile' and method 'viewFiles'");
    target.viewFile = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.viewFiles();
        }
      });
    view = finder.findRequiredView(source, 2131230727, "field 'changePassword' and method 'changePassword'");
    target.changePassword = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.changePassword();
        }
      });
    view = finder.findRequiredView(source, 2131230728, "field 'viewSMSApp'");
    target.viewSMSApp = (android.widget.Button) view;
    view = finder.findRequiredView(source, 2131230725, "field 'passwordText'");
    target.passwordText = (android.widget.EditText) view;
  }

  public static void reset(com.example.demomobilesecurity.MainActivity target) {
    target.viewFile = null;
    target.changePassword = null;
    target.viewSMSApp = null;
    target.passwordText = null;
  }
}
