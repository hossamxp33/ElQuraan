package com.codesroots.elquraan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.codesroots.elquraan.Helpers.BroadcastHelper;
import com.codesroots.elquraan.Models.FavouriteModel;
import com.codesroots.elquraan.R;
import com.codesroots.elquraan.db.Constants;
import com.codesroots.elquraan.db.DBAdapter;
import com.codesroots.elquraan.db.DBHelper;

import java.util.ArrayList;


/**
 * Created by tournedo2003 on 3/13/17.
 */

public class FavList_Adapter extends RecyclerView.Adapter<FavList_Adapter.ViewHolder> {

    private ArrayList<FavouriteModel> ads_list;
    private Context context;
    private DBAdapter dbAdapter;
    private DBHelper dbHelper;

    public FavList_Adapter(Context context, ArrayList<FavouriteModel> chalet_list_result) {
        this.context = context;
        this.ads_list = chalet_list_result;
        dbHelper = new DBHelper(context);
        dbAdapter = new DBAdapter(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate( R.layout.fav_row, parent, false);
        return new ViewHolder(view);
    }

     @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(ads_list.get(position).getName());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.open();
                dbAdapter.Delete(Constants.FAV_NAME,ads_list.get(position).getDatabaseid());
                dbAdapter.close();
                ads_list.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("tafseer_link",ads_list.get(position).getTafseer());
                intent.putExtra("name",ads_list.get(position).getName());
                intent.putExtra("tartib" , ads_list.get(position).getTartib());
                intent.putExtra("ayatcount",ads_list.get(position).getAyatcount());
                intent.putExtra("pos",ads_list.get(position).getIds());
                BroadcastHelper.sendInform(context,"playfav",intent);
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
       ImageButton delete;
       TextView name;

        private ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            delete = itemView.findViewById(R.id.delete);
           
        }

    }
}
