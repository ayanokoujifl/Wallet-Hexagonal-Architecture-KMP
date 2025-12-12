package com.luisleite.feature.wallet.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisleite.domain.usecase.CreateWalletUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class WalletViewModel(private val createWalletUseCase: CreateWalletUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(WalletUiState())
    val uiState = _uiState.asStateFlow()

    fun createWallet(userId: String) {
        viewModelScope.launch {
            createWalletUseCase(userId).onStart {
                _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            }.catch { error ->
                _uiState.value = _uiState.value.copy(isLoading = false, error = error.message ?: "Unknown Error")
            }.collect { wallet ->
                _uiState.value = _uiState.value.copy(isLoading = false, wallet = wallet, error = null)
            }
        }
    }
}