package com.example.rootchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.rootchecker.RootChecker.RootBeer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RootBeer rootBeer = new RootBeer(this);
        if (rootBeer.isRooted() && rootBeer.isRootedWithBusyBoxCheck()) {
            //we found indication of root
            showRootedDialog(this);
        } else {
            //we didn't find indication of root
        }
    }

    public static void showRootedDialog(Context context) {
        final android.app.AlertDialog.Builder rootedBuilder = new android.app.AlertDialog.Builder(context);
        rootedBuilder.setTitle("Your Device is rooted.");
        rootedBuilder.setMessage("This device is rooted. You can't use this app.");
        rootedBuilder.setCancelable(false);
        rootedBuilder.show();
    }

}