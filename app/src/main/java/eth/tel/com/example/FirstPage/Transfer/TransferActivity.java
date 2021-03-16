package eth.tel.com.example.FirstPage.Transfer;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

import eth.tel.com.example.Adapter.GebetaPagerAdapter;
import eth.tel.com.example.R;

public class TransferActivity extends FragmentActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    LinearLayout mainBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_transfer);

        mainBackground = findViewById(R.id.mainBackground);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        getTabs();

    }

    public void getTabs(){
        final GebetaPagerAdapter gebetaPagerAdapter = new GebetaPagerAdapter(getSupportFragmentManager());

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                gebetaPagerAdapter.addFragment(TransferFragment.getInstance(),getString(R.string.transfer));

                viewPager.setAdapter(gebetaPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

            }
        });

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