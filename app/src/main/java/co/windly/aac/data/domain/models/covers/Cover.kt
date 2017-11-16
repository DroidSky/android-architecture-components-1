package co.windly.aac.data.domain.models.covers

import org.apache.commons.lang3.StringUtils

data class Cover(
  var id: Long = 0L,
  var name: String = StringUtils.EMPTY
)
