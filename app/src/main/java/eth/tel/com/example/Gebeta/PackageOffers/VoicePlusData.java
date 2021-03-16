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

public class VoicePlusData extends Fragment {

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
    TextView dailyColor,weeklyColor,monthlyColor;

    private static  final  int RESULT_PICK_CONTACT =1;
    // Button ID for Buy Click
    Button openBuy12VD, openBuy19VD,openBuy29VD, openBuy36VD, openBuy46VD,openBuy52VD;
    Button openBuy50VW, openBuy55VW,openBuy81VW, openBuy86VW, openBuy128VW,openBuy133VW;
    Button openBuy157VM, openBuy214VM,openBuy238VM, openBuy257VM, openBuy360VM,openBuy270VM;
    Button openBuy328VM, openBuy352VM,openBuy371VM, openBuy466VM, openBuy1514VM,openBuy1525VM;
    Button openBuy1549VM, openBuy1568VM,openBuy1663VM;

    EditText phoneGiftNum;
    Button buyForGift,cancelForSelf,cancelForGift,buyForSelf;
    CheckBox forGiftChecked;
    TextInputLayout rechargeField;
    ViewGroup tContainer;
    ImageView selectContact;
    TextView packageDescription;

    public static VoicePlusData getInstance(){
        VoicePlusData voicePlusData = new VoicePlusData();
        return voicePlusData;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.voice_plus_data, container, false);

        openBuy12VD = view.findViewById(R.id.openBuy12VD);
        openBuy19VD = view.findViewById(R.id.openBuy19VD);
        openBuy29VD = view.findViewById(R.id.openBuy29VD);
        openBuy36VD = view.findViewById(R.id.openBuy36VD);
        openBuy46VD = view.findViewById(R.id.openBuy46VD);
        openBuy52VD = view.findViewById(R.id.openBuy52VD);
        //WEEKLY
        openBuy50VW = view.findViewById(R.id.openBuy50VW);
        openBuy55VW = view.findViewById(R.id.openBuy55VW);
        openBuy81VW = view.findViewById(R.id.openBuy81VW);
        openBuy86VW = view.findViewById(R.id.openBuy86VW);
        openBuy128VW = view.findViewById(R.id.openBuy128VW);
        openBuy133VW = view.findViewById(R.id.openBuy133VW);
        //MONTHLY
        openBuy157VM = view.findViewById(R.id.openBuy157VM);
        openBuy214VM = view.findViewById(R.id.openBuy214VM);
        openBuy238VM = view.findViewById(R.id.openBuy238VM);
        openBuy257VM = view.findViewById(R.id.openBuy257VM);
        openBuy360VM = view.findViewById(R.id.openBuy360VM);
        openBuy270VM = view.findViewById(R.id.openBuy270VM);
        openBuy328VM = view.findViewById(R.id.openBuy328VM);
        openBuy352VM = view.findViewById(R.id.openBuy352VM);
        openBuy371VM = view.findViewById(R.id.openBuy371VM);
        openBuy466VM = view.findViewById(R.id.openBuy466VM);
        openBuy1514VM = view.findViewById(R.id.openBuy1514VM);
        openBuy1525VM = view.findViewById(R.id.openBuy1525VM);
        openBuy1549VM = view.findViewById(R.id.openBuy1549VM);
        openBuy1568VM = view.findViewById(R.id.openBuy1568VM);
        openBuy1663VM = view.findViewById(R.id.openBuy1663VM);

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
        dailyColor = view.findViewById(R.id.dailyColorVoiceData);
        weeklyColor = view.findViewById(R.id.weeklyColorVoiceData);
        monthlyColor = view.findViewById(R.id.monthlyColorVoiceData);

        changeMyTheme();

        // Call The Dialog Box //:::::::::::::::::::::::::::::::::
        openBuy12VD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy12VD();
            }
        });
        openBuy19VD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy19VD();
            }
        });
        openBuy29VD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy29VD();
            }
        });
        openBuy36VD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy36VD();
            }
        });
        openBuy46VD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy46VD();
            }
        });
        openBuy52VD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy52VD();
            }
        });

        openBuy50VW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy50VW();
            }
        });
        openBuy55VW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy55VW();
            }
        });
        openBuy81VW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy81VW();
            }
        });
        openBuy86VW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy86VW();
            }
        });
        openBuy128VW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy128VW();
            }
        });
        openBuy133VW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy133VW();
            }
        });

        openBuy157VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy157VM();
            }
        });
        openBuy214VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy214VM();
            }
        });
        openBuy238VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy238VM();
            }
        });
        openBuy257VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy257VM();
            }
        });
        openBuy360VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy360VM();
            }
        });
        openBuy270VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy270VM();
            }
        });
        openBuy328VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy328VM();
            }
        });
        openBuy352VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy352VM();
            }
        });
        openBuy371VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy371VM();
            }
        });
        openBuy466VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy466VM();
            }
        });
        openBuy1514VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1514VM();
            }
        });
        openBuy1525VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1525VM();
            }
        });
        openBuy1549VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1549VM();
            }
        });
        openBuy1568VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1568VM();
            }
        });
        openBuy1663VM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1663VM();
            }
        });
        return view;
    }

    private void buy12VD() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*1*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*1*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy19VD() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*1*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*1*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy29VD() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*1*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*1*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy36VD() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*1*4*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*1*4*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy46VD() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*1*5*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*1*5*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy52VD() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*1*6*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*1*6*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy50VW() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*2*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*2*1*" + number + astrix + 1 + hash));
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
    private void buy55VW() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*2*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*2*2*" + number + astrix + 1 + hash));
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
    private void buy81VW() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*2*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*2*3*" + number + astrix + 1 + hash));
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
    private void buy86VW() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*2*4*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*2*4*" + number + astrix + 1 + hash));
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
    private void buy128VW() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*2*5*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*2*5*" + number + astrix + 1 + hash));
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
    private void buy133VW() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*2*6*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*2*6*" + number + astrix + 1 + hash));
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

    private void buy157VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*1*" + number + astrix + 1 + hash));
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
    private void buy214VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*2*" + number + astrix + 1 + hash));
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
    private void buy238VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*3*" + number + astrix + 1 + hash));
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
    private void buy257VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*4*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*4*" + number + astrix + 1 + hash));
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
    private void buy360VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*5*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*5*" + number + astrix + 1 + hash));
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
    private void buy270VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*6*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*6*" + number + astrix + 1 + hash));
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
    private void buy328VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*7*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*7*" + number + astrix + 1 + hash));
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
    private void buy352VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*8*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*8*" + number + astrix + 1 + hash));
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
    private void buy371VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*9*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*9*" + number + astrix + 1 + hash));
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
    private void buy466VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*10*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*10*" + number + astrix + 1 + hash));
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
    private void buy1514VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*11*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*11*" + number + astrix + 1 + hash));
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
    private void buy1525VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*12*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*12*" + number + astrix + 1 + hash));
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
    private void buy1549VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*13*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*13*" + number + astrix + 1 + hash));
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
    private void buy1568VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*14*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*14*" + number + astrix + 1 + hash));
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
    private void buy1663VM() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*4*3*15*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*4*3*15*" + number + astrix + 1 + hash));
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
                openBuy12VD.setBackgroundResource(R.drawable.blue);
                openBuy19VD.setBackgroundResource(R.drawable.blue);
                openBuy29VD.setBackgroundResource(R.drawable.blue);
                openBuy36VD.setBackgroundResource(R.drawable.blue);
                openBuy46VD.setBackgroundResource(R.drawable.blue);
                openBuy52VD.setBackgroundResource(R.drawable.blue);
                openBuy50VW.setBackgroundResource(R.drawable.blue);
                openBuy55VW.setBackgroundResource(R.drawable.blue);
                openBuy81VW.setBackgroundResource(R.drawable.blue);
                openBuy86VW.setBackgroundResource(R.drawable.blue);
                openBuy128VW.setBackgroundResource(R.drawable.blue);
                openBuy133VW.setBackgroundResource(R.drawable.blue);
                openBuy157VM.setBackgroundResource(R.drawable.blue);
                openBuy214VM.setBackgroundResource(R.drawable.blue);
                openBuy238VM.setBackgroundResource(R.drawable.blue);
                openBuy257VM.setBackgroundResource(R.drawable.blue);
                openBuy360VM.setBackgroundResource(R.drawable.blue);
                openBuy270VM.setBackgroundResource(R.drawable.blue);
                openBuy328VM.setBackgroundResource(R.drawable.blue);
                openBuy352VM.setBackgroundResource(R.drawable.blue);
                openBuy371VM.setBackgroundResource(R.drawable.blue);
                openBuy466VM.setBackgroundResource(R.drawable.blue);
                openBuy1514VM.setBackgroundResource(R.drawable.blue);
                openBuy1525VM.setBackgroundResource(R.drawable.blue);
                openBuy1549VM.setBackgroundResource(R.drawable.blue);
                openBuy1568VM.setBackgroundResource(R.drawable.blue);
                openBuy1663VM.setBackgroundResource(R.drawable.blue);
                break;
        }
    }

}