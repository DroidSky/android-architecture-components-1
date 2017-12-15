package co.windly.aac.ui.publishinghouses.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.windly.aac.R
import co.windly.aac.data.domain.models.publishinghouses.PublishingHouse
import co.windly.aac.data.network.managers.publishinghouses.PublishingHousesNetworkManager
import co.windly.aac.ui.base.DeprecatedBaseListFragment
import dagger.android.support.AndroidSupportInjection
import io.reactivex.Observable
import org.apache.commons.lang3.StringUtils
import java.util.*
import javax.inject.Inject

@Deprecated("mvvm-rewrite")
class DeprecatedPublishingHousesListFragment : DeprecatedBaseListFragment<PublishingHouse>(), PublishingHouseListItem.Handler {

  companion object {

    fun newInstance() = DeprecatedPublishingHousesListFragment()
  }

  @Inject
  lateinit var networkManager: PublishingHousesNetworkManager

  override val loadItemsObservable: Observable<List<PublishingHouse>>
    get() = this.networkManager.getPublishingHouses()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_list, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun mapItem(item: PublishingHouse): CompatibleListItem<PublishingHouse>
    = PublishingHouseListItem(item, this)

  override fun onDeleteClicked(identifier: Long) {
    this.deleteItem(this.networkManager.deletePublishingHouse(identifier), identifier)
  }

  override fun onSortButtonClicked() {
    Collections.sort(this.itemAdapter.adapterItems, { first, second ->
      run {
        val firstName = (first as PublishingHouseListItem).house.name
        val secondName = (second as PublishingHouseListItem).house.name
        StringUtils.compare(firstName, secondName)
      }
    })
    this.itemAdapter.fastAdapter.notifyAdapterDataSetChanged()
  }
}