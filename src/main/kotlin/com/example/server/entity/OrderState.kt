package com.example.server.entity


interface BaseCodeEnum {
    val code: Int
}

enum class OrderState(override val code: Int) : BaseCodeEnum {
    ON(0), CLOSE(-1), FINISHED(1);

}

internal object CodeEnumUtil {
    @JvmStatic
    fun <E> codeOf(enumClass: Class<E>, code: Int): E? where E : Enum<*>?, E : BaseCodeEnum? {
        val enumConstants = enumClass.enumConstants
        for (e in enumConstants) {
            if (e!!.code == code) return e
        }
        return null
    }
}