package com.example.coroutinesuspend.playground

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async {
            getRandom3()
        }
        val value2 = async {
            getRandom4()
        }
        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
    }
    println(elapsedTime)
}

//거의 안씀
//async를 이용해 동시에 다른 블록을 실행한다.
//launch와 다르게 await 키워드를 통해 결과를 받을 수 있다.
suspend fun getRandom3(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

suspend fun getRandom4(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}