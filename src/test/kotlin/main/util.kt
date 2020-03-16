package main

val isNotGithubAction: Boolean
    get() = System.getenv("GITHUB_ACTIONS") != "true"