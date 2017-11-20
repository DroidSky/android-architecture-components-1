package co.windly.aac.presentation.covers.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.covers.Cover
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.item_covers_list.view.*

class CoverListItem(val cover: Cover) : AbstractItem<CoverListItem, CoverListItem.ViewHolder>() {

  override fun getLayoutRes(): Int = R.layout.item_covers_list

  override fun getType(): Int = R.id.item_covers_list

  override fun getIdentifier(): Long = this.cover.id

  override fun getViewHolder(view: View) = ViewHolder(view)

  class ViewHolder(view: View) : FastAdapter.ViewHolder<CoverListItem>(view) {

    override fun bindView(item: CoverListItem?, payloads: MutableList<Any>?) {
      this.itemView.name.text = item?.cover?.name
    }

    override fun unbindView(item: CoverListItem?) {
      this.itemView.name.text = null
    }
  }
}