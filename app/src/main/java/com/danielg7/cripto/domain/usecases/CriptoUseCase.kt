package com.danielg7.cripto.domain.usecases

import com.danielg7.cripto.data.repositories.CriptosRepository
import javax.inject.Inject

class CriptoUseCase @Inject constructor(private val repository: CriptosRepository) {

    fun getCriptos() = repository.getCriptos()
}
