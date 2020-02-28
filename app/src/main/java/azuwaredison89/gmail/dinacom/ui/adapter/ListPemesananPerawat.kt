package azuwaredison89.gmail.dinacom.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import azuwaredison89.gmail.dinacom.R
import azuwaredison89.gmail.dinacom.model.PesanPerawat
import kotlinx.android.synthetic.main.item_pesan_perat.view.*

class ListPemesananPerawat(private val listItem: List<PesanPerawat>) : RecyclerView.Adapter<ListPemesananPerawat.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pesan_perat, parent, false))
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pemesan: PesanPerawat) {
            with(itemView) {
                textViewNamaPemesan.text = pemesan.nama
                textViewKeluhanPemesan.text = pemesan.keluhan
                this.setOnClickListener {
//                    context.startActivity(
//                            Intent(context, ).
//                    )
                }
            }
        }
    }
}