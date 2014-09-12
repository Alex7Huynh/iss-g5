// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230725, "field 'viewFile'");
    target.viewFile = (android.widget.Button) view;
    view = finder.findRequiredView(source, 2131230724, "field 'passwordText'");
    target.passwordText = (android.widget.EditText) view;
  }

  public static void reset(com.example.demomobilesecurity.MainActivity target) {
    target.viewFile = null;
    target.passwordText = null;
  }
}
