package co.windly.aac.ui.authors.list

class AuthorsListEmptyItemViewModel {

  private val listener: AuthorsListEmptyItemViewModelListener

  constructor(listener: AuthorsListEmptyItemViewModelListener) {
    this.listener = listener
  }

  fun onRetryClick() {
    this.listener.onRetryClick()
  }

  interface AuthorsListEmptyItemViewModelListener {
    fun onRetryClick()
  }
}
