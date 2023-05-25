package com.aedeo.applicationmaintenancename;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterContact extends BaseAdapter {
    Context context;

    ArrayList<Contact> contactArrayList;

    LayoutInflater layoutInflater;
    int itteration = 0;
    public AdapterContact() {

    }

    public AdapterContact(Context context, ArrayList<Contact> contactArrayList) {
        layoutInflater = LayoutInflater.from(context);
        this.contactArrayList = contactArrayList;
    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return contactArrayList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.layout_adapter_contact, null);
        itteration++;
        TextView adapterNameContact = (TextView) view.findViewById(R.id.adapter_contact_name);
        TextView adapterNumContact = (TextView) view.findViewById(R.id.adapter_contact_num);
        TextView adapterHiddenIndex = (TextView) view.findViewById(R.id.adapter_item_index);

        adapterHiddenIndex.setText(String.valueOf(itteration));
        adapterNameContact.setText(contactArrayList.get(i).getNama());
        adapterNumContact.setText(contactArrayList.get(i).getNoHp());

        return view;
    }
}
