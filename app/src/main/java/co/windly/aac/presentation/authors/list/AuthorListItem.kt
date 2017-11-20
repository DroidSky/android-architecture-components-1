package co.windly.aac.presentation.authors.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.presentation.base.BaseListFragment
import kotlinx.android.synthetic.main.item_authors_list.view.*

class AuthorListItem(val author: Author)
  : BaseListFragment.CompatibleListItem<Author>(author) {

  override fun getLayoutRes(): Int = R.layout.item_authors_list

  override fun getType(): Int = R.id.item_authors_list

  override fun getIdentifier(): Long = this.author.id

  override fun getViewHolder(view: View) = ViewHolder(view)

  class ViewHolder(view: View) : BaseListFragment.CompatibleListItem.ViewHolder<Author>(view) {

    override fun bindView(item: BaseListFragment.CompatibleListItem<Author>?, payloads: MutableList<Any>?) {
      this.itemView.firstName.text = item?.item?.firstName
      this.itemView.lastName.text = item?.item?.lastName
    }

    override fun unbindView(item: BaseListFragment.CompatibleListItem<Author>?) {
      this.itemView.firstName.text = null
      this.itemView.lastName.text = null
    }
  }
}
