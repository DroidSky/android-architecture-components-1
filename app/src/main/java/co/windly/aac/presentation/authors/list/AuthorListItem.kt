package co.windly.aac.presentation.authors.list

import android.view.View
import co.windly.aac.R
import co.windly.aac.data.domain.models.authors.Author
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.item_authors_list.view.*

class AuthorListItem(val author: Author) : AbstractItem<AuthorListItem, AuthorListItem.ViewHolder>() {

  override fun getLayoutRes(): Int = R.layout.item_authors_list

  override fun getType(): Int = R.id.item_authors_list

  override fun getIdentifier(): Long = this.author.id

  override fun getViewHolder(view: View) = ViewHolder(view)

  class ViewHolder(view: View) : FastAdapter.ViewHolder<AuthorListItem>(view) {

    override fun bindView(item: AuthorListItem?, payloads: MutableList<Any>?) {
      this.itemView.firstName.text = item?.author?.firstName
      this.itemView.lastName.text = item?.author?.lastName
    }

    override fun unbindView(item: AuthorListItem?) {
      this.itemView.firstName.text = null
      this.itemView.lastName.text = null
    }
  }
}
