package co.windly.aac.ui.covers.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.covers.Cover
import co.windly.aac.ui.base.DeprecatedBaseListFragment
import kotlinx.android.synthetic.main.item_covers_list.view.*

@Deprecated("mvvm-rewrite")
class CoverListItem(
  val cover: Cover,
  private val handler: Handler
) : DeprecatedBaseListFragment.CompatibleListItem<Cover>(cover) {

  override fun getLayoutRes(): Int = R.layout.item_covers_list

  override fun getType(): Int = R.id.item_covers_list

  override fun getIdentifier(): Long = this.cover.id

  override fun getViewHolder(view: View) = ViewHolder(view, this.handler)

  class ViewHolder(
    var view: View,
    private var handler: Handler
  ) : DeprecatedBaseListFragment.CompatibleListItem.ViewHolder<Cover>(view) {

    override fun bindView(item: DeprecatedBaseListFragment.CompatibleListItem<Cover>?, payloads: MutableList<Any>?) {
      this.itemView.name.text = item?.item?.name
      this.itemView.deleteCover.setOnClickListener { this.handler.onDeleteClicked(requireNotNull(item).identifier) }
    }

    override fun unbindView(item: DeprecatedBaseListFragment.CompatibleListItem<Cover>?) {
      this.itemView.name.text = null
    }
  }

  interface Handler {

    fun onDeleteClicked(identifier: Long)
  }
}
