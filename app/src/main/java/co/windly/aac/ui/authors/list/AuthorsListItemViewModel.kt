package co.windly.aac.ui.authors.list

import android.databinding.ObservableField
import co.windly.aac.data.domain.models.authors.Author

class AuthorsListItemViewModel {

  private val author: Author
  private val listener: AuthorsListItemViewModelListener
  private val firstName: ObservableField<String>
  private val lastName: ObservableField<String>
  private val isDeleting: ObservableField<Boolean>

  constructor(author: Author, listener: AuthorsListItemViewModelListener) {
    this.author = author
    this.listener = listener
    this.firstName = ObservableField(author.firstName)
    this.lastName = ObservableField(author.lastName)
    this.isDeleting = ObservableField(false)
  }

  fun onDeleteClick() {
    this.listener.onDeleteClick(this.author.id)
    this.isDeleting.set(true)
  }

  fun getFirstName() = this.firstName

  fun getLastName() = this.lastName

  fun getIsDeleting() = this.isDeleting

  interface AuthorsListItemViewModelListener {
    fun onDeleteClick(authorId: Long)
  }
}
