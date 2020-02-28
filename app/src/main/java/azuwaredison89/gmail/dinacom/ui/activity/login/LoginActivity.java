package azuwaredison89.gmail.dinacom.ui.activity.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import azuwaredison89.gmail.dinacom.R;

import azuwaredison89.gmail.dinacom.ui.activity.register.RegisterActivity;
//
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        ed_email = findViewById(R.id.ed_email);
//        ed_password = findViewById(R.id.ed_password);
//        btn_register3 = findViewById(R.id.btn_register3);
//
//        btn_register3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent j = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(j);
//                finish();
//            }
//        });
    }

    public void register(View view){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}
