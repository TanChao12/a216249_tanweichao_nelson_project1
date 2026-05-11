package com.example.a216249_tanweichao_nelson_project1

data class Opportunity(
    val id: Int,
    val location: String,
    val category: String,
    val analysis: String,
    val score: String,
    val sdgImpact: String,
    val timeAgo: String = "Just now"
)