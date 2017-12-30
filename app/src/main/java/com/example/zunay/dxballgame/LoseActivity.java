package com.example.zunay.dxballgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {

    ImageButton image_button;
    Button main_menu_button;
    TextView textView_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        image_button=findViewById(R.id.button_image);
        main_menu_button=findViewById(R.id.main_menu);
        textView_score=findViewById(R.id.textView_score);

        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoseActivity.this,DXBallActivity.class);
                startActivity(intent);
            }
        });
        main_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoseActivity.this,MainMenu.class);
                startActivity(intent);
            }
        });
        textView_score.setText("Your Score is : "+String.valueOf(Stage.points));

    }
}
