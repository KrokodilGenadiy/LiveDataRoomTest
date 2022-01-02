package com.zaus_app.livedataroomtest

import androidx.lifecycle.ViewModel
import com.zaus_app.livedataroomtest.entity.StringEntity
import java.util.concurrent.Executors

class MainActivityViewModel : ViewModel() {
    val stringEntityDAO = App.instance.stringEntityDAO

    val stringLiveData = stringEntityDAO.getLastData()

    fun putDataToDB(stringEntity: StringEntity) {
        //Работа с ДБ не должна происходить в главном потоке
        Executors.newSingleThreadExecutor().execute {
            stringEntityDAO.putData(stringEntity)
        }
    }
}