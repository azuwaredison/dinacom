package azuwaredison89.gmail.dinacom.ui.activity.pesanperawat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import azuwaredison89.gmail.dinacom.R;

public class DaftarNamaPerawatActivity extends AppCompatActivity {

    protected ListView lv_perawat;
    protected ListAdapter adapter1;
    SimpleAdapter Adapter_perawat;
    HashMap<String, String> map_perawat;
    ArrayList<HashMap<String, String>> list_perawat;
    String[] perawat1;
    String[] perawat2;
    String[] perawat3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_nama_perawat);
        lv_perawat = (ListView) findViewById(R.id.listView_perawat);

        perawat1 = new String[] {"Perawat Sinta", "Perawat Susanti", "Perawat Hetty", "Perawat Cenni", "Perawat Siska"};
        perawat2= new String[] {"Jam Kerja : 08.00 - 12.00", "Jam Kerja : 12.00 - 17.00",
                "Jam Kerja : 19.00 - 00.00",
                "Jam Kerja : 08.00 - 16.00", "Jam Kerja : 17.00 - 00.00"};
        perawat3 = new String[] {Integer.toString(R.drawable.perawat3),
                Integer.toString(R.drawable.perawat3),
                Integer.toString(R.drawable.perawat3),
                Integer.toString(R.drawable.perawat3),
                Integer.toString(R.drawable.perawat3)};

        list_perawat = new ArrayList<HashMap<String,String>>();

        for (int i = 0; i < perawat1.length; i++){
            map_perawat = new HashMap<String, String>();
            map_perawat.put("list", perawat1[i]);
            map_perawat.put("latin", perawat2[i]);
            map_perawat.put("gbr", perawat3[i]);
            list_perawat.add(map_perawat);
        }

        Adapter_perawat = new SimpleAdapter(this, list_perawat, R.layout.list_nama_perawat,
                new String[] {"list", "latin", "gbr"}, new int[] {R.id.judul_perawat, R.id.ltn_perawat, R.id.iv_perawat});

        lv_perawat.setAdapter(Adapter_perawat);

        lv_perawat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String nama_negara=lv_perawat.getItemAtPosition(position).toString();
                Intent intent= new Intent(getApplicationContext(),
                        DataPerawatActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

