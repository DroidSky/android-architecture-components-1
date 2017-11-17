package co.windly.aac.presentation.covers.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.windly.aac.R
import co.windly.aac.data.domain.models.covers.Cover
import co.windly.aac.data.network.managers.covers.CoversNetworkManager
import co.windly.aac.presentation.base.BaseListFragment
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class CoversListFragment : BaseListFragment() {

  @Inject
  lateinit var networkManager: CoversNetworkManager

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_list, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.swipeRefresh.setOnRefreshListener { this.loadCovers() }
    this.swipeRefresh.isRefreshing = true
    this.loadCovers()
  }

  private fun loadCovers() {
    this.disposables += this.networkManager.getCovers()
      .doOnComplete { this.swipeRefresh.isRefreshing = false }
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { this.handleCovers(it) }
  }

  private fun handleCovers(covers: List<Cover>) {
    this.setItems(covers.map { CoverListItem(it) })
  }
}
