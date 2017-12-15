package co.windly.aac.ui.empty

class EmptyItemViewModel {

  private val listener: EmptyItemViewModelListener

  constructor(listener: EmptyItemViewModelListener) {
    this.listener = listener
  }

  public fun onRetryClick() {
    this.listener.onRetryClick()
  }

  interface EmptyItemViewModelListener {
    fun onRetryClick()
  }
}