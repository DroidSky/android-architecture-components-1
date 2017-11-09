package co.windly.aac.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import co.windly.aac.data.database.daos.*
import co.windly.aac.data.database.models.authors.AuthorEntity
import co.windly.aac.data.database.models.books.BookEntity
import co.windly.aac.data.database.models.covers.CoverEntity
import co.windly.aac.data.database.models.publishinghouses.PublishingHouseEntity

@Database(
  version = 1,
  exportSchema = false,
  entities = arrayOf(
    AuthorEntity::class,
    BookEntity::class,
    CoverEntity::class,
    PublishingHouseEntity::class
  )
)
abstract class AndroidDatabase : RoomDatabase() {

  abstract fun databaseDao(): DatabaseDao

  abstract fun authorsDao(): AuthorsDao

  abstract fun booksDao(): BooksDao

  abstract fun coversDao(): CoversDao

  abstract fun publishingHousesDao(): PublishingHousesDao
}
