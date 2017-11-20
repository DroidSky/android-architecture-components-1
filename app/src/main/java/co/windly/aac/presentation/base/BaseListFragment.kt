package co.windly.aac.presentation.base

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import co.windly.aac.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.fragment_list.*


abstract class BaseListFragment : BaseFragment() {

  protected var adapter: ItemAdapter<AbstractItem<*, *>> = ItemAdapter()

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
}
