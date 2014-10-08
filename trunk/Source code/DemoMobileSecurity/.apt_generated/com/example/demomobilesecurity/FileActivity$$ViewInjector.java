// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class FileActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.FileActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230727, "field 'lv_files'");
    target.lv_files = (android.widget.ListView) view;
    view = finder.findRequiredView(source, 2131230728, "method 'hideFiles'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.hideFiles();
        }
      });
  }

  public static void reset(com.example.demomobilesecurity.FileActivity target) {
    target.lv_files = null;
  }
}
