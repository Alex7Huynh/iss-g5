// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class BrowseFileActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.BrowseFileActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230720, "field 'listView'");
    target.listView = (android.widget.ListView) view;
    view = finder.findRequiredView(source, 2131230721, "field 'selectFile' and method 'selectFile'");
    target.selectFile = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.selectFile();
        }
      });
  }

  public static void reset(com.example.demomobilesecurity.BrowseFileActivity target) {
    target.listView = null;
    target.selectFile = null;
  }
}
