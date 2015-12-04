package space.bumper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String emojiThumb = new String(Character.toChars(0x1F44D));
    String emojiOkay = new String(Character.toChars(0x1F44C));
    String emojiFingerRight = new String(Character.toChars(0x1F448));
    String emojiWink = new String(Character.toChars(0x1F609));

    public String[] bumpStrings = {"Press to Bump!", "Happy Humping! " + emojiThumb, "Not Bad... " + emojiOkay, "Giggity. " + emojiOkay  + emojiFingerRight, "Stay Safe. " + emojiWink};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Random num = new Random();

        final TextSwitcher txtBumpSwitch = (TextSwitcher) findViewById(R.id.txtBump);
        txtBumpSwitch.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView myText = new TextView(MainActivity.this);
                myText.setTextSize(30);
                myText.setTextColor(Color.WHITE);
                return myText;
            }
        });
        txtBumpSwitch.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        txtBumpSwitch.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        txtBumpSwitch.setText(bumpStrings[0]);

        final ImageButton btnBump = (ImageButton) findViewById(R.id.btnBump);
        btnBump.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Button Down", "Debug");
                        // this is where the 'ping' api call should be made
                        btnBump.setImageResource(R.drawable.bumpactive);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.d("Button Up", "Debug");
                        // this is where we should say 'Happy Humping'...so let's make it so.
                        int choice = num.nextInt(4) + 1;
                        txtBumpSwitch.setText(bumpStrings[choice]);
                        btnBump.setImageResource(R.drawable.bump);
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txtBumpSwitch.setText(bumpStrings[0]);
                            }
                        }, 5000);
                        return true;
                }
                return false;
            }
        });
    }
}
