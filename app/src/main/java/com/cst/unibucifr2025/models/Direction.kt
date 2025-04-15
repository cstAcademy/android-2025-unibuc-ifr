package com.cst.unibucifr2025.models

import com.cst.unibucifr2025.R

sealed class Direction(
    open val id: Int,
    val name: String,
    val description: String,
    val type: DirectionType
)

class North(id: Int) : Direction(
    description = "Description",
    id = id,
    name = "North",
    type = DirectionType.NORTH)
class South(id: Int) : Direction(id, "Description", "South", DirectionType.SOUTH)
class East(id: Int) : Direction(id, "East", "Description",DirectionType.EAST)
class West(id: Int) : Direction(id, "West", "Description", DirectionType.WEST)

enum class DirectionType(val id: Int, val resourceId: Int) {
    NORTH(0, R.string.north),
    SOUTH(1, R.string.south),
    EAST(2, R.string.east),
    WEST(3, R.string.west),
    UNKNOWN(-1,R.string.unknown);
    companion object{
        fun getDirectionTypeById(id: Int) = DirectionType.entries.find { it.id == id } ?: UNKNOWN
    }
}