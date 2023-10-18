package com.example.a2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// successful push

public class MainActivity extends AppCompatActivity {

    Button btn_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView main_text = findViewById(R.id.textView);
        Button btn_second = findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showInfo(main_text.getText().toString(), btn_second);
                showInfoAlert("Do you want close?");

            }
        });
    }

    public void btnClick(View v){
        showInfo(((Button)v).getText().toString(), ((Button)v));
    }

    private void showInfoAlert(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Help message")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Of-course!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showInfo(String text, Button btn){
        btn.setText("Already changed");
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        Toast.makeText(this,text, Toast.LENGTH_LONG).show();
    }
}