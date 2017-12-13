package co.windly.aac.ui.authors.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import co.windly.aac.BR
import co.windly.aac.R
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.databinding.FragmentMainAuthorsListBinding
import co.windly.aac.ui.base.BaseFragment
import javax.inject.Inject

class AuthorsListFragment : BaseFragment<FragmentMainAuthorsListBinding, AuthorsListViewModel>(), AuthorsListNavigator {

  @Inject
  lateinit var authorsListViewModel: AuthorsListViewModel

  companion object {
    fun newInstance() = AuthorsListFragment().apply { this.arguments = Bundle() }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.subscribeToLiveData()
  }

  override fun getViewModel(): AuthorsListViewModel
    = this.authorsListViewModel

  override fun getBindingVariable(): Int
    = BR.viewModel

  override fun getLayoutId(): Int
    = R.layout.fragment_main_authors_list

  private fun subscribeToLiveData() {
    authorsListViewModel.getAuthorsData().observe(this, Observer<List<Author>> { authors ->
      authors?.let { authorsListViewModel.setAuthorsDataList(it) }
    })
  }
}
