import com.rabbitmq.client.ConnectionFactory

val qName = "hello"

fun main() {
    val factory = ConnectionFactory()
    factory.host = "localHost"

    //try:
    val connection = factory.newConnection()
    val chanel = connection.createChannel()

    chanel.queueDeclare(qName, false, false, false, null)
    val msg = "Hello world"
    chanel.basicPublish("", qName, null, msg.encodeToByteArray())
    println("[x} Send msg: $msg")
}