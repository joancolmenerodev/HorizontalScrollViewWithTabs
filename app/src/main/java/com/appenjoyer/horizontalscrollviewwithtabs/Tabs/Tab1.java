package com.appenjoyer.horizontalscrollviewwithtabs.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appenjoyer.horizontalscrollviewwithtabs.R;

/**
 * Created by Joan on 27/10/2015.
 */
public class Tab1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab1, container, false);

    }

}
