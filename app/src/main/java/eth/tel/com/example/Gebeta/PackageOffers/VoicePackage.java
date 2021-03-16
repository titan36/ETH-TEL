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

public class VoicePackage extends Fragment {

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
    TextView dailyColor,weeklyColor,monthlyColor,nightColor;

    private static  final  int RESULT_PICK_CONTACT =1;
    // Button ID for Buy Click
    Button openBuy8D, openBuy13D,openBuy28D;
    Button openBuy46W, openBuy65W,openBuy100W;
    Button openBuy100M, openBuy166M,openBuy280M,openBuy415M,openBuy450M, openBuy600M,openBuy750M,openBuy830M;
    Button openBuy930M, openBuy1080M,openBuy1230M,openBuy1380M;
    Button openBuy30N, openBuy60N,openBuy120N,openBuy420N;

    EditText phoneGiftNum;
    Button buyForGift,cancelForSelf,cancelForGift,buyForSelf;
    CheckBox forGiftChecked;
    TextInputLayout rechargeField;
    ViewGroup tContainer;
    ImageView selectContact;
    TextView packageDescription;

    public static VoicePackage getInstance(){
        VoicePackage voicePackage = new VoicePackage();
        return voicePackage;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.voice_package, container,false);

        openBuy8D = view.findViewById(R.id.openBuy8D);
        openBuy13D = view.findViewById(R.id.openBuy13D);
        openBuy28D = view.findViewById(R.id.openBuy28D);
        //WEEKLY
        openBuy46W = view.findViewById(R.id.openBuy46W);
        openBuy65W = view.findViewById(R.id.openBuy65W);
        openBuy100W = view.findViewById(R.id.openBuy100W);
        //MONTHLY
        openBuy100M = view.findViewById(R.id.openBuy100M);
        openBuy166M = view.findViewById(R.id.openBuy166M);
        openBuy280M = view.findViewById(R.id.openBuy280M);
        openBuy415M = view.findViewById(R.id.openBuy415M);
        openBuy450M = view.findViewById(R.id.openBuy450M);
        openBuy600M = view.findViewById(R.id.openBuy600M);
        openBuy750M = view.findViewById(R.id.openBuy750M);
        openBuy830M = view.findViewById(R.id.openBuy830M);
        openBuy930M = view.findViewById(R.id.openBuy930M);
        openBuy1080M = view.findViewById(R.id.openBuy1080M);
        openBuy1230M = view.findViewById(R.id.openBuy1230M);
        openBuy1380M = view.findViewById(R.id.openBuy1380M);
        //NIGHT
        openBuy30N = view.findViewById(R.id.openBuy30N);
        openBuy60N = view.findViewById(R.id.openBuy60N);
        openBuy120N = view.findViewById(R.id.openBuy120N);
        openBuy420N = view.findViewById(R.id.openBuy420N);
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
        dailyColor = view.findViewById(R.id.dailyColorVoice);
        weeklyColor = view.findViewById(R.id.weeklyColorVoice);
        monthlyColor = view.findViewById(R.id.monthlyColorVoice);
        nightColor = view.findViewById(R.id.nightColorVoice);

        changeMyTheme();

        // Call The Dialog Box //:::::::::::::::::::::::::::::::::
        openBuy8D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy8D();
            }
        });
        openBuy13D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy13D();
            }
        });
        openBuy28D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy28D();
            }
        });

        openBuy46W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy46W();
            }
        });
        openBuy65W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy65W();
            }
        });
        openBuy100W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy100W();
            }
        });

        openBuy100M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy100M();
            }
        });
        openBuy166M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy166M();
            }
        });
        openBuy280M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy280M();
            }
        });
        openBuy415M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy415M();
            }
        });
        openBuy450M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy450M();
            }
        });
        openBuy600M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy600M();
            }
        });
        openBuy750M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy750M();
            }
        });
        openBuy830M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy830M();
            }
        });
        openBuy930M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy930M();
            }
        });
        openBuy1080M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1080M();
            }
        });
        openBuy1230M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1230M();
            }
        });
        openBuy1380M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy1380M();
            }
        });

        openBuy30N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy30N();
            }
        });
        openBuy60N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy60N();
            }
        });
        openBuy120N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy120N();
            }
        });
        openBuy420N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy420N();
            }
        });
        return view;
    }
    private void buy8D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*2*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*2*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Voice_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy13D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*2*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*2*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Voice_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy28D() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*2*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*2*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Daily_Voice_Package_for_24_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy46W() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*3*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*3*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_Voice_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy65W() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*3*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*3*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_Voice_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy100W() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*3*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*3*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Weekly_Voice_Package_for_7_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy100M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy166M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy280M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy415M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*4*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*4*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy450M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*5*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*5*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy600M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*6*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*6*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy750M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*7*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*7*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy830M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*8*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*8*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy930M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*9*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*9*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy1080M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*10*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*10*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy1230M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*11*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*11*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy1380M() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*4*12*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*4*12*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Monthly_Voice_Package_for_30_days);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }

    private void buy30N() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*1*1*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*1*1*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Night_Voice_Package_for_6_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy60N() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*1*2*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*1*2*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Night_Voice_Package_for_6_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy120N() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*1*3*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*1*3*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Night_Voice_Package_for_6_hours);
        dialog.setContentView(custom_dialog);
        dialog.show();
    }
    private void buy420N() {
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
                intentRecharge.setData(Uri.parse("tel:*999*2*1*1*1*4*1"+ hash));
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
                    intentRecharge.setData(Uri.parse("tel:*999*2*2*1*1*4*" + number + astrix + 1 + hash));
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
        packageDescription.setText(R.string.Night_Voice_Package_for_6_hours);
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
                openBuy8D.setBackgroundResource(R.drawable.blue);
                openBuy13D.setBackgroundResource(R.drawable.blue);
                openBuy28D.setBackgroundResource(R.drawable.blue);
                openBuy46W.setBackgroundResource(R.drawable.blue);
                openBuy65W.setBackgroundResource(R.drawable.blue);
                openBuy100W.setBackgroundResource(R.drawable.blue);
                openBuy100M.setBackgroundResource(R.drawable.blue);
                openBuy166M.setBackgroundResource(R.drawable.blue);
                openBuy280M.setBackgroundResource(R.drawable.blue);
                openBuy415M.setBackgroundResource(R.drawable.blue);
                openBuy450M.setBackgroundResource(R.drawable.blue);
                openBuy600M.setBackgroundResource(R.drawable.blue);
                openBuy750M.setBackgroundResource(R.drawable.blue);
                openBuy830M.setBackgroundResource(R.drawable.blue);
                openBuy930M.setBackgroundResource(R.drawable.blue);
                openBuy1080M.setBackgroundResource(R.drawable.blue);
                openBuy1230M.setBackgroundResource(R.drawable.blue);
                openBuy1380M.setBackgroundResource(R.drawable.blue);
                openBuy30N.setBackgroundResource(R.drawable.blue);
                openBuy60N.setBackgroundResource(R.drawable.blue);
                openBuy120N.setBackgroundResource(R.drawable.blue);
                openBuy420N.setBackgroundResource(R.drawable.blue);
                break;
        }
    }
}