package azuwaredison89.gmail.dinacom.ui.activity.pesandokter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.DataDoctor
import azuwaredison89.gmail.dinacom.model.SpecificCategoryDoctor
import azuwaredison89.gmail.dinacom.ui.adapter.AdapterListDocter
import azuwaredison89.gmail.dinacom.ui.adapter.AdapterListHargaDocter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_daftar_nama_dokter.*
import kotlinx.android.synthetic.main.activity_harga_dokter.*
import java.util.*

class HargaDokterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harga_dokter)

//        getListDoctorHarga()

    }

//    fun getListDoctorHarga() {
//        val idcategory = intent.getStringExtra("categoryDocter") as String
//        val idDoctor = intent.getStringExtra("idDocter") as String
//
//        val database = FirebaseDatabase.getInstance()
//        val ref = database.getReference("specific_category_doctor").child("79d8c39e-5a4b-11ea-8e2d-0242ac130003")
//        val listDocter = mutableListOf<SpecificCategoryDoctor>()
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(p0: DataSnapshot) {
//                listDocter.clear()
//                for (snap in p0.children) {
//                    val user = snap.getValue(SpecificCategoryDoctor::class.java)
//                    user?.let {
//                    }
//                }
//
//                Log.d("apacok", listDocter[1].name)
//
//                val adapter = AdapterListHargaDocter(this@HargaDokterActivity, idDoctor, idcategory, listDocter as ArrayList<SpecificCategoryDoctor>)
//                recyclerViewPilihPenyakit.layoutManager = LinearLayoutManager(this@HargaDokterActivity, RecyclerView.VERTICAL, false)
//                recyclerViewPilihPenyakit.adapter = adapter
//                adapter.notifyDataSetChanged()
////                view.onSuccess(listMember)
//            }
//
//            override fun onCancelled(p0: DatabaseError) {
////                view.onFailed(p0.message)
//            }
//        })
    }
}