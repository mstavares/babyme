package com.github.mstavares.babyme.domain.models

data class Baby(
    val yearOfBirth: Int,
    val gender: Gender,
    // TODO can be changed to an enum too
    val ethnicity: String,
    val name: String,
    val babiesWithThisName: Int,
    val nameRank: Int
) {

    enum class Gender { MALE, FEMALE }

}