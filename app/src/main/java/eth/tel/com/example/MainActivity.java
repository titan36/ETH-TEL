package eth.tel.com.example;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import eth.tel.com.example.Adapter.SlidePagerAdapter;
import eth.tel.com.example.Home.FirstPage;
import eth.tel.com.example.Home.SecondPage;

public class MainActivity extends FragmentActivity {

    String tc = "Touch";
    String getToucher;
    String toucher = "";

    String SHARED_PREFERTHEME = "setTheme";
    String getThemeku;
    String themeku = "";

    String fl = "Floater";
    String getFloater;
    String floater = "";

    ViewPager pager;
    PagerAdapter pagerAdapter;
    TabLayout tabIndicator;
    RelativeLayout mainBackground;

    SwipeRefreshLayout swipeCheckBalance;

    /*  Permission request code to draw over other apps  */
    private static final int DRAW_OVER_OTHER_APP_PERMISSION_REQUEST_CODE = 1222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Touch();
        loadLocale();
        setContentView(R.layout.activity_main);

        swipeCheckBalance = findViewById(R.id.swipeCheckBalance);
        swipeCheckBalance.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String hash = Uri.encode("#");
                intentRecharge.setData(Uri.parse("tel:*804"+ hash));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(intentRecharge);
                    swipeCheckBalance.setRefreshing(false);
                    //int c1 = getResources().getColor(R.color.blueText);
                    //int c2 = getResources().getColor(R.color.colorAccent);
                    //swipeCheckBalance.setColorSchemeColors(c2);
                    //swipeCheckBalance.setProgressBackgroundColorSchemeColor(c1);
                }
            }
        });

        mainBackground = findViewById(R.id.mainBackground);
        tabIndicator = findViewById(R.id.tab_indicatorHome);

        tabIndicator.setupWithViewPager(pager);

        pager = new ViewPager(this);
        pager.setAdapter(pagerAdapter);
        tabIndicator.setupWithViewPager(pager);

        final List<Fragment> list = new ArrayList<>();
        list.add(new FirstPage());
        list.add(new SecondPage());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);

        tabIndicator.setupWithViewPager(pager);

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == list.size() - 1) {
                    loadSecondScreen();
                }
                if (tab.getPosition() == list.size() - 2) {
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


        changeOurTheme();

    }

    private void loadSecondScreen() {
        tabIndicator.setVisibility(View.VISIBLE);
    }
    private void loadFirstScreen() {
        tabIndicator.setVisibility(View.VISIBLE);
    }

    public void Touch(){

        SharedPreferences sharedPreferencesTouch = getSharedPreferences(tc, MODE_PRIVATE);
        getToucher = sharedPreferencesTouch.getString(toucher, "off");

        assert getToucher != null;
        if (getToucher.equals("on")) {
            this.setFinishOnTouchOutside(false);
        }
        else if (getToucher.equals("off")) {
            this.setFinishOnTouchOutside(true);
        }
    }

    public void changeOurTheme(){

        SharedPreferences sharedPreferencesTheme = getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
        getThemeku = sharedPreferencesTheme.getString(themeku, "blue");

        assert getThemeku != null;
        switch (getThemeku) {
            case "blue":
                mainBackground.setBackgroundResource(R.drawable.bluecorner);
                break;
        }
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

    private void requisitionPermission(){
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
