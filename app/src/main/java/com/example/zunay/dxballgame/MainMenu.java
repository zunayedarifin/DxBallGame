package com.example.zunay.dxballgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    ImageButton imageButton7;
    ImageButton imageButton8;
    ImageButton imageButton9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        imageButton1=findViewById(R.id.level_1);
        imageButton2=findViewById(R.id.level_2);
        imageButton3=findViewById(R.id.level_3);
        imageButton4=findViewById(R.id.level_4);
        imageButton5=findViewById(R.id.level_5);
        imageButton6=findViewById(R.id.level_6);
        imageButton7=findViewById(R.id.level_7);
        imageButton8=findViewById(R.id.level_8);
        imageButton9=findViewById(R.id.level_9);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Level.current_level="Level 1";
                Intent intent = new Intent(MainMenu.this,DXBallActivity.class);
                startActivity(intent);

            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Level.current_level="Level 2";
                Intent intent = new Intent(MainMenu.this,DXBallActivity.class);
                startActivity(intent);

            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Level.current_level="Level 3";
                Intent intent = new Intent(MainMenu.this,DXBallActivity.class);
                startActivity(intent);

            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Level.current_level="Level 4";
                Intent intent = new Intent(MainMenu.this,DXBallActivity.class);
                startActivity(intent);

            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Level.current_level="Level 5";
                Intent intent = new Intent(MainMenu.this,DXBallActivity.class);
                startActivity(intent);

            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Level.current_level="Level 6";
                Intent intent = new Intent(MainMenu.this,DXBallActivity.class);
                startActivity(intent);

            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Level.current_level="Level 7";
                Intent intent = new Intent(MainMenu.this,DXBallActivity.class);
                startActivity(intent);

            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Level.current_level="Level 8";
                Intent intent = new Intent(MainMenu.this,DXBallActivity.class);
                startActivity(intent);

            }
        });
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Level.current_level="Level 9";
                Intent intent = new Intent(MainMenu.this,DXBallActivity.class);
                startActivity(intent);

            }
        });
    }


}
