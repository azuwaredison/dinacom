package azuwaredison89.gmail.dinacom.ui.activity.pesanperawat

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.Perawat
import azuwaredison89.gmail.dinacom.ui.activity.pesanperawat.DataPerawatActivity.Companion.EXTRA_PERAWAT
import azuwaredison89.gmail.dinacom.ui.adapter.ListPerawatAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_daftar_nama_perawat.*


class DaftarNamaPerawatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_nama_perawat)
        getDataPerawat()
    }

    private fun getDataPerawat() {
        val listPerawat = ArrayList<Perawat>()
        val db = FirebaseDatabase.getInstance()
        val rf = db.getReference("Perawat")
        rf.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(this@DaftarNamaPerawatActivity, "Failed Load Data Perawat", Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snap in dataSnapshot.children) {
                    val perawat = snap.getValue(Perawat::class.java)!!
                    listPerawat.add(perawat)
                    recyclerViewPerawat.apply {
                        layoutManager = LinearLayoutManager(this@DaftarNamaPerawatActivity)
                        setHasFixedSize(true)
                        adapter = ListPerawatAdapter(listPerawat).apply {
                            setOnClickCallback(object : ListPerawatAdapter.OnItemCallback{
                                override fun onItemClicked(data: Perawat) {
                                    val intent =  Intent(this@DaftarNamaPerawatActivity, DataPerawatActivity::class.java).apply {
                                        putExtra(EXTRA_PERAWAT, perawat.nama)
                                    }
                                    startActivity(intent)
                                }

                            })
                        }
                    }
                }
            }
        })
    }
}