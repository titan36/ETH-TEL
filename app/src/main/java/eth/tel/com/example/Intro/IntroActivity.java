package eth.tel.com.example.Intro;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import eth.tel.com.example.MainActivity;
import eth.tel.com.example.R;

public class IntroActivity extends Activity {

    static final int REQUEST_CODE = 123;

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position = -1 ;
    Button btnGetStarted, btn_got;
    Animation btnAnim;
    TextView later;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (restorePrefData()){
            Intent homeActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(homeActivity);
            finish();
        }

        loadLocale();
        setContentView(R.layout.activity_intro);

        btnNext = findViewById(R.id.btn_next);
        btn_got = findViewById(R.id.btn_got);
        later = findViewById(R.id.later);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("WELCOME","ETH TEL App provide All ethiotelecom Service.\n" +
                "Feel Free To Use ETH TEL App.\n",R.drawable.welcome));
        mList.add(new ScreenItem("EASY TO USE","Check balance, recharge your balance"+"\nand all features you want.\n",R.drawable.easy));
        mList.add(new ScreenItem("GOOD TO GO","Get Started & Grant All The Permission \n " +
                "We Don't Collect Any User Data.\n" + "You are SAFE with Us!",R.drawable.launch));

        screenPager = findViewById(R.id.screen_viewPager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        tabIndicator.setupWithViewPager(screenPager);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size()-1){
                    loadFirstScreen();
                }
            }
        });

        btn_got.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }
            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }
                if (tab.getPosition() == mList.size()-2){
                    loadSecondScreen();
                }
                if (tab.getPosition() == mList.size()-3){
                    loadFirstScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent homeActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(homeActivity);
                if (ContextCompat.checkSelfPermission(IntroActivity.this,Manifest.permission.CALL_PHONE)+
                        ContextCompat.checkSelfPermission(IntroActivity.this,Manifest.permission.READ_CONTACTS)+
                        ContextCompat.checkSelfPermission(IntroActivity.this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(IntroActivity.this,Manifest.permission.CALL_PHONE) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(IntroActivity.this,Manifest.permission.READ_CONTACTS) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(IntroActivity.this,Manifest.permission.CAMERA)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(IntroActivity.this,R.style.StylishDialog);
                        builder.setTitle("Grant Those Permission");
                        builder.setMessage("Camera, Read Contact and Call Phone");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(
                                        IntroActivity.this,
                                        new String[]{
                                                Manifest.permission.CALL_PHONE,
                                                Manifest.permission.READ_CONTACTS,
                                                Manifest.permission.CAMERA
                                        },
                                        REQUEST_CODE
                                );
                            }
                        });
                        builder.setNegativeButton("Cancel",null);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    } else {
                        ActivityCompat.requestPermissions(
                                IntroActivity.this,
                                new String[]{
                                        Manifest.permission.CALL_PHONE,
                                        Manifest.permission.READ_CONTACTS,
                                        Manifest.permission.CAMERA
                                },
                                REQUEST_CODE
                        );
                    }

                } else {
                    Toast.makeText(IntroActivity.this, "Permission Already Granted", Toast.LENGTH_SHORT).show();
                }
                savePrefsData();
                finish();
            }
        });

    }

    private boolean restorePrefData() {
        SharedPreferences pref =  getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenBefore = pref.getBoolean("isIntroOpen",false);
        return isIntroActivityOpenBefore;
    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpen",true);
        editor.commit();
    }

    private void loadLastScreen() {
        btn_got.setVisibility(View.INVISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        later.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btnGetStarted.setAnimation(btnAnim);
    }

    private void loadSecondScreen() {
        btn_got.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.INVISIBLE);
        later.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

    }

    private void loadFirstScreen() {
        btn_got.setVisibility(View.INVISIBLE);
        btnNext.setVisibility(View.VISIBLE);
        btnGetStarted.setVisibility(View.INVISIBLE);
        later.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);


    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_lang",lang);
        editor.apply();
    }
    public void loadLocale(){
        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("My_lang","");
        setLocale(language);
    }
}
