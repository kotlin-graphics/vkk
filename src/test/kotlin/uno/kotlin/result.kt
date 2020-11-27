@file:Suppress("UNCHECKED_CAST")

package uno.kotlin

/** https://gist.github.com/elizarov/03425be1c4209d59ad813ddccab29313 */
class Result<T> private constructor(private val result: Any?) {
    // discovery

    val isFailure: Boolean
        get() = result is Failure
    val isSuccess: Boolean
        get() = result !is Failure

    // value retrieval

    fun get(): T = when (result) {
        is Failure -> throw result.exception
        else -> result as T
    }

    fun getOrNull(): T? = when (result) {
        is Failure -> null
        else -> result as T
    }

    inline fun getOrElse(default: () -> T): T = when {
        isFailure -> default()
        else -> value
    }

    // exception retrieval

    fun exceptionOrNull(): Throwable? = (result as? Failure)?.exception

    // companion with constructors

    companion object {
        fun <T> success(value: T): Result<T> = Result(value)
        fun <T> failure(exception: Throwable) = Result<T>(Failure(exception))
    }

    // internal API for inline functions

    @PublishedApi
    internal val exception: Throwable
        get() = (result as Failure).exception
    @PublishedApi
    internal val value: T
        get() = result as T

    private class Failure(@JvmField val exception: Throwable)
}

inline fun <T> resultOf(block: () -> T): Result<T> =
        try {
            Result.success(block())
        } catch (e: Throwable) {
            Result.failure(e)
        }

// -- extensions ---

// transformation

inline fun <U, T> Result<T>.map(block: (T) -> U): Result<U> = when {
    isFailure -> this as Result<U>
    else -> resultOf { block(value) }
}

inline fun <U, T : U> Result<T>.handle(block: (Throwable) -> U): Result<U> = when {
    isFailure -> resultOf { block(exception) }
    else -> this as Result<U>
}

// "peek" onto value/exception and pipe

inline fun <T> Result<T>.onFailure(block: (Throwable) -> Unit): Result<T> {
    if (isFailure) block(exception)
    return this
}

inline fun <T> Result<T>.onSuccess(block: (T) -> Unit): Result<T> {
    if (isSuccess) block(value)
    return this
}
