package com.danielg7.traders.domain.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielg7.common.utils.DataState
import com.danielg7.common.utils.ErrorResponse
import com.danielg7.traders.data.remote.model.Traders
import com.danielg7.traders.domain.usecases.TraderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class TraderViewModel @Inject constructor(private val useCase: TraderUseCase) : ViewModel() {

    var traders: List<Traders> by mutableStateOf(listOf())

    fun getTraders(
        onSuccess: (successResponse: List<Traders>) -> Unit,
        onError: (errorResponse: ErrorResponse) -> Unit,
        refresh: Boolean
    ) {
        useCase.getTraders(refresh)
            .onEach { response ->
                when (response) {
                    is DataState.Success -> {
                        onSuccess(response.data)
                        traders = response.data
                    }
                    is DataState.Error -> {
                        onError(response.error)
                    }
                    else -> Unit
                }
            }.launchIn(viewModelScope)
    }
}
