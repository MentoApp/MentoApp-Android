package com.mentoapp.dotorit.presentation.join.profile

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.mentoapp.dotorit.R
import com.mentoapp.dotorit.domain.usecase.ValidateNicknameUseCase
import com.mentoapp.dotorit.presentation.ui.theme.ProfileBackground1
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

    private val _selectedProfileImage = MutableStateFlow(R.drawable.img_profile_1)
    val selectedProfileImage = _selectedProfileImage.asStateFlow()

    private val _selectedBackgroundColor = MutableStateFlow(ProfileBackground1)
    val selectedBackgroundColor = _selectedBackgroundColor.asStateFlow()

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

    fun updateProfileImage(imageRes: Int) {
        _selectedProfileImage.value = imageRes
    }

    fun updateBackgroundColor(color: Color) {
        _selectedBackgroundColor.value = color
    }
}