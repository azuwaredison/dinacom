package azuwaredison89.gmail.dinacom.ui.activity.pesandokter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.CategoryDoctor
import azuwaredison89.gmail.dinacom.ui.adapter.AdapterCategoryDocter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_dokter.*
import java.util.ArrayList

class DokterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dokter)

        getKategoriDoctor()
    }


    fun getKategoriDoctor() {
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("kategori_dokter")
        val listMember = mutableListOf<CategoryDoctor>()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                listMember.clear()
                for (snap in p0.children) {
                    val user = snap.getValue(CategoryDoctor::class.java)
                    user?.let {
                        listMember.add(it)
                    }
                }

                val adapter = AdapterCategoryDocter(this@DokterActivity, listMember as ArrayList<CategoryDoctor>)
                recyclerViewCategoryDocter.layoutManager = LinearLayoutManager(this@DokterActivity, RecyclerView.VERTICAL, false)
                recyclerViewCategoryDocter.adapter = adapter
                adapter.notifyDataSetChanged()
//                view.onSuccess(listMember)
            }

            override fun onCancelled(p0: DatabaseError) {
//                view.onFailed(p0.message)
            }
        })
    }
}