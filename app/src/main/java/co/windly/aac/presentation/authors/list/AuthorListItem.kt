package co.windly.aac.presentation.authors.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.presentation.base.BaseListFragment
import kotlinx.android.synthetic.main.item_authors_list.view.*

class AuthorListItem(val author: Author, val handler: Handler)
  : BaseListFragment.CompatibleListItem<Author>(author) {

  override fun getLayoutRes(): Int = R.layout.item_authors_list

  override fun getType(): Int = R.id.item_authors_list

  override fun getIdentifier(): Long = this.author.id

  override fun getViewHolder(view: View) = ViewHolder(view, this.handler)

  class ViewHolder(var view: View, var handler: Handler) : BaseListFragment.CompatibleListItem.ViewHolder<Author>(view) {

    override fun bindView(item: BaseListFragment.CompatibleListItem<Author>?, payloads: MutableList<Any>?) {
      this.itemView.firstName.text = item?.item?.firstName
      this.itemView.lastName.text = item?.item?.lastName
      this.itemView.deleteAuthor.setOnClickListener { this.handler.onDeleteClicked(requireNotNull(item).identifier) }
    }

    override fun unbindView(item: BaseListFragment.CompatibleListItem<Author>?) {
      this.itemView.firstName.text = null
      this.itemView.lastName.text = null
    }
  }

  interface Handler {

    fun onDeleteClicked(identifier: Long)
  }
}
