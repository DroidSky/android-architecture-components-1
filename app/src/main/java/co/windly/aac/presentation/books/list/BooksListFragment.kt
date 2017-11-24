package co.windly.aac.presentation.books.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.windly.aac.R
import co.windly.aac.data.domain.models.books.Book
import co.windly.aac.data.network.managers.books.BooksNetworkManager
import co.windly.aac.presentation.base.BaseListFragment
import dagger.android.support.AndroidSupportInjection
import io.reactivex.Observable
import org.apache.commons.lang3.StringUtils
import java.util.*
import javax.inject.Inject

class BooksListFragment : BaseListFragment<Book>(), BookListItem.Handler {

  companion object {

    fun newInstance() = BooksListFragment()
  }

  @Inject
  lateinit var networkManager: BooksNetworkManager

  override val loadItemsObservable: Observable<List<Book>>
    get() = this.networkManager.getBooks()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_list, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun mapItem(item: Book): CompatibleListItem<Book> = BookListItem(item, this)

  override fun onDeleteClicked(identifier: Long) {
    this.deleteItem(this.networkManager.deleteBook(identifier), identifier)
  }

  override fun onSortButtonClicked() {
    Collections.sort(this.itemAdapter.adapterItems, { first, second ->
      run {
        val firstTitle = (first as BookListItem).book.title
        val secondTitle = (second as BookListItem).book.title
        StringUtils.compare(firstTitle, secondTitle)
      }
    })
    this.itemAdapter.fastAdapter.notifyAdapterDataSetChanged()
  }
}
