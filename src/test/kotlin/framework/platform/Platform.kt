package framework.platform

import mu.KotlinLogging
import org.lwjgl.vulkan.VkInstance
import thirdParty.spdlog.Sink
import vkk.entities.VkSurfaceKHR

enum class ExitCode {
    /* App prepare succeeded, it ran correctly and exited properly with no errors */
    Success,
    /* App prepare failed, could not run */
    UnableToRun,
    /* App encountered an unexpected error */
    FatalError
}

val logger = KotlinLogging.logger { }

abstract class Platform {

    open fun destroy() {}

    /**
     * @brief Sets up windowing system and logging
     * @param app The application to prepare after the platform is prepared
     */
    open fun initialize(app: Application): Boolean {

        activeApp = app

        // Override initialize_sinks in the derived platforms
        val sinks = platformSinks

//        auto logger = std ::make_shared < spdlog::logger > ("logger", sinks.begin(), sinks.end())
//        logger->set_pattern(LOGGER_FORMAT)
//        spdlog::set_default_logger(logger)
//
//        LOGI("Logger initialized")

        if (activeApp!!.options.benchmark != 0) {
            benchmarkMode = true
            totalBenchmarkFrames = activeApp!!.options.benchmark
            remainingBenchmarkFrames = totalBenchmarkFrames
            activeApp!!.benchmarkMode = true
        }

        return true
    }

    /**
     * @brief Prepares the active app supplied in the initialize function
     */
    open fun prepare(): Boolean = activeApp?.prepare(this) ?: false

    /**
     * @brief Gets a handle from the platform's Vulkan surface
     * @param instance The Vulkan instance
     * @returns A VkSurfaceKHR handle, for use by the application
     */
    abstract fun createSurface(instance: VkInstance): VkSurfaceKHR

    /**
     * @brief Handles the main loop of the platform
     *        This function is responsible for calling run()
     */
    abstract fun mainLoop()

    /**
     * @brief Handles the running of the app
     */
    open fun run() {

        if (benchmarkMode) {

            timer.start()

            if (remainingBenchmarkFrames == 0) {
                val timeTaken = timer.stop()
                logger.info { "Benchmark completed in $timeTaken seconds (ran $totalBenchmarkFrames frames, averaged ${totalBenchmarkFrames / timeTaken} fps)" }
                close()
            }
        }

        if (activeApp!!.focus || activeApp!!.benchmarkMode) {
            activeApp!!.step()
            remainingBenchmarkFrames--
        }
    }

    /**
     * @brief Terminates the platform and the application
     * @param code Determines how the platform should exit
     */
    open fun terminate(code: ExitCode) {
        activeApp?.finish()
        activeApp = null
    }

    /**
     * @brief Requests to close the platform at the next available point
     */
    abstract fun close()

    /**
     * @return The dot-per-inch scale factor
     */
    open val dpiFactor get() = 1f

    fun getApp() = activeApp!!

//    std::vector<std::string> &get_arguments()

//    static void set_arguments(const std::vector<std::string> &args)

    //    protected :
    protected var activeApp: Application? = null

    protected var benchmarkMode = false

    protected var totalBenchmarkFrames = 0

    protected var remainingBenchmarkFrames = 0

    protected val timer = Timer()

    protected abstract val platformSinks: Array<Sink>

//    private :
    /// Static so can be set via JNI code in android_platform.cpp
//    static std::vector<std::string> arguments

    /** he working directory of the application set by the platform */
    var externalStorageDirectory = ""

    /** the suitable directory for temporary files from the environment variables set in the system */
    var tempDirectory = ""
}