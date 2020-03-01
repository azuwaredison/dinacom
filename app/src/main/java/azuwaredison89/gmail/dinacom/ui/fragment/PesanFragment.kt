package azuwaredison89.gmail.dinacom.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.PesanPerawat
import azuwaredison89.gmail.dinacom.ui.adapter.ListPemesananPerawat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_pesan.*

/**
 * A simple [Fragment] subclass.
 */

class PesanFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewPerawatPesan.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = ListPemesananPerawat(getListPerawatPesan())
        }
    }

    private fun getListPerawatPesan(): List<PesanPerawat> {
        val listPesan = mutableListOf<PesanPerawat>()
        val db = FirebaseDatabase.getInstance()
        val rf = db.getReference("Pemesanan_Perawat")
        rf.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(activity, "Failed Load Data Perawat", Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listPesan.clear()
                for (snap in dataSnapshot.children) {
                    val perawatPesanan = snap.getValue(PesanPerawat::class.java)!!
                    listPesan.add(perawatPesanan)
                }
            }
        })
        return listPesan
    }
}