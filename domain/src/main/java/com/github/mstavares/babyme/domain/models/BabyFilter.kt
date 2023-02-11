package com.github.mstavares.babyme.domain.models

data class BabyFilter private constructor(
    val gender: Baby.Gender? = null

) {

    class Builder {
        private var gender: Baby.Gender? = null

        fun gender(gender: Baby.Gender) = apply { this.gender = gender }

        fun build() = BabyFilter(gender)

    }

}