import java.io.*
import java.net.*

/*fun main() {
    println("enter the server name")
    val serverName = readln()
    val port = 80

    try {
        // establish a TCP connection with the server
        val clientSocket = Socket(serverName, port)

        // send an HTTP GET request to the server
        val outToServer = PrintWriter(clientSocket.getOutputStream())
        outToServer.println("GET / HTTP/1.1\r\nHost: $serverName\r\n\r\n")
        outToServer.flush()

     ww   // read the HTTP response from the server
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
}*/

fun main() {
    try {
        // establish a TCP connection with the server





        val clientSocket = Socket(readln(), 80)

        // send an HTTP GET request for the HTML page to the server
        val outToServer = PrintWriter(clientSocket.getOutputStream())
        outToServer.println("GET / HTTP/1.1\r\nHost: $(clientSocket. ) \r\n\r\n")
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