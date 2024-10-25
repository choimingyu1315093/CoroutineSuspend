package com.example.coroutinesuspend.playground

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis


//CoroutineStart.Lazy는 준비만 하고 있는 상태다.
//start를 해야 시작한다.
fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async(start = CoroutineStart.LAZY) {
            getRandom5()
        }
        val value2 = async(start = CoroutineStart.LAZY) {
            getRandom6()
        }

        value1.start()
        value2.start()

        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
    }
    println(elapsedTime)
}

suspend fun getRandom5(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

suspend fun getRandom6(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}