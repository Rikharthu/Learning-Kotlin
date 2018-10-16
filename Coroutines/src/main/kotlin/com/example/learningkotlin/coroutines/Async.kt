package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.*
import java.io.File
import kotlin.coroutines.experimental.suspendCoroutine

/*
The C# Way:
async Task<Image> LoadImage(String url)
{
    // do the work
}

async Task ProcessImage(String url)
{
    var image = await LoadImage(url);
    myUI.SetImage(image);
}

LoadImage(url) -> produces Task<Image>

await LoadImage(url) -> produces Image


The Kotlin way:
fun loadImageAsync(): Deferred<Image> = async {
    // do the work
}

fun processImage(): Deferred = async {
    val image = loadImageAsync().await()
    myUI.setImage(image)
}

loadImage() -> produces Image

async{ loadImage() } -> produces Deferred<Image>
*/

fun main(args: Array<String>) {
    val deferred = (1..1_000_000).map { n ->
        async {
            // 'async' runs in parallel, otherwise we would have to wait 11.5 days
            delay(1000)
            n
        }
    }

//    runBlocking {
//        val sum = deferred.sumBy { it.await() }
//        println("Sum: $sum")
//    }

    // Greet user
    async {
        val greeting = loadGreetingAsync().await() + " " + loadUserAsync().await() + "!"
        println(greeting)
    }

    // Or:
    async {
        val greeting = composeGreetingAsync().await()
        println(greeting)
    }

    // Post a new comment
    launch {
        val token = requestAccessTokenAsync().await()
        val result = postCommentAsync(token, "Hello, World!").await()
        if (result) {
            println("Successfully posted new comment!")
        } else {
            println("Could not post new comment :(")
        }
    }
    // Or
    for (i in 1..100) {
        launch { postItem("Labdien, Pasaule! ($i)") }
    }

    // Or even
    listOf("Hello", "Hi", "How are you?", "Fine").forEach {
        // because forEach is inlined
        launch { postItem(it) }
    }

    println("Press 'enter' to exit")
    readLine()
}

fun loadGreetingAsync(): Deferred<String> {
    return async {
        delay(3000)
        return@async "Hello"
    }
}

fun loadUserAsync(): Deferred<String> {
    return async {
        delay(3000)
        val username = System.getProperty("user.name")
        return@async username
    }
}

fun composeGreeting(greeting: String, name: String): String {
    return "$greeting, $name!"
}

fun composeGreetingAsync() = async(CommonPool) {
    // Start loading greeting and name
    val deferredGreeting = loadGreetingAsync()
    val deferredName = loadUserAsync()

    val greeting = deferredGreeting.await()
    val name = deferredName.await()

    composeGreeting(greeting, name)
    // or
    // composeGreeting(greeting.await(), name.await())
}

// suspend marks that function won't return immediatelly, it will suspend for a while
// and then return result later on
suspend fun requestToken(): String {
    // Simulate network
//    Thread.sleep(3000)
    // P.S. When you need to delay execution, use delay() instead of sleep()!!! (comment-uncomment to experiment why)
    delay(3000)
    return "50hgdnzf9nb3047gzdrnwgm54s0"
}

fun requestAccessTokenAsync() = async {
    requestToken()
}

suspend fun postComment(authToken: String, body: String): Boolean {
    println("Posting '$body' by $authToken...")
//    Thread.sleep(3000)
    delay(3000)
    return true
}

fun postCommentAsync(authToken: String, body: String) = async {
    println("Posting '$body' by $authToken...")
    true
}

fun processPost(result: Boolean) {
    println("Processing post result: $result")
}

suspend fun postItem(body: String) {
    val token = requestToken()
    val postResult = postComment(token, body)
    processPost(postResult)
}