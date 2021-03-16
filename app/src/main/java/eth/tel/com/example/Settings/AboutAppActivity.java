package eth.tel.com.example.Settings;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import eth.tel.com.example.R;

public class AboutAppActivity extends AppCompatActivity {

    String SHARED_PREFS = "codeTheme";
    String getThemeku;
    String themeku = "";

    String SHARED_PREFERTHEME = "setTheme";
    String getTheme;
    String changeTheme = "";

    Toolbar toolbar;
    TextView esTitle,privacyTitle,supportTitle,thanksTitle;

    TextView openPrivacy,myEmail,donateNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        openPrivacy = findViewById(R.id.openPrivacy);
        myEmail = findViewById(R.id.myEmail);
        donateNow = findViewById(R.id.openDonatePage);

        toolbar = findViewById(R.id.toolbarAbout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        esTitle = findViewById(R.id.esTitle);
        privacyTitle = findViewById(R.id.privacyTitle);
        supportTitle = findViewById(R.id.supportTitle);
        thanksTitle = findViewById(R.id.thanksTitle);

        changeOurTheme();

        TextView textView =  findViewById(R.id.barataa);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        TextView telegram =  findViewById(R.id.myTgAccount);
        telegram.setMovementMethod(LinkMovementMethod.getInstance());

        TextView telegramChannel =  findViewById(R.id.joinTelegramChannel);
        telegramChannel.setMovementMethod(LinkMovementMethod.getInstance());

        myEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent website = new Intent(AboutAppActivity.this,FeedBackActivity.class);
                startActivity(website);
            }
        });

        openPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent website = new Intent(AboutAppActivity.this,PrivacyPolicyActivity.class);
                startActivity(website);
            }
        });
    }
    public void changeOurTheme(){
        SharedPreferences sharedPreferencesTheme = getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
        getThemeku = sharedPreferencesTheme.getString(themeku, "blue");

        if(getThemeku.equals("blue")) {
            toolbar.setBackgroundResource(R.drawable.blue);
            esTitle.setTextColor(getResources().getColor(R.color.blueText));
            privacyTitle.setTextColor(getResources().getColor(R.color.blueText));
            supportTitle.setTextColor(getResources().getColor(R.color.blueText));
            thanksTitle.setTextColor(getResources().getColor(R.color.blueText));
        }
    }
}