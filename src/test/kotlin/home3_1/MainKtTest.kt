@file:Suppress("UNREACHABLE_CODE")

package home3_1

import org.junit.Test

import org.junit.Assert.*
import org.junit.Assert.assertEquals as assertEquals

@Suppress("UNUSED_EXPRESSION")
class MainKtTest {


    @Test
    fun ago_To_Text() {
    }

    @Test
    fun `commision_Test`() {
        val cardType = "Mastercard"
        val monthSum = 7400000
        val transferSum = 10000000
        val expected = 0
        val result = comissioncalc(cardType,monthSum, transferSum)
        assertEquals(result, expected)
    }

}
