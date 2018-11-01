package com.codesroots.elquraan.Adapter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codesroots.elquraan.Helpers.BroadcastHelper;
import com.codesroots.elquraan.Helpers.DownloadTask;
import com.codesroots.elquraan.Models.TafaseerModel;
import com.codesroots.elquraan.R;
import com.tuyenmonkey.mkloader.MKLoader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by tournedo2003 on 3/13/17.
 */

public class TafaseerAdapter extends RecyclerView.Adapter<TafaseerAdapter.ViewHolder> {

    private ArrayList<TafaseerModel.OthertafaseerBean> ads_list;
    private Context context;
    private int ClickedPosition = -1;
     String filepath;
    public TafaseerAdapter(Context context, ArrayList<TafaseerModel.OthertafaseerBean> chalet_list_result) {
        this.context = context;
        this.ads_list = chalet_list_result;
        if (receiver == null){
            receiver = new Receiver();
            IntentFilter filter = new IntentFilter(BroadcastHelper.ACTION_NAME);
            context.registerReceiver(receiver, filter);
            isRegistered = true;
        }
        File   direct = new File(Environment.getExternalStorageDirectory() + "/OtherTafaseer");
        filepath = Environment.getExternalStoragePublicDirectory(String.valueOf(direct)) + "/";

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tafaseer_row, parent, false);
        return new ViewHolder(view);
    }
    private int tafseer_duration =0,total_tafseerduration = 0;
    private Timer tafseer_timer;
    private boolean tafseerpause = false,isFileLoaded = false;
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        isTafseerLoaded = false;
        holder.name.setText(ads_list.get(position).getTitle());
        if (!ads_list.get(position).isPlaying()) {
            holder.audiototallength.setText("0:00");
            holder.progresslength.setText("0:00");
            holder.seekBar.setProgress(0);
            holder.play.setBackgroundResource(R.drawable.playgold);
        } else {
            File file = new File(filepath + "/" + ads_list.get(position).getTitle() + ".mp3");
            if (file.exists()) {
                if (!isTafseerLoaded) {
                    holder.progressa.setVisibility(View.VISIBLE);
                    holder.play.setVisibility(View.GONE);
                    tafseer_duration = 0;
                    total_tafseerduration = 0;
                    tafseermp = new MediaPlayer();
                    ads_list.get(position).setPlaying(true);
                    ClickedPosition = position;
                    holder.seekBar.setEnabled(true);
                    try {
                        tafseermp.setDataSource(filepath);
                        tafseermp.prepareAsync();
                        tafseermp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(final MediaPlayer mp) {
                                isTafseerLoaded = true;
                                isTafseerPLAYING = true;
                                tafseermp.start();
                                ((Activity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        holder.progressa.setVisibility(View.GONE);
                                        holder.play.setVisibility(View.VISIBLE);
                                        holder.progresslength.setText("0:00");
                                        holder.seekBar.setMax(mp.getDuration());
                                        total_tafseerduration = mp.getDuration();
                                        holder.audiototallength.setText(getCurrentTime(mp.getDuration()));
                                        tafseer_duration = tafseermp.getDuration();
                                        holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                                            @Override
                                            public void onStopTrackingTouch(SeekBar seekBar) {

                                            }

                                            @Override
                                            public void onStartTrackingTouch(SeekBar seekBar) {

                                            }

                                            @Override
                                            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                if (tafseermp != null && fromUser) {
                                                    tafseermp.seekTo(progress);
                                                }
                                            }
                                        });
                                        isPLAYING = false;
                                        holder.play.setVisibility(View.VISIBLE);
                                        holder.progressa.setVisibility(View.GONE);
                                        holder.play.setBackgroundResource(R.drawable.playgold);
                                    }
                                });
                                if (tafseer_timer == null) {
                                    tafseer_timer = new Timer();
                                    tafseer_timer.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (isTafseerPLAYING) {
                                                tafseer_duration = tafseermp.getCurrentPosition();
                                                ((Activity) context).runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        if (tafseermp.isPlaying()) {
                                                            holder.progresslength.setText(getCurrentTime(tafseer_duration));
                                                            holder.seekBar.setProgress(tafseermp.getCurrentPosition());

                                                        } else if (!tafseerpause) {
                                                            holder.progresslength.setText("0:00");
                                                            tafseer_timer.cancel();
                                                            tafseer_timer.purge();
                                                            tafseer_timer = null;
                                                            holder.seekBar.setProgress(0);
                                                            holder.play.setBackgroundResource(R.drawable.playgold);
                                                            holder.seekBar.setEnabled(false);
                                                        }
                                                    }
                                                });


                                            }
                                        }
                                    }, 1000, 1000);
                                }
                                ((Activity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        holder.play.setVisibility(View.VISIBLE);
                                        holder.play.setEnabled(true);
                                        holder.play.setBackgroundResource(R.drawable.pausse);
                                    }
                                });
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!isTafseerPLAYING) {
                                isTafseerPLAYING = true;
                                if (tafseermp != null) {
                                    tafseermp.start();
                                }
                                holder.seekBar.setEnabled(true);
                                holder.play.setVisibility(View.VISIBLE);
                                holder.progressa.setVisibility(View.GONE);
                                holder.play.setBackgroundResource(R.drawable.pausse);
                            } else {
                                isTafseerPLAYING = false;
                                if (tafseermp != null) {
                                    if (tafseermp.isPlaying()) {
                                        tafseermp.pause();
                                    }
                                }
                                holder.play.setVisibility(View.VISIBLE);
                                holder.progressa.setVisibility(View.GONE);
                                holder.play.setBackgroundResource(R.drawable.playgold);
                            }
                        }
                    });
                }

            } else {


                final Dialog dialog = new Dialog(context, R.style.MyDialog);
                dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setContentView(R.layout.open_download_dialog);
                dialog.setCancelable(false);
                dialog.show();
                TextView playi, download;
                playi = dialog.findViewById(R.id.playi);
                download = dialog.findViewById(R.id.download);
                playi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                        if (!isTafseerLoaded) {
                            holder.progressa.setVisibility(View.VISIBLE);
                            holder.play.setVisibility(View.GONE);
                            tafseer_duration = 0;
                            total_tafseerduration = 0;
                            tafseermp = new MediaPlayer();
                            ads_list.get(position).setPlaying(true);
                            ClickedPosition = position;
                            holder.seekBar.setEnabled(true);
                            try {
                                tafseermp.setDataSource(ads_list.get(position).getLink());
                                tafseermp.prepareAsync();
                                tafseermp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(final MediaPlayer mp) {
                                        isTafseerLoaded = true;
                                        isTafseerPLAYING = true;
                                        tafseermp.start();
                                        ((Activity) context).runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                holder.progressa.setVisibility(View.GONE);
                                                holder.play.setVisibility(View.VISIBLE);
                                                holder.progresslength.setText("0:00");
                                                holder.seekBar.setMax(mp.getDuration());
                                                total_tafseerduration = mp.getDuration();
                                                holder.audiototallength.setText(getCurrentTime(mp.getDuration()));

                                                tafseer_duration = tafseermp.getDuration();
                                                holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                                                    @Override
                                                    public void onStopTrackingTouch(SeekBar seekBar) {

                                                    }

                                                    @Override
                                                    public void onStartTrackingTouch(SeekBar seekBar) {

                                                    }

                                                    @Override
                                                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                        if (tafseermp != null && fromUser) {
                                                            tafseermp.seekTo(progress);
                                                        }
                                                    }
                                                });

                                                isPLAYING = false;
                                                holder.play.setVisibility(View.VISIBLE);
                                                holder.progressa.setVisibility(View.GONE);
                                                holder.play.setBackgroundResource(R.drawable.playgold);
                                            }
                                        });
                                        if (tafseer_timer == null) {
                                            tafseer_timer = new Timer();
                                            tafseer_timer.schedule(new TimerTask() {
                                                @Override
                                                public void run() {
                                                    if (isTafseerPLAYING) {
                                                        tafseer_duration = tafseermp.getCurrentPosition();
                                                        ((Activity) context).runOnUiThread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                if (tafseermp.isPlaying()) {
                                                                    holder.progresslength.setText(getCurrentTime(tafseer_duration));
                                                                    holder.seekBar.setProgress(tafseermp.getCurrentPosition());

                                                                } else if (!tafseerpause) {
                                                                    holder.progresslength.setText("0:00");
                                                                    tafseer_timer.cancel();
                                                                    tafseer_timer.purge();
                                                                    tafseer_timer = null;
                                                                    holder.seekBar.setProgress(0);
                                                                    holder.play.setBackgroundResource(R.drawable.playgold);
                                                                    holder.seekBar.setEnabled(false);
                                                                }
                                                            }
                                                        });


                                                    }
                                                }
                                            }, 1000, 1000);
                                        }
                                        ((Activity) context).runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                holder.play.setVisibility(View.VISIBLE);
                                                holder.play.setEnabled(true);
                                                holder.play.setBackgroundResource(R.drawable.pausse);
                                            }
                                        });
                                    }
                                });

                            } catch (IOException e) {
                                Toast.makeText(context, "Load failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (!isTafseerPLAYING) {
                                        isTafseerPLAYING = true;
                                        if (tafseermp != null) {
                                            tafseermp.start();
                                        }
                                        holder.seekBar.setEnabled(true);
                                        holder.play.setVisibility(View.VISIBLE);
                                        holder.progressa.setVisibility(View.GONE);
                                        holder.play.setBackgroundResource(R.drawable.pausse);
                                    } else {
                                        isTafseerPLAYING = false;
                                        if (tafseermp != null) {
                                            if (tafseermp.isPlaying()) {
                                                tafseermp.pause();
                                            }
                                        }
                                        holder.play.setVisibility(View.VISIBLE);
                                        holder.progressa.setVisibility(View.GONE);
                                        holder.play.setBackgroundResource(R.drawable.playgold);
                                    }
                                }
                            });
                        }
                    }
                });

                download.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED) {
                            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context
                                    , Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                                ActivityCompat.requestPermissions((Activity) context, new String[]{
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, 10);
                            } else {
                                ActivityCompat.requestPermissions((Activity) context, new String[]{
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, 10);
                            }
                        } else {
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                }
                            });
                            DownloadTask downloadTask;
                            downloadTask = new DownloadTask(context, ads_list.get(position).getLink(),
                                    ads_list.get(position).getTitle());
                        }
                    }
                });










//
//
//            if (!isTafseerLoaded) {
//                holder.progressa.setVisibility(View.VISIBLE);
//                holder.play.setVisibility(View.GONE);
//                tafseer_duration = 0;
//                total_tafseerduration = 0;
//                tafseermp = new MediaPlayer();
//                ads_list.get(position).setPlaying(true);
//                ClickedPosition = position;
//                holder.seekBar.setEnabled(true);
//                try {
//                    tafseermp.setDataSource(ads_list.get(position).getLink());
//                    tafseermp.prepareAsync();
//                    tafseermp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                        @Override
//                        public void onPrepared(final MediaPlayer mp) {
//                            isTafseerLoaded = true;
//                            isTafseerPLAYING = true;
//                            tafseermp.start();
//                            ((Activity) context).runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    holder.progressa.setVisibility(View.GONE);
//                                    holder.play.setVisibility(View.VISIBLE);
//                                    holder.progresslength.setText("0:00");
//                                    holder.seekBar.setMax(mp.getDuration());
//                                    total_tafseerduration = mp.getDuration();
//                                    holder.audiototallength.setText(getCurrentTime(mp.getDuration()));
//                                    tafseer_duration = tafseermp.getDuration();
//                                    holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//                                        @Override
//                                        public void onStopTrackingTouch(SeekBar seekBar) {
//
//                                        }
//
//                                        @Override
//                                        public void onStartTrackingTouch(SeekBar seekBar) {
//
//                                        }
//
//                                        @Override
//                                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                                            if (tafseermp != null && fromUser) {
//                                                tafseermp.seekTo(progress);
//                                            }
//                                        }
//                                    });
//                                    isPLAYING = false;
//                                    holder.play.setVisibility(View.VISIBLE);
//                                    holder.progressa.setVisibility(View.GONE);
//                                    holder.play.setBackgroundResource(R.drawable.playgold);
//                                }
//                            });
//                            if (tafseer_timer == null) {
//                                tafseer_timer = new Timer();
//                                tafseer_timer.schedule(new TimerTask() {
//                                    @Override
//                                    public void run() {
//                                        if (isTafseerPLAYING) {
//                                            tafseer_duration = tafseermp.getCurrentPosition();
//                                            ((Activity) context).runOnUiThread(new Runnable() {
//                                                @Override
//                                                public void run() {
//                                                    if (tafseermp.isPlaying()) {
//                                                        holder.progresslength.setText(getCurrentTime(tafseer_duration));
//                                                        holder.seekBar.setProgress(tafseermp.getCurrentPosition());
//
//                                                    } else if (!tafseerpause) {
//                                                        holder.progresslength.setText("0:00");
//                                                        tafseer_timer.cancel();
//                                                        tafseer_timer.purge();
//                                                        tafseer_timer = null;
//                                                        holder.seekBar.setProgress(0);
//                                                        holder.play.setBackgroundResource(R.drawable.playgold);
//                                                        holder.seekBar.setEnabled(false);
//                                                    }
//                                                }
//                                            });
//
//
//                                        }
//                                    }
//                                }, 1000, 1000);
//                            }
//                            ((Activity) context).runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    holder.play.setVisibility(View.VISIBLE);
//                                    holder.play.setEnabled(true);
//                                    holder.play.setBackgroundResource(R.drawable.pausse);
//                                }
//                            });
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            } else {
//                ((Activity) context).runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (!isTafseerPLAYING) {
//                            isTafseerPLAYING = true;
//                            if (tafseermp != null) {
//                                tafseermp.start();
//                            }
//                            holder.seekBar.setEnabled(true);
//                            holder.play.setVisibility(View.VISIBLE);
//                            holder.progressa.setVisibility(View.GONE);
//                            holder.play.setBackgroundResource(R.drawable.pausse);
//                        } else {
//                            isTafseerPLAYING = false;
//                            if (tafseermp != null) {
//                                if (tafseermp.isPlaying()) {
//                                    tafseermp.pause();
//                                }
//                            }
//                            holder.play.setVisibility(View.VISIBLE);
//                            holder.progressa.setVisibility(View.GONE);
//                            holder.play.setBackgroundResource(R.drawable.playgold);
//                        }
//                    }
//                });
//            }
            }
//
        }
//


       holder.tafseer_relative.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (ClickedPosition == position) {
                   File file = new File(filepath + "/" + ads_list.get(position).getTitle() + ".mp3");
                   if (file.exists()){
                        if (!isTafseerLoaded){
                            holder.progressa.setVisibility(View.VISIBLE);
                            holder.play.setVisibility(View.GONE);
                            tafseer_duration = 0;
                            total_tafseerduration = 0;
                            tafseermp = new MediaPlayer();
                            ads_list.get(position).setPlaying(true);
                            ClickedPosition = position;
                            holder.seekBar.setEnabled(true);
                            try {
                                tafseermp.setDataSource(filepath);
                                tafseermp.prepareAsync();
                                tafseermp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(final MediaPlayer mp) {
                                        isTafseerLoaded = true;
                                        isTafseerPLAYING = true;
                                        tafseermp.start();
                                        ((Activity) context).runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                holder.progressa.setVisibility(View.GONE);
                                                holder.play.setVisibility(View.VISIBLE);
                                                holder.progresslength.setText("0:00");
                                                holder.seekBar.setMax(mp.getDuration());
                                                total_tafseerduration = mp.getDuration();
                                                holder.audiototallength.setText(getCurrentTime(mp.getDuration()));
                                                tafseer_duration = tafseermp.getDuration();
                                                holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                                                    @Override
                                                    public void onStopTrackingTouch(SeekBar seekBar) {

                                                    }

                                                    @Override
                                                    public void onStartTrackingTouch(SeekBar seekBar) {

                                                    }

                                                    @Override
                                                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                        if (tafseermp != null && fromUser) {
                                                            tafseermp.seekTo(progress);
                                                        }
                                                    }
                                                });
                                                isPLAYING = false;
                                                holder.play.setVisibility(View.VISIBLE);
                                                holder.progressa.setVisibility(View.GONE);
                                                holder.play.setBackgroundResource(R.drawable.playgold);
                                            }
                                        });
                                        if (tafseer_timer == null) {
                                            tafseer_timer = new Timer();
                                            tafseer_timer.schedule(new TimerTask() {
                                                @Override
                                                public void run() {
                                                    if (isTafseerPLAYING) {
                                                        tafseer_duration = tafseermp.getCurrentPosition();
                                                        ((Activity) context).runOnUiThread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                if (tafseermp.isPlaying()) {
                                                                    holder.progresslength.setText(getCurrentTime(tafseer_duration));
                                                                    holder.seekBar.setProgress(tafseermp.getCurrentPosition());

                                                                } else if (!tafseerpause) {
                                                                    holder.progresslength.setText("0:00");
                                                                    tafseer_timer.cancel();
                                                                    tafseer_timer.purge();
                                                                    tafseer_timer = null;
                                                                    holder.seekBar.setProgress(0);
                                                                    holder.play.setBackgroundResource(R.drawable.playgold);
                                                                    holder.seekBar.setEnabled(false);
                                                                }
                                                            }
                                                        });


                                                    }
                                                }
                                            }, 1000, 1000);
                                        }
                                        ((Activity) context).runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                holder.play.setVisibility(View.VISIBLE);
                                                holder.play.setEnabled(true);
                                                holder.play.setBackgroundResource(R.drawable.pausse);
                                            }
                                        });
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } else {
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (!isTafseerPLAYING) {
                                        isTafseerPLAYING = true;
                                        if (tafseermp != null) {
                                            tafseermp.start();
                                        }
                                        holder.seekBar.setEnabled(true);
                                        holder.play.setVisibility(View.VISIBLE);
                                        holder.progressa.setVisibility(View.GONE);
                                        holder.play.setBackgroundResource(R.drawable.pausse);
                                    } else {
                                        isTafseerPLAYING = false;
                                        if (tafseermp != null) {
                                            if (tafseermp.isPlaying()) {
                                                tafseermp.pause();
                                            }
                                        }
                                        holder.play.setVisibility(View.VISIBLE);
                                        holder.progressa.setVisibility(View.GONE);
                                        holder.play.setBackgroundResource(R.drawable.playgold);
                                    }
                                }
                            });
                        }

                   } else {
                   if (!isTafseerLoaded) {
                       holder.progressa.setVisibility(View.VISIBLE);
                       holder.play.setVisibility(View.GONE);
                       tafseer_duration = 0;
                       total_tafseerduration = 0;
                       tafseermp = new MediaPlayer();
                       ads_list.get(position).setPlaying(true);
                       ClickedPosition = position;
                       holder.seekBar.setEnabled(true);
                       try {
                           tafseermp.setDataSource(ads_list.get(position).getLink());
                           tafseermp.prepareAsync();
                           tafseermp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                               @Override
                               public void onPrepared(final MediaPlayer mp) {
                                   isTafseerLoaded = true;
                                   isTafseerPLAYING = true;
                                   tafseermp.start();
                                   ((Activity) context).runOnUiThread(new Runnable() {
                                       @Override
                                       public void run() {
                                           holder.progressa.setVisibility(View.GONE);
                                           holder.play.setVisibility(View.VISIBLE);
                                           holder.progresslength.setText("0:00");
                                           holder.seekBar.setMax(mp.getDuration());
                                           total_tafseerduration = mp.getDuration();
                                           holder.audiototallength.setText(getCurrentTime(mp.getDuration()));

                                           tafseer_duration = tafseermp.getDuration();
                                           holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                                               @Override
                                               public void onStopTrackingTouch(SeekBar seekBar) {

                                               }

                                               @Override
                                               public void onStartTrackingTouch(SeekBar seekBar) {

                                               }

                                               @Override
                                               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                   if (tafseermp != null && fromUser) {
                                                       tafseermp.seekTo(progress);
                                                   }
                                               }
                                           });

                                           isPLAYING = false;
                                           holder.play.setVisibility(View.VISIBLE);
                                           holder.progressa.setVisibility(View.GONE);
                                           holder.play.setBackgroundResource(R.drawable.playgold);
                                       }
                                   });
                                   if (tafseer_timer == null) {
                                       tafseer_timer = new Timer();
                                       tafseer_timer.schedule(new TimerTask() {
                                           @Override
                                           public void run() {
                                               if (isTafseerPLAYING) {
                                                   tafseer_duration = tafseermp.getCurrentPosition();
                                                   ((Activity) context).runOnUiThread(new Runnable() {
                                                       @Override
                                                       public void run() {
                                                           if (tafseermp.isPlaying()) {
                                                               holder.progresslength.setText(getCurrentTime(tafseer_duration));
                                                               holder.seekBar.setProgress(tafseermp.getCurrentPosition());

                                                           } else if (!tafseerpause) {
                                                               holder.progresslength.setText("0:00");
                                                               tafseer_timer.cancel();
                                                               tafseer_timer.purge();
                                                               tafseer_timer = null;
                                                               holder.seekBar.setProgress(0);
                                                               holder.play.setBackgroundResource(R.drawable.playgold);
                                                               holder.seekBar.setEnabled(false);
                                                           }
                                                       }
                                                   });


                                               }
                                           }
                                       }, 1000, 1000);
                                   }
                                   ((Activity) context).runOnUiThread(new Runnable() {
                                       @Override
                                       public void run() {
                                           holder.play.setVisibility(View.VISIBLE);
                                           holder.play.setEnabled(true);
                                           holder.play.setBackgroundResource(R.drawable.pausse);
                                       }
                                   });
                               }
                           });

                       } catch (IOException e) {
                           Toast.makeText(context, "Load failed", Toast.LENGTH_SHORT).show();
                       }
                   } else {
                       ((Activity) context).runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               if (!isTafseerPLAYING) {
                                   isTafseerPLAYING = true;
                                   if (tafseermp != null) {
                                       tafseermp.start();
                                   }
                                   holder.seekBar.setEnabled(true);
                                   holder.play.setVisibility(View.VISIBLE);
                                   holder.progressa.setVisibility(View.GONE);
                                   holder.play.setBackgroundResource(R.drawable.pausse);
                               } else {
                                   isTafseerPLAYING = false;
                                   if (tafseermp != null) {
                                       if (tafseermp.isPlaying()) {
                                           tafseermp.pause();
                                       }
                                   }
                                   holder.play.setVisibility(View.VISIBLE);
                                   holder.progressa.setVisibility(View.GONE);
                                   holder.play.setBackgroundResource(R.drawable.playgold);
                               }
                           }
                       });
                   }
               }

               } else {

                   if (tafseermp != null) {
                       tafseermp.pause();
                       tafseermp = null;
                   }
                       if (ClickedPosition != -1) {
                           ads_list.get(ClickedPosition).setPlaying(false);
                       }
                       ads_list.get(position).setPlaying(true);
                       isTafseerLoaded =false;
                       notifyDataSetChanged();




                 //  else {

//                   if (file.exists()){
//                       if (!isTafseerLoaded) {
//
//                           holder.progressa.setVisibility(View.VISIBLE);
//                           holder.play.setVisibility(View.GONE);
//                           tafseer_duration = 0;
//                           total_tafseerduration = 0;
//                           tafseermp = new MediaPlayer();
//                           ads_list.get(position).setPlaying(true);
//                           ClickedPosition = position;
//                           holder.seekBar.setEnabled(true);
//                           try {
//                               tafseermp.setDataSource(ads_list.get(position).getLink());
//                               tafseermp.prepareAsync();
//                               tafseermp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                                   @Override
//                                   public void onPrepared(final MediaPlayer mp) {
//                                       isTafseerLoaded = true;
//                                       isTafseerPLAYING = true;
//                                       tafseermp.start();
//                                       ((Activity) context).runOnUiThread(new Runnable() {
//                                           @Override
//                                           public void run() {
//                                               holder.progressa.setVisibility(View.GONE);
//                                               holder.play.setVisibility(View.VISIBLE);
//                                               holder.progresslength.setText("0:00");
//                                               holder.seekBar.setMax(mp.getDuration());
//                                               total_tafseerduration = mp.getDuration();
//                                               holder.audiototallength.setText(getCurrentTime(mp.getDuration()));
//
//                                               tafseer_duration = tafseermp.getDuration();
//                                               holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//
//                                                   @Override
//                                                   public void onStopTrackingTouch(SeekBar seekBar) {
//
//                                                   }
//
//                                                   @Override
//                                                   public void onStartTrackingTouch(SeekBar seekBar) {
//
//                                                   }
//
//                                                   @Override
//                                                   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                                                       if (tafseermp != null && fromUser) {
//                                                           tafseermp.seekTo(progress);
//                                                       }
//                                                   }
//                                               });
//
//                                               isPLAYING = false;
//                                               holder.play.setVisibility(View.VISIBLE);
//                                               holder.progressa.setVisibility(View.GONE);
//                                               holder.play.setBackgroundResource(R.drawable.playgold);
//                                           }
//                                       });
//                                       if (tafseer_timer == null) {
//                                           tafseer_timer = new Timer();
//                                           tafseer_timer.schedule(new TimerTask() {
//                                               @Override
//                                               public void run() {
//                                                   if (isTafseerPLAYING) {
//                                                       tafseer_duration = tafseermp.getCurrentPosition();
//                                                       ((Activity) context).runOnUiThread(new Runnable() {
//                                                           @Override
//                                                           public void run() {
//                                                               if (tafseermp.isPlaying()) {
//                                                                   holder.progresslength.setText(getCurrentTime(tafseer_duration));
//                                                                   holder.seekBar.setProgress(tafseermp.getCurrentPosition());
//
//                                                               } else if (!tafseerpause) {
//                                                                   holder.progresslength.setText("0:00");
//                                                                   tafseer_timer.cancel();
//                                                                   tafseer_timer.purge();
//                                                                   tafseer_timer = null;
//                                                                   holder.seekBar.setProgress(0);
//                                                                   holder.play.setBackgroundResource(R.drawable.playgold);
//                                                                   holder.seekBar.setEnabled(false);
//                                                               }
//                                                           }
//                                                       });
//
//
//                                                   }
//                                               }
//                                           }, 1000, 1000);
//                                       }
//                                       ((Activity) context).runOnUiThread(new Runnable() {
//                                           @Override
//                                           public void run() {
//                                               holder.play.setVisibility(View.VISIBLE);
//                                               holder.play.setEnabled(true);
//                                               holder.play.setBackgroundResource(R.drawable.pausse);
//                                           }
//                                       });
//                                   }
//                               });
//
//                           } catch (IOException e) {
//                               Toast.makeText(context, "Load failed", Toast.LENGTH_SHORT).show();
//                           }
//                       } else {
//                           ((Activity) context).runOnUiThread(new Runnable() {
//                               @Override
//                               public void run() {
//                                   if (!isTafseerPLAYING) {
//                                       isTafseerPLAYING = true;
//                                       if (tafseermp != null) {
//                                           tafseermp.start();
//                                       }
//                                       holder.seekBar.setEnabled(true);
//                                       holder.play.setVisibility(View.VISIBLE);
//                                       holder.progressa.setVisibility(View.GONE);
//                                       holder.play.setBackgroundResource(R.drawable.pausse);
//                                   } else {
//                                       isTafseerPLAYING = false;
//                                       if (tafseermp != null) {
//                                           if (tafseermp.isPlaying()) {
//                                               tafseermp.pause();
//                                           }
//                                       }
//                                       holder.play.setVisibility(View.VISIBLE);
//                                       holder.progressa.setVisibility(View.GONE);
//                                       holder.play.setBackgroundResource(R.drawable.playgold);
//                                   }
//                               }
//                           });
//                       }
//                   } else {
//
             }
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
        TextView name, audiototallength, progresslength;
        ImageView play;
        SeekBar seekBar;
        MKLoader progressa;
        RelativeLayout tafseer_relative;
        private ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.play_title);
            audiototallength = itemView.findViewById(R.id.tafseer_total);
            progresslength = itemView.findViewById(R.id.tafseer_time);
            play = itemView.findViewById(R.id.play_tafseer);
            seekBar = itemView.findViewById(R.id.tafseer_seek);
            progressa = itemView.findViewById(R.id.progressa);
            tafseer_relative = itemView.findViewById(R.id.tafseer_relative);
        }

    }
    private boolean isTafseerLoaded = false,isPLAYING = false,isTafseerPLAYING = false;
    MediaPlayer tafseermp;




    public String getCurrentTime(long different) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentdate = "";


        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        long monthesInMilli = daysInMilli * 30;
        long yearInMilli = monthesInMilli * 12;

        long elapsedyears = different / yearInMilli;
        different = different % yearInMilli;

        long elapsedmonths = different / monthesInMilli;
        different = different % monthesInMilli;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;


        if (elapsedHours >= 1) {
            currentdate = elapsedHours + " : " + elapsedMinutes;
        } else {
            if (elapsedSeconds < 10) {
                currentdate = elapsedMinutes + " : 0" + elapsedSeconds;
            } else {
                currentdate = elapsedMinutes + " : " + elapsedSeconds;
            }
        }


        return currentdate;

    }



    Receiver receiver;
    private boolean isRegistered = false;

    private class Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context arg0, Intent arg1) {
            String methodName = arg1.getStringExtra(BroadcastHelper.BROADCAST_EXTRA_METHOD_NAME);
            if (methodName != null && methodName.length() > 0) {
                Log.v("receive", methodName);
                switch (methodName) {
                    case "pause" :
                        if (tafseer_timer != null){
                            tafseer_timer.cancel();
                            tafseer_timer.purge();
                            tafseer_timer = null;
                        }
                        if (tafseermp != null){
                            if (tafseermp.isPlaying()){
                                tafseermp.stop();
                                tafseermp = null;
                            }
                        }
                        try{
                            if (isRegistered){
                                context.unregisterReceiver(receiver);
                            }
                        } catch (NullPointerException e){
                            e.printStackTrace();
                        }
                        break;

                    default:
                        break;

                }
            }
        }
    }


    public void openAddDialog() {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.add_alarm);
        dialog.setCancelable(false);
        dialog.show();
        TextView playi,download;
        playi = dialog.findViewById(R.id.playi);
        download = dialog.findViewById(R.id.download);
        playi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



}
