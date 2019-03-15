package com.example.android.tutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.tutorial.R;
import com.example.android.tutorial.models.Contact;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    Context context;
    ArrayList<Contact> arrayList;

    public ContactAdapter(Context context, ArrayList<Contact> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.row_item_contact,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = convertView.findViewById(R.id.tv_id);
            viewHolder.tvName = convertView.findViewById(R.id.tv_name);
            viewHolder.tvPhone = convertView.findViewById(R.id.tv_phone);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        try {
            Contact contact = arrayList.get(position);
            viewHolder.tvId.setText(String.valueOf(contact.getId()));
            viewHolder.tvName.setText(contact.getName());
            viewHolder.tvPhone.setText(contact.getPhone());
        }catch (Exception e){

        }
        return convertView;
    }

    private class ViewHolder {
        TextView tvId, tvName, tvPhone;
    }
}

