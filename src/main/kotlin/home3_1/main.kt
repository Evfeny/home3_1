package home3_1
import kotlin.math.roundToInt


fun main() {

    agoToText(50)
    commision("Mastercard", 740000,7500000)
}

    fun agoToText (secondsNotOnline:Int){
        when{
            secondsNotOnline in 0..60 -> println("был(а) только что\n")
            secondsNotOnline in 61..60*60 -> correctTextMin(secondsNotOnline/60)
            secondsNotOnline in (60*60+1)..24*60*60 ->correctTextHours(secondsNotOnline/60/60)
            secondsNotOnline in (24*60*60+1)..24*60*60*2 -> println("был(а) в сети сегодня\n")
            secondsNotOnline in (24*60*60*2+1)..24*60*60*3 -> println("был(а) в сети вчера\n")
            secondsNotOnline>24*60*60*3 -> println("был(а) в сети давно\n")
        }
    }

    fun correctTextMin(minutesNotOnline:Int) {
        if (minutesNotOnline in 11..19) println("был(а) в сети $minutesNotOnline минут назад\n")
        else {
            when (minutesNotOnline % 10) {
                1 -> println("был(а) в сети $minutesNotOnline минуту назад\n")
                2, 3, 4 -> println("был(а) в сети $minutesNotOnline минуты назад\n")
                5, 6, 7, 8, 9, 0 -> println("был(а) в сети $minutesNotOnline минут назад\n")
                else -> println("Ошибка! Невероятное количество минут\n")
            }
        }
    }
        fun correctTextHours(hoursNotOnline: Int) {
            when {
                hoursNotOnline in 0..1 -> println("был(а) в сети $hoursNotOnline час назад\n")
                hoursNotOnline in 2..4 -> println("был(а) в сети $hoursNotOnline часа назад\n")
                hoursNotOnline in 5..20 -> println("был(а) в сети $hoursNotOnline часов назад\n")
                hoursNotOnline in 21..22 -> println("был(а) в сети $hoursNotOnline час назад\n")
                hoursNotOnline<=24 -> println("был(а) в сети $hoursNotOnline часа назад\n")
            }
        }

fun commision(cardType: String = "VK Pay", monthSum: Int = 0, transferSum: Int) {
    println("Вы хотите перевести ${transferSum / 100} руб.")
    println("Ваша комиссия составит - ${comissioncalc(cardType, monthSum, transferSum) / 100} руб. \n")
}

fun comissioncalc(cardType: String = "VK Pay", monthSum: Int = 0, transferSum: Int): Int {
    when (cardType) {
        "VK Pay" -> return 0
        "Mastercard", "Maestro" -> return masterComission(monthSum, transferSum)
        "Visa", "Мир" -> return visaComission(monthSum, transferSum)
        else -> return 0
    }
}

fun visaComission(monthSum: Int, transferSum: Int): Int {
    if (transferSum * 0.0075 < 35 * 100) return 35 * 100
    else return (transferSum * 0.0075).roundToInt()
}

fun masterComission(monthSum: Int, transferSum: Int): Int {
    if (monthSum < 75000 * 100) return 0
    else return (transferSum * 0.006 + 20 * 100).roundToInt()
}
