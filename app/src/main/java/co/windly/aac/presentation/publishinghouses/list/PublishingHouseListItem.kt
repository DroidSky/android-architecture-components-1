package co.windly.aac.presentation.publishinghouses.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.publishinghouses.PublishingHouse
import co.windly.aac.presentation.base.BaseListFragment
import kotlinx.android.synthetic.main.item_publishing_houses_list.view.*

class PublishingHouseListItem(val house: PublishingHouse)
  : BaseListFragment.CompatibleListItem<PublishingHouse>(house) {

  override fun getLayoutRes(): Int = R.layout.item_publishing_houses_list

  override fun getType(): Int = R.id.item_publishing_houses_list

  override fun getIdentifier(): Long = this.house.id

  override fun getViewHolder(view: View) = ViewHolder(view)

  class ViewHolder(view: View) : BaseListFragment.CompatibleListItem.ViewHolder<PublishingHouse>(view) {

    override fun bindView(item: BaseListFragment.CompatibleListItem<PublishingHouse>?, payloads: MutableList<Any>?) {
      this.itemView.name.text = item?.item?.name
    }

    override fun unbindView(item: BaseListFragment.CompatibleListItem<PublishingHouse>?) {
      this.itemView.name.text = null
    }
  }
}
