package azuwaredison89.gmail.dinacom.ui.activity.pesandokter;

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
import azuwaredison89.gmail.dinacom.model.Dokter;

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

        lv = findViewById(R.id.list_view);

        Gbr = new String[] {Integer.toString(R.drawable.unnamed),
                Integer.toString(R.drawable.unnamed),
                Integer.toString(R.drawable.unnamed),
                Integer.toString(R.drawable.unnamed),
                Integer.toString(R.drawable.unnamed) };

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
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String nama =
                Intent intent= new Intent(DaftarNamaDokterActivity.this, HargaDokterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private ArrayList<Dokter> listDokter() {
        ArrayList<Dokter> listDokter = new ArrayList<Dokter>();
        listDokter.add(new Dokter("Dokter Mamang", "08.00 - 12.00"));
        listDokter.add(new Dokter("Dokter Yudis", "13.00 - 15.00"));
        listDokter.add(new Dokter("Dokter Alan", "19.00 - 22.00"));
        listDokter.add(new Dokter("Dokter Santo", "08.00 - 12.00"));
        listDokter.add(new Dokter("Dokter Lisa", "13.00 - 17.00"));
        return listDokter;
    }
}
