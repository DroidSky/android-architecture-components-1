package co.windly.aac.presentation.books.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.windly.aac.R
import co.windly.aac.presentation.base.BaseListFragment

class BooksListFragment : BaseListFragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_list, container, false)
}