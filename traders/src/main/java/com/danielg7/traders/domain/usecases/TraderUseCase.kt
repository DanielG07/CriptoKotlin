package com.danielg7.traders.domain.usecases

import com.danielg7.traders.data.repository.TradersRepository
import javax.inject.Inject

class TraderUseCase @Inject constructor(private val repository: TradersRepository) {

    fun getTraders(refresh: Boolean) = repository.getTraders(refresh)
}
