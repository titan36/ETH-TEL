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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Locale;

import eth.tel.com.example.R;

public class FeedBackActivity extends Activity {

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

    Button send;
    private EditText ouremail, subject, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_feed_back);

        backgroundTheme = findViewById(R.id.background);
        ouremail = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);

        setTheTheme();
        Touch();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ourEmail = ouremail.getText().toString();
                String ourSubject = subject.getText().toString();
                String ourMessage = message.getText().toString();


                String[] email_divide = ourEmail.split(",");

                Intent send = new Intent(Intent.ACTION_SEND);

                send.putExtra(Intent.EXTRA_EMAIL, email_divide);
                send.putExtra(Intent.EXTRA_SUBJECT, ourSubject);
                send.putExtra(Intent.EXTRA_TEXT, ourMessage);
                send.setType("message/rfc822");
                send.setPackage("com.google.android.gm");
                startActivity(send);
            }
        });
        message.addTextChangedListener(transferTextWatcher);
    }
    private TextWatcher transferTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (message.getText().length() > 3) {
                send.setEnabled(true);
            } else send.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
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

    public void setTheTheme(){

        SharedPreferences sharedPreferencesTheme = getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
        getTheme = sharedPreferencesTheme.getString(changeTheme, "blue");

        if(getTheme.equals("blue")) {
            backgroundTheme.setBackgroundResource(R.drawable.bluecorner);
            send.setBackgroundResource(R.drawable.selector_blue);
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

}