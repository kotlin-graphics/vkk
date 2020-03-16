package tests

import io.kotlintest.specs.StringSpec
import main.isNotGithubAction

class `04 initCommandBuffer` : StringSpec() {
    init {
        if (isNotGithubAction)
            "04 initCommandBuffer" {

            }
    }
}