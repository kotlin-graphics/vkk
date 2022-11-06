package vkk

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import nl.adaptivity.xmlutil.serialization.XML

//fun parse(text: String) {
//
//    val format = XML {}
//    val registry = format.decodeFromString<Registry>(text)
//}
//
//@Serializable
//data class Registry(
//    val platforms: List<Platform>
//                   )
//
//@Serializable
//data class Platform(val name: String,
//                    val protect: String,
//                    val comment: String)
//
//@Serializable
//data class Comment(val value: String)