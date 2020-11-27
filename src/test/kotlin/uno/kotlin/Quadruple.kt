package uno.kotlin

import java.io.Serializable

/**
 * Created by GBarbieri on 06.03.2017.
 */

/**
 * Represents a group of four values
 *
 * There is no meaning attached to values in this class, it can be used for any purpose.
 * Quadruple exhibits value semantics, i.e. two quadruple are equal if all four components are equal.
 * An example of decomposing it into values:
 *
 * @param A type of the first value.
 * @param B type of the second value.
 * @param C type of the third value.
 * @param D type of the fourth value.
 * @property first First value.
 * @property second Second value.
 * @property third Third value.
 * @property fourth Fourth value.
 */
public data class Quadruple<out A, out B, out C, out D>(
        public val first: A,
        public val second: B,
        public val third: C,
        public val fourth: D
) : Serializable {

    /**
     * Returns string representation of the [Quadruple] including its [first], [second], [third] and [fourth] values.
     */
    public override fun toString(): String = "($first, $second, $third, $fourth)"
}

/**
 * Converts this quadruple into a list.
 */
public fun <T> Quadruple<T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth)
