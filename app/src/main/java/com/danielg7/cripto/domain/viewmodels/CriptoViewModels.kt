package com.danielg7.cripto.domain.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielg7.cripto.data.remote.models.Payload
import com.danielg7.cripto.domain.usecases.CriptoUseCase
import com.danielg7.cripto.utils.DataState
import com.danielg7.cripto.utils.ErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CriptoViewModel @Inject constructor(private val useCase: CriptoUseCase) : ViewModel() {

    fun getCriptos(
        onSuccess: (successResponse: List<Payload>) -> Unit,
        onError: (errorResponse: ErrorResponse) -> Unit
    ) {
        useCase.getCriptos()
            .onEach { response ->
                when (response) {
                    is DataState.Success -> {
                        onSuccess(response.data)
                    }
                    is DataState.Error -> {
                        onError(response.error)
                    }
                    else -> Unit
                }
            }.launchIn(viewModelScope)
    }
}