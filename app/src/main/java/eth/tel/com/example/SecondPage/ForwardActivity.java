package eth.tel.com.example.SecondPage;

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
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.util.Locale;

import eth.tel.com.example.R;

public class ForwardActivity extends Activity {

    private static  final  int RESULT_PICK_CONTACT =1;
    EditText forwardNumber;
    Button forwardNow, Deactive, checkForward;
    ImageView selectForward;
    TextView moreText;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        Touch();
        setContentView(R.layout.activity_forward);

        moreText = findViewById(R.id.textView);
        backgroundTheme = findViewById(R.id.background);
        selectForward = findViewById(R.id.selectForward);
        forwardNumber = (EditText) findViewById(R.id.forwardNumber);
        forwardNow = (Button) findViewById(R.id.forwardNow);
        checkForward = (Button) findViewById(R.id.checkForward);
        Deactive = (Button) findViewById(R.id.deactive);

        changeOurTheme();

        selectForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent, RESULT_PICK_CONTACT);
            }
        });

        forwardNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String number = forwardNumber.getText().toString();
                String hash = Uri.encode("#");

                if (number.trim().isEmpty()) {
                    Toast.makeText(ForwardActivity.this, "Please Insert Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    intentRecharge.setData(Uri.parse("tel:*21*" + number + hash));
                }
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(ForwardActivity.this, "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                } else {
                    startActivity(intentRecharge);
                }
                forwardNumber.setText("");
            }
        });

        checkForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String hash = Uri.encode("#");
                intentRecharge.setData(Uri.parse("tel:*"+ hash + 21 + hash));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(ForwardActivity.this,"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(intentRecharge);
                }
            }
        });

        Deactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String hash = Uri.encode("#");
                intentRecharge.setData(Uri.parse("tel:"+ hash + 21 + hash));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(ForwardActivity.this,"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(intentRecharge);
                }
            }
        });
        forwardNumber.addTextChangedListener(transferTextWatcher);
        forwardNow.addTextChangedListener(transferTextWatcher);
    }

    private TextWatcher transferTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (forwardNumber.getText().length() > 9) {
                forwardNow.setEnabled(true);
            } else forwardNow.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private void requisitionPermission(){
        ActivityCompat.requestPermissions(ForwardActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            if (requestCode == RESULT_PICK_CONTACT) {
                contactPicked(data);
            }
        }
        else {
            //Toast.makeText(this, R.string.failed, Toast.LENGTH_SHORT).show();
            requisitionPermissionContact();
        }
    }
    private void contactPicked (Intent data) {
        Cursor cursor = null;
        try {
            String phoneNum = null;
            Uri uri = data.getData();
            cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            phoneNum = cursor.getString(phoneIndex);

            forwardNumber.setText(phoneNum.trim().replace("+251","0").replace("-","").replace(" ",""));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void requisitionPermissionContact(){
        ActivityCompat.requestPermissions(ForwardActivity.this,new String[]{Manifest.permission.READ_CONTACTS},1);
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
            selectForward.setBackgroundResource(R.drawable.contact);
            moreText.setBackgroundResource(R.drawable.bluebutton);
            forwardNow.setBackgroundResource(R.drawable.selector_blue);
            checkForward.setBackgroundResource(R.drawable.custom_button);
            Deactive.setBackgroundResource(R.drawable.custom_button);
        }
    }
}