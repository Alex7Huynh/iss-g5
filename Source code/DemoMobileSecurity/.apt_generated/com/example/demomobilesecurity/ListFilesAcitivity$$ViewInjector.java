// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ListFilesAcitivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.ListFilesAcitivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230722, "field 'listView'");
    target.listView = (android.widget.ListView) view;
    view = finder.findRequiredView(source, 2131230723, "field 'addFile'");
    target.addFile = (android.widget.Button) view;
  }

  public static void reset(com.example.demomobilesecurity.ListFilesAcitivity target) {
    target.listView = null;
    target.addFile = null;
  }
}
