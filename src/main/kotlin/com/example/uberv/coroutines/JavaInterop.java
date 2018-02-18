package com.example.uberv.coroutines;

import java.util.concurrent.CompletableFuture;

public class JavaInterop {

    public static void main(String[] args) {

    }

    CompletableFuture<String> loadGreetings() {
        CompletableFuture<String> future1 = loadGreeting();
        CompletableFuture<String> future2 = loadName();
        return future1.thenCompose(greeting ->
                future2.thenCompose(name ->
                        CompletableFuture.supplyAsync(() ->
                                greeting + ", " + name + "!")));
    }

    static public CompletableFuture<String> loadGreeting() {
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    static public CompletableFuture<String> loadName() {
        return CompletableFuture.supplyAsync(() -> System.getProperty("user.name"));
    }
}
