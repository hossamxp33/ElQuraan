package com.codesroots.elquraan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.codesroots.elquraan.Helpers.BroadcastHelper;
import com.codesroots.elquraan.Models.SewarModelView;
import com.codesroots.elquraan.R;

import java.util.ArrayList;


/**
 * Created by tournedo2003 on 3/13/17.
 */

public class RecyclerPagerAdapter extends RecyclerView.Adapter<RecyclerPagerAdapter.ViewHolder> {

    private ArrayList<SewarModelView.DataBean> ads_list;
    private Context context;
    private boolean isHidden  = true;

    public RecyclerPagerAdapter(Context context, ArrayList<SewarModelView.DataBean> chalet_list_result) {
        this.context = context;
        this.ads_list = chalet_list_result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate( R.layout.pager_item, parent, false);
        return new ViewHolder(view);
    }

     @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (ads_list.size()<= position){

        } else {
            holder.imageView.setImageBitmap(ads_list.get(position).getPageImage());
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isHidden) {
                        BroadcastHelper.sendInform(context, "show");
                        isHidden = false;
                    } else {
                        BroadcastHelper.sendInform(context, "hide");
                        isHidden = true;
                    }
                }
            });
        }
            if (position == ads_list.size() - 8) {
                Intent intent = new Intent();
                intent.putExtra("pos", position);
                BroadcastHelper.sendInform(context, "next");
            }

    }



    @Override
    public int getItemCount() {
        return 604;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
       ImageView imageView;

        private ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
           
        }

    }
}
