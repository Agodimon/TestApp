package com.example.testapp

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class EmailValidator : TextWatcher {
    internal var isValid = false
    override fun afterTextChanged(editableText: Editable) {
        isValid = isValidEmail(editableText)
    }

    override fun beforeTextChanged(
        s: CharSequence, start: Int, count: Int, after:
        Int
    ) = Unit

    override fun onTextChanged(
        s: CharSequence, start: Int, before: Int, count:
        Int
    ) = Unit

    companion object {
const val NAME_MAIL = "NAME_MAIL"

        /**
         * Паттерн для сравнения. */
        private val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        fun isValidEmail(email: CharSequence?): Boolean {
            return email != null && EMAIL_PATTERN.matcher(email).matches()
        }

        fun isArrayEmailsEquals(): Array<String> = arrayOf("one@mail.com", "two@mail.com", "three@mail.com")

        fun isEqualsNameEmail():String = "ex@mail.ru"

        fun isSameCheckOne(): String = NAME_MAIL
        fun isSameCheckTwo(): String = NAME_MAIL

        fun isNotSameEmail() = "agodimon@mail.ru"
    }
}