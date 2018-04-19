package com.ciotea.dbflowdemo.sample.view;

import com.ciotea.dbflowdemo.db.bean.NoteBean;

import java.util.List;

/**
 * OnShowDataView.java
 * @author jzman
 * create at 2018/4/17 0017 11:40
 */
public interface OnShowDataView {
    void onShowData(List<NoteBean> noteBeans);
    void onNotifyData(List<NoteBean> noteBeans);
}
