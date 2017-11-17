package co.windly.aac.presentation.base

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.fragment_list.*

abstract class BaseListFragment : BaseFragment() {

  private var adapter: ItemAdapter<AbstractItem<*, *>> = ItemAdapter()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return super.onCreateView(inflater, container, savedInstanceState).also {
      requireNotNull(this.recyclerView)
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.recyclerView.adapter = FastAdapter.with<IItem<*, *>, ItemAdapter<*>>(adapter)
    this.recyclerView.layoutManager = LinearLayoutManager(this.context)
  }

  fun addItem(item: AbstractItem<*, *>) {
    this.adapter.add(item)
  }

  fun addItems(items: List<AbstractItem<*, *>>) {
    this.adapter.add(items)
  }

  fun setItems(items: List<AbstractItem<*, *>>) {
    this.adapter.setNewList(items)
  }

  fun clearItems() {
    this.adapter.clear()
  }

  fun removeItem(position: Int) {
    this.adapter.remove(position)
  }
}
