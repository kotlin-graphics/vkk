package framework.platform

import glm_.f
import glm_.vec2.Vec2i
import org.lwjgl.glfw.GLFW

abstract class Application {
//    public:

    abstract fun destroy()

    /**
     * @brief Advances the application forward one frame, calculating the delta time between steps
     *        and then calling the update method accordingly
     */
    fun step() {

        var deltaTime = timer.tick().f

        // Fix the framerate to 60 FPS for benchmark mode and avoid
        // a huge spike in frame time while loading the app
        if (benchmarkMode || frameCount == 0)
            deltaTime = 0.01667f

        if (focus || benchmarkMode)
            update(deltaTime)

        val elapsedTime = timer.elapsed().f

        frameCount++

        if (elapsedTime > 0.5f) {
            fps = (frameCount - lastFrameCount) / elapsedTime
            frameTime = deltaTime * 1000f

            logger.info { "FPS: {:.1f}".format(fps) }

            lastFrameCount = frameCount
            timer.lap()
        }
    }

    /**
     * @brief Prepares the application for execution
     * @param platform The platform the application is being run on
     */
    open fun prepare(platform: Platform): Boolean {
        timer.start()
        return true
    }

    /**
     * @brief Updates the application
     * @param delta_time The time since the last update
     */
    abstract fun update(deltaTime: Float)

    /**
     * @brief Handles cleaning up the application
     */
    open fun finish() {
        val executionTime = timer.stop()
        logger.info { "Closing App (Runtime: {:.1f})".format(executionTime) }
    }

    /**
     * @brief Handles resizing of the window
     * @param width New width of the window
     * @param height New height of the window
     */
    fun resize(size: Vec2i) {}

    /**
     * @brief Handles input events of the window
     * @param input_event The input event object
     */
    open fun inputEvent(inputEvent: InputEvent) {

        (inputEvent as? InputEvent.KeyInputEvent)?.let { keyEvent ->
            if (keyEvent.code == GLFW.GLFW_KEY_ESCAPE)
                platform!!.close()
        }
    }

    /**
     * @brief Parses the arguments against Application::usage
     * @param args The argument list
     */
//    void parse_options(const std::vector<std::string> &args)

    //    protected :
    protected var fps = 0f
    /** In ms */
    protected var frameTime = 0f

    protected var frameCount = 0

    protected var lastFrameCount = 0

//    static std::string usage

    val options = Options()

//    static void set_usage(const std::string &usage)

    //    private:
    var name = "Sample Name"

    var focus = true

    private val timer = Timer()

    var benchmarkMode = false

    // The debug info of the app
//    DebugInfo debug_info
//    {}
}