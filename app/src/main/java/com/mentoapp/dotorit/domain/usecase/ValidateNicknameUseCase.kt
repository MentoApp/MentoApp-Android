package com.mentoapp.dotorit.domain.usecase

import com.mentoapp.dotorit.domain.model.Nickname

class ValidateNicknameUseCase {

    sealed class ValidationResult {
        object Valid : ValidationResult()
        data class Invalid(val message: String) : ValidationResult()
    }

    operator fun invoke(nickname: String): ValidationResult {
        return when {
            nickname.length < Nickname.MIN_LENGTH -> {
                ValidationResult.Invalid("닉네임은 최소 ${Nickname.MIN_LENGTH}자 이상이어야 합니다.")
            }

            nickname.length > Nickname.MAX_LENGTH -> {
                ValidationResult.Invalid("닉네임은 최대 ${Nickname.MAX_LENGTH}자까지 가능합니다.")
            }
            // 추가적인 유효성 검사 규칙 (특수문자 금지 등)
            else -> ValidationResult.Valid
        }
    }
}