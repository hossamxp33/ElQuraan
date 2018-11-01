package com.codesroots.elquraan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codesroots.elquraan.Helpers.BroadcastHelper;
import com.codesroots.elquraan.Helpers.DownloadTask;
import com.codesroots.elquraan.Helpers.PreferenceHelper;
import com.codesroots.elquraan.Models.All_Sour_Model;
import com.codesroots.elquraan.R;
import com.codesroots.elquraan.db.DBAdapter;
import com.codesroots.elquraan.db.DBHelper;

import java.io.File;
import java.util.ArrayList;


/**
 * Created by tournedo2003 on 3/13/17.
 */

public class TopDialog_Adapter extends RecyclerView.Adapter<TopDialog_Adapter.ViewHolder> {

    private ArrayList<All_Sour_Model.DataBean> ads_list;
    private Context context;
    private DBAdapter dbAdapter;
    private DBHelper dbHelper;
    String filepath;
    private PreferenceHelper helper;
    File files;
    public TopDialog_Adapter(Context context, ArrayList<All_Sour_Model.DataBean> chalet_list_result) {
        this.context = context;
        this.ads_list = chalet_list_result;
        dbHelper = new DBHelper(context);
        dbAdapter = new DBAdapter(context);
        File direct = new File(Environment.getExternalStorageDirectory() + "/OtherTafaseer");
        filepath = Environment.getExternalStoragePublicDirectory(String.valueOf(direct)) + "/";
        helper = new PreferenceHelper(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate( R.layout.quranlist_row, parent, false);
        return new ViewHolder(view);
    }

     @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(ads_list.get(position).getName());
         File file = new File(filepath + "/" + ads_list.get(position).getName() + ".mp3");
            if (file.exists()){
                holder.tafseer.setText(context.getString(R.string.downloaded));
                holder.tafseer.setEnabled(false);
            }
            if (helper.getLanguageID() == 0){
                 files = new File(filepath + "/" + ads_list.get(position).getName() + "t.mp3");
            } else {
                 files = new File(filepath + "/" + ads_list.get(position).getName() + "ts.mp3");
            }
         if (files.exists()){
             holder.sounds.setText(context.getString(R.string.downloaded));
             holder.sounds.setEnabled(false);
         }
         if (ads_list.get(position).getSoraType() == 0){
            holder.sora_type.setText(context.getString(R.string.madnia));
        } else {
            holder.sora_type.setText(context.getString(R.string.makia));
        }
        if (position %2 == 0){
             holder.allview.setBackgroundColor(ContextCompat.getColor(context,R.color.beige));
        } else {
                holder.allview.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        }
        holder.sora_number.setText(String.valueOf(ads_list.get(position).getId() ));
        holder.tafseer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                    DownloadTask downloadTask;
                    downloadTask = new DownloadTask(context, ads_list.get(position).getSoundtrack(),
                            ads_list.get(position).getName() );
              //  }
            }
        });
        holder.sounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    DownloadTask downloadTask;
                    if (helper.getLanguageID() == 0){
                        if (ads_list.get(position).getTafseerlink().contains("http"))
                            downloadTask = new DownloadTask(context, ads_list.get(position).getTafseerlink(),
                                ads_list.get(position).getName()+ "t");
                    } else {
                        if (ads_list.get(position).getSecond_lang().contains("http"))
                            downloadTask = new DownloadTask(context, ads_list.get(position).getSecond_lang(),
                                ads_list.get(position).getName()+ "ts");
                    }

            }
        });

        holder.expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ads_list.get(position).isOpened()){
                    holder.details.setVisibility(View.GONE);
                    ads_list.get(position).setOpened(false);
                    holder.expand.setImageResource(R.drawable.add);
                }
                else {
                    holder.details.setVisibility(View.VISIBLE);
                    ads_list.get(position).setOpened(true);
                    holder.expand.setImageResource(R.drawable.minus);
                }
            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();


                intent.putExtra("sora_id",ads_list.get(position).getId());
                intent.putExtra("pos",ads_list.get(position).getFirstpage());
                BroadcastHelper.sendInform(context,"gotopage",intent);
            }
        });
         holder.sora_type.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent();
                 intent.putExtra("sora_id",ads_list.get(position).getId());
                 intent.putExtra("pos",position);
                 BroadcastHelper.sendInform(context,"gotopage",intent);
             }
         });
         holder.sora_number.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent();
                 intent.putExtra("pos",position);
                 intent.putExtra("sora_id",ads_list.get(position).getId());
                 BroadcastHelper.sendInform(context,"gotopage",intent);
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

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
       ImageView expand;
       TextView name,sora_type,sora_number,sounds,tafseer;
        LinearLayout details,allview;
        private ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sora_name);
            sora_number = itemView.findViewById(R.id.sora_number);
            sora_type = itemView.findViewById(R.id.sora_type);
           expand = itemView.findViewById(R.id.expand);
            details = itemView.findViewById(R.id.details_row);
            sounds = itemView.findViewById(R.id.download_sound);
            tafseer = itemView.findViewById(R.id.download_tafseer);
            allview = itemView.findViewById(R.id.wow);
        }

    }
}
