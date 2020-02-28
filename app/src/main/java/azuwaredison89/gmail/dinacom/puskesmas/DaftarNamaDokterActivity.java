package azuwaredison89.gmail.dinacom.puskesmas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import azuwaredison89.gmail.dinacom.R;
import azuwaredison89.gmail.dinacom.data.DataDokterActivity;
import azuwaredison89.gmail.dinacom.data.HargaDokterActivity;

public class DaftarNamaDokterActivity extends AppCompatActivity {

    protected ListView lv;
    protected ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Pil;
    String[] Ltn;
    String[] Gbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_nama_dokter);

        lv = (ListView) findViewById(R.id.list_view);

        Pil = new String[] {"Dokter Mawang", "Dokter Yudis", "Dokter Alan", "Dokter Santo", "Dokter Lisa"};
        Ltn = new String[] {"Jam Kerja : 08.00 - 12.00", "Jam Kerja : 13.00 - 17.00",
                "Jam Kerja : 19.00 - 22.00", "Jam Kerja : 08.00 - 12.00", "Jam Kerja : 13.00 - 17.00"};
        Gbr = new String[] {Integer.toString(R.drawable.unnamed),
                Integer.toString(R.drawable.unnamed),
                Integer.toString(R.drawable.unnamed),
                Integer.toString(R.drawable.unnamed),
                Integer.toString(R.drawable.unnamed) };

        mylist = new ArrayList<HashMap<String,String>>();

        for (int i = 0; i < Pil.length; i++){
            map = new HashMap<String, String>();
            map.put("list", Pil[i]);
            map.put("latin", Ltn[i]);
            map.put("gbr", Gbr[i]);
            mylist.add(map);
        }

        Adapter = new SimpleAdapter(this, mylist, R.layout.list_nama_dokter,
                new String[] {"list", "latin", "gbr"}, new int[] {R.id.txt_judul, R.id.tv_ltn, R.id.imV});
        lv.setAdapter(Adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String nama_negara=lv.getItemAtPosition(position).toString();
                Intent intent= new Intent(getApplicationContext(),
                        HargaDokterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
