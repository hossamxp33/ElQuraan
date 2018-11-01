//package com.codesroots.elquraan.Adapter;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.codesroots.elquraan.Activity.MainActivity;
//import com.codesroots.elquraan.Models.Agzaa_Model;
//import com.codesroots.elquraan.R;
//
//import java.util.ArrayList;
//
//
///**
// * Created by tournedo2003 on 3/13/17.
// */
//
//public class SourNamesAdapter extends RecyclerView.Adapter<SourNamesAdapter.ViewHolder> {
//
//    private ArrayList<Agzaa_Model.PartsBean.MiniPartsBean.TafaseerBean> ads_list;
//    private Context context;
//
//
//    public SourNamesAdapter(Context context, ArrayList<Agzaa_Model.PartsBean.MiniPartsBean.TafaseerBean> chalet_list_result) {
//        this.context = context;
//        this.ads_list = chalet_list_result;
//
//
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(ads_list.get(viewType).getTo() == 0 ? R.layout.soura_name_row : R.layout.gozaa_name_row, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        holder.name.setText(ads_list.get(position).getName());
//        if (ads_list.get(position).getTo() == 0) {
//            if (ads_list.get(position).getFrom() != 0) {
//                holder.ooa.setVisibility(View.GONE);
//            } else {
//                holder.ooa.setVisibility(View.VISIBLE);
//            }
//            if (ads_list.get(position).getSoraType() == 0) {
//                holder.ayat_number.setText(context.getString(R.string.makia) + " "
//                        + ads_list.get(position).getAyatCounter() + " ," + context.getString(R.string.aya));
//            } else {
//                holder.ayat_number.setText(context.getString(R.string.madnia) + " "
//                        + ads_list.get(position).getAyatCounter() + " ," + context.getString(R.string.aya));
//            }
//            holder.soura_number.setText(String.valueOf(ads_list.get(position).getId()));
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, MainActivity.class);
//                    intent.putExtra("id", ads_list.get(position).getId());
//                    intent.putExtra("tlink", ads_list.get(position).getSoundtrack());
//                    intent.putExtra("flink", ads_list.get(position).getTafseerlink());
//                    intent.putExtra("pages_count", ads_list.get(position).getPagesCounter());
//                    intent.putExtra("name", ads_list.get(position).getName());
//                    context.startActivity(intent);
//                }
//            });
//        } else {
////            holder.itemView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    if (ads_list.get(position +1) != null) {
////                        if (ads_list.get(position + 1).getFrom() == 0) {
////                            ads_list.get(position + 1).setFrom(1);
////                            notifyItemChanged(position + 1);
////                        } else {
////                            ads_list.get(position + 1).setFrom(0);
////                            notifyItemChanged(position + 1);
////                        }
////                    }
////                }
////            });
//        }
//    }
//
//    @Override
//    public long getItemId(int arg0) {
//        // TODO Auto-generated method stub
//        return arg0;
//    }
//
//    @Override
//    public int getItemCount() {
//        return ads_list.size();
//
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return position;
//    }
//
//    static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView name, soura_number, ayat_number, type;
//        TextView pagestarted;
//        RelativeLayout ooa;
//
//        private ViewHolder(View itemView) {
//            super(itemView);
//            name = itemView.findViewById(R.id.souraname);
//            pagestarted = itemView.findViewById(R.id.pagestarted);
//            soura_number = itemView.findViewById(R.id.positiona);
//            ayat_number = itemView.findViewById(R.id.ayat_number);
//            ooa = itemView.findViewById(R.id.ooa);
//        }
//
//    }
//}
