package eth.tel.com.example.FirstPage.Transfer;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import eth.tel.com.example.R;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class TransferFragment extends Fragment {

    String SHARED_PREFS = "codeTheme";
    String getThemeku;
    String themeku = "";

    String tc = "Touch";
    String getToucher;
    String toucher = "";

    String ts = "Transfer";
    String getTransfer;
    String transfer = "";

    String SHARED_PREFERTHEME = "setTheme";
    String getTheme;
    String changeTheme = "";

    String pr = "Permission";
    String getPermission;
    String permission = "";

    ViewGroup tContainer;

    RelativeLayout backgroundTheme;

    private static  final  int RESULT_PICK_CONTACT =1;

    private EditText transferNumber;
    private EditText amount;
    Button transferNow, cancel;

    ImageView select;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public static TransferFragment getInstance(){
        TransferFragment transferFragment = new TransferFragment();
        return transferFragment;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_transfer, container, false);

        transferNow = view.findViewById(R.id.transferNow);
        select = view.findViewById(R.id.select);
        backgroundTheme = view.findViewById(R.id.background);
        cancel = view.findViewById(R.id.cancelTransfer);
        transferNumber =  view.findViewById(R.id.transferNumber);
        amount =  view.findViewById(R.id.amount);
        transferNow =  view.findViewById(R.id.transferNow);
        select = view.findViewById(R.id.select);
        tContainer = view.findViewById(R.id.myLayout);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent, RESULT_PICK_CONTACT);
            }
        });

        transferNumber.addTextChangedListener(transferTextWatcher);
        amount.addTextChangedListener(transferTextWatcher);

        transferNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = transferNumber.getText().toString();
                String money = amount.getText().toString();
                String hash = Uri.encode("#");
                String asterisk = Uri.encode("*");
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                intentRecharge.setData(Uri.parse("tel:*806*"+ number + asterisk + money + hash));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(),"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermissionContact();
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

        transferNumber.addTextChangedListener(transferTextWatcher);
        amount.addTextChangedListener(transferTextWatcher);

        changeOurTheme();
        Touch();
        return view;
    }
    private TextWatcher transferTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (!amount.getText().toString().equals("") &&  transferNumber.getText().length() > 9) {
                transferNow.setEnabled(true);
            } else transferNow.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case RESULT_PICK_CONTACT:
                    contactPicked (data);
                    break;
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
            String phoneNo = null;
            Uri uri = data.getData();
            cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            phoneNo = cursor.getString(phoneIndex);

            transferNumber.setText(phoneNo.trim().replace("+251","0").replace("-","").replace(" ",""));

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
        getActivity().getResources().updateConfiguration(configuration,getActivity().getResources().getDisplayMetrics());
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
            select.setBackgroundResource(R.drawable.contact);
            transferNow.setBackgroundResource(R.drawable.selector_blue);
        }
    }
}