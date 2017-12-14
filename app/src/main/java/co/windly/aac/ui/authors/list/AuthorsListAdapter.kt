package co.windly.aac.ui.authors.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.databinding.ItemAuthorsListBinding
import co.windly.aac.ui.base.BaseViewHolder

class AuthorsListAdapter : RecyclerView.Adapter<BaseViewHolder> {

  companion object {
    const val VIEW_TYPE_EMPTY = 0
    const val VIEW_TYPE_NORMAL = 1
  }

  private val authorsList: MutableList<Author>

  constructor(authorsList: List<Author>) {
    this.authorsList = mutableListOf<Author>().apply { this.addAll(authorsList) }
  }

  override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
    holder?.onBind(position)
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
    when (viewType) {
      VIEW_TYPE_NORMAL -> {
        val itemsAuthorsListBinding = ItemAuthorsListBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return AuthorViewHolder(itemsAuthorsListBinding)
      }
      else -> {
        throw IllegalArgumentException("Unknown view type.")
      }
    }
  }

  override fun getItemViewType(position: Int): Int
    = VIEW_TYPE_NORMAL

  override fun getItemCount(): Int
    = this.authorsList.size

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
      // TODO: Handle item removal.
    }
  }
}
