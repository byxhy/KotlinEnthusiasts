fun main() {
    // learnKotlinbyExample: https://play.kotlinlang.org/byExample/overview
    introduction()
}




fun introduction() {
    println("[Hello Kotlin]")
    printMessage("Hello")

    println("\n[Functions]")
    defaultFunctions()
    infixFunctions()
    operatorFunctions()
    varargFunctions()

    println("\n[Variables]")
    variables()

    println("\n[Null Safety]")
    nullSafety()
}


fun printMessage(message: String): Unit {
    println(message)
}
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[${prefix}] $message")
}
fun sum(x: Int, y: Int): Int {
    return x + y
}
fun multiply(x: Int, y: Int) = x * y
fun defaultFunctions() {
    println("Default Parameter Values and Named Arguments:")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix("Hello", "Test")
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 9))
    println(multiply(2, 4))
}

fun infixFunctions() {
    println("\nInfix Functions:")
    infix fun Int.times(str: String) = str.repeat(this)
    println(3 times "Bye ")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
}
class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }
}
fun operatorFunctions() {
    println("\nOperator Functions:")
    operator fun Int.times(str: String) = str.repeat(this)
    println( 2 * "Bye ")

    operator fun String.get(range: IntRange) = substring(range)
    val str = "I'm learning Kotlin programing now"
    println(str[0..11])
}

fun varargFunctions() {
    println("\nFunctions with vararg Parameters:")
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Say: "
    )
    log("Hello", "Hallo", "Salut", "Hola", "你好")

}
fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}
fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}
fun log(vararg entries: String) {
    printAll(*entries)
}

fun variables() {
    var a: String = "initial"
    println(a)
    val b: Int = 1
    println(b)
    val c = 3
    println(c)

    // Allowed: Var cannot be reassigned
    a = "mutable"
    println(a)

    // Error: Val cannot be reassigned
    // b = 5

    // Error: Variable "e" must be initialized first
    // var e: Int
    // println(e)

    // Allowed: You're free to choose when to initialize a variable. However, it must be initialized before the first read
    var d: Int
    if (b > c) {
        d = 1
    } else {
        d = 0
    }
    println(d)
}
fun nullSafety() {
     var neverNull: String  ="This can't be null"
    // Error: Null can not be a value of a non-null type String
    // neverNull = null

    // Allowed: If you need a variable that can be null, declare it nullable by adding ? at the end of its type
    var nullable: String? = "You can keep a null here"
    println(nullable)
    nullable = null
    println(nullable)
    nullable = "Not null"
    println(nullable)

    // When inferring types, the compiler assumes non-null for variables that are initialized with a value.
    var inferredNonNull = "The compier assumes non-null"
    // Error: Assign null to a variable with inferred type
    // inferredNonNull = null

    println( strLength(neverNull) )
    println( strLength((nullable)) )
    println( strLength((inferredNonNull)) )

    // Working with Nulls
    println( describeString(neverNull) )

    println( describeString(nullable) )
    nullable = null
    println( describeString(nullable) )
    nullable = ""
    println( describeString(nullable) )
}
fun strLength(notNull: String): Int {
    return notNull.length
}
fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}