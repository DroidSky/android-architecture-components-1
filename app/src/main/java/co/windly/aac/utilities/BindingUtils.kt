package co.windly.aac.utilities

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.data.domain.models.books.Book
import co.windly.aac.ui.authors.list.AuthorsListAdapter
import co.windly.aac.ui.books.list.BooksListAdapter

class BindingUtils private constructor() {

  companion object {

    @JvmStatic
    @BindingAdapter("adapter")
    fun addAuthorsListItems(recyclerView: RecyclerView, authors: ArrayList<Author>) {
      recyclerView.adapter?.let {
        val adapter = it as AuthorsListAdapter
        adapter.clearItems()
        adapter.addItems(authors)
      }
    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun addBooksListItems(recyclerView: RecyclerView, books: ArrayList<Book>) {
      recyclerView.adapter?.let {
        val adapter = it as BooksListAdapter
        adapter.clearItems()
        adapter.addItems(books)
      }
    }

    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisibility(view: View, visible: Boolean) {
      view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }
  }
}
