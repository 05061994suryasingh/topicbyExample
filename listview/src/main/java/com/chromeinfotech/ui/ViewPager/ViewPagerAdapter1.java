package com.chromeinfotech.ui.ViewPager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chromeinfotech.listview.R;

/**
 * Created by user on 10/3/17.
 */

public class ViewPagerAdapter1 extends PagerAdapter {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private int[] myImages = new int[]{ R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7};

//constructor
    public ViewPagerAdapter1(Context context) {
        this.context = context ;

    }

//return the size of myImages
    @Override
    public int getCount() {
        return myImages.length;
    }
    @Override
    public boolean isViewFromObject(View view , Object object) {
        return view == ((LinearLayout) object);
    }

    //Override the method instantiateItem and set imageview to viewgroup
    @Override
    public Object instantiateItem(ViewGroup container , int position) {
        mLayoutInflater = LayoutInflater.from(context);

        View itemView       = mLayoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(myImages[position]);
        container.addView(itemView);
        return itemView;
    }

    /**
     * distroy the view
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
