package eth.tel.com.example.Gebeta.PackageOffers;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import eth.tel.com.example.R;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class InternationalCall extends Fragment {

    String SHARED_PREFS = "codeTheme";
    String getThemeku;
    String themeku = "";

    String tc = "Touch";
    String getToucher;
    String toucher = "";

    String SHARED_PREFERTHEME = "setTheme";
    String getTheme;
    String changeTheme = "";

    RelativeLayout backgroundDialog,background;
    TextView dailyColor,weeklyColor,monthlyColor;

    private static  final  int RESULT_PICK_CONTACT =1;
    // Button ID for Buy Click
    Button openBuy10W, openBuy202W,openBuy50M;

    EditText phoneGiftNum;
    Button buyForGift,cancelForSelf,cancelForGift,buyForSelf;
    CheckBox forGiftChecked;
    TextInputLayout rechargeField;
    ViewGroup tContainer;
    ImageView selectContact;
    TextView packageDescription;

    public static InternationalCall getInstance(){
        InternationalCall internationalCall = new InternationalCall();
        return internationalCall;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.international_call, container, false);

        openBuy10W = view.findViewById(R.id.openBuy10W);
        openBuy202W = view.findViewById(R.id.openBuy202W);
        openBuy50M = view.findViewById(R.id.openBuy50M);

        // OTHER ID
        selectContact = view.findViewById(R.id.selectContact);
        packageDescription = view.findViewById(R.id.packageDescription);
        tContainer = view.findViewById(R.id.myLayout);
        rechargeField = view.findViewById(R.id.ti_recharge);
        buyForGift = view.findViewById(R.id.buyForGift);
        cancelForSelf = view.findViewById(R.id.cancelForSelf);
        cancelForGift = view.findViewById(R.id.cancelForGift);
        buyForSelf = view.findViewById(R.id.buyForSelf);
        forGiftChecked = view.findViewById(R.id.forGiftChecked);
        phoneGiftNum = view.findViewById(R.id.phone);
        background = view.findViewById(R.id.background);
        backgroundDialog = view.findViewById(R.id.background);

        //Color Text
        dailyColor = view.findViewById(R.id.dailyColorInt);
        weeklyColor = view.findViewById(R.id.weeklyColorInt);
        monthlyColor = view.findViewById(R.id.monthlyColorInt);

        changeMyTheme();

        // Call The Dialog Box //:::::::::::::::::::::::::::::::::
        openBuy10W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy10W();
            }
        });
        openBuy202W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy202W();
            }
        });
        openBuy50M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy50M();
            }
        });

        return view;
    }

    private void buy10W() {
        final Dialog dialog = new Dialog(getActivity(),R.style.StylishDialogInvisible);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View custom_dialog = layoutInflater.inflate(R.layout.package_choice,null);

        forGiftChecked = custom_dialog.findViewById(R.id.forGiftChecked);
        tContainer = custom_dialog.findViewById(R.id.myLayout);
        rechargeField = custom_dialog.findViewById(R.id.ti_recharge);
        buyForGift = custom_dialog.findViewById(R.id.buyForGift);
        cancelForSelf = custom_dialog.findViewById(R.id.cancelForSelf);
        cancelForGift = custom_dialog.findViewById(R.id.cancelForGift);
        buyForSelf = custom_dialog.findViewById(R.id.buyForSelf);
        selectContact = custom_dialog.findViewById(R.id.selectContact);
        phoneGiftNum = custom_dialog.findViewById(R.id.phone);
        phoneGiftNum.addTextChangedListener(transferTextWatcher);
        packageDescription = custom_dialog.findViewById(R.id.packageDescription);
        backgroundDialog = custom_dialog.findViewById(R.id.background);

        changeOurTheme();

        SharedPreferences sharedPreferencesTouch = getActivity().getSharedPreferences(tc, MODE_PRIVATE);
        getToucher = sharedPreferencesTouch.getString(toucher, "off");

        if (getToucher.equals("on")) {
            dialog.setCanceledOnTouchOutside(false);
        }

        selectContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent, RESULT_PICK_CONTACT);
            }
        });
        forGiftChecked.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(tContainer);
                visible = !visible;
                rechargeField.setVisibility(visible ?  View.VISIBLE: View.GONE);
                cancelForGift.setVisibility(visible ?  View.VISIBLE: View.GONE);
                buyForGift.setVisibility(visible ?  View.VISIBLE: View.GONE);
                cancelForSelf.setVisibility(visible ?  View.GONE: View.VISIBLE);
                buyForSelf.setVisibility(visible ?  View.GONE: View.VISIBLE);
            }
        });
        buyForSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String hash = Uri.encode("#");
                intentRecharge.setData(Uri.parse("tel:*999*2*1*5*1*1*1"+ hash));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(),"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(intentRecharge);
                }
            }
        });
        buyForGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String number = phoneGiftNum.getText().toString();
                String hash = Uri.encode("#");
                String astrix = Uri.encode("*");

                if (number.trim().isEmpty()) {
                    Toast.makeText(getContext(), "Please Insert Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*5*1*1*" + number + astrix + 1 + hash));
                }
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getContext(), "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                } else {
                    startActivity(intentRecharge);
                }
                phoneGiftNum.setText("");
            }
        });
        cancelForGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        cancelForSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        packageDescription.setText(R.string.Weekly_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy202W() {
        final Dialog dialog = new Dialog(getActivity(),R.style.StylishDialogInvisible);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View custom_dialog = layoutInflater.inflate(R.layout.package_choice,null);

        forGiftChecked = custom_dialog.findViewById(R.id.forGiftChecked);
        tContainer = custom_dialog.findViewById(R.id.myLayout);
        rechargeField = custom_dialog.findViewById(R.id.ti_recharge);
        buyForGift = custom_dialog.findViewById(R.id.buyForGift);
        cancelForSelf = custom_dialog.findViewById(R.id.cancelForSelf);
        cancelForGift = custom_dialog.findViewById(R.id.cancelForGift);
        buyForSelf = custom_dialog.findViewById(R.id.buyForSelf);
        selectContact = custom_dialog.findViewById(R.id.selectContact);
        phoneGiftNum = custom_dialog.findViewById(R.id.phone);
        phoneGiftNum.addTextChangedListener(transferTextWatcher);
        packageDescription = custom_dialog.findViewById(R.id.packageDescription);
        backgroundDialog = custom_dialog.findViewById(R.id.background);

        changeOurTheme();

        SharedPreferences sharedPreferencesTouch = getActivity().getSharedPreferences(tc, MODE_PRIVATE);
        getToucher = sharedPreferencesTouch.getString(toucher, "off");

        if (getToucher.equals("on")) {
            dialog.setCanceledOnTouchOutside(false);
        }

        selectContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent, RESULT_PICK_CONTACT);
            }
        });
        forGiftChecked.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(tContainer);
                visible = !visible;
                rechargeField.setVisibility(visible ?  View.VISIBLE: View.GONE);
                cancelForGift.setVisibility(visible ?  View.VISIBLE: View.GONE);
                buyForGift.setVisibility(visible ?  View.VISIBLE: View.GONE);
                cancelForSelf.setVisibility(visible ?  View.GONE: View.VISIBLE);
                buyForSelf.setVisibility(visible ?  View.GONE: View.VISIBLE);
            }
        });
        buyForSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String hash = Uri.encode("#");
                intentRecharge.setData(Uri.parse("tel:*999*2*1*5*2*1*1"+ hash));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(),"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(intentRecharge);
                }
            }
        });
        buyForGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String number = phoneGiftNum.getText().toString();
                String hash = Uri.encode("#");
                String astrix = Uri.encode("*");

                if (number.trim().isEmpty()) {
                    Toast.makeText(getContext(), "Please Insert Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*5*2*1*" + number + astrix + 1 + hash));
                }
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getContext(), "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                } else {
                    startActivity(intentRecharge);
                }
                phoneGiftNum.setText("");
            }
        });
        cancelForGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        cancelForSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        packageDescription.setText(R.string._2_weeks_Package_for_14_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy50M() {
        final Dialog dialog = new Dialog(getActivity(),R.style.StylishDialogInvisible);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View custom_dialog = layoutInflater.inflate(R.layout.package_choice,null);

        forGiftChecked = custom_dialog.findViewById(R.id.forGiftChecked);
        tContainer = custom_dialog.findViewById(R.id.myLayout);
        rechargeField = custom_dialog.findViewById(R.id.ti_recharge);
        buyForGift = custom_dialog.findViewById(R.id.buyForGift);
        cancelForSelf = custom_dialog.findViewById(R.id.cancelForSelf);
        cancelForGift = custom_dialog.findViewById(R.id.cancelForGift);
        buyForSelf = custom_dialog.findViewById(R.id.buyForSelf);
        selectContact = custom_dialog.findViewById(R.id.selectContact);
        phoneGiftNum = custom_dialog.findViewById(R.id.phone);
        phoneGiftNum.addTextChangedListener(transferTextWatcher);
        packageDescription = custom_dialog.findViewById(R.id.packageDescription);
        backgroundDialog = custom_dialog.findViewById(R.id.background);

        changeOurTheme();

        SharedPreferences sharedPreferencesTouch = getActivity().getSharedPreferences(tc, MODE_PRIVATE);
        getToucher = sharedPreferencesTouch.getString(toucher, "off");

        if (getToucher.equals("on")) {
            dialog.setCanceledOnTouchOutside(false);
        }

        selectContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent, RESULT_PICK_CONTACT);
            }
        });
        forGiftChecked.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(tContainer);
                visible = !visible;
                rechargeField.setVisibility(visible ?  View.VISIBLE: View.GONE);
                cancelForGift.setVisibility(visible ?  View.VISIBLE: View.GONE);
                buyForGift.setVisibility(visible ?  View.VISIBLE: View.GONE);
                cancelForSelf.setVisibility(visible ?  View.GONE: View.VISIBLE);
                buyForSelf.setVisibility(visible ?  View.GONE: View.VISIBLE);
            }
        });
        buyForSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String hash = Uri.encode("#");
                intentRecharge.setData(Uri.parse("tel:*999*2*1*5*3*1*1"+ hash));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(),"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(intentRecharge);
                }
            }
        });
        buyForGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRecharge = new Intent(Intent.ACTION_CALL);
                String number = phoneGiftNum.getText().toString();
                String hash = Uri.encode("#");
                String astrix = Uri.encode("*");

                if (number.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please Insert Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*5*3*1*" + number + astrix + 1 + hash));
                }
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getContext(), "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                } else {
                    startActivity(intentRecharge);
                }
                phoneGiftNum.setText("");
            }
        });
        cancelForGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        cancelForSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        packageDescription.setText(R.string.Monthly_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private TextWatcher transferTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (phoneGiftNum.getText().length() > 9) {
                buyForGift.setEnabled(true);
            } else buyForGift.setEnabled(false);

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
            String phoneNum = null;
            Uri uri = data.getData();
            cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            phoneNum = cursor.getString(phoneIndex);

            phoneGiftNum.setText(phoneNum.trim().replace("+251","0").replace("-","").replace(" ",""));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void requisitionPermissionContact(){
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_CONTACTS},1);
    }
    private void requisitionPermission(){
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);
    }
    public void changeOurTheme(){
        SharedPreferences sharedPreferencesTheme = getActivity().getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
        getThemeku = sharedPreferencesTheme.getString(themeku, "blue");

        assert getThemeku != null;
        switch (getThemeku) {
            case "blue":
                backgroundDialog.setBackgroundResource(R.drawable.bluecorner);
                buyForSelf.setBackgroundResource(R.drawable.blue);
                buyForGift.setBackgroundResource(R.drawable.selector_blue);
                selectContact.setBackgroundResource(R.drawable.contact);
                break;

        }
    }

    public void changeMyTheme(){
        SharedPreferences sharedPreferencesTheme = getActivity().getSharedPreferences(SHARED_PREFERTHEME, MODE_PRIVATE);
        getThemeku = sharedPreferencesTheme.getString(themeku, "blue");

        assert getThemeku != null;
        switch (getThemeku) {
            case "blue":
                dailyColor.setBackgroundResource(R.drawable.blue);
                weeklyColor.setBackgroundResource(R.drawable.blue);
                monthlyColor.setBackgroundResource(R.drawable.blue);
                openBuy10W.setBackgroundResource(R.drawable.blue);
                openBuy202W.setBackgroundResource(R.drawable.blue);
                openBuy50M.setBackgroundResource(R.drawable.blue);
                break;
        }
    }

}