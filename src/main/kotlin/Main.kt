import kotlinx.coroutines.*
suspend fun main() = runBlocking<Unit> {
//    println("Введите время через сколько прозвенит первый будильник")
//    val first = readln().toInt()
//    println("Введите время через сколько прозвенит второй будильник")
//    val second = readln().toInt()
//    println("Введите время через сколько прозвенит третий будильник")
//    val thirst = readln().toInt()
//    launch{firstAlaramClock(first,second,thirst)}
    launch{firstAlaramClock(5,7,10)}
}

suspend fun firstAlaramClock(f: Int, s: Int, t: Int) = runBlocking<Unit>{
    var sec = s
    var thi = t
    for(i in 0 ..< f){
        delay(1000L)
        println("Tick Tack Tick")
    }
    println("бзы бзы  бзы")
    thi -= sec
    sec -= f
    launch{ secondAlaramClock(sec,thi) }
}

suspend fun secondAlaramClock(s: Int, t: Int) = runBlocking<Unit>{
    for(i in 0 ..< s){
        delay(1000L)
        println("Tick Tack")
    }
    println("бр бр бр бр")
    launch{thirstAlaramClock(t)}
}
suspend fun thirstAlaramClock(t: Int) = runBlocking{
    for(i in 0 ..< t){
        delay(1000L)
        println("Tick")
    }
    println("Тр тр тр тр")
}