package com.mrhabibi.autonomousdialog.sample;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mrhabibi.autonomousdialog.AutonomousDialog;
import com.mrhabibi.autonomousdialog.wrapper.BasicDialogWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAlertDialog = findViewById(R.id.button_alertdialog);
        Button buttonDialogFragment = findViewById(R.id.button_dialogfragment);
        Button buttonDialogActivity = findViewById(R.id.button_dialogactivity);
        Button buttonDialogFragmentActivity = findViewById(R.id.button_dialogfragmentactivity);

        buttonAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AutonomousDialog.builder(MainActivity.this)
                        .setContent(BasicDialogWrapper.newBuilder()
                                .message("Sample message")
                                .positiveText("OK")
                                .build())
                        .show();
            }
        });

        buttonDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AutonomousDialog.builder(MainActivity.this)
                        .setContent(new SampleDialogFragment())
                        .show();
            }
        });

        buttonDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AutonomousDialog.builder(MainActivity.this)
                        .setContent(SampleDialogActivity.class, null)
                        .show();
            }
        });

        buttonDialogFragmentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AutonomousDialog.builder(MainActivity.this)
                        .setContent(SampleDialogFragmentActivity.class, new SampleDialogFragment())
                        .show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
