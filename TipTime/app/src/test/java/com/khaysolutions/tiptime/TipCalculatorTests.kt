package com.khaysolutions.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundUp() {
        val amount = 10.00 // total amount to pay $10
        val tipPercent = 20.00 // percentage to pay in addition 20%
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, roundUp = false)

        assertEquals(expectedTip, actualTip)
    }

}