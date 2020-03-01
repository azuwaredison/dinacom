package azuwaredison89.gmail.dinacom.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import azuwaredison89.gmail.dinacom.R;
//import azuwaredison89.gmail.dinacom.api.PrefManager;

public class PengaturanActivity extends AppCompatActivity {

    Button keluar, masukkan, bantuan;
    public static final String TAG_ID = "email";
    public static final String TAG_USERNAME = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        keluar = (Button) findViewById(R.id.keluar);
        masukkan = (Button) findViewById(R.id.masukkan);
        bantuan = (Button) findViewById(R.id.bantuan);

        bantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bantuan();
            }
        });

        masukkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Masukkan();
            }
        });

        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                PrefManager.getInstance(getApplicationContext()).logout();
            }
        });
    }

    private void Bantuan() {
        Intent intent = new Intent(PengaturanActivity.this, BantuanActivity.class);
        startActivity(intent);
    }

    private void Masukkan() {

    }
}
