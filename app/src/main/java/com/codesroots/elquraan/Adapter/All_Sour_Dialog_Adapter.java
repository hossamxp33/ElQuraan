package com.codesroots.elquraan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codesroots.elquraan.Helpers.BroadcastHelper;
import com.codesroots.elquraan.Helpers.PreferenceHelper;
import com.codesroots.elquraan.Models.All_Sour_Model;
import com.codesroots.elquraan.R;

import java.util.ArrayList;


/**
 * Created by tournedo2003 on 3/13/17.
 */

public class All_Sour_Dialog_Adapter extends RecyclerView.Adapter<All_Sour_Dialog_Adapter.ViewHolder> {

    private ArrayList<All_Sour_Model.DataBean> ads_list;
    private Context context;
    private int ClickedPosition = -1;
    String filepath;
    PreferenceHelper helper;
    public All_Sour_Dialog_Adapter(Context context, ArrayList<All_Sour_Model.DataBean> chalet_list_result) {
        this.context = context;
        this.ads_list = chalet_list_result;
        helper = new PreferenceHelper(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_sour_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(ads_list.get(position).getName());
        holder.ayat_num.setText(String.valueOf(ads_list.get(position).getAyatCounter()));
        holder.tartib.setText(String.valueOf(ads_list.get(position).getId() - 1));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("nam",ads_list.get(position).getName());
                intent.putExtra("ayatcount",ads_list.get(position).getAyatCounter());
                intent.putExtra("tartib",ads_list.get(position).getId() - 1);
                if (helper.getLanguageID() == 0){
                    intent.putExtra("tf",ads_list.get(position).getTafseerlink());
                } else {
                    intent.putExtra("tf",ads_list.get(position).getSecond_lang());
                }
                intent.putExtra("pos",position);
                BroadcastHelper.sendInform(context,"plays",intent);
            }
        });
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public int getItemCount() {
        return ads_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, ayat_num, tartib;

        private ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sora_name);
            ayat_num = itemView.findViewById(R.id.ayat_num);
            tartib = itemView.findViewById(R.id.tartib);
        }
    }

}
