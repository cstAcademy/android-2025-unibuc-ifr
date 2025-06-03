package com.cst.unibucifr2025.models.dummyData

import com.cst.unibucifr2025.models.many_to_many.UserJobModel

fun getRandomUserJob() = getDummyUserJobs().random()

fun getDummyUserJobs() = listOf(
    UserJobModel(
        jobId = "1",
        title = "Developer"
    ),
    UserJobModel(
        jobId = "2",
        title = "Designer"
    ),
    UserJobModel(
        jobId = "3",
        title = "Tester"
    ),
    UserJobModel(
        jobId = "4",
        title = "Manager"
    ),
    UserJobModel(
        jobId = "5",
        title = "Architect"
    ),
    UserJobModel(
        jobId = "6",
        title = "HR"
    ),
    UserJobModel(
        jobId = "7",
        title = "CEO"
    ),
    UserJobModel(
        jobId = "8",
        title = "CTO"
    ),
    UserJobModel(
        jobId = "9",
        title = "CFO"
    ),
    UserJobModel(
        jobId = "10",
        title = "COO"
    )
)