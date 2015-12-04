package space.bumper;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameWrapper.getEditText().getText().toString();
                String password = passwordWrapper.getEditText().getText().toString();
                Toast.makeText(getApplicationContext(), username + " " + password, Toast.LENGTH_SHORT).show();
                try {
                    URL api = new URL("http://bumper.deecewan.me/login");
                    HttpURLConnection conn = (HttpURLConnection) api.openConnection();

                    conn.setDoOutput(true);
                    conn.setChunkedStreamingMode(0);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);

                } catch (IOException e) {
                    Log.e("SHIT", "onClick: fuck", e);
                } finally {
                    Toast.makeText(getApplicationContext(), "fuck", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(v.getContext(), Registration.class);
                v.getContext().startActivity(intent);

            }
        });

    }
}
