package azuwaredison89.gmail.dinacom.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.Perawat
import kotlinx.android.synthetic.main.list_nama_perawat.view.*

class ListPerawatAdapter(private val listPerawat: List<Perawat>) : RecyclerView.Adapter<ListPerawatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_nama_perawat, parent, false))
    }

    override fun getItemCount(): Int = listPerawat.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(listPerawat[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(perawat: Perawat) {
            with(itemView) {
                textViewNamaPerawat.text = perawat.nama
                textViewJadwalPerawat.text = perawat.jadwal
            }
        }
    }
}