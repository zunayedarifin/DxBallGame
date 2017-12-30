package com.example.zunay.dxballgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Zunayed on 12/28/2017.
 */

public class DXBallActivity extends Activity implements View.OnKeyListener {
    static int life=1;
    //static String currentLevel="Level 1";
    //StringBuilder builder = new StringBuilder();
    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        switch(event.getAction())
        {
            case KeyEvent.ACTION_DOWN:
                //builder.append("down, ");
                break;
            case KeyEvent.ACTION_UP:
                //builder.append("up, ");
                break;
        }
    	/*builder.append(event.getKeyCode());
    	builder.append(", ");
    	builder.append((char) event.getUnicodeChar());
    	String text = builder.toString();*/
        //return event.getKeyCode() != KeyEvent.KEYCODE_BACK;
        return true;
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String str = getIntent().getStringExtra("Level");
        //LoseActivity.currentLevel="level1";
        GameCanvas g= new GameCanvas(getApplicationContext(),str);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        g.setFocusableInTouchMode(true);
        g.requestFocus();
        setContentView(g);
    }
}
