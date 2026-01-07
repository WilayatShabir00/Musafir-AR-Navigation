package com.codingwithvedang.musafir;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;


import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.copySign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.codingwithvedang.musafir.arrendering.ARScene;
import com.codingwithvedang.musafir.arrendering.DirectionInstruction;
import com.codingwithvedang.musafir.arrendering.DisplayRotationHelper;
import com.codingwithvedang.musafir.device.CompassListener;
import com.codingwithvedang.musafir.device.WifiLocation;
import com.google.ar.sceneform.ux.ArFragment;

public class ARActivity extends AppCompatActivity  {
    WifiLocation wifiLocation;
    final String TAG = "ARActivity";
    int x,y,floor;

    private CompassListener compassListener;
    private DisplayRotationHelper dhelper;
    private ARScene navscene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        //Use a custom compass object to reduce
        compassListener = new CompassListener(this);
        dhelper = new DisplayRotationHelper(this);
        //Get Route
        Intent routeIntent = getIntent();
        ArrayList<DirectionInstruction> directionInstructions = (ArrayList<DirectionInstruction>) routeIntent.getSerializableExtra("Directions");
        //Instantiate the ARCore stuff
        ArFragment arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ARView);
        navscene = new ARScene(this,compassListener,arFragment,dhelper, directionInstructions);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle("Calibrating the AR");

        // set dialog message
        alertDialogBuilder
                .setMessage("Readings may not be accurate if phone is not calibrated in the Figure-8 pattern.")
                .setCancelable(false)
//                .setNegativeButton("DON'T SHOW THIS AGAIN", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                })
                .setPositiveButton("Calibrate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        //serverHandler.removeCallbacks(serverReqThread);
        navscene.destroy();
    }
}