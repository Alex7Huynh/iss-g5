// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ItemView$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.adapter.ItemView target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230746, "field 'tv_file'");
    target.tv_file = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131230744, "field 'cb_select' and method 'selectFile'");
    target.cb_select = (android.widget.CheckBox) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.selectFile();
        }
      });
    view = finder.findRequiredView(source, 2131230745, "field 'iv_view'");
    target.iv_view = (android.widget.ImageView) view;
  }

  public static void reset(com.example.demomobilesecurity.adapter.ItemView target) {
    target.tv_file = null;
    target.cb_select = null;
    target.iv_view = null;
  }
}
