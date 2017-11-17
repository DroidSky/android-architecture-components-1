package co.windly.aac.presentation.publishinghouses.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.publishinghouses.PublishingHouse
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.item_publishing_houses_list.view.*

class PublishingHouseListItem(private val house: PublishingHouse)
  : AbstractItem<PublishingHouseListItem, PublishingHouseListItem.ViewHolder>() {

  override fun getLayoutRes(): Int = R.layout.item_publishing_houses_list

  override fun getType(): Int = R.id.item_publishing_houses_list

  override fun getIdentifier(): Long = this.house.id

  override fun getViewHolder(view: View) = ViewHolder(view)

  class ViewHolder(view: View) : FastAdapter.ViewHolder<PublishingHouseListItem>(view) {

    override fun bindView(item: PublishingHouseListItem?, payloads: MutableList<Any>?) {
      this.itemView.name.text = item?.house?.name
    }

    override fun unbindView(item: PublishingHouseListItem?) {
      this.itemView.name.text = null
    }
  }
}