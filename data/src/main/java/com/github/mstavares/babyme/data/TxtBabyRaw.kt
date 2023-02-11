package com.github.mstavares.babyme.data

import com.github.mstavares.babyme.domain.models.Baby

data class TxtBabyRaw(
    val yearOfBirth: String,
    val gender: String,
    val ethnicity: String,
    val name: String,
    val babiesWithThisName: String,
    val nameRank: String
) {

    companion object {

        private val skipChars = listOf("[", "]", ",", "\"", "")

        fun parse(string: String): TxtBabyRaw? {
            val items = mutableListOf<String>()
            string.trim().split(",").forEach {
                var item = it
                skipChars.forEach { item = item.replace(it, "").trim() }
                if(!skipChars.contains(item)) items.add(item)
            }
            if(items.size != 6) return null
            return TxtBabyRaw(items[0], items[1], items[2], items[3], items[4], items[5])
        }

    }

    fun toBaby() = Baby(
        yearOfBirth.toInt(), if(gender.lowercase() == "male") Baby.Gender.MALE else Baby.Gender.FEMALE,
        ethnicity, name, babiesWithThisName.toInt(), nameRank.toInt()
    )

}