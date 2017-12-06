package co.windly.aac.ui.books.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.books.Book
import co.windly.aac.ui.base.DeprecatedBaseListFragment
import kotlinx.android.synthetic.main.item_books_list.view.*

class BookListItem(
  val book: Book,
  private val handler: Handler
) : DeprecatedBaseListFragment.CompatibleListItem<Book>(book) {

  override fun getLayoutRes(): Int = R.layout.item_books_list

  override fun getType(): Int = R.id.item_books_list

  override fun getIdentifier(): Long = this.book.id

  override fun getViewHolder(view: View) = ViewHolder(view, this.handler)

  class ViewHolder(
    var view: View,
    private var handler: Handler
  ) : DeprecatedBaseListFragment.CompatibleListItem.ViewHolder<Book>(view) {

    override fun bindView(item: DeprecatedBaseListFragment.CompatibleListItem<Book>?, payloads: MutableList<Any>?) {
      this.itemView.title.text = item?.item?.title
      this.itemView.deleteBook.setOnClickListener { this.handler.onDeleteClicked(requireNotNull(item).identifier) }
    }

    override fun unbindView(item: DeprecatedBaseListFragment.CompatibleListItem<Book>?) {
      this.itemView.title.text = null
    }
  }

  interface Handler {

    fun onDeleteClicked(identifier: Long)
  }
}
