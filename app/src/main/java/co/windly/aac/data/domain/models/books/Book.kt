package co.windly.aac.data.domain.models.books

import org.apache.commons.lang3.StringUtils

data class Book(
  var id: Long = 0L,
  var title: String = StringUtils.EMPTY,
  var pages: Int = 0,
  var description: String = StringUtils.EMPTY,
  var isbn: String = StringUtils.EMPTY,
  var quantity: Int = 0,
  var coverId: Long = 0L,
  var authorId: Long = 0L,
  var publishingHouseId: Long = 0L
)
