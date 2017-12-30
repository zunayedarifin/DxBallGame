package com.example.zunay.dxballgame;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Zunayed on 12/29/2017.
 */

public class CustomAdapter extends BaseAdapter {
    private Context mContext;

    public CustomAdapter(Context context) {
        mContext = context;
    }

    // Other methods...

    public void startIntent()
    {
        Intent intent = new Intent(mContext, LoseActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
