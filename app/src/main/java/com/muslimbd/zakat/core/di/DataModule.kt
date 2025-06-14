package com.muslimbd.zakat.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


//@Module
//@InstallIn(SingletonComponent::class)
//abstract class RepositoryModule{
//
//    @Singleton
//    @Binds
//    abstract fun bindTrackRepo(repo: TrackRepoImpl): TrackRepo
//}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

//    @Singleton
//    @Provides
//    fun provideDatabase(@ApplicationContext context: Context): MuslimDatabase {
//        return Room.databaseBuilder(
//            context.applicationContext,
//            MuslimDatabase::class.java,
//            "AlQuranDB.db"
//        ).fallbackToDestructiveMigration().build()
//    }
//
//
//    @Provides
//    fun provideQuranDao(database: MuslimDatabase): QuranDao = database.quranDao()
//
//    @Provides
//    fun provideSurahDao(database: MuslimDatabase): SurahDao = database.surahDao()

}