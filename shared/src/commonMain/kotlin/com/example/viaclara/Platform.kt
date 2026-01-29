package com.example.viaclara

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform