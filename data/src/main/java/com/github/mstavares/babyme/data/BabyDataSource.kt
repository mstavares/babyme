package com.github.mstavares.babyme.data

import com.github.mstavares.babyme.domain.models.Baby
import com.github.mstavares.babyme.domain.models.BabyFilter

interface BabyDataSource {

    fun getBaby(filter: BabyFilter?, failure: () -> Unit, success: (Baby?) -> Unit)
}