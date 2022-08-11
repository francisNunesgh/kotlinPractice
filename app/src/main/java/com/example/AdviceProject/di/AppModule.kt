package com.example.pratica.di

import com.example.pratica.repository.AdviceRepository
import com.example.pratica.repository.AdviceRepositoryImpl
import com.example.pratica.ui.viewmodel.AdviceViewModel
import com.example.pratica.webclient.service.AdviceService
import com.example.pratica.webclient.service.AdviceWebClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val URL_BASE = "https://api.adviceslip.com"

val retrofitModule = module {
    single<OkHttpClient> {
        val client = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
            client.addInterceptor(logging)
        }
        client.build()
    }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .client(get<OkHttpClient>())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}
val serviceModule = module {
    single<AdviceService> { get<Retrofit>().create(AdviceService::class.java) }
}

val webClientModule = module {
    single<AdviceWebClient> { AdviceWebClient(get<AdviceService>()) }
}

val repositoryModule = module {
    single<AdviceRepository> { AdviceRepositoryImpl(get<AdviceWebClient>()) }
}

val viewModelModule = module {
    viewModel<AdviceViewModel>{ AdviceViewModel(get<AdviceRepository>())}
}
