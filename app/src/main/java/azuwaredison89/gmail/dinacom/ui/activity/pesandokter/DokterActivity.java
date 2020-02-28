package azuwaredison89.gmail.dinacom.ui.activity.pesandokter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import azuwaredison89.gmail.dinacom.R;
import azuwaredison89.gmail.dinacom.ui.fragment.HomeFragment;

public class DokterActivity extends AppCompatActivity {
    Button btn_dokter_umum, btn_dokter_gigi, btn_penyakit_dalam, btn_tht , btn_mata, kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter);

        btn_dokter_umum = (Button) findViewById(R.id.btn_dokter_umum);
        btn_dokter_gigi = (Button) findViewById(R.id.btn_dokter_gigi);
        btn_penyakit_dalam = (Button) findViewById(R.id.btn_penyakt_dalam);
        btn_tht = (Button) findViewById(R.id.btn_tht);
        btn_mata = (Button) findViewById(R.id.btn_mata);


        kembali = (Button) findViewById(R.id.kembali);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(DokterActivity.this, HomeFragment.class);
                startActivity(k);
            }
        });

        btn_dokter_umum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(intent);
            }
        });

        btn_dokter_gigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(u);
            }
        });

        btn_penyakit_dalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dalam = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(dalam);
            }
        });

        btn_tht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tht = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(tht);
            }
        });

        btn_mata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mata = new Intent(DokterActivity.this, DaftarNamaDokterActivity.class);
                startActivity(mata);
            }
        });
    }
}
