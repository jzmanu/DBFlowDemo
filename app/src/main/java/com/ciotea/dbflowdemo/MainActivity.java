package com.ciotea.dbflowdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ciotea.dbflowdemo.db.bean.NoteBean;
import com.ciotea.dbflowdemo.sample.adapter.NoteAdapter;
import com.ciotea.dbflowdemo.sample.presenter.NotePresenter;
import com.ciotea.dbflowdemo.sample.view.OnShowDataView;

import java.util.List;

/**
 * MainActivity.java
 * @author jzman
 * create at 2018/4/17 0017 10:45
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        OnShowDataView,AdapterView.OnItemClickListener{
    private Button btnAdd;
    private Button btnDelete;
    private Button btnUpdate;
    private Button btnQuery;
    private ListView lvData;
    private NoteAdapter adapter;
    private NotePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();
    }

    private void initView() {
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnQuery = findViewById(R.id.btnQuery);
        lvData = findViewById(R.id.lvData);
    }

    private void initListener() {
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
        lvData.setOnItemClickListener(this);
    }

    private void initData() {
        presenter = new NotePresenter(this);
        presenter.initData();
        presenter.loadData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                presenter.addData();
                break;
            case R.id.btnDelete:
                Toast.makeText(this, "请点击单条记录进行删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnUpdate:
                presenter.uodateData();
                break;
            case R.id.btnQuery:
                presenter.loadData();
                break;
        }
    }

    @Override
    public void onShowData(List<NoteBean> noteBeans) {
        adapter = new NoteAdapter(this,noteBeans);
        lvData.setAdapter(adapter);
    }

    @Override
    public void onNotifyData(List<NoteBean> noteBeans) {
        adapter.setList(noteBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, final long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("要删除这条记录吗?")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.deleteData((int) id);
                    }
                }).create().show();
    }
}
