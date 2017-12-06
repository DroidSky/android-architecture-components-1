package co.windly.aac.ui.authors.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.ui.base.DeprecatedBaseListFragment
import kotlinx.android.synthetic.main.item_authors_list.view.*

class AuthorListItem(
  val author: Author,
  private val handler: Handler
) : DeprecatedBaseListFragment.CompatibleListItem<Author>(author) {

  override fun getLayoutRes(): Int = R.layout.item_authors_list

  override fun getType(): Int = R.id.item_authors_list

  override fun getIdentifier(): Long = this.author.id

  override fun getViewHolder(view: View) = ViewHolder(view, this.handler)

  class ViewHolder(
    var view: View,
    private var handler: Handler
  ) : DeprecatedBaseListFragment.CompatibleListItem.ViewHolder<Author>(view) {

    override fun bindView(item: DeprecatedBaseListFragment.CompatibleListItem<Author>?, payloads: MutableList<Any>?) {
      this.itemView.firstName.text = item?.item?.firstName
      this.itemView.lastName.text = item?.item?.lastName
      this.itemView.deleteAuthor.setOnClickListener { this.handler.onDeleteClicked(requireNotNull(item).identifier) }
    }

    override fun unbindView(item: DeprecatedBaseListFragment.CompatibleListItem<Author>?) {
      this.itemView.firstName.text = null
      this.itemView.lastName.text = null
    }
  }

  interface Handler {

    fun onDeleteClicked(identifier: Long)
  }
}
