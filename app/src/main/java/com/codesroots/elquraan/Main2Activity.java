package com.codesroots.elquraan;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SnapHelper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codesroots.elquraan.Adapter.CustomPagerAdapter;
import com.codesroots.elquraan.Helpers.ApiClient;
import com.codesroots.elquraan.Helpers.ApiInterface;
import com.codesroots.elquraan.Helpers.PreferenceHelper;
import com.codesroots.elquraan.Helpers.ProgressDialogHelper;
import com.codesroots.elquraan.Helpers.rtlVIEWPAGER;
import com.codesroots.elquraan.Models.CircleImageView;
import com.codesroots.elquraan.Models.FullQuranModel;
import com.codesroots.elquraan.Models.SewarModelView;
import com.codesroots.elquraan.db.DBAdapter;
import com.codesroots.elquraan.db.DBHelper;
import com.crashlytics.android.Crashlytics;
import com.tuyenmonkey.mkloader.MKLoader;

import java.util.ArrayList;
import java.util.Timer;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Main2Activity extends AppCompatActivity {

    DBAdapter dbAdapter;
    DBHelper dbHelper;
    rtlVIEWPAGER mViewPager;
    private CustomPagerAdapter adapter;
    private ImageView play_tafseer, stop_tafseer;
    LinearLayout play_lin;
    SeekBar tafseer_seek;
    RelativeLayout toolbar;
    MKLoader progressa;
    TextView tafseertime, tafseer_total, play_title, sora_name;
    Timer tafseer_timer;
    RelativeLayout tafseer_relative;
    CircleImageView switch_sound;
    ArrayList<SewarModelView.DataBean> arrayList, nextArray;
    private int currentpage = 0;
    private boolean isTafseer = false, loading = false;

    ImageView speed_find;
    SnapHelper snapHelper;
    PreferenceHelper helper;
    String filepath;
    ImageView gotofasel,menuq;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private boolean isPositionChanged = false;
    int lastposition = 0, currentpos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        askFormPermissions();
        setContentView(R.layout.activity_main);
        initialize();

        getData();

    }


    private void initialize()
    {
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
        mViewPager = findViewById(R.id.full_pager);
      //  dataBeanArrayList = new ArrayList<>();
    }
    private void askFormPermissions() {
        if (ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(Main2Activity.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                ActivityCompat.requestPermissions(Main2Activity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.WAKE_LOCK},
                        8);
            }
        }
    }


    private int count = 0, page = 1, ia = 1, countnext = 0;
    Timer timer, nexttimer;
    private FullQuranModel sewarModel;
    Call<FullQuranModel> call;

    private void getData() {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        call = apiService.getFullQuran();

        call.enqueue(new Callback<FullQuranModel>() {
            @Override
            public void onResponse(Call<FullQuranModel> call, final Response<FullQuranModel> response) {
                if (response.body() != null) {
                    sewarModel = response.body();
                    mViewPager.setAdapter(adapter);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            showProgressdialog(getString(R.string.loading));
//                            LoadData(0);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<FullQuranModel> call, Throwable t) {
                ProgressDialogHelper.removeSimpleProgressDialog();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Main2Activity.this,
                                getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
