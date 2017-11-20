package co.windly.aac.presentation.books.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.books.Book
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.item_books_list.view.*

class BookListItem(val book: Book) : AbstractItem<BookListItem, BookListItem.ViewHolder>() {

  override fun getLayoutRes(): Int = R.layout.item_books_list

  override fun getType(): Int = R.id.item_books_list

  override fun getIdentifier(): Long = this.book.id

  override fun getViewHolder(view: View) = ViewHolder(view)

  class ViewHolder(view: View) : FastAdapter.ViewHolder<BookListItem>(view) {

    override fun bindView(item: BookListItem?, payloads: MutableList<Any>?) {
      this.itemView.title.text = item?.book?.title
    }

    override fun unbindView(item: BookListItem?) {
      this.itemView.title.text = null
    }
  }
}