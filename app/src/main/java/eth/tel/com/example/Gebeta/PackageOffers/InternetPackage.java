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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import eth.tel.com.example.R;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class InternetPackage extends Fragment {

    String ex = "Checker";
    String getChecker;
    String checker = "";

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
    TextView dailyColor,weeklyColor,monthlyColor,nightColor,weekendColor;

    private static  final  int RESULT_PICK_CONTACT =1;
    // Button ID for Buy Click
    Button openBuy25D, openBuy45D,openBuy100D,openBuy200D,openBuy500D, openBuy1GBD;
    Button openBuy250W, openBuy500W,openBuy700W,openBuy1GBW, openBuy2GBW;
    Button openBuy500M, openBuy1GBM,openBuy2GBM,openBuy4GBM,openBuy8GBM, openBuy10GBM,openBuy20GBM;
    Button openBuy50N, openBuy100N,openBuy160N;
    Button openBuy500WE, openBuy1GBWE,openBuy2GBWE;

    EditText phoneGiftNum;
    Button buyForGift,cancelForSelf,cancelForGift,buyForSelf;
    CheckBox forGiftChecked;
    TextInputLayout rechargeField;
    ViewGroup tContainer;
    ImageView selectContact;
    TextView packageDescription;

    public static InternetPackage getInstance(){
        InternetPackage internetPackage = new InternetPackage();
        return internetPackage;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.internet_package, container,false);

        // ID Name for Buy Click Code
        //DAILY
        openBuy25D = view.findViewById(R.id.openBuy25D);
        openBuy45D = view.findViewById(R.id.openBuy45D);
        openBuy100D = view.findViewById(R.id.openBuy100D);
        openBuy200D = view.findViewById(R.id.openBuy200D);
        openBuy500D = view.findViewById(R.id.openBuy500D);
        openBuy1GBD = view.findViewById(R.id.openBuy1GBD);
        //WEEKLY
        openBuy250W = view.findViewById(R.id.openBuy250W);
        openBuy500W = view.findViewById(R.id.openBuy500W);
        openBuy700W = view.findViewById(R.id.openBuy700W);
        openBuy1GBW = view.findViewById(R.id.openBuy1GBW);
        openBuy2GBW = view.findViewById(R.id.openBuy2GBW);
        //MONTHLY
        openBuy500M = view.findViewById(R.id.openBuy500M);
        openBuy1GBM = view.findViewById(R.id.openBuy1GBM);
        openBuy2GBM = view.findViewById(R.id.openBuy2GBM);
        openBuy4GBM = view.findViewById(R.id.openBuy4GBM);
        openBuy8GBM = view.findViewById(R.id.openBuy8GBM);
        openBuy10GBM = view.findViewById(R.id.openBuy10GBM);
        openBuy20GBM = view.findViewById(R.id.openBuy20GBM);
        //NIGHT
        openBuy50N = view.findViewById(R.id.openBuy50N);
        openBuy100N = view.findViewById(R.id.openBuy100N);
        openBuy160N = view.findViewById(R.id.openBuy160N);
        //WEEKEND
        openBuy500WE = view.findViewById(R.id.openBuy500WE);
        openBuy1GBWE = view.findViewById(R.id.openBuy1GBWE);
        openBuy2GBWE = view.findViewById(R.id.openBuy2GBWE);
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
        dailyColor = view.findViewById(R.id.dailyColorInternet);
        weeklyColor = view.findViewById(R.id.weeklyColorInternet);
        monthlyColor = view.findViewById(R.id.monthlyColorInternet);
        nightColor = view.findViewById(R.id.nightColorInternet);
        weekendColor = view.findViewById(R.id.weekendColorInternet);

        changeMyTheme();

        // Call The Dialog Box //:::::::::::::::::::::::::::::::::
        openBuy25D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy25D();
            }
        });
        openBuy45D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy45D();
            }
        });
        openBuy100D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy100D();
            }
        });
        openBuy200D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy200D();
            }
        });
        openBuy500D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy500D();
            }
        });
        openBuy1GBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1GBD();
            }
        });
        //WEEKLY
        openBuy250W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy250W();
            }
        });
        openBuy500W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy500W();
            }
        });
        openBuy700W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy700W();
            }
        });
        openBuy1GBW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1GBW();
            }
        });
        openBuy2GBW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy2GBW();
            }
        });
        //MONTHLY
        openBuy500M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy500M();
            }
        });
        openBuy1GBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1GBM();
            }
        });
        openBuy2GBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy2GBM();
            }
        });
        openBuy4GBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy4GBM();
            }
        });
        openBuy8GBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy8GBM();
            }
        });
        openBuy10GBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy10GBM();
            }
        });
        openBuy20GBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy20GBM();
            }
        });

        //NIGHT
        openBuy50N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy50N();
            }
        });
        openBuy100N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy100N();
            }
        });
        openBuy160N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy160N();
            }
        });
        //WEEKEND
        openBuy500WE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy500WE();
            }
        });
        openBuy1GBWE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1GBWE();
            }
        });
        openBuy2GBWE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy2GBWE();
            }
        });
        return view;
    }
    // Gift Code //::::::::::::::::::::::::::::::::::::::
    private void buy25D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*1*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*1*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Internet_Package_For_24_Hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy45D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*1*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*1*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Internet_Package_For_24_Hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy100D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*1*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*1*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Internet_Package_For_24_Hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy200D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*1*4*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*1*4*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Internet_Package_For_24_Hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy500D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*1*5*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*1*5*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Internet_Package_For_24_Hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy1GBD() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*1*6*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*1*6*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Internet_Package_For_24_Hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy250W() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*2*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*2*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_Internet_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy500W() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*2*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*2*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_Internet_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy700W() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*2*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*2*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_Internet_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy1GBW() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*2*4*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*2*4*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_Internet_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy2GBW() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*2*5*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*2*5*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_Internet_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy500M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*3*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*3*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Internet_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy1GBM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*3*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*3*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Internet_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy2GBM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*3*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*3*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Internet_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy4GBM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*3*4*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*3*4*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Internet_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy8GBM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*3*5*1"+ hash));
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*3*5*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Internet_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy10GBM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*3*6*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*3*6*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Internet_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy20GBM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*3*7*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*3*7*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Internet_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy30GBM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*3*8*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*3*8*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Internet_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy50N() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*4*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*4*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Night_Internet_Package_for_6_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy100N() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*4*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*4*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Night_Internet_Package_for_6_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy160N() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*4*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*4*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Night_Internet_Package_for_6_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy500WE() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*5*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*5*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekend_Internet_Package_for_2_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy1GBWE() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*5*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*5*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekend_Internet_Package_for_2_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy2GBWE() {
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

        changeOurTheme();
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*2*5*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*2*5*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekend_Internet_Package_for_2_days);
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
                nightColor.setBackgroundResource(R.drawable.blue);
                weekendColor.setBackgroundResource(R.drawable.blue);
                openBuy25D.setBackgroundResource(R.drawable.blue);
                openBuy45D.setBackgroundResource(R.drawable.blue);
                openBuy100D.setBackgroundResource(R.drawable.blue);
                openBuy200D.setBackgroundResource(R.drawable.blue);
                openBuy500D.setBackgroundResource(R.drawable.blue);
                openBuy1GBD.setBackgroundResource(R.drawable.blue);
                openBuy250W.setBackgroundResource(R.drawable.blue);
                openBuy500W.setBackgroundResource(R.drawable.blue);
                openBuy700W.setBackgroundResource(R.drawable.blue);
                openBuy1GBW.setBackgroundResource(R.drawable.blue);
                openBuy2GBW.setBackgroundResource(R.drawable.blue);
                openBuy500M.setBackgroundResource(R.drawable.blue);
                openBuy1GBM.setBackgroundResource(R.drawable.blue);
                openBuy2GBM.setBackgroundResource(R.drawable.blue);
                openBuy4GBM.setBackgroundResource(R.drawable.blue);
                openBuy8GBM.setBackgroundResource(R.drawable.blue);
                openBuy10GBM.setBackgroundResource(R.drawable.blue);
                openBuy20GBM.setBackgroundResource(R.drawable.blue);
                openBuy50N.setBackgroundResource(R.drawable.blue);
                openBuy100N.setBackgroundResource(R.drawable.blue);
                openBuy160N.setBackgroundResource(R.drawable.blue);
                openBuy500WE.setBackgroundResource(R.drawable.blue);
                openBuy1GBWE.setBackgroundResource(R.drawable.blue);
                openBuy2GBWE.setBackgroundResource(R.drawable.blue);
                break;
        }
    }
}