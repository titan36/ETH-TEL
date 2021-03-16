package eth.tel.com.example.FirstPage.Recharge;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

import eth.tel.com.example.R;

import static android.content.Context.MODE_PRIVATE;

public class RechargeFragment extends Fragment implements View.OnClickListener {

    String SHARED_PREFS = "codeTheme";
    String getThemeku;
    String themeku = "";

    String tc = "Touch";
    String getToucher;
    String toucher = "";

    String pr = "Permission";
    String getPermission;
    String permission = "";

    String SHARED_PREFERTHEME = "setTheme";
    String getTheme;
    String changeTheme = "";

    RelativeLayout backgroundTheme;

    private static  final  int RESULT_PICK_CONTACT =1;

    private CompoundButton autoFocus;
    private CompoundButton useFlash;
    private TextView statusMessage;

    private EditText transferNumber;
    private EditText amount;

    Button cancel, rechargeNow,cancelRechargeOther, rechargeNowOther;
    CheckBox rechargeOthers;
    TextInputLayout rechargeFeild;

    ViewGroup tContainer;

    ImageView selectContact;

    private static final String TAG = "MainActivity";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public static RechargeFragment getInstance(){
        RechargeFragment rechargeFragment = new RechargeFragment();
        return rechargeFragment;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recharge, container, false);

        selectContact = view.findViewById(R.id.selectContact);
        rechargeOthers = view.findViewById(R.id.rechargeOthers);
        rechargeNowOther = view.findViewById(R.id.rechargeNowOther);
        rechargeNow = view.findViewById(R.id.rechargeNow);

        tContainer = view.findViewById(R.id.myLayout);
        rechargeFeild = view.findViewById(R.id.ti_recharge);
        rechargeOthers = view.findViewById(R.id.rechargeOthers);
        cancelRechargeOther = view.findViewById(R.id.cancelRechargeOther);
        rechargeNowOther = view.findViewById(R.id.rechargeNowOther);
        backgroundTheme = view.findViewById(R.id.background);

        changeOurTheme();
        Touch();

        rechargeOthers.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(tContainer);
                visible = !visible;
                rechargeFeild.setVisibility(visible ?  View.VISIBLE: View.GONE);
                cancel.setVisibility(visible ?  View.GONE: View.VISIBLE);
                rechargeNow.setVisibility(visible ?  View.GONE: View.VISIBLE);
                cancelRechargeOther.setVisibility(visible ?  View.VISIBLE: View.GONE);
                rechargeNowOther.setVisibility(visible ?  View.VISIBLE: View.GONE);
            }
        });

        statusMessage = view.findViewById(R.id.status_message);


        cancel = view.findViewById(R.id.cancelRecharge);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        selectContact =  view.findViewById(R.id.selectContact);
        selectContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent, RESULT_PICK_CONTACT);
            }
        });

        cancelRechargeOther = view.findViewById(R.id.cancelRechargeOther);
        cancelRechargeOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        rechargeNow = view.findViewById(R.id.rechargeNow);

        rechargeNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = transferNumber.getText().toString();
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String hash = Uri.encode("#");
                intentRecharge.setData(Uri.parse("tel:*805*" + number + hash));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(),"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(intentRecharge);
                }
                transferNumber.setText("");
            }
        });

        transferNumber = view.findViewById(R.id.text_value);
        amount = view.findViewById(R.id.phone);

        rechargeNowOther = view.findViewById(R.id.rechargeNowOther);

        rechargeNowOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = transferNumber.getText().toString();
                String money = amount.getText().toString();
                String asterisk = Uri.encode("*");
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String hash = Uri.encode("#");
                intentRecharge.setData(Uri.parse("tel:*805*"+ number + asterisk + money + hash));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(),"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(intentRecharge);
                }
                transferNumber.setText("");
                amount.setText("");
            }
        });


        transferNumber.addTextChangedListener(transferTextWatcher);
        amount.addTextChangedListener(transferTextWatcher);
        rechargeNow.addTextChangedListener(transferTextWatcher);
        rechargeNowOther.addTextChangedListener(transferTextWatcher);

        return view;
    }
    private TextWatcher transferTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (amount.getText().length() > 9 && transferNumber.getText().length() > 13) {
                rechargeNowOther.setEnabled(true);
            } else rechargeNowOther.setEnabled(false);
            if (transferNumber.getText().length() > 13) {
                rechargeNow.setEnabled(true);
            } else rechargeNow.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void requisitionPermission(){
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);
    }

    private void contactPicked (Intent data) {
        Cursor cursor = null;
        try {
            String phoneNum = null;
            Uri uri = data.getData();
            cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            phoneNum = cursor.getString(phoneIndex);

            amount.setText(phoneNum.trim().replace("+251","0").replace("-","").replace(" ",""));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void requisitionPermissionContact(){
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_CONTACTS},1);
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
            selectContact.setBackgroundResource(R.drawable.contact);
            rechargeNow.setBackgroundResource(R.drawable.selector_blue);
            rechargeNowOther.setBackgroundResource(R.drawable.selector_blue);
        }
    }

    @Override
    public void onClick(View v) {

    }
}