package azuwaredison89.gmail.dinacom.ui.activity.pesandokter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.CategoryDoctor
import azuwaredison89.gmail.dinacom.model.DataDoctor
import azuwaredison89.gmail.dinacom.ui.adapter.AdapterListDocter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_daftar_nama_dokter.*

class DaftarNamaDokterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_nama_dokter)

        getListDoctor()

    }

    fun getListDoctor() {
        val idcategory = intent.getStringExtra("idcategory") as String

        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("docter")
        val listDocter = mutableListOf<DataDoctor>()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                listDocter.clear()
                for (snap in p0.children) {
                    val user = snap.getValue(DataDoctor::class.java)
                    user?.let {
                        if (it.category_docter == idcategory){
                            listDocter.add(it)
                        }
                    }
                }

                val adapter = AdapterListDocter(this@DaftarNamaDokterActivity, listDocter as ArrayList<DataDoctor>)
                recyclerViewDataDocter.layoutManager = LinearLayoutManager(this@DaftarNamaDokterActivity, RecyclerView.VERTICAL, false)
                recyclerViewDataDocter.adapter = adapter
                adapter.notifyDataSetChanged()
//                view.onSuccess(listMember)
            }

            override fun onCancelled(p0: DatabaseError) {
//                view.onFailed(p0.message)
            }
        })
    }
}