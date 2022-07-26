package com.danielg7.cripto.domain.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielg7.cripto.data.remote.models.Cripto
import com.danielg7.cripto.domain.usecases.CriptoUseCase
import com.danielg7.cripto.utils.DataState
import com.danielg7.cripto.utils.ErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CriptoViewModel @Inject constructor(private val useCase: CriptoUseCase) : ViewModel() {

    var criptos: List<Cripto> by mutableStateOf(listOf())

    fun getCriptos(
        onSuccess: (successResponse: List<Cripto>) -> Unit,
        onError: (errorResponse: ErrorResponse) -> Unit,
        refresh: Boolean
    ) {
        useCase.getCriptos(refresh)
            .onEach { response ->
                when (response) {
                    is DataState.Success -> {
                        onSuccess(response.data)
                        criptos = response.data
                    }
                    is DataState.Error -> {
                        onError(response.error)
                    }
                    else -> Unit
                }
            }.launchIn(viewModelScope)
    }
}
