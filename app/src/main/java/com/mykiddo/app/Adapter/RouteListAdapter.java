package com.mykiddo.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.mykiddo.app.R;
import com.mykiddo.app.RoutListData;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;


public class RouteListAdapter extends RecyclerView.Adapter<RouteListAdapter.PlaceViewHolder> {
    private Context mContext;
    private ArrayList<RoutListData> mModelList;
    ImaggListner imaggListner;


    public RouteListAdapter(Context mContext, ArrayList<RoutListData> mPlaceList, ImaggListner imaggListner) {
        this.mContext = mContext;
        this.mModelList = mPlaceList;
        this.imaggListner = imaggListner;

    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_routlist,
                parent, false);
        return new PlaceViewHolder(view);
    }


    private void setAnimation(View viewToAnimate) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.1f, 1.0f
                , Animation.RESTART, 0.5f,
                Animation.RESTART, 0.5f
        );
        anim.setDuration(1000);
        viewToAnimate.startAnimation(anim);
    }



    @Override
    public void onBindViewHolder(final PlaceViewHolder holder, int position) {
        setAnimation(holder.itemView);
        holder.ttxt.setText(mModelList.get(position).text);
        holder.text.setText(mModelList.get(position).price);
        holder.add.setText(mModelList.get(position).address);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                imaggListner.onClick();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mModelList.size();

    }

    protected int mLastPosition = -1;

    protected void setAnimation(View viewToAnimate, int position) {
        if (position > mLastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(new Random().nextInt(501));//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim);
            mLastPosition = position;
        }
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView ttxt;
        public TextView text;
        public TextView add;


        public PlaceViewHolder(View itemView) {
            super(itemView);

            ttxt = itemView.findViewById(R.id.route1);
            text = itemView.findViewById(R.id.address);
            add = itemView.findViewById(R.id.adrreess2);





        }
    }
    public interface ImaggListner {
        void onClick();
    }


}
