import java.io.*
import java.net.*


fun main() {
    val okResponses = listOf(200, 301)
     try {
        connect(okResponses)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


fun connect(okResponses: List<Int>) {
    print("Host:")
    val clientHost = readln()
    print("\nPort:")
    val clientPort = readln().toInt()
    val clientSocket = Socket(clientHost, clientPort)
    print("\nCommand:")
    val clientGet = readln()
    // send an HTTP request for the HTML page to the server
    val outToServer = PrintWriter(clientSocket.getOutputStream())
    outToServer.println("$clientGet\r\nHost: $clientHost \r\n\r\n")
    outToServer.flush()

    // read and print the HTTP response from the server
    val inFromServer = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
    var responseLine: String? = inFromServer.readLine()
    val HTTP_response = responseLine!!.split(" ")[1].toInt()
    while (responseLine != null) {
        println(responseLine)
        responseLine = inFromServer.readLine()
    }
    println()
    println()
    if (HTTP_response in okResponses) {
        inFromServer.close()
        outToServer.close()
        clientSocket.close()
    }
    else connect(okResponses)
}