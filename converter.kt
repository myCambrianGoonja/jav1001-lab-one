fun main() {
    //Taking input from the user and storing it in readUnitValue
    println("Please enter a positive integer")
    var readUnitValue: Int? = readLine()?.toIntOrNull()

    //Checking the validity of the readUnitValue
    val valid = checkValidityInt(readUnitValue)
    if(!valid) return

    //Asking the user to input the orignal unit of the value entered
    println("Please enter the current unit")
    var readOriginalUnit = readLine()

    //Checking the validity of the Original unit entred
    val validOriginalUnit = checkValidString(readOriginalUnit, "")
    if(!validOriginalUnit) return
    
    //Asking the user to input the unit that the value should to be converted into
    println("Please enter wanted convertion unit")
    var readConversionUnit = readLine()

    //Checking readConversionUnit != validOriginalUnit && readConversionUnit != NULL
    val validConversionUnit = checkValidString(readConversionUnit, readOriginalUnit)
    if(!validConversionUnit) return

    // The main function where the conversion is done
    convertingToTheConvertUnit(readOriginalUnit, readConversionUnit, readUnitValue)
}

fun checkValidityInt(value: Int?): Boolean {
    if(value == null) {
        println("Please enter a valid integer")
        return false
    } else {
        return true
    }
}

fun checkValidString(value: String?, orUnit:String?): Boolean {
    if(value.isNullOrBlank()) {
        println("Unit value cannot be null")
        return false
    } else if(value.equals(orUnit)) {
        println("Both units cannot be the same")
        return false
    } 
    else return true
}

fun convertingToTheConvertUnit(originalUnit: String?, conversionUnit: String?, value:Int?) {
  val combineValue = "$originalUnit-$conversionUnit"

  when(combineValue) {
    "km-mi" -> {
        println("Conversion of $value km = ${value?.times(0.64)} mi ")
    } "mi-km" -> {
        println("Conversion of $value mi = ${value?.times(1.61)} km ")
    } "cm-in" -> {
        println("Conversion of $value cm = ${value?.times(0.39)} in ")
    } "in-cm" -> {
        println("Conversion of $value in = ${value?.times(2.54)} cm ")
    } "kg-lb" -> {
        println("Conversion of $value kg = ${value?.times(2.54)} lb")
    } "lb-kg" -> {
        println("Conversion of $value kg = ${value?.times(2.54)} lb")
    } "g-oz" -> {
        println("Conversion of $value g = ${value?.times(0.04)} oz")
    } "oz-g" -> {
        println("Conversion of $value oz = ${value?.times(28.35)} g")
    } "C-F" -> {
        println("Conversion of $value C = ${value?.times(9)?.div(5)?.plus(32)} F")
    } "F-C" -> {
        println("Conversion of $value F = ${value?.minus(32)?.times(5)?.div(9)} C")
    } "C-K" -> {
        println("Conversion of $value C = ${value?.plus(273.15)} K")
    } "F-K" -> {
        println("Conversion of $value F = ${value?.minus(32)?.times(5)?.div(9)?.plus(273.15)} K")
    } "L-cups" -> {
          println("Conversion of $value L = ${value?.times(4.17)} cups")
    } "cups-L" -> {
          println("Conversion of $value cups = ${value?.times(0.24)} L")
    } else -> {
        println("Try using short forms like in/cm/km/mi/kg etc if you did then sorry your unit is not supported")
    }
  }

}