package azuwaredison89.gmail.dinacom.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.Perawat
import kotlinx.android.synthetic.main.list_nama_perawat.view.*

class ListPerawatAdapter(private val listPerawat: ArrayList<Perawat>) : RecyclerView.Adapter<ListPerawatAdapter.ViewHolder>() {

    private lateinit var onItemCallback: OnItemCallback

    interface OnItemCallback {
        fun onItemClicked(data: Perawat)
    }

    fun setOnClickCallback(onItemCallback: OnItemCallback){
        this.onItemCallback = onItemCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_nama_perawat, parent, false))
    }

    override fun getItemCount(): Int = listPerawat.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(listPerawat[position])
        holder.itemView.setOnClickListener { onItemCallback.onItemClicked(listPerawat[holder.adapterPosition]) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(perawat: Perawat) {
            with(itemView) {
                textViewNamaPerawat.text = perawat.nama
                textViewJadwalPerawat.text = perawat.ojadwal
            }
        }
    }
}