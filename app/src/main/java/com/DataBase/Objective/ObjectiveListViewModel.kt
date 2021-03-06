package com.DataBase.Objective

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.DataBase.AppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ObjectiveListViewModel(application: Application):AndroidViewModel(application) {

    val allObjectiveWithCategory: LiveData<List<ObjectiveWithCategory>>
    private val objectiveListRepository: ObjectiveListRepository

    init {
        val appDBDao = AppDataBase.getDatabase(
            application
        ).appDBDao()

        objectiveListRepository = ObjectiveListRepository(appDBDao)
        allObjectiveWithCategory = objectiveListRepository.allObjectivesWithCategory
    }

    fun addObjective(objective: Objective){
        viewModelScope.launch(Dispatchers.IO){
            objectiveListRepository.addObjective(objective)
        }
    }

    fun updateObjective(objective: Objective){
        viewModelScope.launch(Dispatchers.IO){
            objectiveListRepository.updateObjective(objective)
        }
    }

    fun deleteObjective(objective: Objective){
        viewModelScope.launch(Dispatchers.IO){
            objectiveListRepository.deleteObjective(objective)
        }
    }
}