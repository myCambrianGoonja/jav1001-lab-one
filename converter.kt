fun main() {
    //Taking input from the user and storing it in readUnitValue
    println("Please enter a positive integer")
    var readUnitValue: Double? = readLine()?.toDoubleOrNull()

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

fun checkValidityInt(value: Double?): Boolean {
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

fun convertingToTheConvertUnit(originalUnit: String?, conversionUnit: String?, value:Double?) {
  val combineValue = "$originalUnit-$conversionUnit"

/*
    Creating maps for different operations of 
    the units based on the formula
 */ 
  val multiplicationFormulaMap = mapOf(
    "km-mi" to 0.62,
    "mi-km" to 1.61,
    "cm-in" to 0.39,
    "in-cm" to 2.54,
    "kg-lb" to 2.04,
    "lb-kg" to 0.45,
    "g-oz" to 0.04,
    "oz-g" to 28.35,
    "L-cups" to 4.17,
    "cups-L" to 0.24,
    "C-F" to 9,
    "F-C" to 0.56,
    "F-K" to 0.56,
  )

    val divMap = mapOf(
        "C-F" to 5
    )

    val plusMap = mapOf(
        "C-F" to 32,
        "C-K" to 273.15,
        "F-K" to 273.15
    )

    val minusMap = mapOf(
        "F-C" to 32,
        "F-K" to 32
    )

    var getMultiplicationValue: Double? = multiplicationFormulaMap[combineValue]?.toDouble()
    var getDivValue: Double? = divMap[combineValue]?.toDouble() 
    var getplusValue: Double? = plusMap[combineValue]?.toDouble()
    var getMinusValue: Double? = minusMap[combineValue]?.toDouble()

    //the following condition is to check whether the user has entered the values that we do convert for
    if(listOf(getMultiplicationValue, getDivValue, getplusValue, getMinusValue).all { it == null }) {
         println("Try using short forms like in/cm/km/mi/kg/F(Faranite)/C/K etc if you did then sorry your unit is not supported")
    } else {   
        println("Conversion of $value $originalUnit = ${value!!.minus(getMinusValue?:0.00).div(getDivValue?: 1.00).times(getMultiplicationValue?: 1.00).plus(getplusValue?:0.00)} $conversionUnit ")
    }

}