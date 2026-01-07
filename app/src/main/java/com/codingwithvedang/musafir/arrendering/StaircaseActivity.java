package com.codingwithvedang.musafir.arrendering;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.codingwithvedang.musafir.ARActivity;
import com.codingwithvedang.musafir.R;

import java.io.Serializable;
import java.util.ArrayList;

public class StaircaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staircase);
        Intent intent = getIntent();
        ArrayList<DirectionInstruction> dirInst = (ArrayList<DirectionInstruction>) intent.getSerializableExtra("instructions");
        Button btn = (Button)findViewById(R.id.ClimbFinished);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arIntent = new Intent(StaircaseActivity.this, ARActivity.class);
                arIntent.putExtra("Directions",(Serializable)dirInst);
                startActivity(arIntent);
            }
        });
    }
}
