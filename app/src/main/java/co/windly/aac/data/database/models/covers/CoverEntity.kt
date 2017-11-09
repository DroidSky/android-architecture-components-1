package co.windly.aac.data.database.models.covers

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.apache.commons.lang3.StringUtils.EMPTY

@Entity(tableName = "covers")
data class CoverEntity(

  @ColumnInfo(name = "id")
  @PrimaryKey(autoGenerate = false)
  var id: Long,

  @ColumnInfo(name = "name")
  var name: String = EMPTY
)
