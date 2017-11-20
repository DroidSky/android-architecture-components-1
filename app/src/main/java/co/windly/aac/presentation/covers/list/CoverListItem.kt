package co.windly.aac.presentation.covers.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.covers.Cover
import co.windly.aac.presentation.base.BaseListFragment
import kotlinx.android.synthetic.main.item_covers_list.view.*

class CoverListItem(val cover: Cover)
  : BaseListFragment.CompatibleListItem<Cover>(cover) {

  override fun getLayoutRes(): Int = R.layout.item_covers_list

  override fun getType(): Int = R.id.item_covers_list

  override fun getIdentifier(): Long = this.cover.id

  override fun getViewHolder(view: View) = ViewHolder(view)

  class ViewHolder(view: View) : BaseListFragment.CompatibleListItem.ViewHolder<Cover>(view) {

    override fun bindView(item: BaseListFragment.CompatibleListItem<Cover>?, payloads: MutableList<Any>?) {
      this.itemView.name.text = item?.item?.name
    }

    override fun unbindView(item: BaseListFragment.CompatibleListItem<Cover>?) {
      this.itemView.name.text = null
    }
  }
}