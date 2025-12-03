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

class Car(color: String ): Vehicle() {
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

open class Aquarium (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }
    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width/2 * length/2 * height / 1000 * 3.14).toInt()
        set(value) {
            height = ((value * 1000 / 3.14) / (width/2 * length/2)).toInt()
        }
    override var water = volume * 0.8
    override val shape = "cylinder"
}


fun main() {
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}