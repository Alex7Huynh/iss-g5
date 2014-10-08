// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ListFilesAcitivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.ListFilesAcitivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230737, "field 'addFile' and method 'addFiles'");
    target.addFile = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.addFiles();
        }
      });
    view = finder.findRequiredView(source, 2131230736, "field 'listView'");
    target.listView = (android.widget.ListView) view;
    view = finder.findRequiredView(source, 2131230738, "field 'restoreFile' and method 'onRestoreFileAction'");
    target.restoreFile = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onRestoreFileAction();
        }
      });
  }

  public static void reset(com.example.demomobilesecurity.ListFilesAcitivity target) {
    target.addFile = null;
    target.listView = null;
    target.restoreFile = null;
  }
}
