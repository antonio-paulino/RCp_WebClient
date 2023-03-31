import java.io.*
import java.net.*

fun main() {
    try {
        // establish a TCP connection with the server
        println("Host:")
        val clientHost = readln()
        println("Port:")
        val clientPort = readln().toInt()
        val clientSocket = Socket(clientHost, clientPort)
        println("Get:")
        val clientGet = readln()
        // send an HTTP GET request for the HTML page to the server
        val outToServer = PrintWriter(clientSocket.getOutputStream())
        outToServer.println("$clientGet\r\nHost: $clientHost \r\n\r\n")
        outToServer.flush()

        // read and print the HTTP response from the server
        val inFromServer = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
        var responseLine: String? = inFromServer.readLine()
        while (responseLine != null) {
            println(responseLine)
            responseLine = inFromServer.readLine()
        }

        // close the socket and the input/output streams
        inFromServer.close()
        outToServer.close()
        clientSocket.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}