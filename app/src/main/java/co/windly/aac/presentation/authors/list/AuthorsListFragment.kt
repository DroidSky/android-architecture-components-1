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
import io.reactivex.Observable
import org.apache.commons.lang3.StringUtils
import java.util.*
import javax.inject.Inject

class AuthorsListFragment : BaseListFragment<Author>() {

  @Inject
  lateinit var networkManager: AuthorsNetworkManager

  override val loadItemsObservable: Observable<List<Author>>
    get() = this.networkManager.getAuthors()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_list, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun mapItem(item: Author): CompatibleListItem<Author> = AuthorListItem(item)

  override fun onSortButtonClicked() {
    Collections.sort(this.adapter.adapterItems, { first, second ->
      run {
        val firstAuthor = (first as AuthorListItem).let { "${it.author.firstName} ${it.author.lastName}" }
        val secondAuthor = (second as AuthorListItem).let { "${it.author.firstName} ${it.author.lastName}" }
        StringUtils.compare(firstAuthor, secondAuthor)
      }
    })
    this.adapter.fastAdapter.notifyAdapterDataSetChanged()
  }
}
