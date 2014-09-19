// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class FileItemView$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.adapter.FileItemView target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230748, "field 'fileAvatar'");
    target.fileAvatar = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131230750, "field 'filePath'");
    target.filePath = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131230747, "field 'fileItemSelect' and method 'onCheck'");
    target.fileItemSelect = (android.widget.CheckBox) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onCheck();
        }
      });
    view = finder.findRequiredView(source, 2131230749, "field 'fileName'");
    target.fileName = (android.widget.TextView) view;
  }

  public static void reset(com.example.demomobilesecurity.adapter.FileItemView target) {
    target.fileAvatar = null;
    target.filePath = null;
    target.fileItemSelect = null;
    target.fileName = null;
  }
}
