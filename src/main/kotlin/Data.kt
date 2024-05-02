data class Zip(
    val name: String,
    val contents: MutableMap<Int, String>,
    val note: MutableList<Message>
)

data class Message(
    val name: String,
    val content: String
)