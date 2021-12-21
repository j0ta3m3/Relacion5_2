fun main(args: Array<String>) {
    var magnum = Pistola("Magnum", 0, 1, "normal", 3, "a")
    var escopeta = Rifle("Escopeta", 2, 2, "normal", 6, "b")
    var M9A1 = Bazoka("M9A1", 4, 1, "proyectil", 14, "c")
    var coche = Coche("Citroen", 8, 7)
    var casa = Casa("Duplex", 0, 1)
    var bocata = Bocadillo("Ponty de pollo", 40, 10)
    var contador = 1
    var listaDeArmas = mutableListOf<Disparo>(magnum, escopeta, M9A1, coche, casa, bocata)
    var mapaDeArmas = mapOf(
        1 to listaDeArmas.get((0..5).random()),
        2 to listaDeArmas.get((0..5).random()),
        3 to listaDeArmas.get((0..5).random()),
        4 to listaDeArmas.get((0..5).random()),
        5 to listaDeArmas.get((0..5).random()),
        6 to listaDeArmas.get((0..5).random())
    )


    while (contador <= 6) {
        mapaDeArmas.get(contador)?.dispara()
        println(mapaDeArmas.get(contador))
        contador += 1
    }


}

interface Disparo {
    var municion: Int
    var municionARestar: Int
    var nombre: String
    open fun dispara() = municion - municionARestar
}

abstract class ArmaDeFuego(
    override var nombre: String,
    override var municion: Int,
    override var municionARestar: Int,
    var tipoDeMunicion: String,
    var danio: Int,
    var radio: String
) : Disparo {
}


open class Pistola(
    nombre: String,
    municion: Int,
    municionARestar: Int,
    tipoDeMunicion: String,
    danio: Int,
    radio: String
) :
    ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {

    override fun dispara(): Int {

        if (municion > 0) municion -= (municionARestar * 1)

        return municion
    }

    override fun toString(): String {
        if (municion < municionARestar) {
            return "La pistola $nombre no tiene municion "
        } else {
            return "La pistola ha disparado"
        }

    }
}


open class Rifle(
    nombre: String,
    municion: Int,
    municionARestar: Int,
    tipoDeMunicion: String,
    danio: Int,
    radio: String
) :
    ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio), Disparo {

    override fun dispara(): Int {

        if (municion > 0) municion -= (municionARestar * 2)

        return municion
    }

    override fun toString(): String {
        if (municion < municionARestar) {
            return " El rifle $nombre no tiene municion suficiente "
        } else {
            return "El rifle ha disparado"
        }

    }
}

open class Bazoka(
    nombre: String,
    municion: Int,
    municionARestar: Int,
    tipoDeMunicion: String,
    danio: Int,
    radio: String
) :
    ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio), Disparo {

    override fun dispara(): Int {

        if (municion > 0) municion -= (municionARestar * 3)

        return municion
    }

    override fun toString(): String {
        if (municion < municionARestar) {
            return " El bazoka $nombre no tiene municion suficiente "
        } else {
            return "El bazoka ha disparado"
        }

    }

}

open class Coche(override var nombre: String, override var municion: Int, override var municionARestar: Int) : Disparo {

    override fun toString(): String {
        if (municion < municionARestar) {
            return "El $nombre no tiene municion "
        } else {
            return "El $nombre ha disparado"
        }

    }

}

open class Casa(override var nombre: String, override var municion: Int, override var municionARestar: Int) : Disparo {

    override fun toString(): String {
        if (municion < municionARestar) {
            return "La $nombre no tiene municion "
        } else {
            return "La $nombre ha disparado"
        }

    }

}

open class Bocadillo(override var nombre: String, override var municion: Int, override var municionARestar: Int) :
    Disparo {

    override fun toString(): String {
        if (municion < municionARestar) {
            return "El $nombre no tiene municion "
        } else {
            return "El $nombre ha disparado"
        }

    }

}