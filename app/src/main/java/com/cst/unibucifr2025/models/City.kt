package com.cst.unibucifr2025.models

sealed class City(
    open val name: String,
    open val description: String,
    val directionType: DirectionType
)

data class NorthCity(
    override val name: String,
    override val description: String,
    val imageUrl: String = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/View_of_Empire_State_Building_from_Rockefeller_Center_New_York_City_dllu_%28cropped%29.jpg/1200px-View_of_Empire_State_Building_from_Rockefeller_Center_New_York_City_dllu_%28cropped%29.jpg"
): City (
    name = name,
    description = description,
    directionType = DirectionType.NORTH
)

data class SouthCity(
    override val name: String,
    override val description: String
): City (
    name = name,
    description = description,
    directionType = DirectionType.SOUTH
)

data class EastCity(
    override val name: String,
    override val description: String
): City (
    name = name,
    description = description,
    directionType = DirectionType.EAST
)

data class WestCity(
    override val name: String,
    override val description: String
): City (
    name = name,
    description = description,
    directionType = DirectionType.EAST
)
