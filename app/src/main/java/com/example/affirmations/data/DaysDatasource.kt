package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Day

class DaysDatasource {
    fun getDays(): List<Day> {
        return listOf(
            Day(R.string.course1, R.drawable.image1, R.string.affirmation1),
            Day(R.string.course2, R.drawable.image2, R.string.affirmation2),
            Day(R.string.course3, R.drawable.image3, R.string.affirmation3),
        )
    }
}