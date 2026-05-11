package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GapFinderViewModel : ViewModel() {
    val savedOpportunities = mutableStateListOf<Opportunity>()

    // Holds the current result for the Analysis page
    var currentAnalysis = mutableStateOf<Opportunity?>(null)

    fun performAnalysis(location: String, category: String) {
        val newOp = Opportunity(
            id = (1000..9999).random(),
            location = location,
            category = category,
            insightTitle = "Affordable $category Delivery",
            insightDesc = "Based on local mobility patterns and a ${(30..50).random()}% supply gap detected in $location.",
            score = (75..95).random(),
            impact = (80..99).random()
        )
        currentAnalysis.value = newOp
        savedOpportunities.add(0, newOp)
    }
}