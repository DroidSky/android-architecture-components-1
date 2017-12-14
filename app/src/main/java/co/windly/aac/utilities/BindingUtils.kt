package co.windly.aac.utilities

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.ui.authors.list.AuthorsListAdapter

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
  }
}
