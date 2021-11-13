package com.example.todo.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.todo.database.AppDatabase
import com.example.todo.model.Category
import com.example.todo.model.ColorCode
import com.example.todo.repository.HomeRepository
import com.example.todo.repository.HomeRepositoryImpl
import com.example.todo.repository.LocalDataSource
import com.example.todo.ui.home.HomeCategoryAdapter
import com.example.todo.ui.home.HomeViewModel
import com.example.todo.ui.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "TODO")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.IO).launch {
                        get<AppDatabase>().categoryDao()
                            .insertCategory(Category("TASK", ColorCode.LIGHT_BLUE, 0))
                        get<AppDatabase>().categoryDao()
                            .insertCategory(Category("PRIVATE", ColorCode.CHOCOLATE, 0))
                        get<AppDatabase>().categoryDao()
                            .insertCategory(Category("WISH LIST", ColorCode.PINK, 0))
                    }
                }
            }).build()
    }

    single {
        get<AppDatabase>().categoryDao()
    }

    single {
        HomeRepositoryImpl(get())
    }.bind(HomeRepository::class)

    single {
        LocalDataSource(get())
    }

    factory {
        HomeCategoryAdapter()
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
