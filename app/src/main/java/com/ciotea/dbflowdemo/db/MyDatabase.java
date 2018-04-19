package com.ciotea.dbflowdemo.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * MyDatabase
 * @author jzman
 * create at 2018/4/17 0017 9:08
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {
    //数据库名称
    public static final String NAME = "MyDatabase";
    //数据库版本号
    public static final int VERSION = 1;
}
