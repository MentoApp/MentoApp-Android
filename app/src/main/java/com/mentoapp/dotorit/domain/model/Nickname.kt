package com.mentoapp.dotorit.domain.model

data class Nickname(
    val value: String
) {
    companion object {
        const val MIN_LENGTH = 2
        const val MAX_LENGTH = 10
    }
}