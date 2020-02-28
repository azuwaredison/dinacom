package azuwaredison89.gmail.dinacom.ui.activity.pesandokter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import azuwaredison89.gmail.dinacom.R;

@RequiresApi(api = Build.VERSION_CODES.M)
public class DokterActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_dokter_umum, btn_dokter_gigi, btn_penyakit_dalam, btn_tht , btn_mata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter);

        btn_dokter_umum = findViewById(R.id.btn_dokter_umum);
        btn_dokter_gigi = findViewById(R.id.btn_dokter_gigi);
        btn_penyakit_dalam = findViewById(R.id.btn_penyakt_dalam);
        btn_tht = findViewById(R.id.btn_tht);
        btn_mata = findViewById(R.id.btn_mata);

        btn_dokter_umum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_dokter_gigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_penyakit_dalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_tht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_mata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dokter_umum:
                Intent intent = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_dokter_gigi:
                Intent u = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(u);
                break;

            case R.id.btn_penyakt_dalam:
                Intent dalam = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(dalam);
                break;

            case R.id.btn_tht:
                Intent tht = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(tht);
                break;

            case R.id.btn_mata:
                Intent mata = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(mata);
        }
    }
}
