package co.windly.aac.data.domain.models.authors

import org.apache.commons.lang3.StringUtils

data class Author(
  var id: Long = 0L,
  var firstName: String = StringUtils.EMPTY,
  var lastName: String = StringUtils.EMPTY
)
