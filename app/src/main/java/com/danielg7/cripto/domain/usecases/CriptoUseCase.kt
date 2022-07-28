package com.danielg7.cripto.domain.usecases

import com.danielg7.cripto.data.repositories.CriptosRepository
import javax.inject.Inject

class CriptoUseCase @Inject constructor(private val repository: CriptosRepository) {

    fun getCriptos(refresh: Boolean) = repository.getCriptos(refresh)
    fun buyCriptos(refresh: Boolean) = repository.buyCriptos(refresh)
}
