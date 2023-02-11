package com.github.mstavares.babyme.domain.repositories

import com.github.mstavares.babyme.domain.models.Baby
import com.github.mstavares.babyme.domain.models.BabyFilter

interface BabyRepository {

    fun getBaby(filter: BabyFilter?, failure: () -> Unit, success: (Baby?) -> Unit)

}