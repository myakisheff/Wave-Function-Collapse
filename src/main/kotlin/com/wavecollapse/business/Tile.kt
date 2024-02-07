package main.kotlin.com.wavecollapse.business
class Tile (
    val id : Int,
    val tile : Any,
    val leftConnections : MutableList<Int>,
    val rightConnections : MutableList<Int>,
    val topConnections : MutableList<Int>,
    val bottomConnections : MutableList<Int>,
){
}