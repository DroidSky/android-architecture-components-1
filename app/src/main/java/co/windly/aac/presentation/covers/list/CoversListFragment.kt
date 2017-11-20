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
import io.reactivex.Observable
import org.apache.commons.lang3.StringUtils
import java.util.*
import javax.inject.Inject

class CoversListFragment : BaseListFragment<Cover>() {

  @Inject
  lateinit var networkManager: CoversNetworkManager

  override val loadItemsObservable: Observable<List<Cover>>
    get() = this.networkManager.getCovers()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_list, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun mapItem(item: Cover): CompatibleListItem<Cover> = CoverListItem(item)

  override fun onSortButtonClicked() {
    Collections.sort(this.adapter.adapterItems, { first, second ->
      run {
        val firstName = (first as CoverListItem).cover.name
        val secondName = (second as CoverListItem).cover.name
        StringUtils.compare(firstName, secondName)
      }
    })
    this.adapter.fastAdapter.notifyAdapterDataSetChanged()
  }
}
