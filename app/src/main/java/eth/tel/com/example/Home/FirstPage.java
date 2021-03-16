package eth.tel.com.example.Home;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;

import eth.tel.com.example.CreditService.CreditServiceActivity;
import eth.tel.com.example.FirstPage.CallMeBack.CallMeBackActivity;
import eth.tel.com.example.FirstPage.Recharge.RechargeActivity;
import eth.tel.com.example.FirstPage.Transfer.TransferActivity;
import eth.tel.com.example.Gebeta.PackageOffers.PackageOfferActivity;
import eth.tel.com.example.R;

import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import java.util.Locale;


import static android.content.Context.MODE_PRIVATE;

public class FirstPage extends Fragment {

    String ex = "Checker";
    String getChecker;
    String checker = "";

    String rn = "RemoveName";
    String getRemoveName;
    String removeName = "";

    String pr = "Permission";
    String getPermission;
    String permission = "";

    ImageView check, recharge, transfer, callMeBack, ethioGebeta, airTimeCredit;
    Button okGotIt;

    TextView checkID,rechargeID,transferID,callMeBackID,gebetaID,creditID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.first_page,container,false );

        check  = view.findViewById(R.id.checkBalance);
        recharge = view.findViewById( R.id.rechargeBalance );
        transfer = view.findViewById( R.id.transferBalance );
        callMeBack = view.findViewById( R.id.callMeBack );
        ethioGebeta = view.findViewById(R.id.ethioGebeta);
        airTimeCredit = view.findViewById(R.id.airTimeCredit);

        checkID = view.findViewById(R.id.checkID);
        rechargeID = view.findViewById(R.id.rechargeID);
        transferID = view.findViewById(R.id.transferID);
        callMeBackID = view.findViewById(R.id.callMeBackID);
        gebetaID = view.findViewById(R.id.gebetaID);
        creditID = view.findViewById(R.id.creditID);

        okGotIt = view.findViewById(R.id.okGotIt);
        //result = view.findViewById(R.id.result);

        checker();
        loadLocale();
        RemoveName();

        SharedPreferences preferences = getActivity().getSharedPreferences("PREFS", 0);
        boolean ifShowDialog = preferences.getBoolean("showDialog",true);
        if (ifShowDialog){
            //showDialog();
        }

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String hash = Uri.encode("#");
                intentRecharge.setData(Uri.parse("tel:*804"+ hash));
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(),"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(intentRecharge);
                }

            }
        });

        recharge.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRechargeActivity();
            }
        } );

        transfer.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransferActivity();
            }
        } );

        callMeBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCallMeBackActivity();
            }
        } );

        ethioGebeta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGebetaActivity();
            }
        } );

        airTimeCredit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreditActivity();
            }
        } );

        return view;
    }
    public void openRechargeActivity() {
        Intent recharge = new Intent(getContext(),RechargeActivity.class);
        startActivity(recharge);
    }
    public void openTransferActivity() {
        Intent transfer = new Intent(getContext(), TransferActivity.class);
        startActivity(transfer);
    }
    public void openCallMeBackActivity() {
        Intent callMeBack = new Intent(getContext(), CallMeBackActivity.class);
        startActivity(callMeBack);
    }
    public void openGebetaActivity() {
        Intent Gebeta = new Intent(getContext(), PackageOfferActivity.class);
        startActivity(Gebeta);
    }
    public void openCreditActivity() {
        Intent Credit = new Intent(getContext(), CreditServiceActivity.class);
        startActivity(Credit);
    }

    private void requisitionPermission(){
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);
    }

    public void checker(){

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(ex, MODE_PRIVATE);
        getChecker = sharedPreferences.getString(checker, "off");

        assert getChecker != null;
        if (getChecker.equals("on")) {
            String hash = Uri.decode("#");
            Intent intentRecharge = new Intent(Intent.ACTION_CALL);
            intentRecharge.setData(Uri.parse("tel:*804" + hash));
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getContext(),"Please Grant Permission",Toast.LENGTH_SHORT).show();
                requisitionPermission();
            }
            else {
                startActivity(intentRecharge);
            }
        }
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
        SharedPreferences preferences = getActivity().getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("My_lang","");
        setLocale(language);
    }
    private void showDialog(){
        final Dialog dialog = new Dialog(getActivity(),R.style.StylishDialog);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View custom_dialog = layoutInflater.inflate(R.layout.whatisnew,null);

        okGotIt = custom_dialog.findViewById(R.id.okGotIt);

        okGotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                SharedPreferences preferences = getActivity().getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("showDialog",false);
                editor.apply();
            }
        });
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    public void RemoveName(){

        SharedPreferences sharedPreferencesRemoveName = getActivity().getSharedPreferences(rn, MODE_PRIVATE);
        getRemoveName = sharedPreferencesRemoveName.getString(removeName, "off");

        assert getRemoveName != null;
        if (getRemoveName.equals("on")) {
            checkID.setText(R.string.blank);
            rechargeID.setText(R.string.blank);
            transferID.setText(R.string.blank);
            callMeBackID.setText(R.string.blank);
            gebetaID.setText(R.string.blank);
            creditID.setText(R.string.blank);
        }
        else if (getRemoveName.equals("off")) {
            checkID.setText(R.string.check);
            rechargeID.setText(R.string.recharges);
            transferID.setText(R.string.transfers);
            callMeBackID.setText(R.string.call_me_backs);
            gebetaID.setText(R.string.gebeta);
            creditID.setText(R.string.credit);
        }
    }
}
