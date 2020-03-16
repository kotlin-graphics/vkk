package main

val isNotCI: Boolean
    get() = System.getenv("GITHUB_ACTIONS") != "true" && System.getenv("TRAVIS") != "true"