package com.example.a216249_tanweichao_nelson_project1

data class Opportunity(
    val id: Int,
    val location: String,
    val category: String,
    val insightTitle: String,
    val insightDesc: String,
    val score: Int,
    val impact: Int
)