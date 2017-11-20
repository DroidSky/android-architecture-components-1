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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*
import org.apache.commons.lang3.StringUtils
import java.util.*
import javax.inject.Inject

class BooksListFragment : BaseListFragment() {

  @Inject
  lateinit var networkManager: BooksNetworkManager

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_list, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.swipeRefresh.setOnRefreshListener { this.loadBooks() }
    this.swipeRefresh.isRefreshing = true
    this.loadBooks()
  }

  override fun onSortButtonClicked() {
    Collections.sort(this.adapter.adapterItems, { first, second ->
      run {
        val firstTitle = (first as BookListItem).book.title
        val secondTitle = (second as BookListItem).book.title
        StringUtils.compare(firstTitle, secondTitle)
      }
    })
    this.adapter.fastAdapter.notifyAdapterDataSetChanged()
  }

  private fun loadBooks() {
    this.disposables += this.networkManager.getBooks()
      .doOnComplete { this.swipeRefresh.isRefreshing = false }
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { this.handleBooks(it) }
  }

  private fun handleBooks(books: List<Book>) {
    this.setItems(books.map { BookListItem(it) })
  }
}
