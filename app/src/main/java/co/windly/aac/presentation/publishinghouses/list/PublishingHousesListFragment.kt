package co.windly.aac.presentation.publishinghouses.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.windly.aac.R
import co.windly.aac.data.domain.models.publishinghouses.PublishingHouse
import co.windly.aac.data.network.managers.publishinghouses.PublishingHousesNetworkManager
import co.windly.aac.presentation.base.BaseListFragment
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class PublishingHousesListFragment : BaseListFragment() {

  @Inject
  lateinit var networkManager: PublishingHousesNetworkManager

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_list, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.swipeRefresh.setOnRefreshListener { this.loadPublishingHouses() }
    this.swipeRefresh.isRefreshing = true
    this.loadPublishingHouses()
  }

  private fun loadPublishingHouses() {
    this.disposables += this.networkManager.getPublishingHouses()
      .doOnComplete { this.swipeRefresh.isRefreshing = false }
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { this.handlePublishingHouses(it) }
  }

  private fun handlePublishingHouses(covers: List<PublishingHouse>) {
    this.setItems(covers.map { PublishingHouseListItem(it) })
  }
}
