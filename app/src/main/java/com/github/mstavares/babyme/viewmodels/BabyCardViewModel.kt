package com.github.mstavares.babyme.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.mstavares.babyme.domain.models.BabyFilter
import com.github.mstavares.babyme.domain.usecases.GetBaby
import com.github.mstavares.babyme.models.BabyUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BabyCardViewModel(application: Application, private val getBaby: GetBaby) : AndroidViewModel(application) {

    private val TAG = BabyCardViewModel::class.java.simpleName
    private val _baby = MutableLiveData<BabyUi?>()
    val baby: LiveData<BabyUi?> = _baby

    init { fetchBaby(null) }

    fun fetchBaby(filter: BabyFilter?) {
        CoroutineScope(Dispatchers.IO).launch {
            getBaby(filter, {}, {
                Log.i(TAG, "Baby received $it")
                if(it == null) _baby.postValue(null)
                else {
                    val babyUi = BabyUi.fromBaby(getApplication(), it)
                    _baby.postValue(babyUi)
                }
            })
        }
    }

}