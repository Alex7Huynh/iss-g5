// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class FileItemView$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.adapter.FileItemView target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230729, "field 'filePath'");
    target.filePath = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131230728, "field 'fileName'");
    target.fileName = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131230727, "field 'fileAvatar'");
    target.fileAvatar = (android.widget.ImageView) view;
  }

  public static void reset(com.example.demomobilesecurity.adapter.FileItemView target) {
    target.filePath = null;
    target.fileName = null;
    target.fileAvatar = null;
  }
}
