package app.nexd.android.ui.helper.shoppingList

import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import app.nexd.android.R
import kotlinx.android.synthetic.main.row_help_request_article.view.*
import mva2.adapter.ItemBinder
import mva2.adapter.ItemViewHolder

class ShoppingListEntryBinder :
    ItemBinder<ShoppingListViewModel.ShoppingListEntry, ShoppingListEntryBinder.ViewHolder>() {

    class ViewHolder(itemView: View) :
        ItemViewHolder<ShoppingListViewModel.ShoppingListEntry>(itemView) {
        private val amount: TextView = itemView.textView_amount
        private val name: TextView = itemView.textView_name
        private val collect: CheckBox = itemView.checkbox_checked

        fun bind(entry: ShoppingListViewModel.ShoppingListEntry) {
            amount.text = itemView.context.getString(
                R.string.helper_request_article_amount_layout,
                entry.articleAmount
            )
            name.text = entry.articleName
            collect.isChecked = entry.isCollected
            collect.visibility = View.VISIBLE

            collect.setOnCheckedChangeListener { _, isChecked ->
                entry.isCollected = isChecked
                itemView.post {
                    toggleItemSelection()
                }
            }

            itemView.setOnClickListener {
                collect.isChecked = !collect.isChecked
            }
        }
    }

    override fun bindViewHolder(holder: ViewHolder, item: ShoppingListViewModel.ShoppingListEntry) {
        holder.bind(item)
    }

    override fun createViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            inflate(parent, R.layout.row_help_request_article)
        )
    }

    override fun canBindData(item: Any): Boolean {
        return item is ShoppingListViewModel.ShoppingListEntry
    }


}