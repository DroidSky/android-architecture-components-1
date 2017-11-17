package co.windly.aac.presentation.authors.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.windly.aac.R
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.data.network.managers.authors.AuthorsNetworkManager
import co.windly.aac.presentation.base.BaseListFragment
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class AuthorsListFragment : BaseListFragment() {

  @Inject
  lateinit var networkManager: AuthorsNetworkManager

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_list, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.swipeRefresh.setOnRefreshListener { this.loadAuthors() }
    this.swipeRefresh.isRefreshing = true
    this.loadAuthors()
  }

  private fun loadAuthors() {
    this.disposables += this.networkManager.getAuthors()
      .doOnComplete { this.swipeRefresh.isRefreshing = false }
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { this.handleAuthors(it) }
  }

  private fun handleAuthors(authors: List<Author>) {
    this.setItems(authors.map { AuthorListItem(it) })
  }
}
