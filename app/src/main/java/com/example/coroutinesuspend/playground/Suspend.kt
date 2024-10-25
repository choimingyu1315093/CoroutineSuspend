package com.example.coroutinesuspend.playground

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    //measureTimeMillis는 코드 실행이 얼마나 걸리는지 알려준다.
    val elapsedTime = measureTimeMillis {
        val value1 = getRandom()
        val value2 = getRandom2()
        println("${value1} + ${value2} = ${value1 + value2}")
    }
    println(elapsedTime)
}

//suspend 함수 만들어서 실행하면 절차지향프로그래밍 때문에 getRandom() 호출되고, 그 이후에 getRandom2() 호출 된다.
suspend fun getRandom(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

suspend fun getRandom2(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}