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
import azuwaredison89.gmail.dinacom.model.User;
import azuwaredison89.gmail.dinacom.ui.activity.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_login2;
    private EditText editTextUsername, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




//        if (PrefManager.getInstance(this).isLoggedIn()) {
//            finish();
//            startActivity(new Intent(this, LoginActivity.class));
//            return;
//        }

        editTextUsername = findViewById(R.id.ed_username);
        editTextEmail = findViewById(R.id.ed_email);
        editTextPassword = findViewById(R.id.ed_password);

        btn_login2 = findViewById(R.id.btn_login2);

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
        String username = editTextUsername.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Data Wajib Diisi", Toast.LENGTH_SHORT).show();
        } else {
            User user = new User(email, password, username);
            Fireba 
                Fireba ref = FirebaseDatabase.getInstance().getReference("profil").child(uid!!)
                val userMedia = mutableListOf(UserMedia("","",""))
                val dataUser = Users("", name!!, email!!, photo.toString(), "0","", userMedia)

                ref.setValue(dataUser).addOnSuccessListener {
                    val editor = sharedPreferences!!.edit()
                    editor.putString(Constanta.DATA_USER, Gson().toJson(dataUser))
                    editor.putBoolean(Constanta.LOGIN, true)
                    editor.apply()
                    view.onSuccess("Success")
                }.addOnFailureListener {
                    view.onFailed(it.localizedMessage!!)
                }

            }
    }

    public void login(View view){
        finish();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
