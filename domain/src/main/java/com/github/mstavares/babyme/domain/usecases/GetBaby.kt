package com.github.mstavares.babyme.domain.usecases

import com.github.mstavares.babyme.domain.models.Baby
import com.github.mstavares.babyme.domain.models.BabyFilter
import com.github.mstavares.babyme.domain.repositories.BabyRepository

class GetBaby(private val repository: BabyRepository) {

    suspend operator fun invoke(filter: BabyFilter?, failure: () -> Unit, success: (Baby?) -> Unit ) {
        repository.getBaby(filter, failure, success)
    }

}