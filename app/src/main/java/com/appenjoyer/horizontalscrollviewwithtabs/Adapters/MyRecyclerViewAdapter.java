package com.appenjoyer.horizontalscrollviewwithtabs.Adapters;

/**
 * Created by Joan on 29/10/2015.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.appenjoyer.horizontalscrollviewwithtabs.R;
import com.appenjoyer.horizontalscrollviewwithtabs.dataModel;

import java.util.List;

/**
 * Created by Joan on 27/10/2015.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder> {

    private Context mContext;
    private List<dataModel> dataModelList;

    public MyRecyclerViewAdapter(Context context, List<dataModel> items) {
        this.dataModelList = items;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        //View per each row
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Click event

            }
        });
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, final int i) {
        //Setting text view title
        dataModel dataModel = dataModelList.get(i);
        customViewHolder.imageView.setImageDrawable(dataModel.icon);
        customViewHolder.textView.setText(dataModel.title);


        customViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        //Click per item
                Toast.makeText(mContext, "Item clicked!", Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textView;

        public CustomViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
            this.textView = (TextView) view.findViewById(R.id.title);
        }
    }
}