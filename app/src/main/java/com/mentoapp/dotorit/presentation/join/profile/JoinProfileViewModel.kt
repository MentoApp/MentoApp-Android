package com.mentoapp.dotorit.presentation.join.profile

import androidx.lifecycle.ViewModel
import com.mentoapp.dotorit.domain.usecase.ValidateNicknameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class JoinProfileViewModel(
    private val validateNicknameUseCase: ValidateNicknameUseCase
) : ViewModel() {

    private val _nickname = MutableStateFlow("")
    val nickname = _nickname.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    private val _buttonEnabled = MutableStateFlow(false)
    val buttonEnabled = _buttonEnabled.asStateFlow()

    fun validateNickname(nickname: String) {
        val result = validateNicknameUseCase(nickname)

        when (result) {
            is ValidateNicknameUseCase.ValidationResult.Valid -> {
                _nickname.value = nickname
                _errorMessage.value = null
                _buttonEnabled.value = true
            }

            is ValidateNicknameUseCase.ValidationResult.Invalid -> {
                _errorMessage.value = result.message
                _buttonEnabled.value = false
            }
        }
    }

    fun updateNickname(nickname: String) {
        _nickname.value = nickname
    }
}