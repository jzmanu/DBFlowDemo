package com.ciotea.dbflowdemo.util;

import com.ciotea.dbflowdemo.db.bean.NoteBean;
import com.ciotea.dbflowdemo.db.bean.NoteBean_Table;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * DBFlowUtil.java
 *
 * @author jzman
 *         create at 2018/4/17 0017 16:39
 */
public class DBFlowUtil<T> {
    /**
     * 插入数据
     *
     * @param model
     */
    public void inseartData(NoteBean model) {
        //1.model,insert()
        model.setTitle("title");
        model.setDate("2018-04-17");
        model.setContent("content");
        model.insert();
        //2.SQLite.insert()
        SQLite.insert(NoteBean.class)
                .columns(NoteBean_Table.title, NoteBean_Table.date, NoteBean_Table.content)
                .values("title", "2018-04-17", "content")
                .execute();
    }

    /**
     * 删除数据
     *
     * @param model
     */
    public void deleteData(NoteBean model) {
        //1.model.delete()
        model.delete();
        //2.SQLite.delete()
        SQLite.delete(NoteBean.class)
                .where(NoteBean_Table.title.is("title"))
                .and(NoteBean_Table.id.is(10))
                .async()
                .execute();
        //删除整张表
        Delete.table(NoteBean.class);
        //删除多张表
//        Delete.table(NoteBean.class, NoteBean1.class);
    }

    /**
     * 更新数据
     * @param model
     */
    public void updateData(NoteBean model) {
        //1.model.update()
        model.update();
        //2.SQLite.update()
        SQLite.update(NoteBean.class)
                .set(NoteBean_Table.title.eq("title"),
                        NoteBean_Table.content.eq("content"))
                .where(NoteBean_Table.id.is(10))
                .async()
                .execute();
    }

    /**
     * 查询数据
     */
    public void queryData(){
        //根据条件查询
        List<NoteBean> noteBeans = SQLite.select()
                .from(NoteBean.class)
                .where(NoteBean_Table.title.is("title"))
                .queryList();
    }
}
