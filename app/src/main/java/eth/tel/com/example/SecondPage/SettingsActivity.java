package eth.tel.com.example.SecondPage;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;

import eth.tel.com.example.MainActivity;
import eth.tel.com.example.R;
import eth.tel.com.example.Settings.ChangeLanguageActivity;

public class SettingsActivity extends AppCompatActivity {

    String SHARED_PREFS = "codeTheme";
    String getThemeku;
    String themeku = "";

    String ts = "Transfer";
    String getTransfer;
    String transfer = "";

    String rn = "RemoveName";
    String getRemoveName;
    String removeName = "";

    String SHARED_PREFERTHEME = "setTheme";
    String getTheme;
    String changeTheme = "";

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switchChecker,touchOutSideActivity,removeNameUnderIcon;

    TextView language;

    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferencesTouch;
    SharedPreferences sharedPreferencesRemoveName;

    Toolbar toolbar;
    TextView generalColor,advancedColor;

    public static final String ex = "Checker";
    public static final String tc = "Touch";

    /*  Permission request code to draw over other apps  */
    private static final int DRAW_OVER_OTHER_APP_PERMISSION_REQUEST_CODE = 1222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_settings);

        toolbar = findViewById(R.id.toolbarSettings);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switchChecker = findViewById(R.id.switchChecker);
        touchOutSideActivity = findViewById(R.id.touchOutSideActivity);
        removeNameUnderIcon = findViewById(R.id.removeNameUnderIcon);
        language = findViewById(R.id.language);
        generalColor = findViewById(R.id.generalColor);
        advancedColor = findViewById(R.id.advancedColor);

        changeOurTheme();

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLanguage();
            }
        });

        sharedPreferences = getSharedPreferences(ex,MODE_PRIVATE);
        switchChecker.setChecked(sharedPreferences.getBoolean(ex,false));
        switchChecker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    String checker = "";
                    SharedPreferences sharedPreferences = getSharedPreferences(ex, MODE_PRIVATE);
                    final SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(checker, "on");
                    editor.putBoolean(ex,true);
                    editor.apply();
                } else {
                    String checker = "";
                    SharedPreferences sharedPreferences = getSharedPreferences(ex, MODE_PRIVATE);
                    final SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(checker, "off");
                    editor.putBoolean(ex,false);
                    editor.apply();
                }
            }
        });

        sharedPreferencesTouch = getSharedPreferences(tc,MODE_PRIVATE);
        touchOutSideActivity.setChecked(sharedPreferencesTouch.getBoolean(tc,false));
        touchOutSideActivity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    String toucher = "";
                    SharedPreferences sharedPreferencesTouch = getSharedPreferences(tc, MODE_PRIVATE);
                    final SharedPreferences.Editor editor = sharedPreferencesTouch.edit();
                    editor.putString(toucher, "on");
                    editor.putBoolean(tc,true);
                    editor.apply();
                } else {
                    String toucher = "";
                    SharedPreferences sharedPreferencesTouch = getSharedPreferences(tc, MODE_PRIVATE);
                    final SharedPreferences.Editor editor = sharedPreferencesTouch.edit();
                    editor.putString(toucher, "off");
                    editor.putBoolean(tc,false);
                    editor.apply();
                }
                finishAffinity();
                Intent homeActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeActivity);
            }
        });

        sharedPreferencesRemoveName = getSharedPreferences(rn,MODE_PRIVATE);
        removeNameUnderIcon.setChecked(sharedPreferencesRemoveName.getBoolean(rn,false));
        removeNameUnderIcon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    String removeName = "";
                    SharedPreferences sharedPreferencesRemoveName = getSharedPreferences(rn, MODE_PRIVATE);
                    final SharedPreferences.Editor editor = sharedPreferencesRemoveName.edit();
                    editor.putString(removeName, "on");
                    editor.putBoolean(rn,true);
                    editor.apply();
                } else {
                    String removeName = "";
                    SharedPreferences sharedPreferencesRemoveName = getSharedPreferences(rn, MODE_PRIVATE);
                    final SharedPreferences.Editor editor = sharedPreferencesRemoveName.edit();
                    editor.putString(removeName, "off");
                    editor.putBoolean(rn,false);
                    editor.apply();
                }
                finishAffinity();
                Intent homeActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeActivity);
            }
        });

    }
    public void openLanguage() {
        Intent language = new Intent(this, ChangeLanguageActivity.class);
        startActivity(language);
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

        if(getThemeku.equals("blue")) {
            toolbar.setBackgroundResource(R.drawable.blue);
            generalColor.setTextColor(getResources().getColor(R.color.blueText));
            advancedColor.setTextColor(getResources().getColor(R.color.blueText));
            switchChecker.setThumbResource(R.drawable.thumb_blue);
            switchChecker.setTrackResource(R.drawable.track_blue);
            touchOutSideActivity.setThumbResource(R.drawable.thumb_blue);
            touchOutSideActivity.setTrackResource(R.drawable.track_blue);
        }
    }
}