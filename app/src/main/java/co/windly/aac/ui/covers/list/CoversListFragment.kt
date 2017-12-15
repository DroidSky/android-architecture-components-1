package co.windly.aac.ui.covers.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import co.windly.aac.BR
import co.windly.aac.R
import co.windly.aac.databinding.FragmentMainCoversListBinding
import co.windly.aac.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_authors_list.*
import javax.inject.Inject

class CoversListFragment : BaseFragment<FragmentMainCoversListBinding, CoversListViewModel>(), CoversListNavigator,
  CoversListAdapter.CoversListAdapterListener {

  @Inject
  lateinit var coversListAdapter: CoversListAdapter

  @Inject
  lateinit var layoutManager: LinearLayoutManager

  private lateinit var fragmentMainCoversListBinding: FragmentMainCoversListBinding

  @Inject
  lateinit var coversListViewModel: CoversListViewModel

  companion object {
    fun newInstance() = CoversListFragment().apply { this.arguments = Bundle() }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.coversListAdapter.setListener(this)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.fragmentMainCoversListBinding = this.getViewDataBinding()
    this.setUp()
    this.subscribeToLiveData()
  }

  override fun getViewModel(): CoversListViewModel
    = this.coversListViewModel

  override fun getBindingVariable(): Int
    = BR.viewModel

  override fun getLayoutId(): Int
    = R.layout.fragment_main_covers_list

  override fun onDeleteClick(coverId: Long) {
    this.coversListViewModel.deleteCover(coverId)
  }

  override fun onRetryClick() {
    this.coversListViewModel.loadCovers()
  }

  private fun setUp() {
    this.layoutManager.orientation = LinearLayoutManager.VERTICAL
    this.fragmentMainCoversListBinding.recyclerView.layoutManager = this.layoutManager
    this.fragmentMainCoversListBinding.recyclerView.itemAnimator = DefaultItemAnimator()
    this.fragmentMainCoversListBinding.recyclerView.adapter = this.coversListAdapter
    this.swipeRefresh.setOnRefreshListener { this.coversListViewModel.loadCovers() }
  }

  private fun subscribeToLiveData() {
    coversListViewModel.getCoversListLiveData().observe(this, Observer { covers ->
      covers?.let { coversListViewModel.addCoverItemsToList(it) }
    })
  }
}
