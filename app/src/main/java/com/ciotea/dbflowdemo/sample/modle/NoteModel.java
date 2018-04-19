package com.ciotea.dbflowdemo.sample.modle;

import com.ciotea.dbflowdemo.db.bean.NoteBean;
import com.ciotea.dbflowdemo.db.bean.NoteBean_Table;
import com.ciotea.dbflowdemo.util.DateUtil;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Date;
import java.util.List;

/**
 * NoteModel.java
 * @author jzman
 * create at 2018/4/17 0017 11:44
 */
public class NoteModel {
    /**
     * 添加数据
     */
    public void addData(int id){
        NoteBean noteBean = new NoteBean();
        noteBean.setDate(DateUtil.getDate(new Date(),DateUtil.DATE_FORMAT_DEFAULT));
//        noteBean.setId(id);//主键自增
        noteBean.setTitle("第"+id+"条数据");
        noteBean.setContent("这是内容....");
        noteBean.insert();
    }

    /**
     * 添加数据
     * @param noteBean
     */
    public void addData(NoteBean noteBean){
        noteBean.insert();
    }

    /**
     * 删除数据
     * @param id
     */
    public void deleteData(int id){
        SQLite.delete()
                .from(NoteBean.class)
                .where(NoteBean_Table.id.is(id))
                .execute();
    }

    /**
     * 删除所有数据
     */
    public void deleteAll(){
        SQLite.delete().from(NoteBean.class).async().execute();
    }


    /**
     * 查询全部数据
     */
    public List<NoteBean> queryData(){
        return SQLite.select().from(NoteBean.class).queryList();
    }

    /**
     * 更新数据
     */
    public void updateData(){
        SQLite.update(NoteBean.class)
                .set(NoteBean_Table.title.is("这是修改的标题"))
                .where(NoteBean_Table.title.is("title"))
                .execute();
    }
}
