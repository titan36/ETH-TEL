package eth.tel.com.example.Home;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import eth.tel.com.example.R;
import eth.tel.com.example.SecondPage.ETHTELActivity;
import eth.tel.com.example.SecondPage.ForwardActivity;
import eth.tel.com.example.SecondPage.WaitActivity;
import eth.tel.com.example.SecondPage.SettingsActivity;
import eth.tel.com.example.SecondPage.WebsiteActivity;

import static android.content.Context.MODE_PRIVATE;

public class SecondPage extends Fragment {

    ImageView forward, wait, etWebs, helpCenter, esTools, settings;

    String rn = "RemoveName";
    String getRemoveName;
    String removeName = "";

    TextView forwardingID,waitingID,websiteID,centerID,moreID,settingID;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.second_page,container,false );

        forward = view.findViewById(R.id.forwardCall);
        wait = view.findViewById(R.id.waitCall);
        etWebs = view.findViewById(R.id.etWebs);
        helpCenter  = view.findViewById(R.id.helpCenter);
        esTools = view.findViewById(R.id.esTools);
        settings = view.findViewById( R.id.settings );

        forwardingID = view.findViewById(R.id.forwardID);
        waitingID = view.findViewById(R.id.waitingID);
        websiteID = view.findViewById(R.id.websiteID);
        centerID = view.findViewById(R.id.centerID);
        moreID = view.findViewById(R.id.moreID);
        settingID = view.findViewById(R.id.settingID);

        RemoveName();

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForwardActivity();
            }
        });

        wait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWaitActivity();
            }
        });

        etWebs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent website = new Intent(getContext(),WebsiteActivity.class);
                startActivity(website);
            }
        });

        helpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpCenter = new Intent( Intent.ACTION_CALL);
                helpCenter.setData( Uri.parse("tel:994"));
                if (ActivityCompat.checkSelfPermission(getContext(),Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(),"Please Grant Permission", Toast.LENGTH_SHORT).show();
                    requisitionPermission();
                }
                else {
                    startActivity(helpCenter);
                }
            }
        });

        esTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEsTools();
            }
        });

        settings.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity();
            }
        } );

        return view;

    }

    public void openForwardActivity() {
        Intent settings = new Intent(getContext(), ForwardActivity.class);
        startActivity(settings);
    }

    public void openWaitActivity() {
        Intent settings = new Intent(getContext(), WaitActivity.class);
        startActivity(settings);
    }

    public void openEtWebs() {
        Intent web = new Intent(getContext(), WebsiteActivity.class);
        startActivity(web);
    }

    public void openEsTools() {
        Intent web = new Intent(getContext(), ETHTELActivity.class);
        startActivity(web);
    }

    public void openSettingsActivity() {
        Intent settings = new Intent(getContext(), SettingsActivity.class);
        startActivity(settings);
    }

    private void requisitionPermission(){
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);
    }
    public void RemoveName(){

        SharedPreferences sharedPreferencesRemoveName = getActivity().getSharedPreferences(rn, MODE_PRIVATE);
        getRemoveName = sharedPreferencesRemoveName.getString(removeName, "off");

        assert getRemoveName != null;
        if (getRemoveName.equals("on")) {
            forwardingID.setText(R.string.blank);
            forwardingID.setText(R.string.blank);
            waitingID.setText(R.string.blank);
            websiteID.setText(R.string.blank);
            centerID.setText(R.string.blank);
            moreID.setText(R.string.blank);
            settingID.setText(R.string.blank);
        }
        else if (getRemoveName.equals("off")) {
            forwardingID.setText(R.string.forwarding);
            waitingID.setText(R.string.waiting);
            websiteID.setText(R.string.website);
            centerID.setText(R.string.call_centers);
            moreID.setText(R.string.more);
            settingID.setText(R.string.mysettings);
        }
    }
}
