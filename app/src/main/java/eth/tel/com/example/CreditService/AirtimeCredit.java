package eth.tel.com.example.CreditService;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import eth.tel.com.example.R;

import static android.content.Context.MODE_PRIVATE;

public class AirtimeCredit extends Fragment {

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

    EditText text_phone_number1, text_phone_number2, text_phone_number3, text_phone_number4, text_phone_number5, text_phone_number6;
    String phone;
    Button sendFive, sendTen, sendFifteen, sendTwentyFive, sendFifty, sendHundred;

    public static AirtimeCredit getInstance(){
        AirtimeCredit airtimeCredit = new AirtimeCredit();
        return airtimeCredit;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.airtime_credit, container, false);

        sendFive = view.findViewById(R.id.sendFive);
        sendTen = view.findViewById(R.id.sendTen);
        sendFifteen = view.findViewById(R.id.sendFifteen);
        sendTwentyFive = view.findViewById(R.id.sendTwentyFive);
        sendFifty = view.findViewById(R.id.sendFifty);
        sendHundred = view.findViewById(R.id.sendHundred);
        backgroundTheme = view.findViewById(R.id.background);

        text_phone_number1 = view.findViewById(R.id.text_phone_number1);
        text_phone_number2 = view.findViewById(R.id.text_phone_number2);
        text_phone_number3 = view.findViewById(R.id.text_phone_number3);
        text_phone_number4 = view.findViewById(R.id.text_phone_number4);
        text_phone_number5 = view.findViewById(R.id.text_phone_number5);
        text_phone_number6 = view.findViewById(R.id.text_phone_number6);

        //changeOurTheme();
        loadLocale();
        Touch();

        sendFive = view.findViewById(R.id.sendFive);
        sendTen = view.findViewById(R.id.sendTen);
        sendFifteen = view.findViewById(R.id.sendFifteen);
        sendTwentyFive = view.findViewById(R.id.sendTwentyFive);
        sendFifty = view.findViewById(R.id.sendFifty);
        sendHundred = view.findViewById(R.id.sendHundred);

        sendFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = text_phone_number1.getText().toString();
                Intent send = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","810",null));
                send.putExtra("sms_body","5");
                startActivity(send);
            }
        });

        sendTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = text_phone_number2.getText().toString();

                Intent send = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","810",null));
                send.putExtra("sms_body","10");
                startActivity(send);
            }
        });

        sendFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = text_phone_number3.getText().toString();

                Intent send = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","810",null));
                send.putExtra("sms_body","15");
                startActivity(send);
            }
        });

        sendTwentyFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = text_phone_number4.getText().toString();

                Intent send = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","810",null));
                send.putExtra("sms_body","25");
                startActivity(send);
            }
        });

        sendFifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = text_phone_number5.getText().toString();

                Intent send = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","810",null));
                send.putExtra("sms_body","50");
                startActivity(send);
            }
        });

        sendHundred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = text_phone_number6.getText().toString();

                Intent send = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","810",null));
                send.putExtra("sms_body","100");
                startActivity(send);
            }
        });

        return view;
    }
    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(configuration,getActivity().getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getActivity().getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_lang",lang);
        editor.apply();
    }
    public void loadLocale(){
        SharedPreferences preferences = getActivity().getSharedPreferences("Settings", MODE_PRIVATE);
        String language = preferences.getString("My_lang","");
        setLocale(language);
    }
    public void Touch(){

        SharedPreferences sharedPreferencesTouch = getActivity().getSharedPreferences(tc, MODE_PRIVATE);
        getToucher = sharedPreferencesTouch.getString(toucher, "off");

        if (getToucher.equals("on")) {
            getActivity().setFinishOnTouchOutside(false);
        }
        else if (getToucher.equals("off")) {
            getActivity().setFinishOnTouchOutside(true);
        }
    }
    public void changeOurTheme(){

        SharedPreferences sharedPreferencesTheme = getActivity().getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
        getThemeku = sharedPreferencesTheme.getString(themeku, "blue");

        if(getThemeku.equals("blue")) {
            backgroundTheme.setBackgroundResource(R.drawable.rounded_shape_for_recharge);
            sendFive.setBackgroundResource(R.drawable.blue);
            sendTen.setBackgroundResource(R.drawable.blue);
            sendFifteen.setBackgroundResource(R.drawable.blue);
            sendTwentyFive.setBackgroundResource(R.drawable.blue);
            sendFifty.setBackgroundResource(R.drawable.blue);
            sendHundred.setBackgroundResource(R.drawable.blue);
        }
    }
}