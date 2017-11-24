package co.windly.aac.presentation.publishinghouses.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.publishinghouses.PublishingHouse
import co.windly.aac.presentation.base.BaseListFragment
import kotlinx.android.synthetic.main.item_publishing_houses_list.view.*

class PublishingHouseListItem(val house: PublishingHouse, val handler: Handler)
  : BaseListFragment.CompatibleListItem<PublishingHouse>(house) {

  override fun getLayoutRes(): Int = R.layout.item_publishing_houses_list

  override fun getType(): Int = R.id.item_publishing_houses_list

  override fun getIdentifier(): Long = this.house.id

  override fun getViewHolder(view: View) = ViewHolder(view, this.handler)

  class ViewHolder(var view: View, var handler: Handler)
    : BaseListFragment.CompatibleListItem.ViewHolder<PublishingHouse>(view) {

    override fun bindView(item: BaseListFragment.CompatibleListItem<PublishingHouse>?, payloads: MutableList<Any>?) {
      this.itemView.name.text = item?.item?.name
      this.itemView.deletePublishingHouse.setOnClickListener {
        this.handler.onDeleteClicked(requireNotNull(item).identifier)
      }
    }

    override fun unbindView(item: BaseListFragment.CompatibleListItem<PublishingHouse>?) {
      this.itemView.name.text = null
    }
  }

  interface Handler {

    fun onDeleteClicked(identifier: Long)
  }
}
