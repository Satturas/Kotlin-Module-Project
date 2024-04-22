data class Zip (
    val name: String,
    val contents: MutableMap<Int, String>,
    val note: ArrayList<Message>)

data class Message(
    val name: String,
    val content: String) {
}