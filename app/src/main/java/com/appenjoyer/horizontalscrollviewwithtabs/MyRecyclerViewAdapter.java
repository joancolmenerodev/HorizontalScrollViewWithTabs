package com.appenjoyer.horizontalscrollviewwithtabs;

/**
 * Created by Joan on 29/10/2015.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joan on 27/10/2015.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder> {

    private Context mContext;
    View animatedView = null;
    private List<dataModel> dataModelList;
    int animatedIndex = -1; // Initially no view is clicked so -1


    public MyRecyclerViewAdapter(Context context, List<dataModel> items) {
        this.dataModelList = items;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        //View per each row
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, null);


        CustomViewHolder viewHolder = new CustomViewHolder(view);
        //final Animation a = AnimationUtils.loadAnimation(mContext, R.anim.scale_up);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Animació per el click
                if (animatedView == null) {
                    animatedView = view;
                } else {
                    animatedView.setAnimation(null);
                    animatedView = view;
                }
                ScaleAnimation fade_in = new ScaleAnimation(1f, 1.3f, 1f, 1.3f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                fade_in.setDuration(100);     // animation duration in milliseconds
                fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
                view.startAnimation(fade_in);
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

        if(animatedIndex == i){
            ScaleAnimation fade_in = new ScaleAnimation(1f, 1.3f, 1f, 1.3f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            fade_in.setDuration(0);     // animation duration in milliseconds
            fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
            customViewHolder.itemView.startAnimation(fade_in);
        }

        customViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatedIndex = i;
                if (animatedView == null) {
                    animatedView = customViewHolder.itemView;
                } else {
                    animatedView.setAnimation(null);
                    animatedView = customViewHolder.itemView;
                }

                ScaleAnimation fade_in = new ScaleAnimation(1f, 1.3f, 1f, 1.3f, Animation.RELATIVE_TO_SELF, 0.2f, Animation.RELATIVE_TO_SELF, 0.2f);
                fade_in.setDuration(100);     // animation duration in milliseconds
                fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
                customViewHolder.itemView.startAnimation(fade_in);




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