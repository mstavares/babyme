package com.github.mstavares.babyme.data

import com.github.mstavares.babyme.domain.models.Baby
import com.github.mstavares.babyme.domain.models.BabyFilter
import com.github.mstavares.babyme.domain.repositories.BabyRepository

class BabyRepositoryImpl(private val txt: BabyDataSource) : BabyRepository {

    override fun getBaby(filter: BabyFilter?, failure: () -> Unit, success: (Baby?) -> Unit) {
        txt.getBaby(filter, failure, success)
    }
}