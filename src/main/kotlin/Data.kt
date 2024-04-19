data class Zip (
    val name: String,
    val contents: MutableMap<Int, String>)

data class Message (
    val name: String,
    val contents: MutableMap<Int, String>,
    val text: String)
