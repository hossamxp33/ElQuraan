package com.codesroots.elquraan;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.codesroots.elquraan.Adapter.CustomPagerAdapter;
import com.codesroots.elquraan.Adapter.TopDialog_Adapter;
import com.codesroots.elquraan.Helpers.ApiClient;
import com.codesroots.elquraan.Helpers.ApiInterface;
import com.codesroots.elquraan.Helpers.BroadcastHelper;
import com.codesroots.elquraan.Helpers.Cache;
import com.codesroots.elquraan.Helpers.ConnectivityReceiver;
import com.codesroots.elquraan.Helpers.DownloadTask;
import com.codesroots.elquraan.Helpers.PreferenceHelper;
import com.codesroots.elquraan.Helpers.ProgressDialogHelper;
import com.codesroots.elquraan.Helpers.rtlVIEWPAGER;
import com.codesroots.elquraan.Models.All_Sour_Model;
import com.codesroots.elquraan.Models.CircleImageView;
import com.codesroots.elquraan.Models.QuranModel;
import com.codesroots.elquraan.Models.SewarModel;
import com.codesroots.elquraan.Models.SewarModelView;
import com.codesroots.elquraan.db.DBAdapter;
import com.codesroots.elquraan.db.DBHelper;
import com.crashlytics.android.Crashlytics;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.tuyenmonkey.mkloader.MKLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    DBAdapter dbAdapter;
    DBHelper dbHelper;
    rtlVIEWPAGER mViewPager;
    private CustomPagerAdapter adapter;
    private ImageView play_tafseer, stop_tafseer;
    SeekBar tafseer_seek;
    RelativeLayout toolbar;
    MKLoader progressa;
    TextView tafseertime, tafseer_total, play_title;
    Timer tafseer_timer;
    private TextView listen, download;
    RelativeLayout tafseer_relative;
    CircleImageView switch_sound;
    ArrayList<SewarModelView.DataBean> arrayList, nextArray;
    private int currentpage = 0;
    ImageView speed_find;
    SnapHelper snapHelper;
    PreferenceHelper helper;
    String filepath;
    ImageView gotofasel,menuq;
    LinearLayout play_lin,playcontainer;
    String currentSoundLink="";//current voice link
   public static  int souraposition = 2; //////////default soura id

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        askFormPermissions();
        setContentView(R.layout.activity_main);
        initialize();
        mViewPager = findViewById(R.id.full_pager);

        if (dbAdapter.CheckIsSorainfoAleadyExists(0))
            getofflinedata(0);
        else
            getData(0);


        ///////////menu to show all swar in the right side
        menuq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showAboutDialog();
            }
        });

        tafseer_seek.getThumb().setColorFilter(ContextCompat.getColor(this, R.color.yel)
                ,PorterDuff.Mode.SRC_ATOP);

        dataBeanArrayList = new ArrayList<>();
        File direct = new File(Environment.getExternalStorageDirectory() + "/OtherTafaseer");
        filepath = Environment.getExternalStoragePublicDirectory(String.valueOf(direct)) + "/";
        speed_find = findViewById(R.id.speed_find);
        speed_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (helper.IsDownloaded()) {
                    RetrieveTopDialogData();
                } else {
                    getDatas();
                }
            }
        });

        tafseer_seek.getProgressDrawable().setColorFilter(ContextCompat.getColor(this,R.color.light_gray),
                PorterDuff.Mode.SRC_ATOP);
        tafseer_seek.setEnabled(false);
        play_tafseer = findViewById(R.id.play_tafseer);
        stop_tafseer = findViewById(R.id.stop_tafseer);
        listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File file = new File(filepath + "/" + dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getName() + "telawa");
                if (file.exists()) {
                    play_tafseer.setVisibility(View.VISIBLE);
                    progressa.setVisibility(View.VISIBLE);
                    tafseer_relative.setVisibility(View.GONE);
                    play_tafseer.setBackgroundResource(R.drawable.playgold);
                    PLAYTafseer(filepath + "/" + dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getName() + "telawa");
                  }

                else
                    {
                    progressa.setVisibility(View.VISIBLE);
                    play_tafseer.setVisibility(View.GONE);

                    if (ConnectivityReceiver.isConnected())
                    {
                        if (dataBeanArrayList3.size()>0)
                          PLAYTafseer(dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getSoundtrack());
                    }

                    else
                        {
            Toast.makeText(MainActivity.this, getString(R.string.filenotdownloaded), Toast.LENGTH_SHORT).show();
                         }
                }
                play_lin.setVisibility(View.GONE);
            }
        });

        /////////action for download sound
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask downloadTask;
                if (dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getSoundtrack().contains("http"))
                    downloadTask = new DownloadTask(MainActivity.this,dataBeanArrayList3.get
                            (mViewPager.getCurrentItem()).getTafaseer().getSoundtrack(),
                            dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getName() + "telawa");
                play_lin.setVisibility(View.GONE);
            }
        });

        //////////////action for play sound
        tafseer_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dataBeanArrayList3.size() > 0) {

                    currentSoundLink = dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getName();
                    File file = new File(filepath + "/" + dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getName() + "telawa" + ".mp3");
                    if (file.exists()) {
                        progressa.setVisibility(View.VISIBLE);
                        play_tafseer.setVisibility(View.GONE);
                        if (dataBeanArrayList3.size() > 0) {
                            if (currentpage <= dataBeanArrayList3.size())
                                PLAYTafseer(filepath + "/" + dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getName() + "telawa" + ".mp3");
                        }
                    }

                    else
                        {
                       if (tafseermp==null)
                        play_lin.setVisibility(View.VISIBLE);
                            else
                            {
                            if (currentpage <= dataBeanArrayList3.size())
                                if (ConnectivityReceiver.isConnected()) {
                                    PLAYTafseer( dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getSoundtrack());
                                }
                                else {
                                 Toast.makeText(MainActivity.this, getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
                                }
                           }
                    }
                }
            }
        });


        switch_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dataBeanArrayList2.size() > 0) {
                    Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                    if (helper.getLanguageID() == 0) {
                        intent.putExtra("tafseer_link", dataBeanArrayList2.get(0).getTafaseer()
                                .getTafseerlink());
                    }
                    else {
                        intent.putExtra("tafseer_link", dataBeanArrayList2.get(0).getTafaseer()
                                .getSecond_lang());
                    }

                    intent.putExtra("name", dataBeanArrayList2.get(0)
                            .getTafaseer().getName());

                    intent.putExtra("ayatcount", dataBeanArrayList2.get(0)
                            .getTafaseer().getAyat_counter());

                    intent.putExtra("tartib",souraposition-1 );


                    startActivity(intent);
                    stopTafseerPlaying();
                }
            }
        });

        stop_tafseer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTafseerPlaying();
            }
        });


        arrayList = new ArrayList<>();
        snapHelper = new PagerSnapHelper();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position != 0) {

                    if (position % 9 == 0 || position == arrayList.size()) {
                        BroadcastHelper.sendInform(MainActivity.this, "next");
                    }
                }


                String dd=dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getName().trim();
                if (!(dataBeanArrayList3.get(mViewPager.getCurrentItem()).getTafaseer().getName().trim()).matches(currentSoundLink.trim()))
                 stopTafseerPlaying();

                currentpage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        if (helper.getIsAllDataSet()) {
//            Retrieve();
//        } else {
//            if (!helper.IsDownloaded()) {
//                getDatas();
//            }
//
//            DBAdapter db = new DBAdapter(this);
//            db.openDB();
//            Cursor c = db.getSourImages();
//            currentposition = currentpage;
//            savedPagesCount = c.getCount();
//            if (!c.isClosed()){
//                c.close();
//            }
//            db.close();
//            if (savedPagesCount >= 662){
//                Retrieve();
//            }
//            else
//                {
//                if (savedPagesCount == 0) {
//                    db.open();
//                    retrievedata(0);
//                } else {
//                    //getNexttData(savedPagesCount - 1);
//                }
//            }
//        }

         gotofasel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFaselDialog();
            }
        });
    }

    private void initialize() {

        dbHelper = new DBHelper(this);
        dbAdapter = new DBAdapter(this);
        toolbar = findViewById(R.id.toolbar);
        helper = new PreferenceHelper(this);
        tafseertime = findViewById(R.id.tafseer_time);
        switch_sound = findViewById(R.id.switch_sound);
        tafseer_relative = findViewById(R.id.tafseer_relative);
        progressa = findViewById(R.id.progressa);
        nextArray = new ArrayList<>();
        gotofasel = findViewById(R.id.ds);
        tafseer_total = findViewById(R.id.tafseer_total);
        play_title = findViewById(R.id.play_title);
        tafseer_seek = findViewById(R.id.tafseer_seek);
        menuq = findViewById(R.id.menuq);
        listen = findViewById(R.id.listen);
        play_lin = findViewById(R.id.lisen_lin);
        playcontainer = findViewById(R.id.play_lin);
        download = findViewById(R.id.download);
    }

//    private void retrievedata(int index)
//    {
//        if (play_lin.getVisibility()==View.VISIBLE)
//            play_lin.setVisibility(View.GONE);
//
//        if (dbAdapter.CheckIsSorainfoAleadyExists(souraposition))
//            getofflinedata(index);
//        else
//            getData(index);
//    }

    private void askFormPermissions() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.WAKE_LOCK},
                        8);
            }
        }
    }


    private int count = 0, page = 1, ia = 1, countnext = 0;
    Timer timer, nexttimer;

    private QuranModel sewarModel;
    Call<QuranModel> call;
    private void getData(final int index) {

        dataBeanArrayList2.clear();
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        call = apiService.getAllQuran();
        call.enqueue(new Callback<QuranModel>() {
            @Override
            public void onResponse(Call<QuranModel> call, final Response<QuranModel> response) {
                if (response.body() != null) {
                    dataBeanArrayList3=response.body().getQuraan();
                    for (int i=0;i<response.body().getQuraan().size();i++)
                    {
                        insertSorainfo(0,
                                response.body().getQuraan().get(i).getId()
                                ,response.body().getQuraan().get(i).getPage_image()
                                ,0
                                ,response.body().getQuraan().get(i).getQuraan_page()
                                ,response.body().getQuraan().get(i).getTafaseer().getSoundtrack()
                                ,response.body().getQuraan().get(i).getTafaseer().getTafseerlink()
                                ,response.body().getQuraan().get(i).getTafaseer().getSecond_lang()
                                ,response.body().getQuraan().get(i).getTafaseer().getName()
                                ,response.body().getQuraan().get(i).getTafaseer().getAyat_counter()
                        );
                    }

                   adapter = new CustomPagerAdapter(MainActivity.this,response.body().getQuraan());
                    mViewPager.setAdapter(adapter);
                    mViewPager.setCurrentItem(index);
                }
            }

            @Override
            public void onFailure(Call<QuranModel> call, Throwable t) {
                ProgressDialogHelper.removeSimpleProgressDialog();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,
                                getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }


//    private void getData(final int index) {
//
//        dataBeanArrayList2.clear();
//        ApiInterface apiService =
//                ApiClient.getClient().create(ApiInterface.class);
//        call = apiService.getSewar(souraposition);
//        call.enqueue(new Callback<SewarModel>() {
//            @Override
//            public void onResponse(Call<SewarModel> call, final Response<SewarModel> response) {
//                if (response.body() != null) {
//                    sewarModel = response.body();
//                    for (int i=0;i<sewarModel.getData().size();i++)
//                    {
//                        insertSorainfo(souraposition,
//                                 sewarModel.getData().get(i).getId()
//                                ,sewarModel.getData().get(i).getPage_image()
//                                ,sewarModel.getData().get(i).getPage_number()
//                                ,sewarModel.getData().get(i).getPart_id()
//                                ,sewarModel.getData().get(i).getTafaseer().getSoundtrack()
//                                ,sewarModel.getData().get(i).getTafaseer().getTafseerlink()
//                                ,sewarModel.getData().get(i).getTafaseer().getSecond_lang()
//                                ,sewarModel.getData().get(i).getTafaseer().getName()
//                                ,sewarModel.getData().get(i).getTafaseer().getAyat_counter()
//                        );
//                    }
//
//                    dataBeanArrayList2=sewarModel.getData();
//                    adapter = new CustomPagerAdapter(MainActivity.this,dataBeanArrayList2);
//                    mViewPager.setAdapter(adapter);
//                    mViewPager.setCurrentItem(index);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SewarModel> call, Throwable t) {
//                ProgressDialogHelper.removeSimpleProgressDialog();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(MainActivity.this,
//                                getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            }
//        });
//    }


    public void insertSorainfo(int Souraid,int imageid, String img, int partid,  int quranpage,
                               String soundpath,String tafserpath,String secondlang,String souraname,int ayatcounter) {
        dbAdapter.open();
        dbAdapter.addSouraParts(Souraid,imageid, img, partid, quranpage,soundpath,tafserpath,secondlang,souraname,ayatcounter);
        dbAdapter.close();
    }

    Dialog findDialog;

    public void showFaselDialog() {

        findDialog = new Dialog(this, R.style.MyDialog);
        findDialog.getWindow().setBackgroundDrawable(
        new ColorDrawable(android.graphics.Color.TRANSPARENT));
        findDialog.setContentView(R.layout.speed_find);
        findDialog.setCancelable(true);
        findDialog.show();
        final TextView go = findDialog.findViewById(R.id.go);

        ImageButton close = findDialog.findViewById(R.id.close_dialog);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findDialog.cancel();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (mViewPager != null) {
                        souraposition=helper.getSavedSoraid();
                        int index=helper.getSavedPage();
                      //  retrievedata(index);
                    }
                findDialog.cancel();
            }
        });
    }

    Dialog down_dialog,progressdialog;

    public void showAllSourDownloadDialog() {
        down_dialog = new Dialog(this, R.style.MyDialog);
        down_dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        down_dialog.setContentView(R.layout.download_dialog);
        down_dialog.setCancelable(true);
        down_dialog.show();

        RecyclerView recyclerView = down_dialog.findViewById(R.id.download_dialog_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TopDialog_Adapter(this, dataBeanArrayList));
    }
    Dialog aboutDialog;
    public void showAboutDialog() {
        aboutDialog = new Dialog(this, R.style.MyDialog);
        aboutDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        aboutDialog.setContentView(R.layout.menu_layout);
        aboutDialog.setCancelable(false);
        aboutDialog.show();
        RelativeLayout aboutapp = aboutDialog.findViewById(R.id.about_app);
        RelativeLayout aboutsheikh = aboutDialog.findViewById(R.id.about_sheikh);
        RelativeLayout finish_quraan = aboutDialog.findViewById(R.id.finish_quraan);
        RelativeLayout shareapp = aboutDialog.findViewById(R.id.share_app);
        ImageView close = aboutDialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutDialog.cancel();
            }
        });
        aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutApp.class);
                startActivity(intent);
            }
        });

        aboutsheikh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutSheikh.class);
                startActivity(intent);
            }
        });
        finish_quraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Finish_Quraan.class);
                startActivity(intent);
            }
        });

        shareapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Sharing Quran Application");
                i.putExtra(Intent.EXTRA_TEXT, "http://www.google.com");
                startActivity(Intent.createChooser(i, "Share URL"));
            }
        });

    }

    private All_Sour_Model sewarModels;
    Call<All_Sour_Model> calls;
    ArrayList<All_Sour_Model.DataBean> dataBeanArrayList;
    ArrayList<SewarModel.DataBean> dataBeanArrayList2=new ArrayList<>();
    List<QuranModel.QuraanBean> dataBeanArrayList3=new ArrayList<>();

    private void getDatas() {
        dataBeanArrayList.clear();
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        calls = apiService.getAllSour();
        calls.enqueue(new Callback<All_Sour_Model>() {
            @Override
            public void onResponse(Call<All_Sour_Model> call, final Response<All_Sour_Model> response) {
                if (response.body() != null) {
                    sewarModels = response.body();
                    dataBeanArrayList = sewarModels.getData();
                    for (int i = 0; i < dataBeanArrayList.size(); i++) {
                        dbAdapter.open();
                        dbAdapter.addSouraName(dataBeanArrayList.get(i).getName(), dataBeanArrayList.get(i).getId(),
                                 dataBeanArrayList.get(i).getId() - 1, dataBeanArrayList.get(i).getPartId(),
                                dataBeanArrayList.get(i).getSoundtrack(), dataBeanArrayList.get(i).getTafseerlink(),
                                dataBeanArrayList.get(i).getPagesCounter(), 0, 0,
                                dataBeanArrayList.get(i).getAyatCounter(),
                                dataBeanArrayList.get(i).getSoraType(),
                                dataBeanArrayList.get(i).getSecond_lang(),dataBeanArrayList.get(i).getFirstpage());
                        dbAdapter.close();
                    }


                   helper.setIsDownloaded(true);
                }
            }

            @Override
            public void onFailure(Call<All_Sour_Model> call, Throwable t) {
                ProgressDialogHelper.removeSimpleProgressDialog();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, getString(R.string.connection_error),
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if (outputStream != null ) {
            if (bitmap != null)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream);
            return outputStream.toByteArray();
        } else {
            return new ByteArrayOutputStream().toByteArray();
        }
    }

    int savedPagesCount = 0, pagesCount = 0, currentposition = 0;
    private boolean isFirstRetrieve = false;

    public void Retrieve() {

        isFirstRetrieve = true;
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        Cursor c = db.getSourImages(1);
        currentposition = currentpage;
        savedPagesCount = c.getCount();
        while (c.moveToNext()) {
                 final SewarModelView.DataBean n = new SewarModelView.DataBean();
                n.setId(c.getInt(1));
                byte[] imgByte = c.getBlob(6);
                n.setSoraId(c.getInt(2));
                Cache.getInstance().getLru().put(c.getInt(2), imgByte);
                byte[] bitmapd = (byte[])Cache.getInstance().getLru().get(c.getInt(2));
                Bitmap bitmap = BitmapFactory.decodeByteArray(imgByte, 0, bitmapd.length);
                n.setPageImage(bitmap);

                n.setPageNumber(c.getInt(4));
                n.setSora(new SewarModelView.DataBean.SoraBean());
                n.getSora().setTafseerlink(c.getString(7));
                n.getSora().setSoundtrack(c.getString(8));
                n.getSora().setIds(c.getInt(3));
                n.getSora().setName(c.getString(9));
                n.getSora().setSecond_lang(c.getString(10));
                n.getSora().setId(c.getInt(3));
                arrayList.add(n);
                pagesCount = pagesCount + 1;
                if (pagesCount == 1) {
                    break;
                }
        //    }
        }
        adapter.notifyDataSetChanged();

    }

    public void getofflinedata(int index)
    {
        dataBeanArrayList3.clear();
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        Cursor c = db.getSourInfo(souraposition);
        while (c.moveToNext()) {
            final QuranModel.QuraanBean  n =new  QuranModel.QuraanBean();
            final QuranModel.QuraanBean.TafaseerBean  ts = new QuranModel.QuraanBean.TafaseerBean();
            n.setId(c.getInt(2));
            n.setPage_image(c.getString(3));
            n.setPart_id(c.getInt(4));
            n.setQuraan_page(c.getInt(5));
            ts.setSoundtrack(c.getString(6));
            ts.setTafseerlink(c.getString(7));
            ts.setSecond_lang(c.getString(8));
            ts.setName(c.getString(9));
            ts.setAyat_counter(c.getInt(10));
            n.setTafaseer(ts);
            dataBeanArrayList3.add(n);
        }

        adapter = new CustomPagerAdapter(MainActivity.this, dataBeanArrayList3);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(index);
    }

    public void RetrieveTopDialogData() {

        DBAdapter db = new DBAdapter(this);
        db.openDB();
        dataBeanArrayList.clear();
        Cursor c = db.getSourNames();
         while (c.moveToNext()) {
            final All_Sour_Model.DataBean n = new All_Sour_Model.DataBean();
            n.setId(c.getInt(1));
            n.setAyatCounter(c.getInt(8));
            n.setName(c.getString(3));
            n.setPagesCounter(c.getInt(7));
            n.setPagesCounter(c.getInt(7));
            n.setSoraType(c.getInt(11));
            n.setPartId(c.getInt(4));
            n.setSoundtrack(c.getString(5));
            n.setTafseerlink(c.getString(6));
            n.setSecond_lang(c.getString(12));
            n.setFirstpage(c.getInt(13));
            dataBeanArrayList.add(n);
        }

        showAllSourDownloadDialog();
    }

    public void RetrieveNext() {
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        Cursor c = (Cursor) Cache.getInstance().getLru().get("data");
        currentposition = currentpage;
        savedPagesCount = c.getCount();
     //   for (int i=0;i<nextArray.size())


        while (c.moveToNext()) {
            if (c.moveToPosition(pagesCount)) {
                final SewarModelView.DataBean n = new SewarModelView.DataBean();
                n.setId(c.getInt(1));
                byte[] imgByte = c.getBlob(6);
                Cache.getInstance().getLru().put(c.getInt(2), imgByte);
                byte[] bitmapd = (byte[])Cache.getInstance().getLru().get(c.getInt(2));

                Bitmap bitmap = BitmapFactory.decodeByteArray(imgByte, 0, bitmapd.length);


                n.setPageImage(bitmap);
                 n.setPageNumber(c.getInt(4));
                n.setSoraId(c.getInt(2));
                n.setSora(new SewarModelView.DataBean.SoraBean());
                n.getSora().setTafseerlink(c.getString(7));
                n.getSora().setSoundtrack(c.getString(8));
                n.getSora().setIds(c.getInt(3));
                n.getSora().setName(c.getString(9));
                n.getSora().setSecond_lang(c.getString(10));
                n.getSora().setId(c.getInt(3));
                arrayList.add(n);
                pagesCount = pagesCount + 1;
                if (pagesCount % 10 == 0) {
                    page = pagesCount / 10;
                    break;
                }
            }
        }

        adapter.notifyDataSetChanged();

    }

    private int total_telawoduration = 0, total_tafseerduration = 0;
    private MediaPlayer mps, tafseermp;
    boolean isPLAYING = false, isLoaded = false;
    boolean isTafseerPLAYING = false, isTafseerLoaded = false;
    int telawoa_duration = 0, tafseer_duration = 0;


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

    public void PLAYTafseer(String soundurl) {

        if (!isTafseerLoaded) {
            //   precision.applyPattern("0 : 00");
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
                                play_tafseer.setVisibility(View.VISIBLE);
                                tafseertime.setText("0:00");
                                tafseer_seek.setMax(mp.getDuration());
                                total_tafseerduration = mp.getDuration();
                                tafseer_total.setText(getCurrentTime(mp.getDuration()));
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
                                    play_tafseer.setVisibility(View.VISIBLE);
                                    progressa.setVisibility(View.GONE);
                                    play_tafseer.setBackgroundResource(R.drawable.playgold);
                                }
                            });
                        }
                        if (tafseer_timer == null) {
                            tafseer_timer = new Timer();
                            tafseer_timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    if (isTafseerPLAYING) {
                                        if (tafseermp!=null)
                                          tafseer_duration = tafseermp.getCurrentPosition();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (tafseermp != null)
                                                if (tafseermp.isPlaying()) {
                                                    tafseertime.setText(getCurrentTime(tafseer_duration));
                                                    tafseer_seek.setProgress(tafseermp.getCurrentPosition());

                                                } else if (!tafseerpause) {
                                                    tafseertime.setText("0:00");
                                                    tafseer_timer.cancel();
                                                    tafseer_timer.purge();
                                                    tafseer_timer = null;
                                                    tafseer_seek.setProgress(0);
                                                    play_tafseer.setBackgroundResource(R.drawable.playgold);
                                                    tafseer_seek.setEnabled(false);
                                                }
                                            }
                                        });
                                    }
                                }
                            }, 1000, 1000);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                play_tafseer.setVisibility(View.VISIBLE);
                                play_tafseer.setEnabled(true);
                                play_tafseer.setBackgroundResource(R.drawable.pausse);
                            }
                        });

                    }
                });

            }
            catch (IOException e) {
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
        }

        else {
            if (!isTafseerPLAYING) {
                isTafseerPLAYING = true;
                resumeTafseerPlaying();
                play_tafseer.setVisibility(View.VISIBLE);
                progressa.setVisibility(View.GONE);
                play_tafseer.setBackgroundResource(R.drawable.pausse);
            } else {
                isTafseerPLAYING = false;
                pauseTafseerPlaying();
                play_tafseer.setVisibility(View.VISIBLE);
                progressa.setVisibility(View.GONE);
                play_tafseer.setBackgroundResource(R.drawable.playgold);
            }
        }
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
        play_tafseer.setVisibility(View.VISIBLE);
        play_tafseer.setBackgroundResource(R.drawable.playgold);
        progressa.setVisibility(View.GONE);
        //tafseertime.setText(getCurrentTime(total_tafseerduration));
        tafseertime.setText("0 : 00");
        tafseer_total.setText("0 : 00");
    }

    private void stopTelawoaPlaying() {
        if (mps != null) {
            mps.release();
            mps = null;
        }
        isLoaded = false;
        isPLAYING = false;
        play_tafseer.setVisibility(View.VISIBLE);
        play_tafseer.setBackgroundResource(R.drawable.playbtn);
        progressa.setVisibility(View.GONE);
        tafseertime.setText(getCurrentTime(total_telawoduration));
    }

    boolean tafseerpause = false;

    @Override
    protected void onResume() {
        super.onResume();
        if (receiver == null) {
            receiver = new Receiver();
            IntentFilter filter = new IntentFilter(BroadcastHelper.ACTION_NAME);
            registerReceiver(receiver, filter);
            isRegistered = true;
        }
       souraposition = helper.getLastsorascrool();
        //retrievedata(helper.getLastpagescrool());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (isRegistered) {
                unregisterReceiver(receiver);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        stopTelawoaPlaying();
        stopTafseerPlaying();
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
                    case "show":
                        toolbar.animate()
                                .translationY(0)
                                .alpha(1.0f)
                                .setDuration(600)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        toolbar.setVisibility(View.VISIBLE);
                                        // barr.setVisibility(View.VISIBLE);
                                    }
                                });

                        playcontainer.animate()
                            .translationY(0)
                            .alpha(1.0f)
                            .setDuration(600)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    playcontainer.setVisibility(View.VISIBLE);
                                }
                            });


                        break;

                    case "next":
                        if (savedPagesCount > arrayList.size()) {
                            page = page + 1;
                            RetrieveNext();
                        } else {
                            page = page + 1;
                           // getNexttData();
                        }
                        break;

                    case "hide":

                        toolbar.animate()
                                .translationY(0)
                                .alpha(0.0f)
                                .setDuration(600)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        toolbar.setVisibility(View.GONE);
                                        // barr.setVisibility(View.GONE);
                                    }
                                });

                      playcontainer.animate()
                                .translationY(playcontainer.getHeight())
                                .alpha(0.0f)
                                .setDuration(600)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        playcontainer.setVisibility(View.GONE);
                                    }
                                });
                      if (play_lin.getVisibility()==View.VISIBLE)
                          play_lin.setVisibility(View.GONE);

                        break;
                    case "playtafseers":

                           if (helper.getLanguageID() == 0){
                               File file = new File(filepath + "/" + dataBeanArrayList3.get(0).getTafaseer().getName() + "t.mp3");
                                if (file.exists()) {
                                    stopTafseerPlaying();
                                    PLAYTafseer(filepath + "/" + dataBeanArrayList3.get(0).getTafaseer().getName() + "t.mp3");
                                } else {

                                    stopTafseerPlaying();
                                    PLAYTafseer(dataBeanArrayList3.get(0).getTafaseer().getTafseerlink());
                               }


                       } else {
                                File file = new File(filepath + "/" + dataBeanArrayList3.get(0).getTafaseer().getName() + "ts.mp3");
                                if (file.exists()){
                                stopTafseerPlaying();
                                    progressa.setVisibility(View.VISIBLE);
                                    play_tafseer.setVisibility(View.GONE);
                                    play_tafseer.setEnabled(false);
                                PLAYTafseer(filepath + "/" + dataBeanArrayList3.get(0).getTafaseer().getName() + "ts.mp3");
                            } else {
                                stopTafseerPlaying();
                                    progressa.setVisibility(View.VISIBLE);
                                    play_tafseer.setVisibility(View.GONE);
                                    play_tafseer.setEnabled(false);
                                PLAYTafseer(dataBeanArrayList3.get(0).getTafaseer().getSecond_lang());
                            }
                        }


                        break;

                    case "gotopage":
                        stopTafseerPlaying();
                          int specPage = arg1.getIntExtra("pos",0);
                            currentpage = specPage;
                            int sorid = arg1.getIntExtra("sora_id",0);
                          souraposition=sorid+1;
                            mViewPager.setCurrentItem(--specPage);

                        if (down_dialog != null && down_dialog.isShowing()){
                            down_dialog.cancel();
                        }



                        break;

                    case "playtelawoa":

                        if (dataBeanArrayList3.size() > 0) {
                            File file = new File(filepath + "/" + dataBeanArrayList3.get(0).getTafaseer().getName() + "telawa" + ".mp3");
                            if (file.exists()) {
                                progressa.setVisibility(View.VISIBLE);
                                play_tafseer.setVisibility(View.GONE);
                                // play_tafseer.setEnabled(false);
                                if (dataBeanArrayList3.size() > 0) {
                                    if (currentpage <= dataBeanArrayList3.size())
                                        PLAYTafseer(filepath + "/" + dataBeanArrayList3.get(0).getTafaseer().getName() + "telawa" + ".mp3");
                                }
                            }

                            else
                            {

                                if (tafseermp==null)
                                    play_lin.setVisibility(View.VISIBLE);
                                else
                                {
                                    if (currentpage <= dataBeanArrayList3.size())
                                        if (ConnectivityReceiver.isConnected()) {
                                            PLAYTafseer( dataBeanArrayList3.get(0).getTafaseer().getSoundtrack());
                                        }
                                        else {
                                            Toast.makeText(MainActivity.this, getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
                                        }
                                }
                            }
                        }
                        break;
                    default:
                        break;

                }
            }
        }
    }

    @Override
    protected void onStop() {

        super.onStop();
        helper.setLastpagescroll(currentpage);
        helper.setLastsourashow(souraposition);
    }

}
