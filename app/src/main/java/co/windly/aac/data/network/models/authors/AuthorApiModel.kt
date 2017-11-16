package co.windly.aac.data.network.models.authors

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.StringUtils

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AuthorApiModel(

  @get:JsonProperty("id")
  val id: Long = 0L,

  @get:JsonProperty("first_name")
  val firstName: String = StringUtils.EMPTY,

  @get:JsonProperty("last_name")
  val lastName: String = StringUtils.EMPTY
)
