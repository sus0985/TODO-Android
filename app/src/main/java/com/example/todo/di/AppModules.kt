package com.example.todo.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.todo.database.AppDatabase
import com.example.todo.model.Tag
import com.example.todo.repository.HomeRepository
import com.example.todo.ui.home.HomeViewModel
import com.example.todo.ui.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "TODO").addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    get<AppDatabase>().tagDao().insertTag(Tag(1,"TAG"))
                }
            }
        }).build()
    }

    single {
        get<AppDatabase>().tagDao()
    }

    single {
        HomeRepository(get())
    }
}

val viewModelModule = module {
    viewModel {
        MainViewModel()
    }
    viewModel {
        HomeViewModel(get())
    }
}
