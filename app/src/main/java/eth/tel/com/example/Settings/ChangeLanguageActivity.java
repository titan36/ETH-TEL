package eth.tel.com.example.Settings;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.Locale;

import eth.tel.com.example.MainActivity;
import eth.tel.com.example.R;

public class ChangeLanguageActivity extends Activity {

    String SHARED_PREFS = "codeTheme";
    String getThemeku;
    String themeku = "";

    String tc = "Touch";
    String getToucher;
    String toucher = "";

    String SHARED_PREFERTHEME = "setTheme";
    String getTheme;
    String changeTheme = "";

    LinearLayout backgroundTheme;
    TextView textView;

    private String locale;

    String SHARED_PREFER = "setNow";
    String getLang;
    String lang = "";

    Button english, oromoo, amharic, tigire;

    ImageView setEnglish1,setEnglish2,setOromo1,setOromo2,setAmhara1,setAmhara2,setTigre1,setTigre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_change_language);

        setEnglish1 = findViewById(R.id.setEnglish1);
        setEnglish2 = findViewById(R.id.setEnglish2);
        setOromo1 = findViewById(R.id.setOromo1);
        setOromo2 = findViewById(R.id.setOromo2);
        setAmhara1 = findViewById(R.id.setAmhara1);
        setAmhara2 = findViewById(R.id.setAmhara2);
        setTigre1 = findViewById(R.id.setTigre1);
        setTigre2 = findViewById(R.id.setTigre2);

        english = findViewById(R.id.english);
        oromoo = findViewById(R.id.oromoo);
        amharic = findViewById(R.id.amharic);
        tigire = findViewById(R.id.tigrenga);

        textView = findViewById(R.id.textView);
        backgroundTheme = findViewById(R.id.myLayout);

        setTheLang();
        changeOurTheme();
        Touch();

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lang = "";
                SharedPreferences sharedPreferencesLang = getSharedPreferences(SHARED_PREFER, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesLang.edit();
                editor.putString(lang, "Eng");
                editor.apply();
                setLocale("en");

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
                getThemeku = sharedPreferences.getString(themeku, "blue");
                assert getThemeku != null;
                switch (getThemeku) {
                    case "blue":
                        StyleableToast.makeText(ChangeLanguageActivity.this, getString(R.string.successLang), R.style.blue).show();
                        break;
                }
                recreate();
                finishAffinity();
                Intent homeActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(homeActivity);

            }
        });

        oromoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lang = "";
                SharedPreferences sharedPreferencesLang = getSharedPreferences(SHARED_PREFER, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesLang.edit();
                editor.putString(lang, "Oro");
                editor.apply();

                setLocale("om");

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
                getThemeku = sharedPreferences.getString(themeku, "blue");
                assert getThemeku != null;
                switch (getThemeku) {
                    case "blue":
                        StyleableToast.makeText(ChangeLanguageActivity.this, getString(R.string.successLang), R.style.blue).show();
                        break;
                }
                recreate();
                finishAffinity();
                Intent homeActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(homeActivity);

            }
        });

        amharic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lang = "";
                SharedPreferences sharedPreferencesLang = getSharedPreferences(SHARED_PREFER, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesLang.edit();
                editor.putString(lang, "Amh");
                editor.apply();

                setLocale("am");

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
                getThemeku = sharedPreferences.getString(themeku, "blue");
                assert getThemeku != null;
                switch (getThemeku) {
                    case "blue":
                        StyleableToast.makeText(ChangeLanguageActivity.this, getString(R.string.successLang), R.style.blue).show();
                        break;
                }
                recreate();
                finishAffinity();
                Intent homeActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(homeActivity);

            }
        });

        tigire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lang = "";
                SharedPreferences sharedPreferencesLang = getSharedPreferences(SHARED_PREFER, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesLang.edit();
                editor.putString(lang, "Tig");
                editor.apply();

                setLocale("ti");

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
                getThemeku = sharedPreferences.getString(themeku, "blue");
                assert getThemeku != null;
                switch (getThemeku) {
                    case "blue":
                        StyleableToast.makeText(ChangeLanguageActivity.this, getString(R.string.successLang), R.style.blue).show();
                        break;
                }
                recreate();
                finishAffinity();
                Intent homeActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeActivity);

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
    public void setTheLang(){

        SharedPreferences sharedPreferencesLang = getSharedPreferences(SHARED_PREFER, MODE_PRIVATE);
        getLang = sharedPreferencesLang.getString(lang, "Eng");

        if(getLang.equals("Eng")) {
            setEnglish1.setBackgroundResource(R.drawable.active);
            setEnglish2.setBackgroundResource(R.drawable.active);
            setOromo1.setBackgroundResource(R.drawable.deactivate);
            setOromo2.setBackgroundResource(R.drawable.deactivate);
            setAmhara1.setBackgroundResource(R.drawable.deactivate);
            setAmhara2.setBackgroundResource(R.drawable.deactivate);
            setTigre1.setBackgroundResource(R.drawable.deactivate);
            setTigre2.setBackgroundResource(R.drawable.deactivate);
        }
        else if(getLang.equals("Oro")) {
            setOromo1.setBackgroundResource(R.drawable.active);
            setOromo2.setBackgroundResource(R.drawable.active);
            setEnglish1.setBackgroundResource(R.drawable.deactivate);
            setEnglish2.setBackgroundResource(R.drawable.deactivate);
            setAmhara1.setBackgroundResource(R.drawable.deactivate);
            setAmhara2.setBackgroundResource(R.drawable.deactivate);
            setTigre1.setBackgroundResource(R.drawable.deactivate);
            setTigre2.setBackgroundResource(R.drawable.deactivate);
        }
        else if(getLang.equals("Amh")) {
            setAmhara1.setBackgroundResource(R.drawable.active);
            setAmhara2.setBackgroundResource(R.drawable.active);
            setEnglish1.setBackgroundResource(R.drawable.deactivate);
            setEnglish2.setBackgroundResource(R.drawable.deactivate);
            setOromo1.setBackgroundResource(R.drawable.deactivate);
            setOromo2.setBackgroundResource(R.drawable.deactivate);
            setTigre1.setBackgroundResource(R.drawable.deactivate);
            setTigre2.setBackgroundResource(R.drawable.deactivate);
        }
        else if(getLang.equals("Tig")) {
            setTigre1.setBackgroundResource(R.drawable.active);
            setTigre2.setBackgroundResource(R.drawable.active);
            setEnglish1.setBackgroundResource(R.drawable.deactivate);
            setEnglish2.setBackgroundResource(R.drawable.deactivate);
            setOromo1.setBackgroundResource(R.drawable.deactivate);
            setOromo2.setBackgroundResource(R.drawable.deactivate);
            setAmhara1.setBackgroundResource(R.drawable.deactivate);
            setAmhara2.setBackgroundResource(R.drawable.deactivate);
        }

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
            textView.setBackgroundResource(R.drawable.bluebutton);
            english.setBackgroundResource(R.drawable.custom_button);
            oromoo.setBackgroundResource(R.drawable.custom_button);
            amharic.setBackgroundResource(R.drawable.custom_button);
        }
    }
}