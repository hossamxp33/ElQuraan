package com.codesroots.elquraan;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codesroots.elquraan.Adapter.All_Sour_Dialog_Adapter;
import com.codesroots.elquraan.Adapter.FavList_Adapter;
import com.codesroots.elquraan.Helpers.ApiClient;
import com.codesroots.elquraan.Helpers.ApiInterface;
import com.codesroots.elquraan.Helpers.BroadcastHelper;
import com.codesroots.elquraan.Helpers.ConnectivityReceiver;
import com.codesroots.elquraan.Helpers.DownloadTask;
import com.codesroots.elquraan.Helpers.PreferenceHelper;
import com.codesroots.elquraan.Helpers.ProgressDialogHelper;
import com.codesroots.elquraan.Models.All_Sour_Model;
import com.codesroots.elquraan.Models.FavouriteModel;
import com.codesroots.elquraan.db.Constants;
import com.codesroots.elquraan.db.DBAdapter;
import com.tuyenmonkey.mkloader.MKLoader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PlayActivity extends AppCompatActivity {
    private boolean isClicked = false;
    private int total_telawoduration = 0, total_tafseerduration = 0;
    private MediaPlayer mps, tafseermp;
    boolean isPLAYING = false, isLoaded = false;
    boolean isTafseerPLAYING = false, isTafseerLoaded = false;
    int telawoa_duration = 0, tafseer_duration = 0;
    SeekBar tafseer_seek;
    private ImageView play_tafseer, stop_tafseer;
    LinearLayout play_lin;
    RelativeLayout toolbar;
    MKLoader progressa;
    TextView tafseertime, tafseer_total, sora_tartib, ayatcount, sora_name;
    Timer tafseer_timer;
    RelativeLayout tafseer_relative;
    ArrayList<All_Sour_Model.DataBean> arrayList;

    private int currentpage = 0;
    private boolean isTafseer = false, loading = false;
    DBAdapter dbAdapter;
    //   DBHelper dbHelper;
    private boolean tafseerpause = false, isforward = false;
    String tafseer_link;
    ImageView newplay, backward, reback, rewind, forward;
    ImageButton back_btn, show_favourite, add_favourite;
    private LinearLayout lisen_lin;
    private TextView listen, download;
    private PreferenceHelper helper;
    private TextView ulfia,arabic;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        arrayList = new ArrayList<>();

       // getData();

        show_favourite = findViewById(R.id.show_favourite);
        add_favourite = findViewById(R.id.add_favourite);
        favouriteModels = new ArrayList<>();
        helper = new PreferenceHelper(this);
        ImageButton menus = findViewById(R.id.menus);
        ulfia = findViewById(R.id.ulfia);
        arabic = findViewById(R.id.arabic);
        if (helper.getLanguageID() == 0){
            arabic.setBackgroundResource(R.drawable.edit_back_gray);
            arabic.setTextColor(ContextCompat.getColor(this,R.color.yel));
            ulfia.setBackgroundResource(R.drawable.edit_back_gray_whiteframe);
            ulfia.setTextColor(ContextCompat.getColor(this,R.color.white));
        } else {
            ulfia.setBackgroundResource(R.drawable.edit_back_gray);
            ulfia.setTextColor(ContextCompat.getColor(this,R.color.yel));
            arabic.setBackgroundResource(R.drawable.edit_back_gray_whiteframe);
            arabic.setTextColor(ContextCompat.getColor(this,R.color.white));
        }
        ulfia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     helper.setLanguageID(1);
                     stopTafseerPlaying();
                ulfia.setBackgroundResource(R.drawable.edit_back_gray);
                ulfia.setTextColor(ContextCompat.getColor(PlayActivity.this,R.color.yel));
                arabic.setBackgroundResource(R.drawable.edit_back_gray_whiteframe);
                arabic.setTextColor(ContextCompat.getColor(PlayActivity.this,R.color.white));
                    File file = new File(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                    if (file.exists()) {
                        progressa.setVisibility(View.VISIBLE);
                        newplay.setVisibility(View.GONE);
                        PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                        tafseer_link = filepath + "/" + sora_name.getText().toString() + "ts.mp3";

                        play_lin.animate()
                                .translationY(play_lin.getHeight())
                                .alpha(0.0f)
                                .setDuration(600)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        play_lin.setVisibility(View.GONE);
                                    }
                                });
                      }
                    else {
//                        progressa.setVisibility(View.VISIBLE);
//                        newplay.setVisibility(View.GONE);
                        if (ConnectivityReceiver.isConnected()) {
                                 play_lin.animate()
                                        .translationY(0)
                                        .alpha(1.0f)
                                        .setDuration(600)
                                        .setListener(new AnimatorListenerAdapter() {
                                            @Override
                                            public void onAnimationEnd(Animator animation) {
                                                super.onAnimationEnd(animation);
                                                play_lin.setVisibility(View.VISIBLE);
                                            }
                                        });


                          //  PLAYTafseer(arrayList.get(currentpage).getSecond_lang());
                        } else {
                            Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                        }
                    }


            }
        });

                arabic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopTafseerPlaying();
                        arabic.setBackgroundResource(R.drawable.edit_back_gray);
                        arabic.setTextColor(ContextCompat.getColor(PlayActivity.this,R.color.yel));
                        ulfia.setBackgroundResource(R.drawable.edit_back_gray_whiteframe);
                        ulfia.setTextColor(ContextCompat.getColor(PlayActivity.this,R.color.white));
                        helper.setLanguageID(0);
                        File file = new File(filepath + "/" + sora_name.getText().toString() + "t.mp3");

                        if (file.exists()) {

                            progressa.setVisibility(View.VISIBLE);
                            newplay.setVisibility(View.GONE);

                                PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                            tafseer_link = filepath + "/" + sora_name.getText().toString() + "t.mp3";
                            play_lin.animate()
                                    .translationY(play_lin.getHeight())
                                    .alpha(0.0f)
                                    .setDuration(600)
                                    .setListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            super.onAnimationEnd(animation);
                                            play_lin.setVisibility(View.GONE);
                                        }
                                    });
                        }
                        else {

//                            progressa.setVisibility(View.VISIBLE);
//                            newplay.setVisibility(View.GONE);
                            if (ConnectivityReceiver.isConnected()) {
                                play_lin.animate()
                                        .translationY(0)
                                        .alpha(1.0f)
                                        .setDuration(600)
                                        .setListener(new AnimatorListenerAdapter() {
                                            @Override
                                            public void onAnimationEnd(Animator animation) {
                                                super.onAnimationEnd(animation);
                                                play_lin.setVisibility(View.VISIBLE);
                                            }
                                        });
                            } else {
                                Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                            }
                        }



                    }
                });

        menus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.size() > 0) {
                    showAllSourDialog();
                } else {
                    isClicked = true;
                    // Toast.makeText(PlayActivity.this, getString(R.string.pleasewait), Toast.LENGTH_SHORT).show();
                    RetrieveTopDialogData();
                    showAllSourDialog();
                }
            }
        });
        listen = findViewById(R.id.listen);

        download = findViewById(R.id.download);

        listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (helper.getLanguageID() == 0){
                    File file = new File(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                    if (file.exists()) {
                        progressa.setVisibility(View.VISIBLE);
                        newplay.setVisibility(View.GONE);
                        PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                    } else {

                        progressa.setVisibility(View.VISIBLE);
                        newplay.setVisibility(View.GONE);

                        if (ConnectivityReceiver.isConnected()) {
                            PLAYTafseer(arrayList.get(currentpage).getTafseerlink());
                        } else {
                            Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                        }
                    }
                    play_lin.animate()
                            .translationY(play_lin.getHeight())
                            .alpha(0.0f)
                            .setDuration(600)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    play_lin.setVisibility(View.GONE);
                                }
                            });
                } else {
                    File file = new File(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                    if (file.exists()) {
                        progressa.setVisibility(View.VISIBLE);
                        newplay.setVisibility(View.GONE);
                        PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                    } else {
                        progressa.setVisibility(View.VISIBLE);
                        newplay.setVisibility(View.GONE);
                        if (ConnectivityReceiver.isConnected()) {
                            PLAYTafseer(arrayList.get(currentpage).getSecond_lang());
                        } else {
                            Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                        }
                    }
                    play_lin.animate()
                            .translationY(play_lin.getHeight())
                            .alpha(0.0f)
                            .setDuration(600)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    play_lin.setVisibility(View.GONE);
                                }
                            });
                }

            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (helper.getLanguageID() == 0) {
                    DownloadTask downloadTask;
                    if (arrayList.get(currentpage).getTafseerlink().contains("http"))
                    downloadTask = new DownloadTask(PlayActivity.this, arrayList.get(currentpage).getTafseerlink(),
                            sora_name.getText().toString() + "t");
                }
                else {
                    DownloadTask downloadTask;
                    if (arrayList.get(currentpage).getSecond_lang().contains("http"))
                        downloadTask = new DownloadTask(PlayActivity.this, arrayList.get(currentpage).getSecond_lang(),
                            sora_name.getText().toString() + "ts");
                }

                play_lin.animate()
                        .translationY(play_lin.getHeight())
                        .alpha(0.0f)
                        .setDuration(600)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                play_lin.setVisibility(View.GONE);
                            }
                   });
            }
        });

        currentpage = getIntent().getIntExtra("pos", 0);
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        newplay = findViewById(R.id.newplay);
        reback = findViewById(R.id.reback);
        rewind = findViewById(R.id.rewind);
        backward = findViewById(R.id.backward);
        forward = findViewById(R.id.forward);
        play_lin = findViewById(R.id.lisen_lin);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTafseerLoaded = false;
                if (currentpage != 0) {
                    stopTafseerPlaying();
                    currentpage = currentpage - 1;
                     sora_name.setText(arrayList.get(currentpage).getName());
                    sora_tartib.setText(String.valueOf(arrayList.get(currentpage).getId() - 1));

                    ayatcount.setText(String.valueOf(arrayList.get(currentpage).getAyatCounter()));

                    if (helper.getLanguageID() == 0){
                        File file = new File(filepath + arrayList.get(currentpage).getName() + "t.mp3");
                        if (file.exists()) {
                            if (arrayList.size() > 0) {
                                if (currentpage <= arrayList.size())
                                    PLAYTafseer(filepath + arrayList.get(currentpage).getName() + "t.mp3");
                                tafseer_link = filepath + arrayList.get(currentpage).getName() + "t.mp3";
                                play_lin.animate()
                                        .translationY(play_lin.getHeight())
                                        .alpha(0.0f)
                                        .setDuration(600)
                                        .setListener(new AnimatorListenerAdapter() {
                                            @Override
                                            public void onAnimationEnd(Animator animation) {
                                                super.onAnimationEnd(animation);
                                                play_lin.setVisibility(View.GONE);
                                            }
                                        });
                            }
                        } else {
                            if (arrayList.size() > 0) {
                                if (currentpage <= arrayList.size())
                                    if (ConnectivityReceiver.isConnected()) {
                                        play_lin.animate()
                                                .translationY(0)
                                                .alpha(1.0f)
                                                .setDuration(600)
                                                .setListener(new AnimatorListenerAdapter() {
                                                    @Override
                                                    public void onAnimationEnd(Animator animation) {
                                                        super.onAnimationEnd(animation);
                                                        play_lin.setVisibility(View.VISIBLE);
                                                    }
                                                });
//                                            PLAYTafseer(arrayList.get(currentpage).getTafseerlink());
//                                            tafseer_link = arrayList.get(currentpage).getTafseerlink();


                                    } else {
                                        Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();

                                    }
                            }
                        }
                    } else {
                        File file = new File(filepath + arrayList.get(currentpage).getName() + "ts.mp3");
                        if (file.exists()) {
                            if (arrayList.size() > 0) {
                                if (currentpage <= arrayList.size())
                                    PLAYTafseer(filepath + arrayList.get(currentpage).getName() + "ts.mp3");
                                tafseer_link = filepath + arrayList.get(currentpage).getName() + "ts.mp3";
                                play_lin.animate()
                                        .translationY(play_lin.getHeight())
                                        .alpha(0.0f)
                                        .setDuration(600)
                                        .setListener(new AnimatorListenerAdapter() {
                                            @Override
                                            public void onAnimationEnd(Animator animation) {
                                                super.onAnimationEnd(animation);
                                                play_lin.setVisibility(View.GONE);
                                            }
                                        });
                            }
                        } else {
                            if (arrayList.size() > 0) {
                                if (currentpage <= arrayList.size())
                                    if (ConnectivityReceiver.isConnected()) {
                                        play_lin.animate()
                                                .translationY(0)
                                                .alpha(1.0f)
                                                .setDuration(600)
                                                .setListener(new AnimatorListenerAdapter() {
                                                    @Override
                                                    public void onAnimationEnd(Animator animation) {
                                                        super.onAnimationEnd(animation);
                                                        play_lin.setVisibility(View.VISIBLE);
                                                    }
                                                });
//                                            PLAYTafseer(arrayList.get(currentpage).getSecond_lang());
//                                            tafseer_link = arrayList.get(currentpage).getSecond_lang();
                                    } else {
                                        Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();

                                    }
                            }
                        }
                    }

                }
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTafseerLoaded = false;
                if (arrayList.size() > 0) {
                    if (currentpage < arrayList.size()) {
                        stopTafseerPlaying();

                        currentpage = currentpage + 1;
                        sora_name.setText(arrayList.get(currentpage).getName());
                        sora_tartib.setText(String.valueOf(arrayList.get(currentpage).getId() - 1));
                        ayatcount.setText(String.valueOf(arrayList.get(currentpage).getAyatCounter()));
                        if (helper.getLanguageID() == 0){
                            File file = new File(filepath + arrayList.get(currentpage).getName() + "t.mp3");
                            if (file.exists()) {
                                if (arrayList.size() > 0) {
                                    if (currentpage <= arrayList.size())
                                            PLAYTafseer(filepath + arrayList.get(currentpage).getName() + "t.mp3");
                                            tafseer_link = filepath + arrayList.get(currentpage).getName() + "t.mp3";
                                    play_lin.animate()
                                            .translationY(play_lin.getHeight())
                                            .alpha(0.0f)
                                            .setDuration(600)
                                            .setListener(new AnimatorListenerAdapter() {
                                                @Override
                                                public void onAnimationEnd(Animator animation) {
                                                    super.onAnimationEnd(animation);
                                                    play_lin.setVisibility(View.GONE);
                                                }
                                            });
                                }
                            } else {
                                if (arrayList.size() > 0) {
                                    if (currentpage <= arrayList.size())
                                        if (ConnectivityReceiver.isConnected()) {
                                            play_lin.animate()
                                                    .translationY(0)
                                                    .alpha(1.0f)
                                                    .setDuration(600)
                                                    .setListener(new AnimatorListenerAdapter() {
                                                        @Override
                                                        public void onAnimationEnd(Animator animation) {
                                                            super.onAnimationEnd(animation);
                                                            play_lin.setVisibility(View.VISIBLE);
                                                        }
                                                    });


//                                                PLAYTafseer(arrayList.get(currentpage).getTafseerlink());
//                                                tafseer_link = arrayList.get(currentpage).getTafseerlink();

                                        } else {
                                            Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();

                                        }
                                }
                            }
                        } else {
                            File file = new File(filepath + arrayList.get(currentpage).getName() + "ts.mp3");
                            if (file.exists()) {
                                if (arrayList.size() > 0) {
                                    if (currentpage <= arrayList.size())

                                            PLAYTafseer(filepath + arrayList.get(currentpage).getName() + "ts.mp3");
                                            tafseer_link = filepath + arrayList.get(currentpage).getName() + "ts.mp3";
                                    play_lin.animate()
                                            .translationY(play_lin.getHeight())
                                            .alpha(0.0f)
                                            .setDuration(600)
                                            .setListener(new AnimatorListenerAdapter() {
                                                @Override
                                                public void onAnimationEnd(Animator animation) {
                                                    super.onAnimationEnd(animation);
                                                    play_lin.setVisibility(View.GONE);
                                                }
                                            });
                                }
                            } else {
                                if (arrayList.size() > 0) {
                                    if (currentpage <= arrayList.size())
                                        if (ConnectivityReceiver.isConnected()) {
                                            play_lin.animate()
                                                    .translationY(0)
                                                    .alpha(1.0f)
                                                    .setDuration(600)
                                                    .setListener(new AnimatorListenerAdapter() {
                                                        @Override
                                                        public void onAnimationEnd(Animator animation) {
                                                            super.onAnimationEnd(animation);
                                                            play_lin.setVisibility(View.VISIBLE);
                                                        }
                                                    });
//                                                PLAYTafseer(arrayList.get(currentpage).getSecond_lang());
//                                                tafseer_link = arrayList.get(currentpage).getSecond_lang();

                                        } else {
                                            Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();

                                        }
                                }
                            }
                        }

                    }
                }
            }
        });

        reback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tafseermp != null) {
                    isforward = true;
                    tafseermp.pause();
                    backwardSong();
                    tafseermp.start();
                    isforward = false;

                }
            }
        });

        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tafseermp != null) {
                    isforward = true;
                    tafseermp.pause();
                      forwardSong();
                    tafseermp.start();
                    isforward = false;
                }
            }
        });
        File direct = new File(Environment.getExternalStorageDirectory() + "/OtherTafaseer");
        filepath = Environment.getExternalStoragePublicDirectory(String.valueOf(direct)) + "/";
        tafseer_link = getIntent().getStringExtra("tafseer_link");
        dbAdapter = new DBAdapter(this);
        toolbar = findViewById(R.id.toolbar);
        tafseertime = findViewById(R.id.tafseer_time);
        tafseer_relative = findViewById(R.id.tafseer_relative);
        progressa = findViewById(R.id.progressa);
        tafseer_seek = findViewById(R.id.tafseer_seek);
        tafseer_seek.getThumb().setColorFilter(ContextCompat.getColor(this, R.color.yel)
                , PorterDuff.Mode.SRC_ATOP);
        tafseer_seek.getProgressDrawable().setColorFilter(ContextCompat.getColor(this, R.color.light_gray), PorterDuff.Mode.SRC_ATOP);
        tafseer_seek.setEnabled(false);
        play_tafseer = findViewById(R.id.play_tafseer);
        stop_tafseer = findViewById(R.id.stop_tafseer);
        ayatcount = findViewById(R.id.ayat_num);
        sora_name = findViewById(R.id.sora_name);
        sora_tartib = findViewById(R.id.sora_tartib);
        sora_name.setText(getIntent().getStringExtra("name"));
        sora_tartib.setText(String.valueOf(getIntent().getIntExtra("tartib", 0)));
        int gg=getIntent().getIntExtra("ayatcount", 0);
        ayatcount.setText(String.valueOf(getIntent().getIntExtra("ayatcount", 0)));

        tafseer_relative.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stopTafseerPlaying();
            }
        });

        newplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTafseerLoaded) {

                    if (isSoundChanged) {

                        isSoundChanged = false;
                        if (helper.getLanguageID() == 0) {
                            File file = new File(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                            if (file.exists()) {
                                progressa.setVisibility(View.VISIBLE);
                                newplay.setVisibility(View.GONE);
                                PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                                tafseer_link = filepath + "/" + sora_name.getText().toString() + "t.mp3";
                            } else {
                                if (ConnectivityReceiver.isConnected()) {
                                    play_lin.animate()
                                            .translationY(0)
                                            .alpha(1.0f)
                                            .setDuration(600)
                                            .setListener(new AnimatorListenerAdapter() {
                                                @Override
                                                public void onAnimationEnd(Animator animation) {
                                                    super.onAnimationEnd(animation);
                                                    play_lin.setVisibility(View.VISIBLE);
                                                }
                                            });
                                } else {
                                    Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                                }
                            }
                        } else {
                            File file = new File(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                            if (file.exists()) {
                                progressa.setVisibility(View.VISIBLE);
                                newplay.setVisibility(View.GONE);
                                PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                                tafseer_link = filepath + "/" + sora_name.getText().toString() + "ts.mp3";
                            } else {
                                if (ConnectivityReceiver.isConnected()) {
                                    play_lin.animate()
                                            .translationY(0)
                                            .alpha(1.0f)
                                            .setDuration(600)
                                            .setListener(new AnimatorListenerAdapter() {
                                                @Override
                                                public void onAnimationEnd(Animator animation) {
                                                    super.onAnimationEnd(animation);
                                                    play_lin.setVisibility(View.VISIBLE);
                                                }
                                            });
                                } else {
                                    Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                    } else {
                        if (helper.getLanguageID() == 0) {

                            File file = new File(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                            if (file.exists()) {
                                progressa.setVisibility(View.VISIBLE);
                                newplay.setVisibility(View.GONE);

                                PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                                tafseer_link = filepath + "/" + sora_name.getText().toString() + "t.mp3";

                            } else {
                                progressa.setVisibility(View.VISIBLE);
                                newplay.setVisibility(View.GONE);
                                if (arrayList.size() > 0) {
                                    if (currentpage <= arrayList.size())
                                        if (ConnectivityReceiver.isConnected()) {
                                            if (helper.getLanguageID() == 0) {
                                                PLAYTafseer(arrayList.get(currentpage).getTafseerlink());
                                                tafseer_link = arrayList.get(currentpage).getTafseerlink();
                                            } else {
                                                PLAYTafseer(arrayList.get(currentpage).getSecond_lang());
                                                tafseer_link = arrayList.get(currentpage).getSecond_lang();

                                            }
                                        } else {
                                            Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();

                                        }
                                }
                            }
                        } else {
                            File file = new File(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                            if (file.exists()) {
                                progressa.setVisibility(View.VISIBLE);
                                newplay.setVisibility(View.GONE);

                                PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                                tafseer_link = filepath + "/" + sora_name.getText().toString() + "ts.mp3";

                            } else {
                                progressa.setVisibility(View.VISIBLE);
                                newplay.setVisibility(View.GONE);
                                if (arrayList.size() > 0) {
                                    if (currentpage <= arrayList.size())
                                        if (ConnectivityReceiver.isConnected()) {
                                            if (helper.getLanguageID() == 0) {
                                                PLAYTafseer(arrayList.get(currentpage).getTafseerlink());
                                                tafseer_link = arrayList.get(currentpage).getTafseerlink();
                                            } else {
                                                PLAYTafseer(arrayList.get(currentpage).getSecond_lang());
                                                tafseer_link = arrayList.get(currentpage).getSecond_lang();
                                            }
                                        } else {
                                            Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();

                                        }
                                }
                            }
                        }

                    }
                } else {
                    if (arrayList.size() > 0) {
                        if (currentpage <= arrayList.size())
                            if (ConnectivityReceiver.isConnected()) {
                                if (helper.getLanguageID() == 0) {
                                    File file = new File(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                                    if (file.exists()) {
                                        PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                                    } else {
                                        PLAYTafseer(arrayList.get(currentpage).getTafseerlink());

                                    }
                                    tafseer_link = arrayList.get(currentpage).getTafseerlink();
                                } else {
                                    File file = new File(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                                    if (file.exists()) {
                                        PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "ts.mp3");

                                    } else {
                                        PLAYTafseer(arrayList.get(currentpage).getSecond_lang());

                                    }
                                    tafseer_link = arrayList.get(currentpage).getSecond_lang();
                                }
                            } else {
                                if (helper.getLanguageID() == 0) {

                                    File file = new File(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                                    if (file.exists()) {
                                        PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "t.mp3");
                                    } else {
                                        Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();

                                    }
                                } else {
                                    File file = new File(filepath + "/" + sora_name.getText().toString() + "ts.mp3");
                                    if (file.exists()) {
                                        PLAYTafseer(filepath + "/" + sora_name.getText().toString() + "ts.mp3");

                                    } else {
                                        Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();

                                    }
                                }

                            }
                    }
                }
            }
        });
        RetrieveTopDialogData();

        add_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.open();
                if (arrayList.size() > 0) {
                    boolean isExist = dbAdapter.CheckIsDataAlreadyInDBorNot(Constants.FAV_NAME, Constants.Pagescount,
                            arrayList.get(currentpage).getId() - 1);
                    if (isExist) {
                        Toast.makeText(PlayActivity.this, getString(R.string.soraexists), Toast.LENGTH_SHORT).show();
                    } else {
                        dbAdapter.addFavourite(arrayList.get(currentpage).getId() - 1, arrayList.get(currentpage).getId(),
                                arrayList.get(currentpage).getSoundtrack(), arrayList.get(currentpage).getTafseerlink(),
                                arrayList.get(currentpage).getName(), arrayList.get(currentpage).getId() - 1,
                                arrayList.get(currentpage).getAyatCounter());
                    }
                    dbAdapter.close();
                    Toast.makeText(PlayActivity.this, getString(R.string.added), Toast.LENGTH_SHORT).show();
                }
            }
        });


        show_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAllFavourite();
            }
        });
    }

    private boolean isSoundChanged = true;
    String filepath;


    public void RetrieveTopDialogData() {
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        arrayList.clear();
        Cursor c = db.getSourNames();
        while (c.moveToNext()) {
            final All_Sour_Model.DataBean n = new All_Sour_Model.DataBean();
            n.setId(c.getInt(2));
            n.setAyatCounter(c.getInt(8));
            n.setName(c.getString(3));
            n.setPagesCounter(c.getInt(7));
            n.setSoraType(c.getInt(11));
            n.setSecond_lang(c.getString(12));
            n.setPartId(c.getInt(4));
            n.setSoundtrack(c.getString(5));
            n.setTafseerlink(c.getString(6));
            n.setFirstpage(c.getInt(13));
            arrayList.add(n);

        }

    }

    Dialog favDialog;

    public void showAllFavourite() {
        favDialog = new Dialog(this, R.style.MyDialog);
        favDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        favDialog.setContentView(R.layout.all_fav_dialog);
        favDialog.setCancelable(true);
        favDialog.show();

        ImageButton close = favDialog.findViewById(R.id.close_dialog);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favDialog.cancel();
            }
        });

        RecyclerView favlist = favDialog.findViewById(R.id.fav_list);
        favlist.setHasFixedSize(true);
        favlist.setLayoutManager(new LinearLayoutManager(this));
        Retrieve();
        favlist.setAdapter(new FavList_Adapter(this, favouriteModels));

    }

    private ArrayList<FavouriteModel> favouriteModels;

    public void Retrieve() {
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        favouriteModels.clear();
        Cursor c = db.getFavourite();
        while (c.moveToNext()) {
            FavouriteModel n = new FavouriteModel();
            n.setDatabaseid(c.getInt(0));
            n.setId(c.getInt(1));
            n.setIds(c.getInt(2));
            n.setName(c.getString(3));
            n.setTartib(c.getInt(4));
            n.setAyatcount(c.getInt(5));
            n.setTafseer(c.getString(6));
            n.setTelawoa(c.getString(7));

            favouriteModels.add(n);


        }
    }


    public void forwardSong() {
        if (tafseermp != null) {
            final int currentPosition = tafseermp.getCurrentPosition();
            if (currentPosition + 4000 <= tafseermp.getDuration()) {
                tafseer_seek.post(new Runnable() {
                    @Override
                    public void run() {
                        tafseermp.seekTo(currentPosition + 4000);
                        tafseer_seek.setProgress(currentPosition + 4000);
                    }
                });
            } else {
                tafseer_seek.setProgress(tafseermp.getDuration());
            }
        }
    }

    public void backwardSong() {
        if (tafseermp != null) {
            final int currentPosition = tafseermp.getCurrentPosition();
            if (currentPosition - 4000 >= 0) {
                tafseer_seek.post(new Runnable() {
                    @Override
                    public void run() {
                        tafseermp.seekTo(currentPosition - 4000);
                        tafseer_seek.setProgress(tafseermp.getCurrentPosition());
                    }
                });
            } else {
                tafseer_seek.setProgress(0);
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            if (isRegistered) {
                unregisterReceiver(receiver);
            }
            if (tafseer_timer != null) {
                tafseer_timer.cancel();
                tafseer_timer.purge();
                tafseer_timer = null;
            }
            if (tafseermp != null) {
                stopTafseerPlaying();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    private All_Sour_Model sewarModel;
    Call<All_Sour_Model> call;

    private void getData() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        call = apiService.getAllSour();
        call.enqueue(new Callback<All_Sour_Model>() {
            @Override
            public void onResponse(Call<All_Sour_Model> call, final Response<All_Sour_Model> response) {
                if (response.body() != null) {
                    sewarModel = response.body();
                   // arrayList = sewarModel.getData();
                    if (isClicked) {
                        showAllSourDialog();
                    }
                }
            }

            @Override
            public void onFailure(Call<All_Sour_Model> call, Throwable t) {
                ProgressDialogHelper.removeSimpleProgressDialog();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(PlayActivity.this, getString(R.string.connection_error),
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    Dialog dialog;

    private void showAllSourDialog() {

        dialog = new Dialog(this, R.style.MyDialog);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.all_sour_dialog);
        dialog.setCancelable(true);
        dialog.show();
        ImageButton back_btn = dialog.findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        RecyclerView recyclerView = dialog.findViewById(R.id.all_sour);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        All_Sour_Dialog_Adapter adapter = new All_Sour_Dialog_Adapter(this, arrayList);
        recyclerView.setAdapter(adapter);


    }


    private void pauseTafseerPlaying() {
        if (tafseermp != null) {
            if (tafseermp.isPlaying()) {
                tafseermp.pause();
            }
        }
    }

    private void resumeTafseerPlaying() {
        if (tafseermp != null) {
            tafseermp.start();
        }
        tafseer_seek.setEnabled(true);

    }

    private void stopTafseerPlaying() {
        if (tafseermp != null) {
            tafseermp.release();
            tafseermp = null;
        }
        tafseer_seek.setEnabled(false);
        tafseer_seek.setProgress(0);
        isTafseerPLAYING = false;
        isTafseerLoaded = false;
        // play_tafseer.setVisibility(View.VISIBLE);
        newplay.setBackgroundResource(R.drawable.playgold);
        progressa.setVisibility(View.GONE);
        tafseertime.setText(getCurrentTime(total_tafseerduration));
    }



    public void PLAYTafseer(String soundurl) {
            if (!isTafseerLoaded) {
                tafseermp = new MediaPlayer();
                tafseer_seek.setEnabled(true);
                try {
                    tafseermp.setDataSource(soundurl);
                    tafseermp.prepareAsync();
                    tafseermp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(final MediaPlayer mp) {
                            isTafseerLoaded = true;
                            isTafseerPLAYING = true;
                            tafseermp.start();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressa.setVisibility(View.GONE);
                                    newplay.setVisibility(View.VISIBLE);
                                    tafseertime.setText("0:00");
                                    tafseer_seek.setMax(mp.getDuration());
                                    total_tafseerduration = mp.getDuration();
                                    // tafseer_total.setText(getCurrentTime(mp.getDuration()));
                                }
                            });

                            tafseer_duration = tafseermp.getDuration();
                            tafseer_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

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
                            if (mps != null) {
                                mps.pause();
                                isPLAYING = false;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        newplay.setVisibility(View.VISIBLE);
                                        progressa.setVisibility(View.GONE);
                                        newplay.setBackgroundResource(R.drawable.playgold);
                                    }
                                });
                            }
                            if (tafseer_timer == null) {
                                tafseer_timer = new Timer();
                                tafseer_timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        if (isTafseerPLAYING) {
                                            try {
                                                tafseer_duration = tafseermp.getCurrentPosition();
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        if (!isforward) {
                                                            if (tafseermp.isPlaying()) {
                                                                tafseertime.setText(getCurrentTime(tafseer_duration));
                                                                tafseer_seek.setProgress(tafseermp.getCurrentPosition());

                                                            } else if (!tafseerpause) {
                                                                tafseertime.setText("0:00");
                                                                if (tafseer_timer != null) {
                                                                    tafseer_timer.cancel();
                                                                    tafseer_timer.purge();
                                                                    tafseer_timer = null;
                                                                }
                                                                tafseer_seek.setProgress(0);
                                                                newplay.setBackgroundResource(R.drawable.playgold);
                                                                tafseer_seek.setEnabled(false);
                                                            }
                                                        }
                                                    }
                                                });
                                            } catch (IllegalStateException e) {
                                                e.printStackTrace();
                                            }

                                        }
                                    }
                                }, 1000, 1000);
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    newplay.setVisibility(View.VISIBLE);
                                    newplay.setEnabled(true);
                                    newplay.setBackgroundResource(R.drawable.pausse);
                                }
                            });

                        }
                    });

                } catch (IOException e) {
                    Toast.makeText(this, "فشل تحميل الملف الصوتي", Toast.LENGTH_SHORT).show();
                    isPLAYING = false;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            play_tafseer.setVisibility(View.VISIBLE);
                            progressa.setVisibility(View.GONE);
                            play_tafseer.setBackgroundResource(R.drawable.playgold);
                        }
                    });
                }
            } else {
                if (!isTafseerPLAYING) {
                    isTafseerPLAYING = true;
                    resumeTafseerPlaying();
                    newplay.setVisibility(View.VISIBLE);
                    progressa.setVisibility(View.GONE);
                    newplay.setBackgroundResource(R.drawable.pausse);
                } else {
                    isTafseerPLAYING = false;
                    pauseTafseerPlaying();
                    newplay.setVisibility(View.VISIBLE);
                    progressa.setVisibility(View.GONE);
                    newplay.setBackgroundResource(R.drawable.playgold);
                }
            }

    }


    public String getCurrentTime(long different) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentdate = "";


        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        long monthesInMilli = daysInMilli * 30;
        long yearInMilli = monthesInMilli * 12;

        different = different % yearInMilli;

        different = different % monthesInMilli;

        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;


        if (elapsedHours >= 1) {
            if (elapsedMinutes < 10) {
                if (elapsedSeconds < 10) {
                    currentdate = elapsedHours + " : 0" + elapsedMinutes + " : 0" + elapsedSeconds;
                } else {
                    currentdate = elapsedHours + " : 0" + elapsedMinutes + " : " + elapsedSeconds;
                }
            } else {
                if (elapsedSeconds < 10) {
                    currentdate = elapsedHours + " : " + elapsedMinutes + ": 0" + elapsedSeconds;
                } else {
                    currentdate = elapsedHours + " : " + elapsedMinutes + " : " + elapsedSeconds;
                }
            }
        } else {
            if (elapsedSeconds < 10) {
                currentdate = elapsedMinutes + " : 0" + elapsedSeconds;
            } else {
                currentdate = elapsedMinutes + " : " + elapsedSeconds;
            }
        }

        return currentdate;

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (receiver == null) {
            receiver = new Receiver();
            IntentFilter filter = new IntentFilter(BroadcastHelper.ACTION_NAME);
            registerReceiver(receiver, filter);
            isRegistered = true;
        }
    }

    Receiver receiver;
    private boolean isRegistered = false;

    private class Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context arg0, final Intent arg1) {
            String methodName = arg1.getStringExtra(BroadcastHelper.BROADCAST_EXTRA_METHOD_NAME);
            if (methodName != null && methodName.length() > 0) {
                Log.v("receive", methodName);
                switch (methodName) {
                    case "plays":
                        stopTafseerPlaying();
                        isTafseerLoaded = false;
                        isSoundChanged = true;
                        if (dialog != null) {
                            dialog.cancel();
                        }
                        currentpage = arg1.getIntExtra("pos", 0);
                        final String name = arg1.getStringExtra("nam");
                        tafseer_link = arg1.getStringExtra("tf");
                        File file = null;
                        if (helper.getLanguageID() == 0){
                             file = new File(filepath + name + "t.mp3");
                            if (file.exists()) {
                                stopTafseerPlaying();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        sora_name.setText(arg1.getStringExtra("nam"));
                                        ayatcount.setText(String.valueOf(arg1.getIntExtra("ayatcount", 0)));
                                        sora_tartib.setText(String.valueOf(arg1.getIntExtra("tartib", 0)));
                                        progressa.setVisibility(View.VISIBLE);
                                        newplay.setVisibility(View.GONE);
                                        PLAYTafseer(filepath + name + "t.mp3");
                                    }
                                });
                                play_lin.animate()
                                        .translationY(play_lin.getHeight())
                                        .alpha(0.0f)
                                        .setDuration(600)
                                        .setListener(new AnimatorListenerAdapter() {
                                            @Override
                                            public void onAnimationEnd(Animator animation) {
                                                super.onAnimationEnd(animation);
                                                play_lin.setVisibility(View.GONE);
                                            }
                                        });
                            } else {
                                if (dialog != null) {
                                    dialog.cancel();
                                }
                                if (ConnectivityReceiver.isConnected()) {
                                    play_lin.animate()
                                            .translationY(0)
                                            .alpha(1.0f)
                                            .setDuration(600)
                                            .setListener(new AnimatorListenerAdapter() {
                                                @Override
                                                public void onAnimationEnd(Animator animation) {
                                                    super.onAnimationEnd(animation);
                                                    play_lin.setVisibility(View.VISIBLE);
                                                }
                                            });
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            sora_name.setText(arg1.getStringExtra("nam"));
                                            ayatcount.setText(String.valueOf(arg1.getIntExtra("ayatcount", 0)));
                                            sora_tartib.setText(String.valueOf(arg1.getIntExtra("tartib", 0)));
                                        }
                                    });
                                } else {
                                    Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                                }
                            }
                        } else {
                             file = new File(filepath + name + "ts.mp3");
                            if (file.exists()) {
                                stopTafseerPlaying();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        play_lin.animate()
                                                .translationY(play_lin.getHeight())
                                                .alpha(0.0f)
                                                .setDuration(600)
                                                .setListener(new AnimatorListenerAdapter() {
                                                    @Override
                                                    public void onAnimationEnd(Animator animation) {
                                                        super.onAnimationEnd(animation);
                                                        play_lin.setVisibility(View.GONE);
                                                    }
                                                });
                                        sora_name.setText(arg1.getStringExtra("nam"));
                                        ayatcount.setText(String.valueOf(arg1.getIntExtra("ayatcount", 0)));
                                        sora_tartib.setText(String.valueOf(arg1.getIntExtra("tartib", 0)));
                                        progressa.setVisibility(View.VISIBLE);
                                        newplay.setVisibility(View.GONE);
                                        PLAYTafseer(filepath + name + "ts.mp3");
                                    }
                                });

                            } else {
                                if (dialog != null) {
                                    dialog.cancel();
                                }
                                if (ConnectivityReceiver.isConnected()) {

                                    play_lin.animate()
                                            .translationY(0)
                                            .alpha(1.0f)
                                            .setDuration(600)
                                            .setListener(new AnimatorListenerAdapter() {
                                                @Override
                                                public void onAnimationEnd(Animator animation) {
                                                    super.onAnimationEnd(animation);
                                                    play_lin.setVisibility(View.VISIBLE);
                                                }
                                            });
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            sora_name.setText(arg1.getStringExtra("nam"));
                                            ayatcount.setText(String.valueOf(arg1.getIntExtra("ayatcount", 0)));
                                            sora_tartib.setText(String.valueOf(arg1.getIntExtra("tartib", 0)));
                                        }
                                    });
                                }
                                else {
                                    play_lin.animate()
                                            .translationY(play_lin.getHeight())
                                            .alpha(0.0f)
                                            .setDuration(600)
                                            .setListener(new AnimatorListenerAdapter() {
                                                @Override
                                                public void onAnimationEnd(Animator animation) {
                                                    super.onAnimationEnd(animation);
                                                    play_lin.setVisibility(View.GONE);
                                                }
                                            });
                                    Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }


                        break;
                    case "playfav":
                        stopTafseerPlaying();
                        isSoundChanged = true;
                        isTafseerLoaded = false;
                        if (favDialog != null) {
                            favDialog.cancel();
                        }
                        currentpage = arg1.getIntExtra("pos", 0);
                        tafseer_link = arg1.getStringExtra("tafseer_link");
                        final String names = arg1.getStringExtra("name");
                        File files = null;
                        if (helper.getLanguageID() == 0){
                             files = new File(filepath + "/" + names + "t.mp3");

                        } else {
                             files = new File(filepath + "/" + names + "ts.mp3");

                        }
                        if (!files.exists()) {
                            stopTafseerPlaying();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sora_name.setText(arg1.getStringExtra("name"));
                                    ayatcount.setText(String.valueOf(arg1.getIntExtra("ayatcount", 0)));
                                    sora_tartib.setText(String.valueOf(arg1.getIntExtra("tartib", 0)));
                                    progressa.setVisibility(View.VISIBLE);
                                    newplay.setVisibility(View.GONE);

                                    if (ConnectivityReceiver.isConnected()) {
                                     //   PLAYTafseer(tafseer_link);
                                        play_lin.animate()
                                                .translationY(0)
                                                .alpha(1.0f)
                                                .setDuration(600)
                                                .setListener(new AnimatorListenerAdapter() {
                                                    @Override
                                                    public void onAnimationEnd(Animator animation) {
                                                        super.onAnimationEnd(animation);
                                                        play_lin.setVisibility(View.VISIBLE);
                                                    }
                                                });
                                    } else {
                                        Toast.makeText(PlayActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            if (favDialog != null) {
                                favDialog.cancel();
                            }
//                            play_lin.animate()
//                                    .translationY(0)
//                                    .alpha(1.0f)
//                                    .setDuration(600)
//                                    .setListener(new AnimatorListenerAdapter() {
//                                        @Override
//                                        public void onAnimationEnd(Animator animation) {
//                                            super.onAnimationEnd(animation);
//                                            play_lin.setVisibility(View.VISIBLE);
//                                        }
//                                    });

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sora_name.setText(arg1.getStringExtra("name"));
                                    ayatcount.setText(String.valueOf(arg1.getIntExtra("ayatcount", 0)));
                                    sora_tartib.setText(String.valueOf(arg1.getIntExtra("tartib", 0)));
                                   if (helper.getLanguageID() == 0) {
                                       PLAYTafseer(filepath + arg1.getStringExtra("name") + "t.mp3");
                                   } else {
                                       PLAYTafseer(filepath + arg1.getStringExtra("name") + "ts.mp3");
                                   }
                                }
                            });
                        }


                        break;
                    default:
                        break;

                }
            }
        }
    }


}
