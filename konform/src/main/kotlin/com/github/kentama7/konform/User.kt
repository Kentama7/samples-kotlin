package com.github.kentama7.konform

import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.maximum
import io.konform.validation.jsonschema.minLength
import io.konform.validation.jsonschema.minimum

data class User(
    val name: String,
    val age: Int?
)

val validateUser = Validation<User> {
    User::name {
        minLength(2)
        maxLength(10)
    }

    User::age ifPresent {
        minimum(0)
        maximum(100)
    }
}

fun main() {
    val user = User("a", 1)
    val result = validateUser(user)
    println(result)
}