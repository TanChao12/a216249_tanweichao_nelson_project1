package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class GapFinderViewModel : ViewModel() {
    val savedOpportunities = mutableStateListOf<Opportunity>()

    fun addOpportunity(location: String, category: String) {
        val scoreValue = (70..98).random()
        val newOp = Opportunity(
            id = (1000..9999).random(),
            location = location,
            category = category,
            analysis = "AI Analytics suggests a $scoreValue% market gap in $location. High demand for $category services detected.",
            score = "$scoreValue%",
            sdgImpact = "Supports SDG 8: Decent Work & Economic Growth.",
            timeAgo = "Search ${(1..12).random()}h ago"
        )
        savedOpportunities.add(0, newOp) // Add to top for recent records
    }
}