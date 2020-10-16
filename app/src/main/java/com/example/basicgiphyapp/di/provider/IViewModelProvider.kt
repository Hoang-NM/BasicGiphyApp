package com.example.basicgiphyapp.di.provider

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basicgiphyapp.ui.main.contract.MainViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class ViewModelFactory @Inject constructor(private val provideMap: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return provideMap.get(modelClass as Class<*>)?.get() as T?
            ?: throw RuntimeException(modelClass.simpleName + " haven't been added bind-map, check IViewModelProvider")
    }
}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class AndroidViewModelKey(val value: KClass<out AndroidViewModel>)

@Module
abstract class IViewModelProvider {
    @Binds
    abstract fun bindViewModelProviderFactory(vmf: ViewModelFactory): ViewModelProvider.Factory

    @AndroidViewModelKey(MainViewModel::class)
    @Binds
    @IntoMap
    abstract fun provideMainViewModel(vm: MainViewModel): AndroidViewModel

}