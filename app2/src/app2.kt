import kotlin.random.Random

fun func(name: String) {
    println("Hello " + name)
}

fun getFactorial(n: Int = 0): Int {
    if (n<0) {
        return -1
    }

    var result = 1
    for (i in 1..n) {
        result *= i
    }

    return result
}

fun getRandomFactorial(): Int {
    val randomNumber = Random.nextInt(0, 6)
    return getFactorial(randomNumber)
}

fun main(args: Array<String>) {
    func(args[0])
    val res = getFactorial(4)
    println(res)
    println(getFactorial())
    println(getRandomFactorial())

    val num = 4
    val sqrLambda = { result: Int -> num * num}
    println(sqrLambda(num))
}