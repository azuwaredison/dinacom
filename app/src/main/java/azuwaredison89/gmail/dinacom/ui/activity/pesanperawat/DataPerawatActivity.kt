package azuwaredison89.gmail.dinacom.ui.activity.pesanperawat

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.PesanPerawat
import azuwaredison89.gmail.dinacom.model.User
import azuwaredison89.gmail.dinacom.ui.activity.home.DashboardActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_data_perawat.*
import java.util.*

class DataPerawatActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERAWAT = "extra_perawat"
    }

    private var namePerawat: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_perawat)

        if (intent.hasExtra(EXTRA_PERAWAT)) {
            val perawatName = intent.getStringExtra(EXTRA_PERAWAT)
            perawatName?.let { namePerawat = it }
        }

        postDataPesanPerawat()
    }

    private fun postDataPesanPerawat() {
        val namaPemesan = data_nama.text.toString().trim()
        val dataAddressPemesan = data_alamat.text.toString().trim()
        val dataAgePemesan = data_usia.text.toString().trim()
        val dataTelp = data_telp.text.toString().trim()
        val dataKeluhan = data_keluhan.text.toString().trim()
        val dataJangkaWaktuRawat = data_jangka_waktu.text.toString().trim().toInt()

        val totalBiaya = 200000* dataJangkaWaktuRawat
        val totalBiayaRupiah = "Rp. $totalBiaya"
        total_biaya.text = totalBiayaRupiah

        perawat_pilih.text = namePerawat

        lanjutkan_perawat.setOnClickListener {
            if (namaPemesan.isEmpty() || dataAddressPemesan.isEmpty() || dataAgePemesan.isEmpty() ||
                    dataTelp.isEmpty() || dataKeluhan.isEmpty()) {
                Toast.makeText(this, "Tidak Boleh Ada Data Yang Kosong", Toast.LENGTH_SHORT).show()
            } else {
                val id = UUID.randomUUID().toString()
                val pesanPerawat = PesanPerawat(id, namaPemesan,  dataAgePemesan, dataTelp, dataKeluhan, dataJangkaWaktuRawat.toString())
                val db = FirebaseDatabase.getInstance()
                val rf = db.getReference("Pemesanan_Perawat").child(id)
                rf.setValue(pesanPerawat).addOnSuccessListener {
                    Toast.makeText(this@DataPerawatActivity, "Success Pesan Perawat", Toast.LENGTH_SHORT).show()
                    startActivity(
                            Intent(this, DashboardActivity::class.java)
                    )
                    this.finish()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed Pesan Perawat", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}