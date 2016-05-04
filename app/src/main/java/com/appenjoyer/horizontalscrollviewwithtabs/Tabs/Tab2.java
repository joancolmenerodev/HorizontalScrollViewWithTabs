package com.appenjoyer.horizontalscrollviewwithtabs.Tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appenjoyer.horizontalscrollviewwithtabs.Adapters.CustomLinearLayoutManager;
import com.appenjoyer.horizontalscrollviewwithtabs.Adapters.MyRecyclerViewAdapter;
import com.appenjoyer.horizontalscrollviewwithtabs.R;
import com.appenjoyer.horizontalscrollviewwithtabs.dataModel;

import java.util.ArrayList;

/**
 * Created by Joan on 27/10/2015.
 */


public class Tab2 extends Fragment {

    private ArrayList<dataModel> dataModelList;
    private RecyclerView rv;
    private MyRecyclerViewAdapter adapter;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        this.mContext = getActivity();

        View rootView = inflater.inflate(R.layout.tab2, container, false);


        rv = (RecyclerView) rootView.findViewById(R.id.rcyList);

        CustomLinearLayoutManager layoutManager = new CustomLinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(layoutManager);

        // Adding code here

        dataModelList = new ArrayList<dataModel>();

        dataModelList.add(new dataModel(ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher),"Hello"));
        dataModelList.add(new dataModel(ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher),"Hello"));
        dataModelList.add(new dataModel(ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher),"Hello"));
        dataModelList.add(new dataModel(ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher),"Hello"));
        dataModelList.add(new dataModel(ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher),"Hello"));
        dataModelList.add(new dataModel(ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher),"Hello"));
        dataModelList.add(new dataModel(ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher),"Hello"));
        dataModelList.add(new dataModel(ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher),"Hello"));
        dataModelList.add(new dataModel(ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher),"Hello"));
        adapter = new MyRecyclerViewAdapter(mContext, dataModelList);
        rv.setAdapter(adapter);

        return rootView;

    }


}
