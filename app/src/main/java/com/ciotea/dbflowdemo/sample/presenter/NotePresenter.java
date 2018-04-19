package com.ciotea.dbflowdemo.sample.presenter;

import com.ciotea.dbflowdemo.db.bean.NoteBean;
import com.ciotea.dbflowdemo.sample.modle.NoteModel;
import com.ciotea.dbflowdemo.sample.view.OnShowDataView;
import com.ciotea.dbflowdemo.util.DateUtil;

import java.util.Date;

/**
 * NotePresenter.java
 * @author jzman
 * create at 2018/4/17 0017 14:26
 */
public class NotePresenter {
    private OnShowDataView mOnShowDataView;
    private NoteModel mNoteModel;

    public NotePresenter(OnShowDataView mOnShowDataView) {
        this.mOnShowDataView = mOnShowDataView;
        mNoteModel = new NoteModel();
    }

    /**
     * 加载数据
     */
    public void loadData(){
        mOnShowDataView.onShowData(mNoteModel.queryData());
    }

    /**
     * 初始化数据
     */
    public void initData(){
        mNoteModel.deleteAll();
        for (int i=0; i<10; i++){
            mNoteModel.addData(i);
        }
    }

    /**
     * 添加数据
     */
    public void addData(){
        mNoteModel.addData(new NoteBean("title", DateUtil.getDate(new Date(),DateUtil.DATE_FORMAT_DEFAULT),"content"));
        loadData();
    }

    /**
     * 根据id删除数据
     * @param id
     */
    public void deleteData(int id){
        mNoteModel.deleteData(id);
        mOnShowDataView.onNotifyData(mNoteModel.queryData());
    }

    /**
     * 更新数据
     */
    public void uodateData(){
        mNoteModel.updateData();
        mOnShowDataView.onNotifyData(mNoteModel.queryData());
    }
}
