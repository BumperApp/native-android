package space.bumper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

public class Registration extends AppCompatActivity {

    int toAdd = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final SeekBar seekAge = (SeekBar) findViewById(R.id.seekAge);
        final EditText txtAge = (EditText) findViewById(R.id.txtAge);
        txtAge.setText(Integer.toString(seekAge.getProgress() + toAdd));

        seekAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtAge.setText(Integer.toString(progress + toAdd));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        txtAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int currText = Integer.parseInt(s.toString());
                if (currText > 90) {
                    txtAge.setText("90");
                    seekAge.setProgress(90 - toAdd);
                } else if (currText < 16) {
                    txtAge.setText("16");
                    seekAge.setProgress(toAdd);
                } else {
                    seekAge.setProgress(currText - toAdd);
                }
            }
        });
    }
}
