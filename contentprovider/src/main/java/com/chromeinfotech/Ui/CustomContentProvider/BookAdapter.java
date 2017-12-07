package com.chromeinfotech.Ui.CustomContentProvider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chromeinfotech.contentprovider.R;

import java.util.List;

/**
 * Created by user on 24/4/17.
 */

public class BookAdapter extends BaseAdapter {

    private List<Bookinfo> bookInfoList;
    private Context context;
    private LayoutInflater layoutInflater;

    public BookAdapter(Context context, List<Bookinfo> bookInfoList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.bookInfoList = bookInfoList;
    }

    @Override
    public int getCount() {
        return bookInfoList.size();
    }

    @Override
    public Bookinfo getItem(int position) {
        return bookInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.book_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvBookTitle.setText(bookInfoList.get(position).getBookTitle());
        viewHolder.tvISBN.setText(bookInfoList.get(position).getIsbn());
        return convertView;
    }


    protected class ViewHolder {
        private TextView tvBookTitle;
        private TextView tvISBN;

        public ViewHolder(View view) {
            tvBookTitle = (TextView) view.findViewById(R.id.tvBookTitle);
            tvISBN = (TextView) view.findViewById(R.id.tvISBN);
        }
    }
}
