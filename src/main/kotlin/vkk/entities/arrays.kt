package vkk.entities


typealias VkCommandPoolArray = LongArray

inline class VkFenceArray(val array: LongArray) : Iterable<VkFence> {

    operator fun get(index: Int) = VkFence(array[index])
    operator fun set(index: Int, fence: VkFence) = array.set(index, fence.L)

    val size get() = array.size
    val indices get() = array.indices

    override operator fun iterator() = VkFenceArrayIterator()

    inner class VkFenceArrayIterator : Iterator<VkFence> {
        private var index = 0
        override fun hasNext() = index < array.size
        override fun next() =
                try {
                    VkFence(array[index++])
                } catch (e: ArrayIndexOutOfBoundsException) {
                    index -= 1
                    throw NoSuchElementException(e.message)
                }
    }
}

fun VkFenceArray(size: Int, block: (Int) -> VkFence) = VkFenceArray(LongArray(size) { block(it).L })
fun VkFenceArray(size: Int) = VkFenceArray(LongArray(size))
fun VkFenceArray(images: Collection<VkFence>) = VkFenceArray(LongArray(images.size) { images.elementAt(it).L })
fun VkFenceArray() = VkFenceArray(LongArray(0))


inline class VkFramebufferArray(val array: LongArray) : Iterable<VkFramebuffer> {

    operator fun get(index: Int) = VkFramebuffer(array[index])
    operator fun set(index: Int, framebuffer: VkFramebuffer) = array.set(index, framebuffer.L)

    val size get() = array.size
    val indices get() = array.indices

    override operator fun iterator() = VkFramebufferArrayIterator()

    inner class VkFramebufferArrayIterator : Iterator<VkFramebuffer> {
        private var index = 0
        override fun hasNext() = index < array.size
        override fun next() =
                try {
                    VkFramebuffer(array[index++])
                } catch (e: ArrayIndexOutOfBoundsException) {
                    index -= 1
                    throw NoSuchElementException(e.message)
                }
    }
}

fun VkFramebufferArray(size: Int, block: (Int) -> VkFramebuffer) = VkFramebufferArray(LongArray(size) { block(it).L })
fun VkFramebufferArray(size: Int) = VkFramebufferArray(LongArray(size))
fun VkFramebufferArray(images: Collection<VkFramebuffer>) = VkFramebufferArray(LongArray(images.size) { images.elementAt(it).L })
fun VkFramebufferArray() = VkFramebufferArray(LongArray(0))

inline class VkImageArray(val array: LongArray) : Iterable<VkImage> {

    operator fun get(index: Int) = VkImage(array[index])
    operator fun set(index: Int, image: VkImage) = array.set(index, image.L)

    val size get() = array.size
    val indices get() = array.indices

    override operator fun iterator() = VkImageArrayIterator()

    inner class VkImageArrayIterator : Iterator<VkImage> {
        private var index = 0
        override fun hasNext() = index < array.size
        override fun next() =
                try {
                    VkImage(array[index++])
                } catch (e: ArrayIndexOutOfBoundsException) {
                    index -= 1
                    throw NoSuchElementException(e.message)
                }
    }
}


fun VkImageArray(size: Int, block: (Int) -> VkImage) = VkImageArray(LongArray(size) { block(it).L })
fun VkImageArray(size: Int) = VkImageArray(LongArray(size))
fun VkImageArray(images: Collection<VkImage>) = VkImageArray(LongArray(images.size) { images.elementAt(it).L })
fun VkImageArray() = VkImageArray(LongArray(0))

inline class VkImageViewArray(val array: LongArray) : Iterable<VkImageView> {

    operator fun get(index: Int) = VkImageView(array[index])
    operator fun set(index: Int, imageView: VkImageView) = array.set(index, imageView.L)

    val size get() = array.size
    val indices get() = array.indices

    override operator fun iterator() = VkImageViewArrayIterator()

    inner class VkImageViewArrayIterator : Iterator<VkImageView> {
        private var index = 0
        override fun hasNext() = index < array.size
        override fun next() =
                try {
                    VkImageView(array[index++])
                } catch (e: ArrayIndexOutOfBoundsException) {
                    index -= 1
                    throw NoSuchElementException(e.message)
                }
    }
}

fun VkImageViewArray(size: Int, block: (Int) -> VkImageView) = VkImageViewArray(LongArray(size) { block(it).L })
fun VkImageViewArray(size: Int) = VkImageViewArray(LongArray(size))
fun VkImageViewArray(images: Collection<VkImageView>) = VkImageViewArray(LongArray(images.size) { images.elementAt(it).L })
fun VkImageViewArray() = VkImageViewArray(LongArray(0))

inline class VkSemaphoreArray(val array: LongArray) : Iterable<VkSemaphore> {

    operator fun get(index: Int) = VkSemaphore(array[index])
    operator fun set(index: Int, imageView: VkSemaphore) = array.set(index, imageView.L)

    val size get() = array.size
    val indices get() = array.indices

    override operator fun iterator() = VkSemaphoreArrayIterator()

    inner class VkSemaphoreArrayIterator : Iterator<VkSemaphore> {
        private var index = 0
        override fun hasNext() = index < array.size
        override fun next() =
                try {
                    VkSemaphore(array[index++])
                } catch (e: ArrayIndexOutOfBoundsException) {
                    index -= 1
                    throw NoSuchElementException(e.message)
                }
    }
}

fun VkSemaphoreArray(size: Int, block: (Int) -> VkSemaphore) = VkSemaphoreArray(LongArray(size) { block(it).L })
fun VkSemaphoreArray(size: Int) = VkSemaphoreArray(LongArray(size))
fun VkSemaphoreArray(images: Collection<VkSemaphore>) = VkSemaphoreArray(LongArray(images.size) { images.elementAt(it).L })
fun VkSemaphoreArray() = VkSemaphoreArray(LongArray(0))