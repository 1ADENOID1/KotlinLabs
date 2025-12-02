import kotlin.random.Random

abstract class Vehicle {
    open val speed: Int = 5

    @JvmName("getSpeedVehicle")
    fun getSpeed(): Int {
        return this.speed
    }

    override fun toString(): String {
        return "Vehicle"
    }
}

class Car(color: String): Vehicle() {
    override val speed = Random.nextInt(50, 150)
    val color = color

    @JvmName("getColorCar")
    fun getColor(): String {
        return this.color
    }

    override fun toString(): String {
        return "Car" + this.speed
    }
}

class Moto: Vehicle() {
    override var speed = 250

    @JvmName("getSpeedMoto")
    fun setSpeed(speed: Int) {
        this.speed = speed
    }

    override fun toString(): String {
        return "Moto" + this.speed
    }

}


fun main() {
    val car = Car("Black")
    println(car.getColor())

    val moto = Moto()
    moto.setSpeed(300)
    println(moto.getSpeed())

    println("list of classes")
    val list = listOf(moto, car)
    for (i in list) {
        println(i.toString())
    }
}