package com.github.mstavares.babyme.data

import android.content.Context
import com.github.mstavares.babyme.domain.models.Baby
import com.github.mstavares.babyme.domain.models.BabyFilter
import kotlin.random.Random

class TxtBabyDataSource(context: Context, private val filePath: String) : BabyDataSource {

    private val babies = mutableListOf<Baby>()

    init {
        val iStream = context.assets.open(filePath)
        iStream.bufferedReader().forEachLine { line ->
            TxtBabyRaw.parse(line)?.let { babies.add(it.toBaby()) }
        }
    }

    override fun getBaby(filter: BabyFilter?, failure: () -> Unit, success: (Baby?) -> Unit) {
        val filtered = babies.filter { it.gender == filter?.gender }
        val source = if(filtered.isEmpty()) babies else filtered
        val baby = source.get(Random.nextInt(0, source.size - 1))
        success(baby)
    }
}