package framework.platform

import glm_.vec2.Vec2

enum class MouseButton {
    Left,
    Right,
    Middle,
    Back,
    Forward,
    Unknown
}

enum class MouseAction {
    Down,
    Up,
    Move,
    Unknown
}

enum class TouchAction {
    Down,
    Up,
    Move,
    Cancel,
    PointerDown,
    PointerUp,
    Unknown
}

sealed class InputEvent {

    class KeyInputEvent(val code: Int, val action: Int) : InputEvent()

    class MouseButtonInputEvent(val button: MouseButton, val action: MouseAction, val pos: Vec2) : InputEvent()

    class TouchInputEvent(val pointerId: Int, val pointerCount: Long, val action: TouchAction, val pos: Vec2)
}