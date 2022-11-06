package vkk

import java.io.File
import vkk.gen.generate
import vkk.gen.jvmInline

fun vk(target: File) {

    generate(target, "vkk/Vk10.kt") {

        `package` = "vkk"

        +"""
            fun ApiVersion(variant: Int, major: Int, minor: Int, patch: Int): ApiVersion {
                val variant = variant.toUInt() shr 29
                val major = major.toUInt() shr 22
                val minor = minor.toUInt() shr 12
                val patch = patch.toUInt()
                return ApiVersion((variant or major or minor or patch).toInt())
            }
            
            $jvmInline
            value class ApiVersion(val value: Int) {
                val variant: Int
                    get() = (value.toUInt() shr 29).toInt()
                val major: Int
                    get() = ((value.toUInt() shr 22) and 0x7Fu).toInt()
                val minor: Int
                    get() = ((value.toUInt() shr 12) and 0x3FFu).toInt()
                val patch: Int
                    get() = (value.toUInt() and 0xFFFu).toInt()
            }
            """
        lateinit var variant: String
        lateinit var major: String
        lateinit var minor: String
        Registry.types.filterIsInstance(Type.ApiVersion::class.java).forEach {
            docs(it.comment)
            +"""val `API VERSION ${it.major},${it.minor}`: ApiVersion = ApiVersion(0, ${it.major}, ${it.minor}, 0)"""
            variant = it.variant
            major = it.major
            minor = it.minor
        }
        Registry.types.filterIsInstance(Type.HeaderVersion::class.java).single().apply {
            docs(comment)
            +"""
                val headerVersion: Int = $version
                /** Complete version of this file*/
                val versionComplete: ApiVersion = ApiVersion($variant, $major, $minor, $version) 
            """
        }
    }
}