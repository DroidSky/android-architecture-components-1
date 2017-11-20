package co.windly.aac.presentation.base

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import co.windly.aac.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*


abstract class BaseListFragment<Item> : BaseFragment() {

  protected var adapter: ItemAdapter<AbstractItem<*, *>> = ItemAdapter()

  protected abstract val loadItemsObservable: Observable<List<Item>>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.setHasOptionsMenu(true)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return super.onCreateView(inflater, container, savedInstanceState).also {
      requireNotNull(this.recyclerView)
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.recyclerView.adapter = FastAdapter.with<IItem<*, *>, ItemAdapter<*>>(adapter)
    this.recyclerView.layoutManager = LinearLayoutManager(this.context)
    this.swipeRefresh.setOnRefreshListener { this.onRefresh() }
    this.swipeRefresh.isRefreshing = true
    this.loadItems()
  }

  override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
    inflater?.inflate(R.menu.list_menu, menu)
    super.onCreateOptionsMenu(menu, inflater)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    if (item?.itemId == R.id.sortItems) {
      this.onSortButtonClicked()
    }
    return super.onOptionsItemSelected(item)
  }

  open fun onRefresh() {
    this.loadItems()
  }

  open fun loadItems() {
    // No-op.
    this.disposables += this.loadItemsObservable
      .doOnComplete { this.swipeRefresh.isRefreshing = false }
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { this.handleLoadedItems(it) }
  }

  open fun handleLoadedItems(items: List<Item>) {
    this.setItems(items.map { this.mapItem(it) })
  }

  abstract fun mapItem(item: Item): CompatibleListItem<Item>

  open fun addItem(item: AbstractItem<*, *>) {
    this.adapter.add(item)
  }

  open fun addItems(items: List<AbstractItem<*, *>>) {
    this.adapter.add(items)
  }

  open fun setItems(items: List<AbstractItem<*, *>>) {
    this.adapter.setNewList(items)
  }

  open fun clearItems() {
    this.adapter.clear()
  }

  open fun removeItem(position: Int) {
    this.adapter.remove(position)
  }

  open fun onSortButtonClicked() {
    // No-op.
  }


  abstract class CompatibleListItem<out Item>(val item: Item) : AbstractItem<CompatibleListItem<*>, CompatibleListItem.ViewHolder<*>>() {

    abstract class ViewHolder<Item>(view: View) : FastAdapter.ViewHolder<CompatibleListItem<Item>>(view)
  }
}
