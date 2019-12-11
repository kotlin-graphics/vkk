package framework.platform

/**
 * @brief Encapsulates basic usage of chrono, providing a means to calculate float
 *        durations between time points via function calls.
 */
class Timer {

    // Configure
//    using DefaultResolution = Seconds

//    virtual ~Timer() = default;

    /**
     * @brief Starts the timer, elapsed() now returns the duration since start()
     */
    fun start() {
        if (!running) {
            running = true
            startTime = System.nanoTime()
        }
    }

    /**
     * @brief Laps the timer, elapsed() now returns the duration since the last lap()
     */
    fun lap() {
        lapping = true
        lapTime = System.nanoTime()
    }

    /**
     * @brief Stops the timer, elapsed() now returns 0
     * @return The total execution time between `start()` and `stop()`
     */
    fun stop(): Double {
        if (!running)
            return 0.0

        running = false
        lapping = false
        val duration = System.nanoTime() - startTime
        startTime = System.nanoTime()
        lapTime = System.nanoTime()

        return duration / 1e-9
    }

    /**
     * @brief Calculates the time difference between now and when the timer was started
     *        if lap() was called, then between now and when the timer was last lapped
     * @return The duration between the two time points (default in milliseconds)
     */
    fun elapsed(): Double {
        if (!running)
            return 0.0

        var start = startTime

        if (lapping)
            start = lapTime

        return (System.nanoTime() - start) / 1e-9
    }

    /**
     * @brief Calculates the time difference between now and the last time this function was called
     * @return The duration between the two time points (default in seconds)
     */
    fun tick(): Double {
        val now = System.nanoTime()
        val duration = now - previousTick
        previousTick = now
        return duration / 1e-9
    }

    private var running = false

    private var lapping = false

    private var startTime = System.nanoTime()

    private var lapTime = 0L

    private var previousTick = System.nanoTime()
}