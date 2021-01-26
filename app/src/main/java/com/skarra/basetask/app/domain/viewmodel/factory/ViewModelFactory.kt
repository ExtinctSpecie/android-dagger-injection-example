package com.skarra.basetask.app.domain.viewmodel.factory

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory {

    fun <T : ViewModel> getViewModel(
        activity: AppCompatActivity,
        provideViewModel: () -> T,
        viewModelClass: Class<T>
    ): T {
        return ViewModelProvider(
            activity,
            Provider(
                provideViewModel
            )
        ).get(viewModelClass)
    }

    fun <T : ViewModel> getViewModel(
        fragment: Fragment,
        provideViewModel: () -> T,
        viewModelClass: Class<T>
    ): T {
        return ViewModelProvider(
            fragment,
            Provider(
                provideViewModel
            )
        ).get(viewModelClass)
    }

    private class Provider<T : ViewModel>(
        private val createViewModel: () -> T
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return createViewModel() as T
        }
    }

}

inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(noinline provideViewModel: () -> T): T {
    return ViewModelFactory().getViewModel(this, provideViewModel, T::class.java)
}

inline fun <reified T : ViewModel> Fragment.getViewModel(noinline provideViewModel: () -> T): T {
    return ViewModelFactory().getViewModel(this, provideViewModel, T::class.java)
}