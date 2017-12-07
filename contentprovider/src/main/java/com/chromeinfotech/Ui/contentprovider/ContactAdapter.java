package com.chromeinfotech.Ui.contentprovider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chromeinfotech.contentprovider.R;
import com.chromeinfotech.utils.Utils;

import java.util.List;

/**
 * Created by user on 21/4/17.
 */

public class ContactAdapter extends BaseAdapter {
    private  Context context;
    private List<Contacts> list;

    public ContactAdapter(Context context, List<Contacts> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        ImageView iv_photo = (ImageView) view.findViewById(R.id.iv_photo);
        TextView tv_phonenumber = (TextView) view.findViewById(R.id.tv_phonenumber);
        tv_name.setText(list.get(position).getName());
        tv_phonenumber.setText(list.get(position).getphonenumber());
        iv_photo.setImageBitmap(list.get(position).getContactphoto());
        Utils.printLog("ContactAdapter" ," value1" + list.get(position).getName());
        return view;
    }
}
