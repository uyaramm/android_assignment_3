package com.example.runapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.runapp.R

/**
 * A data class to represent the information presented in the dog card
 */
data class InfoCard(
    @DrawableRes val imageResourceId: Int,
    @StringRes val dayOfTrainning: Int,
    val description: Int,
    @StringRes val message: Int
)

val cards = listOf(
    InfoCard(R.drawable.day1, R.string.dayOfTrainning_1,R.string.description_1, R.string.message_1),
    InfoCard(R.drawable.day2,R.string.dayOfTrainning_2, R.string.description_2, R.string.message_2),
    InfoCard(R.drawable.day3,R.string.dayOfTrainning_3, R.string.description_3, R.string.message_3),
    InfoCard(R.drawable.day4,R.string.dayOfTrainning_4, R.string.description_4, R.string.message_4),
    InfoCard(R.drawable.day5,R.string.dayOfTrainning_5, R.string.description_5, R.string.message_5),
    InfoCard(R.drawable.day6,R.string.dayOfTrainning_6, R.string.description_6, R.string.message_6),
    InfoCard(R.drawable.day7,R.string.dayOfTrainning_7, R.string.description_7, R.string.message_7),
    InfoCard(R.drawable.day8,R.string.dayOfTrainning_8, R.string.description_8, R.string.message_8),
    InfoCard(R.drawable.day9,R.string.dayOfTrainning_9, R.string.description_9, R.string.message_9),
    InfoCard(R.drawable.day10,R.string.dayOfTrainning_10, R.string.description_10, R.string.message_10),
    InfoCard(R.drawable.day11,R.string.dayOfTrainning_11, R.string.description_11, R.string.message_11),
    InfoCard(R.drawable.day12,R.string.dayOfTrainning_12, R.string.description_12, R.string.message_12),
    InfoCard(R.drawable.day13,R.string.dayOfTrainning_13, R.string.description_13, R.string.message_13),
    InfoCard(R.drawable.day14,R.string.dayOfTrainning_14, R.string.description_14, R.string.message_14),
    InfoCard(R.drawable.day15,R.string.dayOfTrainning_15, R.string.description_15, R.string.message_15),
    InfoCard(R.drawable.day16,R.string.dayOfTrainning_16, R.string.description_16, R.string.message_16),
    InfoCard(R.drawable.day17,R.string.dayOfTrainning_17, R.string.description_17, R.string.message_17),
    InfoCard(R.drawable.day18,R.string.dayOfTrainning_18, R.string.description_18, R.string.message_18),
    InfoCard(R.drawable.day19,R.string.dayOfTrainning_19, R.string.description_19, R.string.message_19),
    InfoCard(R.drawable.day20,R.string.dayOfTrainning_20, R.string.description_20, R.string.message_20),
    InfoCard(R.drawable.day21,R.string.dayOfTrainning_21, R.string.description_21, R.string.message_21),
    InfoCard(R.drawable.day22,R.string.dayOfTrainning_22, R.string.description_22, R.string.message_22),
    InfoCard(R.drawable.day23,R.string.dayOfTrainning_23, R.string.description_23, R.string.message_23),
    InfoCard(R.drawable.day24,R.string.dayOfTrainning_24, R.string.description_24, R.string.message_24),
    InfoCard(R.drawable.day25,R.string.dayOfTrainning_25, R.string.description_25, R.string.message_25),
    InfoCard(R.drawable.day26,R.string.dayOfTrainning_26, R.string.description_26, R.string.message_26),
    InfoCard(R.drawable.day27,R.string.dayOfTrainning_27, R.string.description_27, R.string.message_27),
    InfoCard(R.drawable.day28,R.string.dayOfTrainning_28, R.string.description_28, R.string.message_28),
    InfoCard(R.drawable.day29,R.string.dayOfTrainning_29, R.string.description_29, R.string.message_29),
    InfoCard(R.drawable.day30,R.string.dayOfTrainning_30, R.string.description_30, R.string.message_30),

)