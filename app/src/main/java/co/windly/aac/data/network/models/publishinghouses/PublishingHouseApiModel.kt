package co.windly.aac.data.network.models.publishinghouses

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.StringUtils

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PublishingHouseApiModel(

  @get:JsonProperty("id")
  val id: Long = 0L,

  @get:JsonProperty("name")
  val name: String = StringUtils.EMPTY
)
