package azuwaredison89.gmail.dinacom.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.CategoryDoctor
import azuwaredison89.gmail.dinacom.model.DataDoctor
import azuwaredison89.gmail.dinacom.model.SpecificCategoryDoctor
import azuwaredison89.gmail.dinacom.ui.activity.pesandokter.DaftarNamaDokterActivity
import com.google.firebase.database.ValueEventListener

class AdapterListHargaDocter(private val context: Context, private val idDoctor: String ,  private val categoryDocter: String, private val listaKategory: ArrayList<SpecificCategoryDoctor>) : RecyclerView.Adapter<AdapterListHargaDocter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_harga_dokter, parent, false))
    }

    override fun getItemCount(): Int {
        return listaKategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  {
        holder.textSpesificPenyakit.text = listaKategory[position].name
        holder.textViewHarga.text = listaKategory[position].price
//
        holder.linearLayouHargat.setOnClickListener {
            val intent = Intent(context, DaftarNamaDokterActivity::class.java)
            intent.putExtra("idDocter", idDoctor)
            intent.putExtra("categoryDocter", categoryDocter)

            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textSpesificPenyakit = itemView.findViewById<TextView>(R.id.textSpesificPenyakit)!!
        var textViewHarga = itemView.findViewById<TextView>(R.id.textViewHarga)!!
        var linearLayouHargat = itemView.findViewById<LinearLayout>(R.id.linearLayouHargat)!!

    }
}