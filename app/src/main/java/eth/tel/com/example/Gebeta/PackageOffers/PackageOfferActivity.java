package eth.tel.com.example.Gebeta.PackageOffers;

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

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

import eth.tel.com.example.Adapter.GebetaPagerAdapter;
import eth.tel.com.example.R;

public class PackageOfferActivity extends FragmentActivity {

    String SHARED_PREFS = "codeTheme";
    String getThemeku;
    String themeku = "";

    String SHARED_PREFERTHEME = "setTheme";
    String getTheme;
    String changeTheme = "";

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_gebeta);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        changeOurTheme();

        getTabs();

    }
    public void getTabs(){
        final GebetaPagerAdapter gebetaPagerAdapter = new GebetaPagerAdapter(getSupportFragmentManager());

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                gebetaPagerAdapter.addFragment(InternetPackage.getInstance(),getString(R.string.internet_package));
                gebetaPagerAdapter.addFragment(VoicePackage.getInstance(),getString(R.string.voice_package));
                gebetaPagerAdapter.addFragment(SMSPackage.getInstance(),getString(R.string.sms_package));
                gebetaPagerAdapter.addFragment(VoicePlusData.getInstance(),getString(R.string.voice_plus_data));
                gebetaPagerAdapter.addFragment(InternationalCall.getInstance(),getString(R.string.international_call));

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
    public void changeOurTheme(){
        SharedPreferences sharedPreferencesTheme = getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
        getThemeku = sharedPreferencesTheme.getString(themeku, "blue");

        assert getThemeku != null;
        switch (getThemeku) {
            case "blue":
                tabLayout.setBackgroundResource(R.drawable.blue);
                break;
        }
    }
}