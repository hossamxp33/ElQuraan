package com.codesroots.elquraan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.codesroots.elquraan.Helpers.PreferenceHelper;

public class ChooseLanguageActivity extends AppCompatActivity {
    private TextView arabic,urdo;
    private PreferenceHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);
        arabic = findViewById(R.id.arabic);
        urdo = findViewById(R.id.urdo);
        helper = new PreferenceHelper(this);
        if (helper.getFirstOpen()){
            Intent intent = new Intent(ChooseLanguageActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.setLanguageID(0);
                Intent intent = new Intent(ChooseLanguageActivity.this,MainActivity.class);
                startActivity(intent);
                helper.setFirstOpen(true);
                finish();
            }
        });

        urdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.setLanguageID(1);
                Intent intent = new Intent(ChooseLanguageActivity.this,MainActivity.class);
                startActivity(intent);
                helper.setFirstOpen(true);
                finish();
            }
        });
    }
}
