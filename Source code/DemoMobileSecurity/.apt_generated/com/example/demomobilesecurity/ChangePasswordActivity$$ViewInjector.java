// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ChangePasswordActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.ChangePasswordActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230722, "field 'oldPassword'");
    target.oldPassword = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230723, "field 'newPassword'");
    target.newPassword = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230724, "field 'renewPassword'");
    target.renewPassword = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230725, "field 'changePassword' and method 'changePassword'");
    target.changePassword = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.changePassword();
        }
      });
  }

  public static void reset(com.example.demomobilesecurity.ChangePasswordActivity target) {
    target.oldPassword = null;
    target.newPassword = null;
    target.renewPassword = null;
    target.changePassword = null;
  }
}
