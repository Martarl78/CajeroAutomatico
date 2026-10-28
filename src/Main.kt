// CajeroAutomatico

// Pide un importe y lo devuelve como double.
// Devuelve null si lo escrito no es un número válido.
fun leerImporte(mensaje: String): Double? {
    print(mensaje)
    // Quita espacios, cambia la coma por punto y convierte a Double (o null)
    return readLine()?.trim()?.replace(',', '.')?.toDoubleOrNull()
}

fun main() {
    var saldo = 500.0      // Saldo inicial
    var salir = false      // Controla cuándo termina el bucle

    // El menú se repite hasta que salir sea true
    while (!salir) {
        println()
        println("===== CAJERO AUTOMÁTICO =====")
        println("1. Consultar saldo")
        println("2. Ingresar dinero")
        println("3. Retirar dinero")
        println("4. Salir")
        print("Seleccione una opción: ")

        // Null si el usuario no escribe un número entero
        val opcion = readLine()?.trim()?.toIntOrNull()

        when (opcion) {
            1 -> println("Su saldo actual es: $saldo €")

            2 -> {
                val cantidad = leerImporte("Introduzca la cantidad que quiera ingresar: ")
                if (cantidad == null) {
                    println("Error: debe introducir un número válido.")
                } else if (cantidad <= 0) {
                    println("Error: la cantidad debe ser mayor que cero.")
                } else {
                    saldo += cantidad
                    println("Ingreso realizado correctamente. Nuevo saldo: $saldo €")
                }
            }

            3 -> {
                val cantidad = leerImporte("Introduzca la cantidad a retirar: ")
                if (cantidad == null) {
                    println("Error: debe introducir un número válido.")
                } else if (cantidad <= 0) {
                    println("Error: la cantidad debe ser mayor que cero.")
                } else if (cantidad > saldo) {
                    println("Error: saldo insuficiente.")
                } else {
                    saldo -= cantidad
                    println("Retirada realizada correctamente. Nuevo saldo: $saldo €")
                }
            }

            4 -> {
                println("Gracias por utilizar el cajero. ¡Hasta pronto!")
                salir = true
            }

            else -> println("Error: opción no válida. Elija una opción del 1 al 4.")
        }
    }
}