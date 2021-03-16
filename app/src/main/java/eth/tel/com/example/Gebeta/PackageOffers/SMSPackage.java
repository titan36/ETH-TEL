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

public class SMSPackage extends Fragment {

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
    Button openBuy18D, openBuy35D, openBuy70D;
    Button openBuy140W, openBuy283W;
    Button openBuy525M, openBuy1050M;

    EditText phoneGiftNum;
    Button buyForGift,cancelForSelf,cancelForGift,buyForSelf;
    CheckBox forGiftChecked;
    TextInputLayout rechargeField;
    ViewGroup tContainer;
    ImageView selectContact;
    TextView packageDescription;

    public static SMSPackage getInstance(){
        SMSPackage smsPackage = new SMSPackage();
        return smsPackage;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sms_package, container,false);

        openBuy18D = view.findViewById(R.id.openBuy18D);
        openBuy35D = view.findViewById(R.id.openBuy35D);
        openBuy70D = view.findViewById(R.id.openBuy70D);

        openBuy140W = view.findViewById(R.id.openBuy140W);
        openBuy283W = view.findViewById(R.id.openBuy283W);

        openBuy525M = view.findViewById(R.id.openBuy525M);
        openBuy1050M = view.findViewById(R.id.openBuy1050M);

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
        dailyColor = view.findViewById(R.id.dailyColor);
        weeklyColor = view.findViewById(R.id.weeklyColor);
        monthlyColor = view.findViewById(R.id.monthlyColor);

        changeMyTheme();

        // Call The Dialog Box //:::::::::::::::::::::::::::::::::
        openBuy18D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy18D();
            }
        });
        openBuy35D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy35D();
            }
        });
        openBuy70D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy70D();
            }
        });

        openBuy140W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy140W();
            }
        });
        openBuy283W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy283W();
            }
        });

        openBuy525M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy525M();
            }
        });
        openBuy1050M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1050M();
            }
        });

        return view;
    }
    private void buy18D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*3*1*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*3*1*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_SMS_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy35D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*3*1*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*3*1*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_SMS_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy70D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*3*1*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*3*1*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_SMS_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy140W() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*3*2*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*3*2*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_SMS_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy283W() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*3*2*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*3*2*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_SMS_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy525M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*3*3*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*3*3*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_SMS_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy1050M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*3*3*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*3*3*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_SMS_Package_for_30_days);
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
                dailyColor.setBackgroundResource(R.drawable.blue);
                weeklyColor.setBackgroundResource(R.drawable.blue);
                monthlyColor.setBackgroundResource(R.drawable.blue);
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
                openBuy18D.setBackgroundResource(R.drawable.blue);
                openBuy35D.setBackgroundResource(R.drawable.blue);
                openBuy70D.setBackgroundResource(R.drawable.blue);
                openBuy140W.setBackgroundResource(R.drawable.blue);
                openBuy283W.setBackgroundResource(R.drawable.blue);
                openBuy525M.setBackgroundResource(R.drawable.blue);
                openBuy1050M.setBackgroundResource(R.drawable.blue);
                break;

        }
    }
}
