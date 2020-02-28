package azuwaredison89.gmail.dinacom.data;

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
import azuwaredison89.gmail.dinacom.puskesmas.DaftarNamaDokterActivity;
import azuwaredison89.gmail.dinacom.puskesmas.DokterActivity;

public class HargaDokterActivity extends AppCompatActivity {

    protected ListView list_harga;
    protected ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> mMap;
    ArrayList<HashMap<String, String>> list1;
    String[] nama1;
    String[] nama2;
    String[] nama3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harga_dokter);

        list_harga = (ListView) findViewById(R.id.list_harga);

        nama1 = new String[] {"Hipertensi", "Arthritis (radang sendi)", "Stroke", "Kanker", "Batu ginjal"};
        nama2 = new String[] {"Rp. 200.000", "Rp. 200.000", "Rp. 200.000", "Rp. 200.000", "Rp. 200.000"};
        nama3 = new String[] {Integer.toString(R.drawable.obat), Integer.toString(R.drawable.obat),
                Integer.toString(R.drawable.obat),
                Integer.toString(R.drawable.obat),
                Integer.toString(R.drawable.obat) };

        list1 = new ArrayList<HashMap<String,String>>();

        for (int i = 0; i < nama1.length; i++){
            mMap = new HashMap<String, String>();
            mMap.put("list", nama1[i]);
            mMap.put("latin", nama2[i]);
            mMap.put("gbr", nama3[i]);
            list1.add(mMap);
        }

        Adapter = new SimpleAdapter(this, list1, R.layout.list_harga_dokter,
                new String[] {"list", "latin", "gbr"}, new int[] {R.id.tv_judul, R.id.tv_harga, R.id.iv_icon});
        list_harga.setAdapter(Adapter);

        list_harga.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String nama_negara=list_harga.getItemAtPosition(position).toString();
                Intent intent= new Intent(getApplicationContext(),
                        DataDokterActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
