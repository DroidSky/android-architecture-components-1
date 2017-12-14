package co.windly.aac.ui.authors.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.databinding.ItemAuthorsEmptyListBinding
import co.windly.aac.databinding.ItemAuthorsListBinding
import co.windly.aac.ui.base.BaseViewHolder

class AuthorsListAdapter : RecyclerView.Adapter<BaseViewHolder> {

  companion object {
    const val VIEW_TYPE_EMPTY = 0
    const val VIEW_TYPE_NORMAL = 1
  }

  private val authorsList: MutableList<Author>
  private lateinit var listener: AuthorsListAdapterListener

  constructor(authorsList: List<Author>) {
    this.authorsList = mutableListOf<Author>().apply { this.addAll(authorsList) }
  }

  override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
    holder?.onBind(position)
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
    return when (viewType) {
      VIEW_TYPE_NORMAL -> {
        val itemsAuthorsListBinding = ItemAuthorsListBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        AuthorViewHolder(itemsAuthorsListBinding)
      }
      VIEW_TYPE_EMPTY -> {
        val itemsAuthorsEmptyListBinding = ItemAuthorsEmptyListBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        EmptyAuthorViewHolder(itemsAuthorsEmptyListBinding)
      }
      else -> {
        throw IllegalArgumentException("Unknown view type.")
      }
    }
  }

  override fun getItemViewType(position: Int): Int
    = if (this.authorsList.isNotEmpty()) {
    VIEW_TYPE_NORMAL
  } else {
    VIEW_TYPE_EMPTY
  }

  override fun getItemCount(): Int
    = if (this.authorsList.isNotEmpty()) {
    this.authorsList.size
  } else {
    1
  }

  fun setListener(listener: AuthorsListAdapterListener) {
    this.listener = listener
  }

  fun addItems(authors: List<Author>) {
    this.authorsList.addAll(authors)
    this.notifyDataSetChanged()
  }

  fun clearItems() {
    this.authorsList.clear()
  }

  inner class AuthorViewHolder : BaseViewHolder, AuthorsListItemViewModel.AuthorsListItemViewModelListener {

    private lateinit var authorsListItemViewModel: AuthorsListItemViewModel
    private val binding: ItemAuthorsListBinding

    constructor(binding: ItemAuthorsListBinding) : super(binding.root) {
      this.binding = binding
    }

    override fun onBind(position: Int) {
      val author = authorsList[position]
      this.authorsListItemViewModel = AuthorsListItemViewModel(author, this)
      this.binding.viewModel = this.authorsListItemViewModel
      this.binding.executePendingBindings()
    }

    override fun onDeleteClick(authorId: Long) {
      listener.onDeleteClick(authorId)
    }
  }

  inner class EmptyAuthorViewHolder : BaseViewHolder, AuthorsListEmptyItemViewModel.AuthorsListEmptyItemViewModelListener {

    private val binding: ItemAuthorsEmptyListBinding

    constructor(binding: ItemAuthorsEmptyListBinding) : super(binding.root) {
      this.binding = binding
    }

    override fun onBind(position: Int) {
      this.binding.viewModel = AuthorsListEmptyItemViewModel(this)
    }

    override fun onRetryClick() {
      listener.onRetryClick()
    }
  }

  interface AuthorsListAdapterListener {

    fun onDeleteClick(authorId: Long)

    fun onRetryClick()
  }
}
