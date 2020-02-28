package azuwaredison89.gmail.dinacom.ui.activity.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import azuwaredison89.gmail.dinacom.R;
import azuwaredison89.gmail.dinacom.api.PrefManager;
import azuwaredison89.gmail.dinacom.api.RequestHandler;

public class RegisterActivity extends AppCompatActivity {

    EditText ed_username, ed_email, ed_password;
    public static final String URL_REGISTER = "http://192.168.43.174/dashboard/user_mysql/register.php";

    private Button btn_login2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (PrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            return;
        }

        btn_login2 = findViewById(R.id.btn_login2);
        ed_username = findViewById(R.id.ed_username);
        ed_email = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);

        btn_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(k);
                finish();
            }
        });
    }

    public void register(View view){
        final String username = ed_username.getText().toString();
        final String email = ed_email.getText().toString();
        final String password = ed_password.getText().toString();

        if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Data Wajib Diisi", Toast.LENGTH_SHORT).show();
        }

     /*   if (TextUtils.isEmpty(username)) {
            ed_username.setError("Silahkan Masukkan Username");
            ed_username.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            ed_email.setError("Silahkan Masukkan Email");
            ed_email.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ed_email.setError("Silahkan Masukkan Email Yang Valid");
            ed_email.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            ed_password.setError("Silahkan Masukkan Password");
            ed_password.requestFocus();
            return;
        } */

        else {
            class Login extends AsyncTask<Void, Void, String> {
                ProgressDialog pdLoading = new ProgressDialog(RegisterActivity.this);

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();

                    //this method will be running on UI thread
                    pdLoading.setMessage("\tLoading...");
                    pdLoading.setCancelable(false);
                    pdLoading.show();
                }

                @Override
                protected String doInBackground(Void... voids) {
                    //creating request handler object
                    RequestHandler requestHandler = new RequestHandler();

                    //creating request parameters
                    HashMap<String, String> params = new HashMap<>();
                    params.put("email", email);
                    params.put("password", password);
                    params.put("username", username);

                    //returing the response
                    return requestHandler.sendPostRequest(URL_REGISTER, params);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    pdLoading.dismiss();
                    try {
                        //converting response to json object
                        JSONObject obj = new JSONObject(s);
                        //if no error in response
                        if (!obj.getBoolean("error")) {
                            Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(RegisterActivity.this, "Exception: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            }
            Login login = new Login();
            login.execute();
        }
    }

    public void login(View view){
        finish();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
