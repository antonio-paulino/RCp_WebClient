import java.io.*
import java.net.*


fun main() {
    val ErrorResponses = listOf(
        400..451, //Client errors
        500..511 //Server errors
    )
     try {
        connect(ErrorResponses)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


fun connect(ErrorResponses: List<IntRange>) {
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
    for(i in ErrorResponses.indices) {
        if (HTTP_response in ErrorResponses[i]) {
            if (i == 0) println("There was a client error, try again")
            else println("There was a server error, try again")
            connect(ErrorResponses)
        }
    }
    inFromServer.close()
    outToServer.close()
    clientSocket.close()
}