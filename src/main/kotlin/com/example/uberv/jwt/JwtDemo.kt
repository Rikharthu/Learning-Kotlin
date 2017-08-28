package com.example.uberv.jwt

import java.security.MessageDigest
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.experimental.and


fun main(args: Array<String>) {
    val header = """{"alg":"HS256","typ":"JWT"}""";
    val payload = """{"loggedInAs":"admin","iat":1422779638}"""
    val key = "secretkey"

    val unsignedToken = "${Base64.getEncoder().encodeToString(header.toByteArray(charset("utf-8")))}.${Base64.getEncoder().encodeToString(payload.toByteArray(charset("utf-8")))}"
    println(unsignedToken)
    val digest = MessageDigest.getInstance("SHA-256")
    val hash = bytesToHex(digest.digest(unsignedToken.toByteArray(charset("utf-8"))))
    println(hash)

    val key2 = SecretKeySpec("secretkey".toByteArray(charset("UTF-8")), "HmacSHA256")
    val mac = Mac.getInstance("HmacSHA1")
    mac.init(key2)

    val token = "$unsignedToken.$hash"
    println("Token: $token")
    println("Header: $header")
    println("Payload: $payload")
}

fun bytesToHex(bytes: ByteArray): String {
    val result = StringBuffer()
    for (b in bytes) result.append(Integer.toString((b and 0xff.toByte()) + 0x100, 16).substring(1))
    return result.toString()
}