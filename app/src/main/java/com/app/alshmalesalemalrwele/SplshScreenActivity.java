package com.app.alshmalesalemalrwele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplshScreenActivity extends AppCompatActivity {
    Handler handler;


    @Override
    protected void onStart() {
        super.onStart();

        if (!verifyInstallerId(SplshScreenActivity.this)){
            Toast.makeText(this, "This Apk file might contain unsafe content. \n Make sure you trust the sender befor you open and install it.", Toast.LENGTH_SHORT).show();
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splsh_screen);


     //   Toast.makeText(this, "from googlePlay?" +verifyInstallerId(this), Toast.LENGTH_SHORT).show();

//        if (!verifyInstallerId(this)) {
//        new PiracyChecker(this)
//                .enableGooglePlayLicensing("BASE_64_LICENSE_KEY")
//                .start();





//        .callback(new PiracyCheckerCallback() {
//                @Override
//                public void allow() {
//                    // Do something when the user is allowed to use the app
//                }
//
//                @Override
//                public void doNotAllow(@NonNull PiracyCheckerError error, @Nullable PirateApp app) {
//                    // You can either do something specific when the user is not allowed to use the app
//                    // Or manage the error, using the 'error' parameter, yourself (Check errors at {@link PiracyCheckerError}).
//
//                    // Additionally, if you enabled the check of pirate apps and/or third-party stores, the 'app' param
//                    // is the app that has been detected on device. App can be null, and when null, it means no pirate app or store was found,
//                    // or you disabled the check for those apps.
//                    // This allows you to let users know the possible reasons why license is been invalid.
//
//                    Toast.makeText(SplshScreenActivity.this, "can not use app annnnn", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(SplshScreenActivity.this, "can not use app annnnn"+error.toString(), Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onError(@NonNull PiracyCheckerError error) {
//                    // This method is not required to be implemented/overridden but...
//                    // You can either do something specific when an error occurs while checking the license,
//                    // Or manage the error, using the 'error' parameter, yourself (Check errors at {@link PiracyCheckerError}).
//                }
//            })

   //  }
//        new PiracyChecker(this)
//                .enableGooglePlayLicensing("BASE_64_LICENSE_KEY")
//                .start();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplshScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    boolean verifyInstallerId(Context context) {
        // A list with valid installers package name
        List<String> validInstallers = new ArrayList<>(Arrays.asList("com.android.vending", "com.google.android.feedback"));
        // The package name of the app that has installed your app
        final String installer = context.getPackageManager().getInstallerPackageName(context.getPackageName());

        // true if your app has been downloaded from Play Store
        return installer != null && validInstallers.contains(installer);
    }
}