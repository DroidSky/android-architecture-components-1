package co.windly.aac.ui.authors.list

import android.databinding.ObservableField
import co.windly.aac.data.domain.models.authors.Author

class AuthorsListItemViewModel {

  private val author: Author
  private val listener: AuthorsListItemViewModelListener
  val firstName: ObservableField<String>
  val lastName: ObservableField<String>

  constructor(author: Author, listener: AuthorsListItemViewModelListener) {
    this.author = author
    this.listener = listener
    this.firstName = ObservableField(author.firstName)
    this.lastName = ObservableField(author.lastName)
  }

  fun onDeleteClick() {
    this.listener.onDeleteClick(this.author.id)
  }

  interface AuthorsListItemViewModelListener {
    fun onDeleteClick(authorId: Long)
  }
}
