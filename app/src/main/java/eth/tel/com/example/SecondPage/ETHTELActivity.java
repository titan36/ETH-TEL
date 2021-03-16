package eth.tel.com.example.SecondPage;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

import eth.tel.com.example.R;
import eth.tel.com.example.Settings.AboutAppActivity;
import eth.tel.com.example.Settings.FeedBackActivity;

public class ETHTELActivity extends Activity {

    String SHARED_PREFS = "codeTheme";
    String getThemeku;
    String themeku = "";

    String tc = "Touch";
    String getToucher;
    String toucher = "";

    String SHARED_PREFERTHEME = "setTheme";
    String getTheme;
    String changeTheme = "";

    RelativeLayout backgroundTheme;

    TextView moreText;

    Button rateMe,shareMe,updateMe,feedBack,aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        Touch();
        setContentView(R.layout.activity_eth_tel);

        backgroundTheme = findViewById(R.id.background);
        moreText = findViewById(R.id.textView);

        feedBack = findViewById(R.id.feedBackToES);
        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeedBack();
                finish();
            }
        });

        shareMe =  findViewById(R.id.shareES);
        shareMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                final String appPackageName = getApplicationContext().getPackageName();
                String strAppLink = "";

                try {
                    strAppLink = "https://play.google.com/store/apps/details?id=" + appPackageName;
                }
                catch (ActivityNotFoundException anfe)
                {
                    strAppLink = "https://play.google.com/store/apps/details?id=" + appPackageName;
                }
                intent.setType("text/link");
                String shareBody = "Hi, I'm Using ETH TEL App , let's try the cool APP" +
                        " "+"ETH TEL v1.2.3 "+ strAppLink;
                String shareSub = "ETH TEL";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent,"Share Via"));
            }

        });

        rateMe =  findViewById(R.id.rateES);
        rateMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "eth.tel.com")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
            }
        });

        updateMe =  findViewById(R.id.updateES);
        updateMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "eth.tel.com")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
            }
        });

        aboutUs =  findViewById(R.id.aboutUs);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutUs();
            }
        });

        changeOurTheme();

    }
    public void openFeedBack() {
        Intent FeedBack = new Intent(this, FeedBackActivity.class);
        startActivity(FeedBack);
    }
    public void openAboutUs() {
        Intent About = new Intent(this, AboutAppActivity.class);
        startActivity(About);
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
    public void Touch(){

        SharedPreferences sharedPreferencesTouch = getSharedPreferences(tc, MODE_PRIVATE);
        getToucher = sharedPreferencesTouch.getString(toucher, "off");

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

        if(getThemeku.equals("blue")) {
            backgroundTheme.setBackgroundResource(R.drawable.rounded_shape_for_recharge);
            moreText.setBackgroundResource(R.drawable.bluebutton);
            rateMe.setBackgroundResource(R.drawable.custom_button);
            shareMe.setBackgroundResource(R.drawable.custom_button);
            updateMe.setBackgroundResource(R.drawable.custom_button);
            feedBack.setBackgroundResource(R.drawable.custom_button);
        }
    }
}