
fun main() {
    println("Hello world");
    println("aaa")

    val inputNum : Int = 4;
    var result : Int = 1;
    for (i in 1..inputNum) {
        result *= i;
    }

    println("The factorial of " + inputNum + " is: " + result);

    val myList = mutableListOf(5, 1, 3, 0, 10);
    println(myList);
    for (i in 0..myList.size-2) {
        for (j in 0..myList.size-i-2) {
            if (myList[j] > myList[j+1]) {
                val tmp = myList[j];
                myList[j] = myList[j + 1]
                myList[j + 1] = tmp;
            }
        }
    }
    println("Sorted list: " + myList);
}