package azuwaredison89.gmail.dinacom.ui.activity.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import azuwaredison89.gmail.dinacom.R;
import azuwaredison89.gmail.dinacom.model.User;
import azuwaredison89.gmail.dinacom.ui.activity.home.DashboardActivity;
import azuwaredison89.gmail.dinacom.ui.activity.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.ed_username);
        editTextEmail = findViewById(R.id.ed_email);
        editTextPassword = findViewById(R.id.ed_password);

        Button btn_login2 = findViewById(R.id.btn_login2);

        btn_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(k);
                finish();
            }
        });
    }

    public void register(View view) {
        String username = editTextUsername.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please Enter Valid Data", Toast.LENGTH_SHORT).show();
        } else {
            String idUser = UUID.randomUUID().toString();
            User user = new User(idUser, email, password, username);
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference rf = db.getReference("User").child(idUser);
            rf.setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(RegisterActivity.this, "Success Register", Toast.LENGTH_SHORT).show();
                    startActivity(
                            new Intent(RegisterActivity.this, DashboardActivity.class)
                    );
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
