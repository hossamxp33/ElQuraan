package com.codesroots.elquraan.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codesroots.elquraan.AlarmListAdapter;
import com.codesroots.elquraan.Models.AlarmModel;
import com.codesroots.elquraan.R;
import com.codesroots.elquraan.db.Constants;
import com.codesroots.elquraan.db.DBAdapter;

import java.util.ArrayList;


/**
 * Created by tournedo2003 on 3/13/17.
 */

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {

    private ArrayList<AlarmModel> ads_list;
    private Context context;
    private AlarmListAdapter alarmListAdapter;

    public AlarmAdapter(Context context, ArrayList<AlarmModel> chalet_list_result) {
        this.context = context;
        this.ads_list = chalet_list_result;
        alarmListAdapter = new AlarmListAdapter(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.alarm_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(ads_list.get(position).getText());
        holder.datetime.setText(ads_list.get(position).getTime() + " "
                            + ads_list.get(position).getDate());
        holder.delete_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBAdapter dbAdapter = new DBAdapter(context);
                dbAdapter.open();
                dbAdapter.Delete(Constants.TB_NAME,ads_list.get(position).getId());
                dbAdapter.close();
                alarmListAdapter.delete(ads_list.get(position).getAlarmid());
               ads_list.remove(position);
               notifyDataSetChanged();
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
        TextView name, datetime;
        ImageView delete_row;
        private ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.alarm_name);
            datetime = itemView.findViewById(R.id.alarm_time);
            delete_row = itemView.findViewById(R.id.delete_row);
        }

    }




}
