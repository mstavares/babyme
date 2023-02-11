package com.github.mstavares.babyme.models

import android.content.Context
import com.github.mstavares.babyme.R
import com.github.mstavares.babyme.domain.models.Baby

data class BabyUi(
    val yearOfBirth: Int,
    val gender: String,
    val genderColor: Int,
    val ethnicity: String,
    val name: String,
    val babiesWithThisName: Int,
    val nameRank: Int

) {

    companion object {

        fun fromBaby(context: Context, from: Baby): BabyUi {
            val genderColorId = if(from.gender == Baby.Gender.MALE) R.color.blue else R.color.pink
            val genderStringId = if(from.gender == Baby.Gender.MALE) R.string.male else R.string.female
            return BabyUi(
                from.yearOfBirth, context.getString(genderStringId), context.getColor(genderColorId),
                from.ethnicity, from.name, from.babiesWithThisName, from.nameRank
            )
        }

    }

}