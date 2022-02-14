package com.example.testapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class EmailValidatorTest {
@Test
fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
    assertTrue(EmailValidator.isValidEmail("name@email.com"))
}

@Test
fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
    assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
}

@Test
fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail("name@email"))
}

@Test
fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail("name@email..com"))
}

@Test
fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail("@email.com"))
}

@Test
fun emailValidator_EmptyString_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail(""))
}

@Test
fun emailValidator_NullEmail_ReturnsFalse() {
    assertFalse(EmailValidator.isValidEmail(null))
}


@Test
fun check_isDomain() {
    assertFalse(EmailValidator.isValidEmail("name@.com"))
}
@Test
fun checking_valid_symbols_in_name() {
    assertFalse(EmailValidator.isValidEmail("&<>$#@mail.com"))
}
@Test
fun checking_valid_characters_in_domain() {
    assertFalse(EmailValidator.isValidEmail("name@&$<>?.com"))
}

@Test
fun checking_not_empty(){
    assertNotNull(EmailValidator.isValidEmail("name@mail.com"))
}

@Test
fun checking_null_in_email(){
    assertNull(EmailValidator.isValidEmail(email = null))
}

@Test
fun checking_not_equals() {
    assertNotEquals(EmailValidator.isValidEmail("name@mail.com"), "exam@mail.com")
}

@Test
fun checking_equals() {
    assertEquals(EmailValidator.isValidEmail(EmailValidator.isEqualsNameEmail()), "ex@mail.ru")
}

@Test
fun is_array_emails_equals() {
    assertArrayEquals(EmailValidator.isArrayEmailsEquals(), arrayOf("one@mail.com", "two@mail.com", "three@mail.com"))
}

@Test
fun is_same_emails() {
    assertSame(EmailValidator.isSameCheckOne(),EmailValidator.isSameCheckTwo())
}


@Test
fun is_not_same_emails() {
    assertNotSame(EmailValidator.isSameCheckOne(),EmailValidator.isNotSameEmail())
}
}