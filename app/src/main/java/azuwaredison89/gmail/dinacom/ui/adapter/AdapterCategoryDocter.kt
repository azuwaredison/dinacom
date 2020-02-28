package azuwaredison89.gmail.dinacom.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.CategoryDoctor
import azuwaredison89.gmail.dinacom.ui.activity.pesandokter.DaftarNamaDokterActivity
import com.google.firebase.database.ValueEventListener

class AdapterCategoryDocter(private val context: Context, private val listaKategory: ArrayList<CategoryDoctor>) : RecyclerView.Adapter<AdapterCategoryDocter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_kategori_dokter, parent, false))
    }

    override fun getItemCount(): Int {
        return listaKategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  {
        holder.textViewKategoryDoctor.text = listaKategory[position].name
//
        holder.textViewKategoryDoctor.setOnClickListener {
            val intent = Intent(context, DaftarNamaDokterActivity::class.java)
            intent.putExtra("idcategory", listaKategory[position].id)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewKategoryDoctor = itemView.findViewById<TextView>(R.id.textViewKategoryDoctor)!!
    }
}