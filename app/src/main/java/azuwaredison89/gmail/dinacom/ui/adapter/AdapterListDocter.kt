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
import azuwaredison89.gmail.dinacom.ui.activity.pesandokter.DaftarNamaDokterActivity
import azuwaredison89.gmail.dinacom.ui.activity.pesandokter.HargaDokterActivity
import com.google.firebase.database.ValueEventListener

class AdapterListDocter(private val context: Context, private val listaKategory: ArrayList<DataDoctor>) : RecyclerView.Adapter<AdapterListDocter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_nama_dokter, parent, false))
    }

    override fun getItemCount(): Int {
        return listaKategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  {
        holder.textViewNamaDocter.text = listaKategory[position].name_docter
        holder.textViewJadwalDocter.text = listaKategory[position].jadwal_docter
//
        holder.linearLayoutDocter.setOnClickListener {
            val intent = Intent(context, HargaDokterActivity::class.java)
            intent.putExtra("idDocter", listaKategory[position].id_docter)
            intent.putExtra("categoryDocter", listaKategory[position].category_docter)

            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewNamaDocter = itemView.findViewById<TextView>(R.id.textViewNamaDocter)!!
        var textViewJadwalDocter = itemView.findViewById<TextView>(R.id.textViewJadwalDocter)!!
        var linearLayoutDocter = itemView.findViewById<LinearLayout>(R.id.linearLayoutDocter)!!

    }
}