package com.ciotea.dbflowdemo.sample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ciotea.dbflowdemo.R;
import com.ciotea.dbflowdemo.db.bean.NoteBean;
import java.util.List;

/**
 * NoteAdapter.java
 * @author jzman
 * create at 2018/4/17 0017 14:39
 */

public class NoteAdapter extends BaseAdapter{
    private Context mContext;
    private List<NoteBean> mList;

    public NoteAdapter(Context mContext, List<NoteBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public List<NoteBean> getList() {
        return mList;
    }

    public void setList(List<NoteBean> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_note_layout,null);
            vh = new ViewHolder();
            vh.tvTitle = convertView.findViewById(R.id.tvTitle);
            vh.tvDate = convertView.findViewById(R.id.tvDate);
            vh.tvContent = convertView.findViewById(R.id.tvContent);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        vh.tvTitle.setText(mList.get(position).getTitle());
        vh.tvDate.setText(mList.get(position).getDate());
        vh.tvContent.setText(mList.get(position).getContent());
        return convertView;
    }

    static class ViewHolder{
        TextView tvTitle;
        TextView tvDate;
        TextView tvContent;
    }
}
