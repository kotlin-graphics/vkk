package vkk

import org.lwjgl.system.MemoryStack
import org.lwjgl.vulkan.*

fun MemoryStack.AccelerationStructureCreateInfoNV(): VkAccelerationStructureCreateInfoNV = VkAccelerationStructureCreateInfoNV.callocStack(this).apply { type = VkStructureType.ACCELERATION_STRUCTURE_CREATE_INFO_NV }
fun MemoryStack.AccelerationStructureCreateInfoNV(block: VkAccelerationStructureCreateInfoNV.() -> Unit): VkAccelerationStructureCreateInfoNV = AccelerationStructureCreateInfoNV().also(block)
fun MemoryStack.AccelerationStructureCreateInfoNV(capacity: Int): VkAccelerationStructureCreateInfoNV.Buffer = VkAccelerationStructureCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.ACCELERATION_STRUCTURE_CREATE_INFO_NV }
fun MemoryStack.AccelerationStructureCreateInfoNV(capacity: Int, block: VkAccelerationStructureCreateInfoNV.Buffer.() -> Unit): VkAccelerationStructureCreateInfoNV.Buffer = AccelerationStructureCreateInfoNV(capacity).also(block)

fun MemoryStack.AccelerationStructureInfoNV(): VkAccelerationStructureInfoNV = VkAccelerationStructureInfoNV.callocStack(this).apply { sType = VkStructureType.ACCELERATION_STRUCTURE_INFO_NV }
fun MemoryStack.AccelerationStructureInfoNV(block: VkAccelerationStructureInfoNV.() -> Unit): VkAccelerationStructureInfoNV = AccelerationStructureInfoNV().also(block)
fun MemoryStack.AccelerationStructureInfoNV(capacity: Int): VkAccelerationStructureInfoNV.Buffer = VkAccelerationStructureInfoNV.callocStack(capacity, this).onEach { it.sType = VkStructureType.ACCELERATION_STRUCTURE_INFO_NV }
fun MemoryStack.AccelerationStructureInfoNV(capacity: Int, block: VkAccelerationStructureInfoNV.Buffer.() -> Unit): VkAccelerationStructureInfoNV.Buffer = AccelerationStructureInfoNV(capacity).also(block)

fun MemoryStack.AccelerationStructureMemoryRequirementsInfoNV(): VkAccelerationStructureMemoryRequirementsInfoNV = VkAccelerationStructureMemoryRequirementsInfoNV.callocStack(this).apply { sType = VkStructureType.ACCELERATION_STRUCTURE_MEMORY_REQUIREMENTS_INFO_NV }
fun MemoryStack.AccelerationStructureMemoryRequirementsInfoNV(block: VkAccelerationStructureMemoryRequirementsInfoNV.() -> Unit): VkAccelerationStructureMemoryRequirementsInfoNV = AccelerationStructureMemoryRequirementsInfoNV().also(block)
fun MemoryStack.AccelerationStructureMemoryRequirementsInfoNV(capacity: Int): VkAccelerationStructureMemoryRequirementsInfoNV.Buffer = VkAccelerationStructureMemoryRequirementsInfoNV.callocStack(capacity, this).onEach { it.sType = VkStructureType.ACCELERATION_STRUCTURE_MEMORY_REQUIREMENTS_INFO_NV }
fun MemoryStack.AccelerationStructureMemoryRequirementsInfoNV(capacity: Int, block: VkAccelerationStructureMemoryRequirementsInfoNV.Buffer.() -> Unit): VkAccelerationStructureMemoryRequirementsInfoNV.Buffer = AccelerationStructureMemoryRequirementsInfoNV(capacity).also(block)

fun MemoryStack.AcquireNextImageInfoKHR(): VkAcquireNextImageInfoKHR = VkAcquireNextImageInfoKHR.callocStack(this).apply { type = VkStructureType.ACQUIRE_NEXT_IMAGE_INFO_KHR }
fun MemoryStack.AcquireNextImageInfoKHR(block: VkAcquireNextImageInfoKHR.() -> Unit): VkAcquireNextImageInfoKHR = AcquireNextImageInfoKHR().also(block)
fun MemoryStack.AcquireNextImageInfoKHR(capacity: Int): VkAcquireNextImageInfoKHR.Buffer = VkAcquireNextImageInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.ACQUIRE_NEXT_IMAGE_INFO_KHR }
fun MemoryStack.AcquireNextImageInfoKHR(capacity: Int, block: VkAcquireNextImageInfoKHR.Buffer.() -> Unit): VkAcquireNextImageInfoKHR.Buffer = AcquireNextImageInfoKHR(capacity).also(block)

fun MemoryStack.ApplicationInfo(): VkApplicationInfo = VkApplicationInfo.callocStack(this).apply { type = VkStructureType.APPLICATION_INFO }
fun MemoryStack.ApplicationInfo(block: VkApplicationInfo.() -> Unit): VkApplicationInfo = ApplicationInfo().also(block)
fun MemoryStack.ApplicationInfo(capacity: Int): VkApplicationInfo.Buffer = VkApplicationInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.APPLICATION_INFO }
fun MemoryStack.ApplicationInfo(capacity: Int, block: VkApplicationInfo.Buffer.() -> Unit): VkApplicationInfo.Buffer = ApplicationInfo(capacity).also(block)

fun MemoryStack.AttachmentDescription(): VkAttachmentDescription = VkAttachmentDescription.callocStack(this)
fun MemoryStack.AttachmentDescription(block: VkAttachmentDescription.() -> Unit): VkAttachmentDescription = AttachmentDescription().also(block)
fun MemoryStack.AttachmentDescription(capacity: Int): VkAttachmentDescription.Buffer = VkAttachmentDescription.callocStack(capacity, this)
fun MemoryStack.AttachmentDescription(capacity: Int, block: VkAttachmentDescription.Buffer.() -> Unit): VkAttachmentDescription.Buffer = AttachmentDescription(capacity).also(block)

fun MemoryStack.AttachmentDescription2KHR(): VkAttachmentDescription2KHR = VkAttachmentDescription2KHR.callocStack(this).apply { type = VkStructureType.ATTACHMENT_DESCRIPTION_2_KHR }
fun MemoryStack.AttachmentDescription2KHR(block: VkAttachmentDescription2KHR.() -> Unit): VkAttachmentDescription2KHR = AttachmentDescription2KHR().also(block)
fun MemoryStack.AttachmentDescription2KHR(capacity: Int): VkAttachmentDescription2KHR.Buffer = VkAttachmentDescription2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.ATTACHMENT_DESCRIPTION_2_KHR }
fun MemoryStack.AttachmentDescription2KHR(capacity: Int, block: VkAttachmentDescription2KHR.Buffer.() -> Unit): VkAttachmentDescription2KHR.Buffer = AttachmentDescription2KHR(capacity).also(block)

fun MemoryStack.AttachmentReference(): VkAttachmentReference = VkAttachmentReference.callocStack(this)
fun MemoryStack.AttachmentReference(block: VkAttachmentReference.() -> Unit): VkAttachmentReference = AttachmentReference().also(block)
fun MemoryStack.AttachmentReference(capacity: Int): VkAttachmentReference.Buffer = VkAttachmentReference.callocStack(capacity, this)
fun MemoryStack.AttachmentReference(capacity: Int, block: VkAttachmentReference.Buffer.() -> Unit): VkAttachmentReference.Buffer = AttachmentReference(capacity).also(block)

fun MemoryStack.AttachmentReference2KHR(): VkAttachmentReference2KHR = VkAttachmentReference2KHR.callocStack(this).apply { type = VkStructureType.ATTACHMENT_REFERENCE_2_KHR }
fun MemoryStack.AttachmentReference2KHR(block: VkAttachmentReference2KHR.() -> Unit): VkAttachmentReference2KHR = AttachmentReference2KHR().also(block)
fun MemoryStack.AttachmentReference2KHR(capacity: Int): VkAttachmentReference2KHR.Buffer = VkAttachmentReference2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.ATTACHMENT_REFERENCE_2_KHR }
fun MemoryStack.AttachmentReference2KHR(capacity: Int, block: VkAttachmentReference2KHR.Buffer.() -> Unit): VkAttachmentReference2KHR.Buffer = AttachmentReference2KHR(capacity).also(block)

fun MemoryStack.AttachmentSampleLocationsEXT(): VkAttachmentSampleLocationsEXT = VkAttachmentSampleLocationsEXT.callocStack(this)
fun MemoryStack.AttachmentSampleLocationsEXT(block: VkAttachmentSampleLocationsEXT.() -> Unit): VkAttachmentSampleLocationsEXT = AttachmentSampleLocationsEXT().also(block)
fun MemoryStack.AttachmentSampleLocationsEXT(capacity: Int): VkAttachmentSampleLocationsEXT.Buffer = VkAttachmentSampleLocationsEXT.callocStack(capacity, this)
fun MemoryStack.AttachmentSampleLocationsEXT(capacity: Int, block: VkAttachmentSampleLocationsEXT.Buffer.() -> Unit): VkAttachmentSampleLocationsEXT.Buffer = AttachmentSampleLocationsEXT(capacity).also(block)

fun MemoryStack.BaseInStructure(): VkBaseInStructure = VkBaseInStructure.callocStack(this)
fun MemoryStack.BaseInStructure(block: VkBaseInStructure.() -> Unit): VkBaseInStructure = BaseInStructure().also(block)
fun MemoryStack.BaseInStructure(capacity: Int): VkBaseInStructure.Buffer = VkBaseInStructure.callocStack(capacity, this)
fun MemoryStack.BaseInStructure(capacity: Int, block: VkBaseInStructure.Buffer.() -> Unit): VkBaseInStructure.Buffer = BaseInStructure(capacity).also(block)

fun MemoryStack.BaseOutStructure(): VkBaseOutStructure = VkBaseOutStructure.callocStack(this)
fun MemoryStack.BaseOutStructure(block: VkBaseOutStructure.() -> Unit): VkBaseOutStructure = BaseOutStructure().also(block)
fun MemoryStack.BaseOutStructure(capacity: Int): VkBaseOutStructure.Buffer = VkBaseOutStructure.callocStack(capacity, this)
fun MemoryStack.BaseOutStructure(capacity: Int, block: VkBaseOutStructure.Buffer.() -> Unit): VkBaseOutStructure.Buffer = BaseOutStructure(capacity).also(block)

fun MemoryStack.BindAccelerationStructureMemoryInfoNV(): VkBindAccelerationStructureMemoryInfoNV = VkBindAccelerationStructureMemoryInfoNV.callocStack(this).apply { type = VkStructureType.BIND_ACCELERATION_STRUCTURE_MEMORY_INFO_NV }
fun MemoryStack.BindAccelerationStructureMemoryInfoNV(block: VkBindAccelerationStructureMemoryInfoNV.() -> Unit): VkBindAccelerationStructureMemoryInfoNV = BindAccelerationStructureMemoryInfoNV().also(block)
fun MemoryStack.BindAccelerationStructureMemoryInfoNV(capacity: Int): VkBindAccelerationStructureMemoryInfoNV.Buffer = VkBindAccelerationStructureMemoryInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.BIND_ACCELERATION_STRUCTURE_MEMORY_INFO_NV }
fun MemoryStack.BindAccelerationStructureMemoryInfoNV(capacity: Int, block: VkBindAccelerationStructureMemoryInfoNV.Buffer.() -> Unit): VkBindAccelerationStructureMemoryInfoNV.Buffer = BindAccelerationStructureMemoryInfoNV(capacity).also(block)

fun MemoryStack.BindBufferMemoryDeviceGroupInfo(): VkBindBufferMemoryDeviceGroupInfo = VkBindBufferMemoryDeviceGroupInfo.callocStack(this).apply { type = VkStructureType.BIND_BUFFER_MEMORY_DEVICE_GROUP_INFO }
fun MemoryStack.BindBufferMemoryDeviceGroupInfo(block: VkBindBufferMemoryDeviceGroupInfo.() -> Unit): VkBindBufferMemoryDeviceGroupInfo = BindBufferMemoryDeviceGroupInfo().also(block)
fun MemoryStack.BindBufferMemoryDeviceGroupInfo(capacity: Int): VkBindBufferMemoryDeviceGroupInfo.Buffer = VkBindBufferMemoryDeviceGroupInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.BIND_BUFFER_MEMORY_DEVICE_GROUP_INFO }
fun MemoryStack.BindBufferMemoryDeviceGroupInfo(capacity: Int, block: VkBindBufferMemoryDeviceGroupInfo.Buffer.() -> Unit): VkBindBufferMemoryDeviceGroupInfo.Buffer = BindBufferMemoryDeviceGroupInfo(capacity).also(block)

fun MemoryStack.BindBufferMemoryInfo(): VkBindBufferMemoryInfo = VkBindBufferMemoryInfo.callocStack(this).apply { type = VkStructureType.BIND_BUFFER_MEMORY_INFO }
fun MemoryStack.BindBufferMemoryInfo(block: VkBindBufferMemoryInfo.() -> Unit): VkBindBufferMemoryInfo = BindBufferMemoryInfo().also(block)
fun MemoryStack.BindBufferMemoryInfo(capacity: Int): VkBindBufferMemoryInfo.Buffer = VkBindBufferMemoryInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.BIND_BUFFER_MEMORY_INFO }
fun MemoryStack.BindBufferMemoryInfo(capacity: Int, block: VkBindBufferMemoryInfo.Buffer.() -> Unit): VkBindBufferMemoryInfo.Buffer = BindBufferMemoryInfo(capacity).also(block)

fun MemoryStack.BindImageMemoryDeviceGroupInfo(): VkBindImageMemoryDeviceGroupInfo = VkBindImageMemoryDeviceGroupInfo.callocStack(this).apply { type = VkStructureType.BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO }
fun MemoryStack.BindImageMemoryDeviceGroupInfo(block: VkBindImageMemoryDeviceGroupInfo.() -> Unit): VkBindImageMemoryDeviceGroupInfo = BindImageMemoryDeviceGroupInfo().also(block)
fun MemoryStack.BindImageMemoryDeviceGroupInfo(capacity: Int): VkBindImageMemoryDeviceGroupInfo.Buffer = VkBindImageMemoryDeviceGroupInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO }
fun MemoryStack.BindImageMemoryDeviceGroupInfo(capacity: Int, block: VkBindImageMemoryDeviceGroupInfo.Buffer.() -> Unit): VkBindImageMemoryDeviceGroupInfo.Buffer = BindImageMemoryDeviceGroupInfo(capacity).also(block)

fun MemoryStack.BindImageMemoryInfo(): VkBindImageMemoryInfo = VkBindImageMemoryInfo.callocStack(this).apply { type = VkStructureType.BIND_IMAGE_MEMORY_INFO }
fun MemoryStack.BindImageMemoryInfo(block: VkBindImageMemoryInfo.() -> Unit): VkBindImageMemoryInfo = BindImageMemoryInfo().also(block)
fun MemoryStack.BindImageMemoryInfo(capacity: Int): VkBindImageMemoryInfo.Buffer = VkBindImageMemoryInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.BIND_IMAGE_MEMORY_INFO }
fun MemoryStack.BindImageMemoryInfo(capacity: Int, block: VkBindImageMemoryInfo.Buffer.() -> Unit): VkBindImageMemoryInfo.Buffer = BindImageMemoryInfo(capacity).also(block)

fun MemoryStack.BindImageMemorySwapchainInfoKHR(): VkBindImageMemorySwapchainInfoKHR = VkBindImageMemorySwapchainInfoKHR.callocStack(this).apply { type = VkStructureType.BIND_IMAGE_MEMORY_SWAPCHAIN_INFO_KHR }
fun MemoryStack.BindImageMemorySwapchainInfoKHR(block: VkBindImageMemorySwapchainInfoKHR.() -> Unit): VkBindImageMemorySwapchainInfoKHR = BindImageMemorySwapchainInfoKHR().also(block)
fun MemoryStack.BindImageMemorySwapchainInfoKHR(capacity: Int): VkBindImageMemorySwapchainInfoKHR.Buffer = VkBindImageMemorySwapchainInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.BIND_IMAGE_MEMORY_SWAPCHAIN_INFO_KHR }
fun MemoryStack.BindImageMemorySwapchainInfoKHR(capacity: Int, block: VkBindImageMemorySwapchainInfoKHR.Buffer.() -> Unit): VkBindImageMemorySwapchainInfoKHR.Buffer = BindImageMemorySwapchainInfoKHR(capacity).also(block)

fun MemoryStack.BindImagePlaneMemoryInfo(): VkBindImagePlaneMemoryInfo = VkBindImagePlaneMemoryInfo.callocStack(this).apply { type = VkStructureType.BIND_IMAGE_PLANE_MEMORY_INFO }
fun MemoryStack.BindImagePlaneMemoryInfo(block: VkBindImagePlaneMemoryInfo.() -> Unit): VkBindImagePlaneMemoryInfo = BindImagePlaneMemoryInfo().also(block)
fun MemoryStack.BindImagePlaneMemoryInfo(capacity: Int): VkBindImagePlaneMemoryInfo.Buffer = VkBindImagePlaneMemoryInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.BIND_IMAGE_PLANE_MEMORY_INFO }
fun MemoryStack.BindImagePlaneMemoryInfo(capacity: Int, block: VkBindImagePlaneMemoryInfo.Buffer.() -> Unit): VkBindImagePlaneMemoryInfo.Buffer = BindImagePlaneMemoryInfo(capacity).also(block)

fun MemoryStack.BindSparseInfo(): VkBindSparseInfo = VkBindSparseInfo.callocStack(this).apply { type = VkStructureType.BIND_SPARSE_INFO }
fun MemoryStack.BindSparseInfo(block: VkBindSparseInfo.() -> Unit): VkBindSparseInfo = BindSparseInfo().also(block)
fun MemoryStack.BindSparseInfo(capacity: Int): VkBindSparseInfo.Buffer = VkBindSparseInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.BIND_SPARSE_INFO }
fun MemoryStack.BindSparseInfo(capacity: Int, block: VkBindSparseInfo.Buffer.() -> Unit): VkBindSparseInfo.Buffer = BindSparseInfo(capacity).also(block)

fun MemoryStack.BufferCopy(): VkBufferCopy = VkBufferCopy.callocStack(this)
fun MemoryStack.BufferCopy(block: VkBufferCopy.() -> Unit): VkBufferCopy = BufferCopy().also(block)
fun MemoryStack.BufferCopy(capacity: Int): VkBufferCopy.Buffer = VkBufferCopy.callocStack(capacity, this)
fun MemoryStack.BufferCopy(capacity: Int, block: VkBufferCopy.Buffer.() -> Unit): VkBufferCopy.Buffer = BufferCopy(capacity).also(block)

fun MemoryStack.BufferCreateInfo(): VkBufferCreateInfo = VkBufferCreateInfo.callocStack(this).apply { type = VkStructureType.BUFFER_CREATE_INFO }
fun MemoryStack.BufferCreateInfo(block: VkBufferCreateInfo.() -> Unit): VkBufferCreateInfo = BufferCreateInfo().also(block)
fun MemoryStack.BufferCreateInfo(capacity: Int): VkBufferCreateInfo.Buffer = VkBufferCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.BUFFER_CREATE_INFO }
fun MemoryStack.BufferCreateInfo(capacity: Int, block: VkBufferCreateInfo.Buffer.() -> Unit): VkBufferCreateInfo.Buffer = BufferCreateInfo(capacity).also(block)

fun MemoryStack.BufferDeviceAddressCreateInfoEXT(): VkBufferDeviceAddressCreateInfoEXT = VkBufferDeviceAddressCreateInfoEXT.callocStack(this).apply { type = VkStructureType.BUFFER_DEVICE_ADDRESS_CREATE_INFO_EXT }
fun MemoryStack.BufferDeviceAddressCreateInfoEXT(block: VkBufferDeviceAddressCreateInfoEXT.() -> Unit): VkBufferDeviceAddressCreateInfoEXT = BufferDeviceAddressCreateInfoEXT().also(block)
fun MemoryStack.BufferDeviceAddressCreateInfoEXT(capacity: Int): VkBufferDeviceAddressCreateInfoEXT.Buffer = VkBufferDeviceAddressCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.BUFFER_DEVICE_ADDRESS_CREATE_INFO_EXT }
fun MemoryStack.BufferDeviceAddressCreateInfoEXT(capacity: Int, block: VkBufferDeviceAddressCreateInfoEXT.Buffer.() -> Unit): VkBufferDeviceAddressCreateInfoEXT.Buffer = BufferDeviceAddressCreateInfoEXT(capacity).also(block)

fun MemoryStack.BufferDeviceAddressInfoEXT(): VkBufferDeviceAddressInfoEXT = VkBufferDeviceAddressInfoEXT.callocStack(this).apply { type = VkStructureType.BUFFER_DEVICE_ADDRESS_INFO_EXT }
fun MemoryStack.BufferDeviceAddressInfoEXT(block: VkBufferDeviceAddressInfoEXT.() -> Unit): VkBufferDeviceAddressInfoEXT = BufferDeviceAddressInfoEXT().also(block)
fun MemoryStack.BufferDeviceAddressInfoEXT(capacity: Int): VkBufferDeviceAddressInfoEXT.Buffer = VkBufferDeviceAddressInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.BUFFER_DEVICE_ADDRESS_INFO_EXT }
fun MemoryStack.BufferDeviceAddressInfoEXT(capacity: Int, block: VkBufferDeviceAddressInfoEXT.Buffer.() -> Unit): VkBufferDeviceAddressInfoEXT.Buffer = BufferDeviceAddressInfoEXT(capacity).also(block)

fun MemoryStack.BufferImageCopy(): VkBufferImageCopy = VkBufferImageCopy.callocStack(this)
fun MemoryStack.BufferImageCopy(block: VkBufferImageCopy.() -> Unit): VkBufferImageCopy = BufferImageCopy().also(block)
fun MemoryStack.BufferImageCopy(capacity: Int): VkBufferImageCopy.Buffer = VkBufferImageCopy.callocStack(capacity, this)
fun MemoryStack.BufferImageCopy(capacity: Int, block: VkBufferImageCopy.Buffer.() -> Unit): VkBufferImageCopy.Buffer = BufferImageCopy(capacity).also(block)

fun MemoryStack.BufferMemoryBarrier(): VkBufferMemoryBarrier = VkBufferMemoryBarrier.callocStack(this).apply { type = VkStructureType.BUFFER_MEMORY_BARRIER }
fun MemoryStack.BufferMemoryBarrier(block: VkBufferMemoryBarrier.() -> Unit): VkBufferMemoryBarrier = BufferMemoryBarrier().also(block)
fun MemoryStack.BufferMemoryBarrier(capacity: Int): VkBufferMemoryBarrier.Buffer = VkBufferMemoryBarrier.callocStack(capacity, this).onEach { it.type = VkStructureType.BUFFER_MEMORY_BARRIER }
fun MemoryStack.BufferMemoryBarrier(capacity: Int, block: VkBufferMemoryBarrier.Buffer.() -> Unit): VkBufferMemoryBarrier.Buffer = BufferMemoryBarrier(capacity).also(block)

fun MemoryStack.BufferMemoryRequirementsInfo2(): VkBufferMemoryRequirementsInfo2 = VkBufferMemoryRequirementsInfo2.callocStack(this).apply { type = VkStructureType.BUFFER_MEMORY_REQUIREMENTS_INFO_2 }
fun MemoryStack.BufferMemoryRequirementsInfo2(block: VkBufferMemoryRequirementsInfo2.() -> Unit): VkBufferMemoryRequirementsInfo2 = BufferMemoryRequirementsInfo2().also(block)
fun MemoryStack.BufferMemoryRequirementsInfo2(capacity: Int): VkBufferMemoryRequirementsInfo2.Buffer = VkBufferMemoryRequirementsInfo2.callocStack(capacity, this).onEach { it.type = VkStructureType.BUFFER_MEMORY_REQUIREMENTS_INFO_2 }
fun MemoryStack.BufferMemoryRequirementsInfo2(capacity: Int, block: VkBufferMemoryRequirementsInfo2.Buffer.() -> Unit): VkBufferMemoryRequirementsInfo2.Buffer = BufferMemoryRequirementsInfo2(capacity).also(block)

fun MemoryStack.BufferViewCreateInfo(): VkBufferViewCreateInfo = VkBufferViewCreateInfo.callocStack(this).apply { type = VkStructureType.BUFFER_VIEW_CREATE_INFO }
fun MemoryStack.BufferViewCreateInfo(block: VkBufferViewCreateInfo.() -> Unit): VkBufferViewCreateInfo = BufferViewCreateInfo().also(block)
fun MemoryStack.BufferViewCreateInfo(capacity: Int): VkBufferViewCreateInfo.Buffer = VkBufferViewCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.BUFFER_VIEW_CREATE_INFO }
fun MemoryStack.BufferViewCreateInfo(capacity: Int, block: VkBufferViewCreateInfo.Buffer.() -> Unit): VkBufferViewCreateInfo.Buffer = BufferViewCreateInfo(capacity).also(block)

fun MemoryStack.CalibratedTimestampInfoEXT(): VkCalibratedTimestampInfoEXT = VkCalibratedTimestampInfoEXT.callocStack(this).apply { type = VkStructureType.CALIBRATED_TIMESTAMP_INFO_EXT }
fun MemoryStack.CalibratedTimestampInfoEXT(block: VkCalibratedTimestampInfoEXT.() -> Unit): VkCalibratedTimestampInfoEXT = CalibratedTimestampInfoEXT().also(block)
fun MemoryStack.CalibratedTimestampInfoEXT(capacity: Int): VkCalibratedTimestampInfoEXT.Buffer = VkCalibratedTimestampInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.CALIBRATED_TIMESTAMP_INFO_EXT }
fun MemoryStack.CalibratedTimestampInfoEXT(capacity: Int, block: VkCalibratedTimestampInfoEXT.Buffer.() -> Unit): VkCalibratedTimestampInfoEXT.Buffer = CalibratedTimestampInfoEXT(capacity).also(block)

fun MemoryStack.CheckpointDataNV(): VkCheckpointDataNV = VkCheckpointDataNV.callocStack(this).apply { type = VkStructureType.CHECKPOINT_DATA_NV }
fun MemoryStack.CheckpointDataNV(block: VkCheckpointDataNV.() -> Unit): VkCheckpointDataNV = CheckpointDataNV().also(block)
fun MemoryStack.CheckpointDataNV(capacity: Int): VkCheckpointDataNV.Buffer = VkCheckpointDataNV.callocStack(capacity, this).onEach { it.type = VkStructureType.CHECKPOINT_DATA_NV }
fun MemoryStack.CheckpointDataNV(capacity: Int, block: VkCheckpointDataNV.Buffer.() -> Unit): VkCheckpointDataNV.Buffer = CheckpointDataNV(capacity).also(block)

fun MemoryStack.ClearAttachment(): VkClearAttachment = VkClearAttachment.callocStack(this)
fun MemoryStack.ClearAttachment(block: VkClearAttachment.() -> Unit): VkClearAttachment = ClearAttachment().also(block)
fun MemoryStack.ClearAttachment(capacity: Int): VkClearAttachment.Buffer = VkClearAttachment.callocStack(capacity, this)
fun MemoryStack.ClearAttachment(capacity: Int, block: VkClearAttachment.Buffer.() -> Unit): VkClearAttachment.Buffer = ClearAttachment(capacity).also(block)

fun MemoryStack.ClearColorValue(): VkClearColorValue = VkClearColorValue.callocStack(this)
fun MemoryStack.ClearColorValue(block: VkClearColorValue.() -> Unit): VkClearColorValue = ClearColorValue().also(block)
fun MemoryStack.ClearColorValue(capacity: Int): VkClearColorValue.Buffer = VkClearColorValue.callocStack(capacity, this)
fun MemoryStack.ClearColorValue(capacity: Int, block: VkClearColorValue.Buffer.() -> Unit): VkClearColorValue.Buffer = ClearColorValue(capacity).also(block)

fun MemoryStack.ClearDepthStencilValue(): VkClearDepthStencilValue = VkClearDepthStencilValue.callocStack(this)
fun MemoryStack.ClearDepthStencilValue(block: VkClearDepthStencilValue.() -> Unit): VkClearDepthStencilValue = ClearDepthStencilValue().also(block)
fun MemoryStack.ClearDepthStencilValue(capacity: Int): VkClearDepthStencilValue.Buffer = VkClearDepthStencilValue.callocStack(capacity, this)
fun MemoryStack.ClearDepthStencilValue(capacity: Int, block: VkClearDepthStencilValue.Buffer.() -> Unit): VkClearDepthStencilValue.Buffer = ClearDepthStencilValue(capacity).also(block)

fun MemoryStack.ClearRect(): VkClearRect = VkClearRect.callocStack(this)
fun MemoryStack.ClearRect(block: VkClearRect.() -> Unit): VkClearRect = ClearRect().also(block)
fun MemoryStack.ClearRect(capacity: Int): VkClearRect.Buffer = VkClearRect.callocStack(capacity, this)
fun MemoryStack.ClearRect(capacity: Int, block: VkClearRect.Buffer.() -> Unit): VkClearRect.Buffer = ClearRect(capacity).also(block)

fun MemoryStack.ClearValue(): VkClearValue = VkClearValue.callocStack(this)
fun MemoryStack.ClearValue(block: VkClearValue.() -> Unit): VkClearValue = ClearValue().also(block)
fun MemoryStack.ClearValue(capacity: Int): VkClearValue.Buffer = VkClearValue.callocStack(capacity, this)
fun MemoryStack.ClearValue(capacity: Int, block: VkClearValue.Buffer.() -> Unit): VkClearValue.Buffer = ClearValue(capacity).also(block)

fun MemoryStack.CommandBufferAllocateInfo(): VkCommandBufferAllocateInfo = VkCommandBufferAllocateInfo.callocStack(this).apply { type = VkStructureType.COMMAND_BUFFER_ALLOCATE_INFO }
fun MemoryStack.CommandBufferAllocateInfo(block: VkCommandBufferAllocateInfo.() -> Unit): VkCommandBufferAllocateInfo = CommandBufferAllocateInfo().also(block)
fun MemoryStack.CommandBufferAllocateInfo(capacity: Int): VkCommandBufferAllocateInfo.Buffer = VkCommandBufferAllocateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.COMMAND_BUFFER_ALLOCATE_INFO }
fun MemoryStack.CommandBufferAllocateInfo(capacity: Int, block: VkCommandBufferAllocateInfo.Buffer.() -> Unit): VkCommandBufferAllocateInfo.Buffer = CommandBufferAllocateInfo(capacity).also(block)

fun MemoryStack.CommandBufferBeginInfo(): VkCommandBufferBeginInfo = VkCommandBufferBeginInfo.callocStack(this).apply { type = VkStructureType.COMMAND_BUFFER_BEGIN_INFO }
fun MemoryStack.CommandBufferBeginInfo(block: VkCommandBufferBeginInfo.() -> Unit): VkCommandBufferBeginInfo = CommandBufferBeginInfo().also(block)
fun MemoryStack.CommandBufferBeginInfo(capacity: Int): VkCommandBufferBeginInfo.Buffer = VkCommandBufferBeginInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.COMMAND_BUFFER_BEGIN_INFO }
fun MemoryStack.CommandBufferBeginInfo(capacity: Int, block: VkCommandBufferBeginInfo.Buffer.() -> Unit): VkCommandBufferBeginInfo.Buffer = CommandBufferBeginInfo(capacity).also(block)

fun MemoryStack.CommandBufferInheritanceConditionalRenderingInfoEXT(): VkCommandBufferInheritanceConditionalRenderingInfoEXT = VkCommandBufferInheritanceConditionalRenderingInfoEXT.callocStack(this).apply { type = VkStructureType.COMMAND_BUFFER_INHERITANCE_CONDITIONAL_RENDERING_INFO_EXT }
fun MemoryStack.CommandBufferInheritanceConditionalRenderingInfoEXT(block: VkCommandBufferInheritanceConditionalRenderingInfoEXT.() -> Unit): VkCommandBufferInheritanceConditionalRenderingInfoEXT = CommandBufferInheritanceConditionalRenderingInfoEXT().also(block)
fun MemoryStack.CommandBufferInheritanceConditionalRenderingInfoEXT(capacity: Int): VkCommandBufferInheritanceConditionalRenderingInfoEXT.Buffer = VkCommandBufferInheritanceConditionalRenderingInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.COMMAND_BUFFER_INHERITANCE_CONDITIONAL_RENDERING_INFO_EXT }
fun MemoryStack.CommandBufferInheritanceConditionalRenderingInfoEXT(capacity: Int, block: VkCommandBufferInheritanceConditionalRenderingInfoEXT.Buffer.() -> Unit): VkCommandBufferInheritanceConditionalRenderingInfoEXT.Buffer = CommandBufferInheritanceConditionalRenderingInfoEXT(capacity).also(block)

fun MemoryStack.CommandBufferInheritanceInfo(): VkCommandBufferInheritanceInfo = VkCommandBufferInheritanceInfo.callocStack(this).apply { type = VkStructureType.COMMAND_BUFFER_INHERITANCE_INFO }
fun MemoryStack.CommandBufferInheritanceInfo(block: VkCommandBufferInheritanceInfo.() -> Unit): VkCommandBufferInheritanceInfo = CommandBufferInheritanceInfo().also(block)
fun MemoryStack.CommandBufferInheritanceInfo(capacity: Int): VkCommandBufferInheritanceInfo.Buffer = VkCommandBufferInheritanceInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.COMMAND_BUFFER_INHERITANCE_INFO }
fun MemoryStack.CommandBufferInheritanceInfo(capacity: Int, block: VkCommandBufferInheritanceInfo.Buffer.() -> Unit): VkCommandBufferInheritanceInfo.Buffer = CommandBufferInheritanceInfo(capacity).also(block)

fun MemoryStack.CommandPoolCreateInfo(): VkCommandPoolCreateInfo = VkCommandPoolCreateInfo.callocStack(this).apply { type = VkStructureType.COMMAND_POOL_CREATE_INFO }
fun MemoryStack.CommandPoolCreateInfo(block: VkCommandPoolCreateInfo.() -> Unit): VkCommandPoolCreateInfo = CommandPoolCreateInfo().also(block)
fun MemoryStack.CommandPoolCreateInfo(capacity: Int): VkCommandPoolCreateInfo.Buffer = VkCommandPoolCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.COMMAND_POOL_CREATE_INFO }
fun MemoryStack.CommandPoolCreateInfo(capacity: Int, block: VkCommandPoolCreateInfo.Buffer.() -> Unit): VkCommandPoolCreateInfo.Buffer = CommandPoolCreateInfo(capacity).also(block)

fun MemoryStack.CmdProcessCommandsInfoNVX(): VkCmdProcessCommandsInfoNVX = VkCmdProcessCommandsInfoNVX.callocStack(this).apply { type = VkStructureType.CMD_PROCESS_COMMANDS_INFO_NVX }
fun MemoryStack.CmdProcessCommandsInfoNVX(block: VkCmdProcessCommandsInfoNVX.() -> Unit): VkCmdProcessCommandsInfoNVX = CmdProcessCommandsInfoNVX().also(block)
fun MemoryStack.CmdProcessCommandsInfoNVX(capacity: Int): VkCmdProcessCommandsInfoNVX.Buffer = VkCmdProcessCommandsInfoNVX.callocStack(capacity, this).onEach { it.type = VkStructureType.CMD_PROCESS_COMMANDS_INFO_NVX }
fun MemoryStack.CmdProcessCommandsInfoNVX(capacity: Int, block: VkCmdProcessCommandsInfoNVX.Buffer.() -> Unit): VkCmdProcessCommandsInfoNVX.Buffer = CmdProcessCommandsInfoNVX(capacity).also(block)

fun MemoryStack.CmdReserveSpaceForCommandsInfoNVX(): VkCmdReserveSpaceForCommandsInfoNVX = VkCmdReserveSpaceForCommandsInfoNVX.callocStack(this).apply { type = VkStructureType.CMD_RESERVE_SPACE_FOR_COMMANDS_INFO_NVX }
fun MemoryStack.CmdReserveSpaceForCommandsInfoNVX(block: VkCmdReserveSpaceForCommandsInfoNVX.() -> Unit): VkCmdReserveSpaceForCommandsInfoNVX = CmdReserveSpaceForCommandsInfoNVX().also(block)
fun MemoryStack.CmdReserveSpaceForCommandsInfoNVX(capacity: Int): VkCmdReserveSpaceForCommandsInfoNVX.Buffer = VkCmdReserveSpaceForCommandsInfoNVX.callocStack(capacity, this).onEach { it.type = VkStructureType.CMD_RESERVE_SPACE_FOR_COMMANDS_INFO_NVX }
fun MemoryStack.CmdReserveSpaceForCommandsInfoNVX(capacity: Int, block: VkCmdReserveSpaceForCommandsInfoNVX.Buffer.() -> Unit): VkCmdReserveSpaceForCommandsInfoNVX.Buffer = CmdReserveSpaceForCommandsInfoNVX(capacity).also(block)

fun MemoryStack.CoarseSampleLocationNV(): VkCoarseSampleLocationNV = VkCoarseSampleLocationNV.callocStack(this)
fun MemoryStack.CoarseSampleLocationNV(block: VkCoarseSampleLocationNV.() -> Unit): VkCoarseSampleLocationNV = CoarseSampleLocationNV().also(block)
fun MemoryStack.CoarseSampleLocationNV(capacity: Int): VkCoarseSampleLocationNV.Buffer = VkCoarseSampleLocationNV.callocStack(capacity, this)
fun MemoryStack.CoarseSampleLocationNV(capacity: Int, block: VkCoarseSampleLocationNV.Buffer.() -> Unit): VkCoarseSampleLocationNV.Buffer = CoarseSampleLocationNV(capacity).also(block)

fun MemoryStack.CoarseSampleOrderCustomNV(): VkCoarseSampleOrderCustomNV = VkCoarseSampleOrderCustomNV.callocStack(this)
fun MemoryStack.CoarseSampleOrderCustomNV(block: VkCoarseSampleOrderCustomNV.() -> Unit): VkCoarseSampleOrderCustomNV = CoarseSampleOrderCustomNV().also(block)
fun MemoryStack.CoarseSampleOrderCustomNV(capacity: Int): VkCoarseSampleOrderCustomNV.Buffer = VkCoarseSampleOrderCustomNV.callocStack(capacity, this)
fun MemoryStack.CoarseSampleOrderCustomNV(capacity: Int, block: VkCoarseSampleOrderCustomNV.Buffer.() -> Unit): VkCoarseSampleOrderCustomNV.Buffer = CoarseSampleOrderCustomNV(capacity).also(block)

fun MemoryStack.ComponentMapping(): VkComponentMapping = VkComponentMapping.callocStack(this)
fun MemoryStack.ComponentMapping(block: VkComponentMapping.() -> Unit): VkComponentMapping = ComponentMapping().also(block)
fun MemoryStack.ComponentMapping(capacity: Int): VkComponentMapping.Buffer = VkComponentMapping.callocStack(capacity, this)
fun MemoryStack.ComponentMapping(capacity: Int, block: VkComponentMapping.Buffer.() -> Unit): VkComponentMapping.Buffer = ComponentMapping(capacity).also(block)

fun MemoryStack.ComputePipelineCreateInfo(): VkComputePipelineCreateInfo = VkComputePipelineCreateInfo.callocStack(this).apply { type = VkStructureType.COMPUTE_PIPELINE_CREATE_INFO }
fun MemoryStack.ComputePipelineCreateInfo(block: VkComputePipelineCreateInfo.() -> Unit): VkComputePipelineCreateInfo = ComputePipelineCreateInfo().also(block)
fun MemoryStack.ComputePipelineCreateInfo(capacity: Int): VkComputePipelineCreateInfo.Buffer = VkComputePipelineCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.COMPUTE_PIPELINE_CREATE_INFO }
fun MemoryStack.ComputePipelineCreateInfo(capacity: Int, block: VkComputePipelineCreateInfo.Buffer.() -> Unit): VkComputePipelineCreateInfo.Buffer = ComputePipelineCreateInfo(capacity).also(block)

fun MemoryStack.ConditionalRenderingBeginInfoEXT(): VkConditionalRenderingBeginInfoEXT = VkConditionalRenderingBeginInfoEXT.callocStack(this).apply { type = VkStructureType.CONDITIONAL_RENDERING_BEGIN_INFO_EXT }
fun MemoryStack.ConditionalRenderingBeginInfoEXT(block: VkConditionalRenderingBeginInfoEXT.() -> Unit): VkConditionalRenderingBeginInfoEXT = ConditionalRenderingBeginInfoEXT().also(block)
fun MemoryStack.ConditionalRenderingBeginInfoEXT(capacity: Int): VkConditionalRenderingBeginInfoEXT.Buffer = VkConditionalRenderingBeginInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.CONDITIONAL_RENDERING_BEGIN_INFO_EXT }
fun MemoryStack.ConditionalRenderingBeginInfoEXT(capacity: Int, block: VkConditionalRenderingBeginInfoEXT.Buffer.() -> Unit): VkConditionalRenderingBeginInfoEXT.Buffer = ConditionalRenderingBeginInfoEXT(capacity).also(block)

fun MemoryStack.ConformanceVersionKHR(): VkConformanceVersionKHR = VkConformanceVersionKHR.callocStack(this)
fun MemoryStack.ConformanceVersionKHR(block: VkConformanceVersionKHR.() -> Unit): VkConformanceVersionKHR = ConformanceVersionKHR().also(block)
fun MemoryStack.ConformanceVersionKHR(capacity: Int): VkConformanceVersionKHR.Buffer = VkConformanceVersionKHR.callocStack(capacity, this)
fun MemoryStack.ConformanceVersionKHR(capacity: Int, block: VkConformanceVersionKHR.Buffer.() -> Unit): VkConformanceVersionKHR.Buffer = ConformanceVersionKHR(capacity).also(block)

fun MemoryStack.CopyDescriptorSet(): VkCopyDescriptorSet = VkCopyDescriptorSet.callocStack(this).apply { type = VkStructureType.COPY_DESCRIPTOR_SET }
fun MemoryStack.CopyDescriptorSet(block: VkCopyDescriptorSet.() -> Unit): VkCopyDescriptorSet = CopyDescriptorSet().also(block)
fun MemoryStack.CopyDescriptorSet(capacity: Int): VkCopyDescriptorSet.Buffer = VkCopyDescriptorSet.callocStack(capacity, this).onEach { it.type = VkStructureType.COPY_DESCRIPTOR_SET }
fun MemoryStack.CopyDescriptorSet(capacity: Int, block: VkCopyDescriptorSet.Buffer.() -> Unit): VkCopyDescriptorSet.Buffer = CopyDescriptorSet(capacity).also(block)

fun MemoryStack.DebugMarkerMarkerInfoEXT(): VkDebugMarkerMarkerInfoEXT = VkDebugMarkerMarkerInfoEXT.callocStack(this).apply { type = VkStructureType.DEBUG_MARKER_MARKER_INFO_EXT }
fun MemoryStack.DebugMarkerMarkerInfoEXT(block: VkDebugMarkerMarkerInfoEXT.() -> Unit): VkDebugMarkerMarkerInfoEXT = DebugMarkerMarkerInfoEXT().also(block)
fun MemoryStack.DebugMarkerMarkerInfoEXT(capacity: Int): VkDebugMarkerMarkerInfoEXT.Buffer = VkDebugMarkerMarkerInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEBUG_MARKER_MARKER_INFO_EXT }
fun MemoryStack.DebugMarkerMarkerInfoEXT(capacity: Int, block: VkDebugMarkerMarkerInfoEXT.Buffer.() -> Unit): VkDebugMarkerMarkerInfoEXT.Buffer = DebugMarkerMarkerInfoEXT(capacity).also(block)

fun MemoryStack.DebugMarkerObjectNameInfoEXT(): VkDebugMarkerObjectNameInfoEXT = VkDebugMarkerObjectNameInfoEXT.callocStack(this).apply { type = VkStructureType.DEBUG_MARKER_OBJECT_NAME_INFO_EXT }
fun MemoryStack.DebugMarkerObjectNameInfoEXT(block: VkDebugMarkerObjectNameInfoEXT.() -> Unit): VkDebugMarkerObjectNameInfoEXT = DebugMarkerObjectNameInfoEXT().also(block)
fun MemoryStack.DebugMarkerObjectNameInfoEXT(capacity: Int): VkDebugMarkerObjectNameInfoEXT.Buffer = VkDebugMarkerObjectNameInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEBUG_MARKER_OBJECT_NAME_INFO_EXT }
fun MemoryStack.DebugMarkerObjectNameInfoEXT(capacity: Int, block: VkDebugMarkerObjectNameInfoEXT.Buffer.() -> Unit): VkDebugMarkerObjectNameInfoEXT.Buffer = DebugMarkerObjectNameInfoEXT(capacity).also(block)

fun MemoryStack.DebugMarkerObjectTagInfoEXT(): VkDebugMarkerObjectTagInfoEXT = VkDebugMarkerObjectTagInfoEXT.callocStack(this).apply { type = VkStructureType.DEBUG_MARKER_OBJECT_TAG_INFO_EXT }
fun MemoryStack.DebugMarkerObjectTagInfoEXT(block: VkDebugMarkerObjectTagInfoEXT.() -> Unit): VkDebugMarkerObjectTagInfoEXT = DebugMarkerObjectTagInfoEXT().also(block)
fun MemoryStack.DebugMarkerObjectTagInfoEXT(capacity: Int): VkDebugMarkerObjectTagInfoEXT.Buffer = VkDebugMarkerObjectTagInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEBUG_MARKER_OBJECT_TAG_INFO_EXT }
fun MemoryStack.DebugMarkerObjectTagInfoEXT(capacity: Int, block: VkDebugMarkerObjectTagInfoEXT.Buffer.() -> Unit): VkDebugMarkerObjectTagInfoEXT.Buffer = DebugMarkerObjectTagInfoEXT(capacity).also(block)

fun MemoryStack.DebugReportCallbackCreateInfoEXT(): VkDebugReportCallbackCreateInfoEXT = VkDebugReportCallbackCreateInfoEXT.callocStack(this).apply { type = VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT }
fun MemoryStack.DebugReportCallbackCreateInfoEXT(block: VkDebugReportCallbackCreateInfoEXT.() -> Unit): VkDebugReportCallbackCreateInfoEXT = DebugReportCallbackCreateInfoEXT().also(block)
fun MemoryStack.DebugReportCallbackCreateInfoEXT(capacity: Int): VkDebugReportCallbackCreateInfoEXT.Buffer = VkDebugReportCallbackCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT }
fun MemoryStack.DebugReportCallbackCreateInfoEXT(capacity: Int, block: VkDebugReportCallbackCreateInfoEXT.Buffer.() -> Unit): VkDebugReportCallbackCreateInfoEXT.Buffer = DebugReportCallbackCreateInfoEXT(capacity).also(block)

fun MemoryStack.DebugUtilsLabelEXT(): VkDebugUtilsLabelEXT = VkDebugUtilsLabelEXT.callocStack(this).apply { type = VkStructureType.DEBUG_UTILS_LABEL_EXT }
fun MemoryStack.DebugUtilsLabelEXT(block: VkDebugUtilsLabelEXT.() -> Unit): VkDebugUtilsLabelEXT = DebugUtilsLabelEXT().also(block)
fun MemoryStack.DebugUtilsLabelEXT(capacity: Int): VkDebugUtilsLabelEXT.Buffer = VkDebugUtilsLabelEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEBUG_UTILS_LABEL_EXT }
fun MemoryStack.DebugUtilsLabelEXT(capacity: Int, block: VkDebugUtilsLabelEXT.Buffer.() -> Unit): VkDebugUtilsLabelEXT.Buffer = DebugUtilsLabelEXT(capacity).also(block)

fun MemoryStack.DebugUtilsMessengerCallbackDataEXT(): VkDebugUtilsMessengerCallbackDataEXT = VkDebugUtilsMessengerCallbackDataEXT.callocStack(this).apply { type = VkStructureType.DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT }
fun MemoryStack.DebugUtilsMessengerCallbackDataEXT(block: VkDebugUtilsMessengerCallbackDataEXT.() -> Unit): VkDebugUtilsMessengerCallbackDataEXT = DebugUtilsMessengerCallbackDataEXT().also(block)
fun MemoryStack.DebugUtilsMessengerCallbackDataEXT(capacity: Int): VkDebugUtilsMessengerCallbackDataEXT.Buffer = VkDebugUtilsMessengerCallbackDataEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT }
fun MemoryStack.DebugUtilsMessengerCallbackDataEXT(capacity: Int, block: VkDebugUtilsMessengerCallbackDataEXT.Buffer.() -> Unit): VkDebugUtilsMessengerCallbackDataEXT.Buffer = DebugUtilsMessengerCallbackDataEXT(capacity).also(block)

fun MemoryStack.DebugUtilsMessengerCreateInfoEXT(): VkDebugUtilsMessengerCreateInfoEXT = VkDebugUtilsMessengerCreateInfoEXT.callocStack(this).apply { type = VkStructureType.DEBUG_UTILS_MESSENGER_CREATE_INFO_EXT }
fun MemoryStack.DebugUtilsMessengerCreateInfoEXT(block: VkDebugUtilsMessengerCreateInfoEXT.() -> Unit): VkDebugUtilsMessengerCreateInfoEXT = DebugUtilsMessengerCreateInfoEXT().also(block)
fun MemoryStack.DebugUtilsMessengerCreateInfoEXT(capacity: Int): VkDebugUtilsMessengerCreateInfoEXT.Buffer = VkDebugUtilsMessengerCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEBUG_UTILS_MESSENGER_CREATE_INFO_EXT }
fun MemoryStack.DebugUtilsMessengerCreateInfoEXT(capacity: Int, block: VkDebugUtilsMessengerCreateInfoEXT.Buffer.() -> Unit): VkDebugUtilsMessengerCreateInfoEXT.Buffer = DebugUtilsMessengerCreateInfoEXT(capacity).also(block)

fun MemoryStack.DebugUtilsObjectNameInfoEXT(): VkDebugUtilsObjectNameInfoEXT = VkDebugUtilsObjectNameInfoEXT.callocStack(this).apply { type = VkStructureType.DEBUG_UTILS_OBJECT_NAME_INFO_EXT }
fun MemoryStack.DebugUtilsObjectNameInfoEXT(block: VkDebugUtilsObjectNameInfoEXT.() -> Unit): VkDebugUtilsObjectNameInfoEXT = DebugUtilsObjectNameInfoEXT().also(block)
fun MemoryStack.DebugUtilsObjectNameInfoEXT(capacity: Int): VkDebugUtilsObjectNameInfoEXT.Buffer = VkDebugUtilsObjectNameInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEBUG_UTILS_OBJECT_NAME_INFO_EXT }
fun MemoryStack.DebugUtilsObjectNameInfoEXT(capacity: Int, block: VkDebugUtilsObjectNameInfoEXT.Buffer.() -> Unit): VkDebugUtilsObjectNameInfoEXT.Buffer = DebugUtilsObjectNameInfoEXT(capacity).also(block)

fun MemoryStack.DebugUtilsObjectTagInfoEXT(): VkDebugUtilsObjectTagInfoEXT = VkDebugUtilsObjectTagInfoEXT.callocStack(this).apply { type = VkStructureType.DEBUG_UTILS_OBJECT_TAG_INFO_EXT }
fun MemoryStack.DebugUtilsObjectTagInfoEXT(block: VkDebugUtilsObjectTagInfoEXT.() -> Unit): VkDebugUtilsObjectTagInfoEXT = DebugUtilsObjectTagInfoEXT().also(block)
fun MemoryStack.DebugUtilsObjectTagInfoEXT(capacity: Int): VkDebugUtilsObjectTagInfoEXT.Buffer = VkDebugUtilsObjectTagInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEBUG_UTILS_OBJECT_TAG_INFO_EXT }
fun MemoryStack.DebugUtilsObjectTagInfoEXT(capacity: Int, block: VkDebugUtilsObjectTagInfoEXT.Buffer.() -> Unit): VkDebugUtilsObjectTagInfoEXT.Buffer = DebugUtilsObjectTagInfoEXT(capacity).also(block)

fun MemoryStack.DedicatedAllocationBufferCreateInfoNV(): VkDedicatedAllocationBufferCreateInfoNV = VkDedicatedAllocationBufferCreateInfoNV.callocStack(this).apply { type = VkStructureType.DEDICATED_ALLOCATION_BUFFER_CREATE_INFO_NV }
fun MemoryStack.DedicatedAllocationBufferCreateInfoNV(block: VkDedicatedAllocationBufferCreateInfoNV.() -> Unit): VkDedicatedAllocationBufferCreateInfoNV = DedicatedAllocationBufferCreateInfoNV().also(block)
fun MemoryStack.DedicatedAllocationBufferCreateInfoNV(capacity: Int): VkDedicatedAllocationBufferCreateInfoNV.Buffer = VkDedicatedAllocationBufferCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.DEDICATED_ALLOCATION_BUFFER_CREATE_INFO_NV }
fun MemoryStack.DedicatedAllocationBufferCreateInfoNV(capacity: Int, block: VkDedicatedAllocationBufferCreateInfoNV.Buffer.() -> Unit): VkDedicatedAllocationBufferCreateInfoNV.Buffer = DedicatedAllocationBufferCreateInfoNV(capacity).also(block)

fun MemoryStack.DedicatedAllocationImageCreateInfoNV(): VkDedicatedAllocationImageCreateInfoNV = VkDedicatedAllocationImageCreateInfoNV.callocStack(this).apply { type = VkStructureType.DEDICATED_ALLOCATION_IMAGE_CREATE_INFO_NV }
fun MemoryStack.DedicatedAllocationImageCreateInfoNV(block: VkDedicatedAllocationImageCreateInfoNV.() -> Unit): VkDedicatedAllocationImageCreateInfoNV = DedicatedAllocationImageCreateInfoNV().also(block)
fun MemoryStack.DedicatedAllocationImageCreateInfoNV(capacity: Int): VkDedicatedAllocationImageCreateInfoNV.Buffer = VkDedicatedAllocationImageCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.DEDICATED_ALLOCATION_IMAGE_CREATE_INFO_NV }
fun MemoryStack.DedicatedAllocationImageCreateInfoNV(capacity: Int, block: VkDedicatedAllocationImageCreateInfoNV.Buffer.() -> Unit): VkDedicatedAllocationImageCreateInfoNV.Buffer = DedicatedAllocationImageCreateInfoNV(capacity).also(block)

fun MemoryStack.DedicatedAllocationMemoryAllocateInfoNV(): VkDedicatedAllocationMemoryAllocateInfoNV = VkDedicatedAllocationMemoryAllocateInfoNV.callocStack(this).apply { type = VkStructureType.DEDICATED_ALLOCATION_MEMORY_ALLOCATE_INFO_NV }
fun MemoryStack.DedicatedAllocationMemoryAllocateInfoNV(block: VkDedicatedAllocationMemoryAllocateInfoNV.() -> Unit): VkDedicatedAllocationMemoryAllocateInfoNV = DedicatedAllocationMemoryAllocateInfoNV().also(block)
fun MemoryStack.DedicatedAllocationMemoryAllocateInfoNV(capacity: Int): VkDedicatedAllocationMemoryAllocateInfoNV.Buffer = VkDedicatedAllocationMemoryAllocateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.DEDICATED_ALLOCATION_MEMORY_ALLOCATE_INFO_NV }
fun MemoryStack.DedicatedAllocationMemoryAllocateInfoNV(capacity: Int, block: VkDedicatedAllocationMemoryAllocateInfoNV.Buffer.() -> Unit): VkDedicatedAllocationMemoryAllocateInfoNV.Buffer = DedicatedAllocationMemoryAllocateInfoNV(capacity).also(block)

fun MemoryStack.DescriptorBufferInfo(): VkDescriptorBufferInfo = VkDescriptorBufferInfo.callocStack(this)
fun MemoryStack.DescriptorBufferInfo(block: VkDescriptorBufferInfo.() -> Unit): VkDescriptorBufferInfo = DescriptorBufferInfo().also(block)
fun MemoryStack.DescriptorBufferInfo(capacity: Int): VkDescriptorBufferInfo.Buffer = VkDescriptorBufferInfo.callocStack(capacity, this)
fun MemoryStack.DescriptorBufferInfo(capacity: Int, block: VkDescriptorBufferInfo.Buffer.() -> Unit): VkDescriptorBufferInfo.Buffer = DescriptorBufferInfo(capacity).also(block)

fun MemoryStack.DescriptorImageInfo(): VkDescriptorImageInfo = VkDescriptorImageInfo.callocStack(this)
fun MemoryStack.DescriptorImageInfo(block: VkDescriptorImageInfo.() -> Unit): VkDescriptorImageInfo = DescriptorImageInfo().also(block)
fun MemoryStack.DescriptorImageInfo(capacity: Int): VkDescriptorImageInfo.Buffer = VkDescriptorImageInfo.callocStack(capacity, this)
fun MemoryStack.DescriptorImageInfo(capacity: Int, block: VkDescriptorImageInfo.Buffer.() -> Unit): VkDescriptorImageInfo.Buffer = DescriptorImageInfo(capacity).also(block)

fun MemoryStack.DescriptorPoolCreateInfo(): VkDescriptorPoolCreateInfo = VkDescriptorPoolCreateInfo.callocStack(this).apply { type = VkStructureType.DESCRIPTOR_POOL_CREATE_INFO }
fun MemoryStack.DescriptorPoolCreateInfo(block: VkDescriptorPoolCreateInfo.() -> Unit): VkDescriptorPoolCreateInfo = DescriptorPoolCreateInfo().also(block)
fun MemoryStack.DescriptorPoolCreateInfo(capacity: Int): VkDescriptorPoolCreateInfo.Buffer = VkDescriptorPoolCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DESCRIPTOR_POOL_CREATE_INFO }
fun MemoryStack.DescriptorPoolCreateInfo(capacity: Int, block: VkDescriptorPoolCreateInfo.Buffer.() -> Unit): VkDescriptorPoolCreateInfo.Buffer = DescriptorPoolCreateInfo(capacity).also(block)

fun MemoryStack.DescriptorPoolInlineUniformBlockCreateInfoEXT(): VkDescriptorPoolInlineUniformBlockCreateInfoEXT = VkDescriptorPoolInlineUniformBlockCreateInfoEXT.callocStack(this).apply { type = VkStructureType.DESCRIPTOR_POOL_INLINE_UNIFORM_BLOCK_CREATE_INFO_EXT }
fun MemoryStack.DescriptorPoolInlineUniformBlockCreateInfoEXT(block: VkDescriptorPoolInlineUniformBlockCreateInfoEXT.() -> Unit): VkDescriptorPoolInlineUniformBlockCreateInfoEXT = DescriptorPoolInlineUniformBlockCreateInfoEXT().also(block)
fun MemoryStack.DescriptorPoolInlineUniformBlockCreateInfoEXT(capacity: Int): VkDescriptorPoolInlineUniformBlockCreateInfoEXT.Buffer = VkDescriptorPoolInlineUniformBlockCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DESCRIPTOR_POOL_INLINE_UNIFORM_BLOCK_CREATE_INFO_EXT }
fun MemoryStack.DescriptorPoolInlineUniformBlockCreateInfoEXT(capacity: Int, block: VkDescriptorPoolInlineUniformBlockCreateInfoEXT.Buffer.() -> Unit): VkDescriptorPoolInlineUniformBlockCreateInfoEXT.Buffer = DescriptorPoolInlineUniformBlockCreateInfoEXT(capacity).also(block)

fun MemoryStack.DescriptorPoolSize(): VkDescriptorPoolSize = VkDescriptorPoolSize.callocStack(this)
fun MemoryStack.DescriptorPoolSize(block: VkDescriptorPoolSize.() -> Unit): VkDescriptorPoolSize = DescriptorPoolSize().also(block)
fun MemoryStack.DescriptorPoolSize(capacity: Int): VkDescriptorPoolSize.Buffer = VkDescriptorPoolSize.callocStack(capacity, this)
fun MemoryStack.DescriptorPoolSize(capacity: Int, block: VkDescriptorPoolSize.Buffer.() -> Unit): VkDescriptorPoolSize.Buffer = DescriptorPoolSize(capacity).also(block)

fun MemoryStack.DescriptorSetAllocateInfo(): VkDescriptorSetAllocateInfo = VkDescriptorSetAllocateInfo.callocStack(this).apply { type = VkStructureType.DESCRIPTOR_SET_ALLOCATE_INFO }
fun MemoryStack.DescriptorSetAllocateInfo(block: VkDescriptorSetAllocateInfo.() -> Unit): VkDescriptorSetAllocateInfo = DescriptorSetAllocateInfo().also(block)
fun MemoryStack.DescriptorSetAllocateInfo(capacity: Int): VkDescriptorSetAllocateInfo.Buffer = VkDescriptorSetAllocateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DESCRIPTOR_SET_ALLOCATE_INFO }
fun MemoryStack.DescriptorSetAllocateInfo(capacity: Int, block: VkDescriptorSetAllocateInfo.Buffer.() -> Unit): VkDescriptorSetAllocateInfo.Buffer = DescriptorSetAllocateInfo(capacity).also(block)

fun MemoryStack.DescriptorSetLayoutBinding(): VkDescriptorSetLayoutBinding = VkDescriptorSetLayoutBinding.callocStack(this)
fun MemoryStack.DescriptorSetLayoutBinding(block: VkDescriptorSetLayoutBinding.() -> Unit): VkDescriptorSetLayoutBinding = DescriptorSetLayoutBinding().also(block)
fun MemoryStack.DescriptorSetLayoutBinding(capacity: Int): VkDescriptorSetLayoutBinding.Buffer = VkDescriptorSetLayoutBinding.callocStack(capacity, this)
fun MemoryStack.DescriptorSetLayoutBinding(capacity: Int, block: VkDescriptorSetLayoutBinding.Buffer.() -> Unit): VkDescriptorSetLayoutBinding.Buffer = DescriptorSetLayoutBinding(capacity).also(block)

fun MemoryStack.DescriptorSetLayoutBindingFlagsCreateInfoEXT(): VkDescriptorSetLayoutBindingFlagsCreateInfoEXT = VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.callocStack(this).apply { type = VkStructureType.DESCRIPTOR_SET_LAYOUT_BINDING_FLAGS_CREATE_INFO_EXT }
fun MemoryStack.DescriptorSetLayoutBindingFlagsCreateInfoEXT(block: VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.() -> Unit): VkDescriptorSetLayoutBindingFlagsCreateInfoEXT = DescriptorSetLayoutBindingFlagsCreateInfoEXT().also(block)
fun MemoryStack.DescriptorSetLayoutBindingFlagsCreateInfoEXT(capacity: Int): VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.Buffer = VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DESCRIPTOR_SET_LAYOUT_BINDING_FLAGS_CREATE_INFO_EXT }
fun MemoryStack.DescriptorSetLayoutBindingFlagsCreateInfoEXT(capacity: Int, block: VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.Buffer.() -> Unit): VkDescriptorSetLayoutBindingFlagsCreateInfoEXT.Buffer = DescriptorSetLayoutBindingFlagsCreateInfoEXT(capacity).also(block)

fun MemoryStack.DescriptorSetLayoutCreateInfo(): VkDescriptorSetLayoutCreateInfo = VkDescriptorSetLayoutCreateInfo.callocStack(this).apply { type = VkStructureType.DESCRIPTOR_SET_LAYOUT_CREATE_INFO }
fun MemoryStack.DescriptorSetLayoutCreateInfo(block: VkDescriptorSetLayoutCreateInfo.() -> Unit): VkDescriptorSetLayoutCreateInfo = DescriptorSetLayoutCreateInfo().also(block)
fun MemoryStack.DescriptorSetLayoutCreateInfo(capacity: Int): VkDescriptorSetLayoutCreateInfo.Buffer = VkDescriptorSetLayoutCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DESCRIPTOR_SET_LAYOUT_CREATE_INFO }
fun MemoryStack.DescriptorSetLayoutCreateInfo(capacity: Int, block: VkDescriptorSetLayoutCreateInfo.Buffer.() -> Unit): VkDescriptorSetLayoutCreateInfo.Buffer = DescriptorSetLayoutCreateInfo(capacity).also(block)

fun MemoryStack.DescriptorSetLayoutSupport(): VkDescriptorSetLayoutSupport = VkDescriptorSetLayoutSupport.callocStack(this).apply { type = VkStructureType.DESCRIPTOR_SET_LAYOUT_SUPPORT }
fun MemoryStack.DescriptorSetLayoutSupport(block: VkDescriptorSetLayoutSupport.() -> Unit): VkDescriptorSetLayoutSupport = DescriptorSetLayoutSupport().also(block)
fun MemoryStack.DescriptorSetLayoutSupport(capacity: Int): VkDescriptorSetLayoutSupport.Buffer = VkDescriptorSetLayoutSupport.callocStack(capacity, this).onEach { it.type = VkStructureType.DESCRIPTOR_SET_LAYOUT_SUPPORT }
fun MemoryStack.DescriptorSetLayoutSupport(capacity: Int, block: VkDescriptorSetLayoutSupport.Buffer.() -> Unit): VkDescriptorSetLayoutSupport.Buffer = DescriptorSetLayoutSupport(capacity).also(block)

fun MemoryStack.DescriptorSetVariableDescriptorCountAllocateInfoEXT(): VkDescriptorSetVariableDescriptorCountAllocateInfoEXT = VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.callocStack(this).apply { type = VkStructureType.DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO_EXT }
fun MemoryStack.DescriptorSetVariableDescriptorCountAllocateInfoEXT(block: VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.() -> Unit): VkDescriptorSetVariableDescriptorCountAllocateInfoEXT = DescriptorSetVariableDescriptorCountAllocateInfoEXT().also(block)
fun MemoryStack.DescriptorSetVariableDescriptorCountAllocateInfoEXT(capacity: Int): VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.Buffer = VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO_EXT }
fun MemoryStack.DescriptorSetVariableDescriptorCountAllocateInfoEXT(capacity: Int, block: VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.Buffer.() -> Unit): VkDescriptorSetVariableDescriptorCountAllocateInfoEXT.Buffer = DescriptorSetVariableDescriptorCountAllocateInfoEXT(capacity).also(block)

//fun MemoryStack.DescriptorSetVariableDescriptorCountLayoutSupportEXT(): VkDescriptorSetVariableDescriptorCountLayoutSupportEXT = VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.callocStack(this).apply { type = VkStructureType.DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO_EXT }
//fun MemoryStack.DescriptorSetVariableDescriptorCountLayoutSupportEXT(block: VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.() -> Unit): VkDescriptorSetVariableDescriptorCountLayoutSupportEXT = DescriptorSetVariableDescriptorCountLayoutSupportEXT().also(block)
//fun MemoryStack.DescriptorSetVariableDescriptorCountLayoutSupportEXT(capacity: Int): VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.Buffer = VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO_EXT }
//fun MemoryStack.DescriptorSetVariableDescriptorCountLayoutSupportEXT(capacity: Int, block: VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.Buffer.() -> Unit): VkDescriptorSetVariableDescriptorCountLayoutSupportEXT.Buffer = DescriptorSetVariableDescriptorCountLayoutSupportEXT(capacity).also(block)

fun MemoryStack.DescriptorUpdateTemplateCreateInfo(): VkDescriptorUpdateTemplateCreateInfo = VkDescriptorUpdateTemplateCreateInfo.callocStack(this).apply { type = VkStructureType.DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO }
fun MemoryStack.DescriptorUpdateTemplateCreateInfo(block: VkDescriptorUpdateTemplateCreateInfo.() -> Unit): VkDescriptorUpdateTemplateCreateInfo = DescriptorUpdateTemplateCreateInfo().also(block)
fun MemoryStack.DescriptorUpdateTemplateCreateInfo(capacity: Int): VkDescriptorUpdateTemplateCreateInfo.Buffer = VkDescriptorUpdateTemplateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO }
fun MemoryStack.DescriptorUpdateTemplateCreateInfo(capacity: Int, block: VkDescriptorUpdateTemplateCreateInfo.Buffer.() -> Unit): VkDescriptorUpdateTemplateCreateInfo.Buffer = DescriptorUpdateTemplateCreateInfo(capacity).also(block)

fun MemoryStack.DescriptorUpdateTemplateEntry(): VkDescriptorUpdateTemplateEntry = VkDescriptorUpdateTemplateEntry.callocStack(this)
fun MemoryStack.DescriptorUpdateTemplateEntry(block: VkDescriptorUpdateTemplateEntry.() -> Unit): VkDescriptorUpdateTemplateEntry = DescriptorUpdateTemplateEntry().also(block)
fun MemoryStack.DescriptorUpdateTemplateEntry(capacity: Int): VkDescriptorUpdateTemplateEntry.Buffer = VkDescriptorUpdateTemplateEntry.callocStack(capacity, this)
fun MemoryStack.DescriptorUpdateTemplateEntry(capacity: Int, block: VkDescriptorUpdateTemplateEntry.Buffer.() -> Unit): VkDescriptorUpdateTemplateEntry.Buffer = DescriptorUpdateTemplateEntry(capacity).also(block)

fun MemoryStack.DeviceCreateInfo(): VkDeviceCreateInfo = VkDeviceCreateInfo.callocStack(this).apply { type = VkStructureType.DEVICE_CREATE_INFO }
fun MemoryStack.DeviceCreateInfo(block: VkDeviceCreateInfo.() -> Unit): VkDeviceCreateInfo = DeviceCreateInfo().also(block)
fun MemoryStack.DeviceCreateInfo(capacity: Int): VkDeviceCreateInfo.Buffer = VkDeviceCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_CREATE_INFO }
fun MemoryStack.DeviceCreateInfo(capacity: Int, block: VkDeviceCreateInfo.Buffer.() -> Unit): VkDeviceCreateInfo.Buffer = DeviceCreateInfo(capacity).also(block)

fun MemoryStack.DeviceEventInfoEXT(): VkDeviceEventInfoEXT = VkDeviceEventInfoEXT.callocStack(this).apply { type = VkStructureType.DEVICE_EVENT_INFO_EXT }
fun MemoryStack.DeviceEventInfoEXT(block: VkDeviceEventInfoEXT.() -> Unit): VkDeviceEventInfoEXT = DeviceEventInfoEXT().also(block)
fun MemoryStack.DeviceEventInfoEXT(capacity: Int): VkDeviceEventInfoEXT.Buffer = VkDeviceEventInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_EVENT_INFO_EXT }
fun MemoryStack.DeviceEventInfoEXT(capacity: Int, block: VkDeviceEventInfoEXT.Buffer.() -> Unit): VkDeviceEventInfoEXT.Buffer = DeviceEventInfoEXT(capacity).also(block)

fun MemoryStack.DeviceGeneratedCommandsFeaturesNVX(): VkDeviceGeneratedCommandsFeaturesNVX = VkDeviceGeneratedCommandsFeaturesNVX.callocStack(this).apply { type = VkStructureType.DEVICE_GENERATED_COMMANDS_FEATURES_NVX }
fun MemoryStack.DeviceGeneratedCommandsFeaturesNVX(block: VkDeviceGeneratedCommandsFeaturesNVX.() -> Unit): VkDeviceGeneratedCommandsFeaturesNVX = DeviceGeneratedCommandsFeaturesNVX().also(block)
fun MemoryStack.DeviceGeneratedCommandsFeaturesNVX(capacity: Int): VkDeviceGeneratedCommandsFeaturesNVX.Buffer = VkDeviceGeneratedCommandsFeaturesNVX.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GENERATED_COMMANDS_FEATURES_NVX }
fun MemoryStack.DeviceGeneratedCommandsFeaturesNVX(capacity: Int, block: VkDeviceGeneratedCommandsFeaturesNVX.Buffer.() -> Unit): VkDeviceGeneratedCommandsFeaturesNVX.Buffer = DeviceGeneratedCommandsFeaturesNVX(capacity).also(block)

fun MemoryStack.DeviceGeneratedCommandsLimitsNVX(): VkDeviceGeneratedCommandsLimitsNVX = VkDeviceGeneratedCommandsLimitsNVX.callocStack(this).apply { type = VkStructureType.DEVICE_GENERATED_COMMANDS_LIMITS_NVX }
fun MemoryStack.DeviceGeneratedCommandsLimitsNVX(block: VkDeviceGeneratedCommandsLimitsNVX.() -> Unit): VkDeviceGeneratedCommandsLimitsNVX = DeviceGeneratedCommandsLimitsNVX().also(block)
fun MemoryStack.DeviceGeneratedCommandsLimitsNVX(capacity: Int): VkDeviceGeneratedCommandsLimitsNVX.Buffer = VkDeviceGeneratedCommandsLimitsNVX.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GENERATED_COMMANDS_LIMITS_NVX }
fun MemoryStack.DeviceGeneratedCommandsLimitsNVX(capacity: Int, block: VkDeviceGeneratedCommandsLimitsNVX.Buffer.() -> Unit): VkDeviceGeneratedCommandsLimitsNVX.Buffer = DeviceGeneratedCommandsLimitsNVX(capacity).also(block)

fun MemoryStack.DeviceGroupBindSparseInfo(): VkDeviceGroupBindSparseInfo = VkDeviceGroupBindSparseInfo.callocStack(this).apply { type = VkStructureType.DEVICE_GROUP_BIND_SPARSE_INFO }
fun MemoryStack.DeviceGroupBindSparseInfo(block: VkDeviceGroupBindSparseInfo.() -> Unit): VkDeviceGroupBindSparseInfo = DeviceGroupBindSparseInfo().also(block)
fun MemoryStack.DeviceGroupBindSparseInfo(capacity: Int): VkDeviceGroupBindSparseInfo.Buffer = VkDeviceGroupBindSparseInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GROUP_BIND_SPARSE_INFO }
fun MemoryStack.DeviceGroupBindSparseInfo(capacity: Int, block: VkDeviceGroupBindSparseInfo.Buffer.() -> Unit): VkDeviceGroupBindSparseInfo.Buffer = DeviceGroupBindSparseInfo(capacity).also(block)

fun MemoryStack.DeviceGroupCommandBufferBeginInfo(): VkDeviceGroupCommandBufferBeginInfo = VkDeviceGroupCommandBufferBeginInfo.callocStack(this).apply { type = VkStructureType.DEVICE_GROUP_COMMAND_BUFFER_BEGIN_INFO }
fun MemoryStack.DeviceGroupCommandBufferBeginInfo(block: VkDeviceGroupCommandBufferBeginInfo.() -> Unit): VkDeviceGroupCommandBufferBeginInfo = DeviceGroupCommandBufferBeginInfo().also(block)
fun MemoryStack.DeviceGroupCommandBufferBeginInfo(capacity: Int): VkDeviceGroupCommandBufferBeginInfo.Buffer = VkDeviceGroupCommandBufferBeginInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GROUP_COMMAND_BUFFER_BEGIN_INFO }
fun MemoryStack.DeviceGroupCommandBufferBeginInfo(capacity: Int, block: VkDeviceGroupCommandBufferBeginInfo.Buffer.() -> Unit): VkDeviceGroupCommandBufferBeginInfo.Buffer = DeviceGroupCommandBufferBeginInfo(capacity).also(block)

fun MemoryStack.DeviceGroupDeviceCreateInfo(): VkDeviceGroupDeviceCreateInfo = VkDeviceGroupDeviceCreateInfo.callocStack(this).apply { type = VkStructureType.DEVICE_GROUP_DEVICE_CREATE_INFO }
fun MemoryStack.DeviceGroupDeviceCreateInfo(block: VkDeviceGroupDeviceCreateInfo.() -> Unit): VkDeviceGroupDeviceCreateInfo = DeviceGroupDeviceCreateInfo().also(block)
fun MemoryStack.DeviceGroupDeviceCreateInfo(capacity: Int): VkDeviceGroupDeviceCreateInfo.Buffer = VkDeviceGroupDeviceCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GROUP_DEVICE_CREATE_INFO }
fun MemoryStack.DeviceGroupDeviceCreateInfo(capacity: Int, block: VkDeviceGroupDeviceCreateInfo.Buffer.() -> Unit): VkDeviceGroupDeviceCreateInfo.Buffer = DeviceGroupDeviceCreateInfo(capacity).also(block)

fun MemoryStack.DeviceGroupPresentCapabilitiesKHR(): VkDeviceGroupPresentCapabilitiesKHR = VkDeviceGroupPresentCapabilitiesKHR.callocStack(this).apply { type = VkStructureType.DEVICE_GROUP_PRESENT_CAPABILITIES_KHR }
fun MemoryStack.DeviceGroupPresentCapabilitiesKHR(block: VkDeviceGroupPresentCapabilitiesKHR.() -> Unit): VkDeviceGroupPresentCapabilitiesKHR = DeviceGroupPresentCapabilitiesKHR().also(block)
fun MemoryStack.DeviceGroupPresentCapabilitiesKHR(capacity: Int): VkDeviceGroupPresentCapabilitiesKHR.Buffer = VkDeviceGroupPresentCapabilitiesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GROUP_PRESENT_CAPABILITIES_KHR }
fun MemoryStack.DeviceGroupPresentCapabilitiesKHR(capacity: Int, block: VkDeviceGroupPresentCapabilitiesKHR.Buffer.() -> Unit): VkDeviceGroupPresentCapabilitiesKHR.Buffer = DeviceGroupPresentCapabilitiesKHR(capacity).also(block)

fun MemoryStack.DeviceGroupPresentInfoKHR(): VkDeviceGroupPresentInfoKHR = VkDeviceGroupPresentInfoKHR.callocStack(this).apply { type = VkStructureType.DEVICE_GROUP_PRESENT_INFO_KHR }
fun MemoryStack.DeviceGroupPresentInfoKHR(block: VkDeviceGroupPresentInfoKHR.() -> Unit): VkDeviceGroupPresentInfoKHR = DeviceGroupPresentInfoKHR().also(block)
fun MemoryStack.DeviceGroupPresentInfoKHR(capacity: Int): VkDeviceGroupPresentInfoKHR.Buffer = VkDeviceGroupPresentInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GROUP_PRESENT_INFO_KHR }
fun MemoryStack.DeviceGroupPresentInfoKHR(capacity: Int, block: VkDeviceGroupPresentInfoKHR.Buffer.() -> Unit): VkDeviceGroupPresentInfoKHR.Buffer = DeviceGroupPresentInfoKHR(capacity).also(block)

fun MemoryStack.DeviceGroupRenderPassBeginInfo(): VkDeviceGroupRenderPassBeginInfo = VkDeviceGroupRenderPassBeginInfo.callocStack(this).apply { type = VkStructureType.DEVICE_GROUP_RENDER_PASS_BEGIN_INFO }
fun MemoryStack.DeviceGroupRenderPassBeginInfo(block: VkDeviceGroupRenderPassBeginInfo.() -> Unit): VkDeviceGroupRenderPassBeginInfo = DeviceGroupRenderPassBeginInfo().also(block)
fun MemoryStack.DeviceGroupRenderPassBeginInfo(capacity: Int): VkDeviceGroupRenderPassBeginInfo.Buffer = VkDeviceGroupRenderPassBeginInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GROUP_RENDER_PASS_BEGIN_INFO }
fun MemoryStack.DeviceGroupRenderPassBeginInfo(capacity: Int, block: VkDeviceGroupRenderPassBeginInfo.Buffer.() -> Unit): VkDeviceGroupRenderPassBeginInfo.Buffer = DeviceGroupRenderPassBeginInfo(capacity).also(block)

fun MemoryStack.DeviceGroupSubmitInfo(): VkDeviceGroupSubmitInfo = VkDeviceGroupSubmitInfo.callocStack(this).apply { type = VkStructureType.DEVICE_GROUP_SUBMIT_INFO }
fun MemoryStack.DeviceGroupSubmitInfo(block: VkDeviceGroupSubmitInfo.() -> Unit): VkDeviceGroupSubmitInfo = DeviceGroupSubmitInfo().also(block)
fun MemoryStack.DeviceGroupSubmitInfo(capacity: Int): VkDeviceGroupSubmitInfo.Buffer = VkDeviceGroupSubmitInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GROUP_SUBMIT_INFO }
fun MemoryStack.DeviceGroupSubmitInfo(capacity: Int, block: VkDeviceGroupSubmitInfo.Buffer.() -> Unit): VkDeviceGroupSubmitInfo.Buffer = DeviceGroupSubmitInfo(capacity).also(block)

fun MemoryStack.DeviceGroupSwapchainCreateInfoKHR(): VkDeviceGroupSwapchainCreateInfoKHR = VkDeviceGroupSwapchainCreateInfoKHR.callocStack(this).apply { type = VkStructureType.DEVICE_GROUP_SWAPCHAIN_CREATE_INFO_KHR }
fun MemoryStack.DeviceGroupSwapchainCreateInfoKHR(block: VkDeviceGroupSwapchainCreateInfoKHR.() -> Unit): VkDeviceGroupSwapchainCreateInfoKHR = DeviceGroupSwapchainCreateInfoKHR().also(block)
fun MemoryStack.DeviceGroupSwapchainCreateInfoKHR(capacity: Int): VkDeviceGroupSwapchainCreateInfoKHR.Buffer = VkDeviceGroupSwapchainCreateInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_GROUP_SWAPCHAIN_CREATE_INFO_KHR }
fun MemoryStack.DeviceGroupSwapchainCreateInfoKHR(capacity: Int, block: VkDeviceGroupSwapchainCreateInfoKHR.Buffer.() -> Unit): VkDeviceGroupSwapchainCreateInfoKHR.Buffer = DeviceGroupSwapchainCreateInfoKHR(capacity).also(block)

fun MemoryStack.DeviceMemoryOverallocationCreateInfoAMD(): VkDeviceMemoryOverallocationCreateInfoAMD = VkDeviceMemoryOverallocationCreateInfoAMD.callocStack(this).apply { type = VkStructureType.DEVICE_MEMORY_OVERALLOCATION_CREATE_INFO_AMD }
fun MemoryStack.DeviceMemoryOverallocationCreateInfoAMD(block: VkDeviceMemoryOverallocationCreateInfoAMD.() -> Unit): VkDeviceMemoryOverallocationCreateInfoAMD = DeviceMemoryOverallocationCreateInfoAMD().also(block)
fun MemoryStack.DeviceMemoryOverallocationCreateInfoAMD(capacity: Int): VkDeviceMemoryOverallocationCreateInfoAMD.Buffer = VkDeviceMemoryOverallocationCreateInfoAMD.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_MEMORY_OVERALLOCATION_CREATE_INFO_AMD }
fun MemoryStack.DeviceMemoryOverallocationCreateInfoAMD(capacity: Int, block: VkDeviceMemoryOverallocationCreateInfoAMD.Buffer.() -> Unit): VkDeviceMemoryOverallocationCreateInfoAMD.Buffer = DeviceMemoryOverallocationCreateInfoAMD(capacity).also(block)

fun MemoryStack.DeviceQueueCreateInfo(): VkDeviceQueueCreateInfo = VkDeviceQueueCreateInfo.callocStack(this).apply { type = VkStructureType.DEVICE_QUEUE_CREATE_INFO }
fun MemoryStack.DeviceQueueCreateInfo(block: VkDeviceQueueCreateInfo.() -> Unit): VkDeviceQueueCreateInfo = DeviceQueueCreateInfo().also(block)
fun MemoryStack.DeviceQueueCreateInfo(capacity: Int): VkDeviceQueueCreateInfo.Buffer = VkDeviceQueueCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_QUEUE_CREATE_INFO }
fun MemoryStack.DeviceQueueCreateInfo(capacity: Int, block: VkDeviceQueueCreateInfo.Buffer.() -> Unit): VkDeviceQueueCreateInfo.Buffer = DeviceQueueCreateInfo(capacity).also(block)

fun MemoryStack.DeviceQueueGlobalPriorityCreateInfoEXT(): VkDeviceQueueGlobalPriorityCreateInfoEXT = VkDeviceQueueGlobalPriorityCreateInfoEXT.callocStack(this).apply { type = VkStructureType.DEVICE_QUEUE_GLOBAL_PRIORITY_CREATE_INFO_EXT }
fun MemoryStack.DeviceQueueGlobalPriorityCreateInfoEXT(block: VkDeviceQueueGlobalPriorityCreateInfoEXT.() -> Unit): VkDeviceQueueGlobalPriorityCreateInfoEXT = DeviceQueueGlobalPriorityCreateInfoEXT().also(block)
fun MemoryStack.DeviceQueueGlobalPriorityCreateInfoEXT(capacity: Int): VkDeviceQueueGlobalPriorityCreateInfoEXT.Buffer = VkDeviceQueueGlobalPriorityCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_QUEUE_GLOBAL_PRIORITY_CREATE_INFO_EXT }
fun MemoryStack.DeviceQueueGlobalPriorityCreateInfoEXT(capacity: Int, block: VkDeviceQueueGlobalPriorityCreateInfoEXT.Buffer.() -> Unit): VkDeviceQueueGlobalPriorityCreateInfoEXT.Buffer = DeviceQueueGlobalPriorityCreateInfoEXT(capacity).also(block)

fun MemoryStack.DeviceQueueInfo2(): VkDeviceQueueInfo2 = VkDeviceQueueInfo2.callocStack(this).apply { type = VkStructureType.DEVICE_QUEUE_INFO_2 }
fun MemoryStack.DeviceQueueInfo2(block: VkDeviceQueueInfo2.() -> Unit): VkDeviceQueueInfo2 = DeviceQueueInfo2().also(block)
fun MemoryStack.DeviceQueueInfo2(capacity: Int): VkDeviceQueueInfo2.Buffer = VkDeviceQueueInfo2.callocStack(capacity, this).onEach { it.type = VkStructureType.DEVICE_QUEUE_INFO_2 }
fun MemoryStack.DeviceQueueInfo2(capacity: Int, block: VkDeviceQueueInfo2.Buffer.() -> Unit): VkDeviceQueueInfo2.Buffer = DeviceQueueInfo2(capacity).also(block)

fun MemoryStack.DispatchIndirectCommand(): VkDispatchIndirectCommand = VkDispatchIndirectCommand.callocStack(this)
fun MemoryStack.DispatchIndirectCommand(block: VkDispatchIndirectCommand.() -> Unit): VkDispatchIndirectCommand = DispatchIndirectCommand().also(block)
fun MemoryStack.DispatchIndirectCommand(capacity: Int): VkDispatchIndirectCommand.Buffer = VkDispatchIndirectCommand.callocStack(capacity, this)
fun MemoryStack.DispatchIndirectCommand(capacity: Int, block: VkDispatchIndirectCommand.Buffer.() -> Unit): VkDispatchIndirectCommand.Buffer = DispatchIndirectCommand(capacity).also(block)

fun MemoryStack.DisplayEventInfoEXT(): VkDisplayEventInfoEXT = VkDisplayEventInfoEXT.callocStack(this).apply { type = VkStructureType.DISPLAY_EVENT_INFO_EXT }
fun MemoryStack.DisplayEventInfoEXT(block: VkDisplayEventInfoEXT.() -> Unit): VkDisplayEventInfoEXT = DisplayEventInfoEXT().also(block)
fun MemoryStack.DisplayEventInfoEXT(capacity: Int): VkDisplayEventInfoEXT.Buffer = VkDisplayEventInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_EVENT_INFO_EXT }
fun MemoryStack.DisplayEventInfoEXT(capacity: Int, block: VkDisplayEventInfoEXT.Buffer.() -> Unit): VkDisplayEventInfoEXT.Buffer = DisplayEventInfoEXT(capacity).also(block)

fun MemoryStack.DisplayModeCreateInfoKHR(): VkDisplayModeCreateInfoKHR = VkDisplayModeCreateInfoKHR.callocStack(this).apply { type = VkStructureType.DISPLAY_MODE_CREATE_INFO_KHR }
fun MemoryStack.DisplayModeCreateInfoKHR(block: VkDisplayModeCreateInfoKHR.() -> Unit): VkDisplayModeCreateInfoKHR = DisplayModeCreateInfoKHR().also(block)
fun MemoryStack.DisplayModeCreateInfoKHR(capacity: Int): VkDisplayModeCreateInfoKHR.Buffer = VkDisplayModeCreateInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_MODE_CREATE_INFO_KHR }
fun MemoryStack.DisplayModeCreateInfoKHR(capacity: Int, block: VkDisplayModeCreateInfoKHR.Buffer.() -> Unit): VkDisplayModeCreateInfoKHR.Buffer = DisplayModeCreateInfoKHR(capacity).also(block)

fun MemoryStack.DisplayModeParametersKHR(): VkDisplayModeParametersKHR = VkDisplayModeParametersKHR.callocStack(this)
fun MemoryStack.DisplayModeParametersKHR(block: VkDisplayModeParametersKHR.() -> Unit): VkDisplayModeParametersKHR = DisplayModeParametersKHR().also(block)
fun MemoryStack.DisplayModeParametersKHR(capacity: Int): VkDisplayModeParametersKHR.Buffer = VkDisplayModeParametersKHR.callocStack(capacity, this)
fun MemoryStack.DisplayModeParametersKHR(capacity: Int, block: VkDisplayModeParametersKHR.Buffer.() -> Unit): VkDisplayModeParametersKHR.Buffer = DisplayModeParametersKHR(capacity).also(block)

fun MemoryStack.DisplayModePropertiesKHR(): VkDisplayModePropertiesKHR = VkDisplayModePropertiesKHR.callocStack(this)
fun MemoryStack.DisplayModePropertiesKHR(block: VkDisplayModePropertiesKHR.() -> Unit): VkDisplayModePropertiesKHR = DisplayModePropertiesKHR().also(block)
fun MemoryStack.DisplayModePropertiesKHR(capacity: Int): VkDisplayModePropertiesKHR.Buffer = VkDisplayModePropertiesKHR.callocStack(capacity, this)
fun MemoryStack.DisplayModePropertiesKHR(capacity: Int, block: VkDisplayModePropertiesKHR.Buffer.() -> Unit): VkDisplayModePropertiesKHR.Buffer = DisplayModePropertiesKHR(capacity).also(block)

fun MemoryStack.DisplayModeProperties2KHR(): VkDisplayModeProperties2KHR = VkDisplayModeProperties2KHR.callocStack(this).apply { type = VkStructureType.DISPLAY_MODE_PROPERTIES_2_KHR }
fun MemoryStack.DisplayModeProperties2KHR(block: VkDisplayModeProperties2KHR.() -> Unit): VkDisplayModeProperties2KHR = DisplayModeProperties2KHR().also(block)
fun MemoryStack.DisplayModeProperties2KHR(capacity: Int): VkDisplayModeProperties2KHR.Buffer = VkDisplayModeProperties2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_MODE_PROPERTIES_2_KHR }
fun MemoryStack.DisplayModeProperties2KHR(capacity: Int, block: VkDisplayModeProperties2KHR.Buffer.() -> Unit): VkDisplayModeProperties2KHR.Buffer = DisplayModeProperties2KHR(capacity).also(block)

fun MemoryStack.DisplayPlaneCapabilitiesKHR(): VkDisplayPlaneCapabilitiesKHR = VkDisplayPlaneCapabilitiesKHR.callocStack(this)
fun MemoryStack.DisplayPlaneCapabilitiesKHR(block: VkDisplayPlaneCapabilitiesKHR.() -> Unit): VkDisplayPlaneCapabilitiesKHR = DisplayPlaneCapabilitiesKHR().also(block)
fun MemoryStack.DisplayPlaneCapabilitiesKHR(capacity: Int): VkDisplayPlaneCapabilitiesKHR.Buffer = VkDisplayPlaneCapabilitiesKHR.callocStack(capacity, this)
fun MemoryStack.DisplayPlaneCapabilitiesKHR(capacity: Int, block: VkDisplayPlaneCapabilitiesKHR.Buffer.() -> Unit): VkDisplayPlaneCapabilitiesKHR.Buffer = DisplayPlaneCapabilitiesKHR(capacity).also(block)

fun MemoryStack.DisplayPlaneCapabilities2KHR(): VkDisplayPlaneCapabilities2KHR = VkDisplayPlaneCapabilities2KHR.callocStack(this).apply { type = VkStructureType.DISPLAY_PLANE_CAPABILITIES_2_KHR }
fun MemoryStack.DisplayPlaneCapabilities2KHR(block: VkDisplayPlaneCapabilities2KHR.() -> Unit): VkDisplayPlaneCapabilities2KHR = DisplayPlaneCapabilities2KHR().also(block)
fun MemoryStack.DisplayPlaneCapabilities2KHR(capacity: Int): VkDisplayPlaneCapabilities2KHR.Buffer = VkDisplayPlaneCapabilities2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_PLANE_CAPABILITIES_2_KHR }
fun MemoryStack.DisplayPlaneCapabilities2KHR(capacity: Int, block: VkDisplayPlaneCapabilities2KHR.Buffer.() -> Unit): VkDisplayPlaneCapabilities2KHR.Buffer = DisplayPlaneCapabilities2KHR(capacity).also(block)

fun MemoryStack.DisplayPlaneInfo2KHR(): VkDisplayPlaneInfo2KHR = VkDisplayPlaneInfo2KHR.callocStack(this).apply { type = VkStructureType.DISPLAY_PLANE_INFO_2_KHR }
fun MemoryStack.DisplayPlaneInfo2KHR(block: VkDisplayPlaneInfo2KHR.() -> Unit): VkDisplayPlaneInfo2KHR = DisplayPlaneInfo2KHR().also(block)
fun MemoryStack.DisplayPlaneInfo2KHR(capacity: Int): VkDisplayPlaneInfo2KHR.Buffer = VkDisplayPlaneInfo2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_PLANE_INFO_2_KHR }
fun MemoryStack.DisplayPlaneInfo2KHR(capacity: Int, block: VkDisplayPlaneInfo2KHR.Buffer.() -> Unit): VkDisplayPlaneInfo2KHR.Buffer = DisplayPlaneInfo2KHR(capacity).also(block)

fun MemoryStack.DisplayPlanePropertiesKHR(): VkDisplayPlanePropertiesKHR = VkDisplayPlanePropertiesKHR.callocStack(this)
fun MemoryStack.DisplayPlanePropertiesKHR(block: VkDisplayPlanePropertiesKHR.() -> Unit): VkDisplayPlanePropertiesKHR = DisplayPlanePropertiesKHR().also(block)
fun MemoryStack.DisplayPlanePropertiesKHR(capacity: Int): VkDisplayPlanePropertiesKHR.Buffer = VkDisplayPlanePropertiesKHR.callocStack(capacity, this)
fun MemoryStack.DisplayPlanePropertiesKHR(capacity: Int, block: VkDisplayPlanePropertiesKHR.Buffer.() -> Unit): VkDisplayPlanePropertiesKHR.Buffer = DisplayPlanePropertiesKHR(capacity).also(block)

fun MemoryStack.DisplayPlaneProperties2KHR(): VkDisplayPlaneProperties2KHR = VkDisplayPlaneProperties2KHR.callocStack(this).apply { type = VkStructureType.DISPLAY_PLANE_PROPERTIES_2_KHR }
fun MemoryStack.DisplayPlaneProperties2KHR(block: VkDisplayPlaneProperties2KHR.() -> Unit): VkDisplayPlaneProperties2KHR = DisplayPlaneProperties2KHR().also(block)
fun MemoryStack.DisplayPlaneProperties2KHR(capacity: Int): VkDisplayPlaneProperties2KHR.Buffer = VkDisplayPlaneProperties2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_PLANE_PROPERTIES_2_KHR }
fun MemoryStack.DisplayPlaneProperties2KHR(capacity: Int, block: VkDisplayPlaneProperties2KHR.Buffer.() -> Unit): VkDisplayPlaneProperties2KHR.Buffer = DisplayPlaneProperties2KHR(capacity).also(block)

fun MemoryStack.DisplayPowerInfoEXT(): VkDisplayPowerInfoEXT = VkDisplayPowerInfoEXT.callocStack(this).apply { type = VkStructureType.DISPLAY_POWER_INFO_EXT }
fun MemoryStack.DisplayPowerInfoEXT(block: VkDisplayPowerInfoEXT.() -> Unit): VkDisplayPowerInfoEXT = DisplayPowerInfoEXT().also(block)
fun MemoryStack.DisplayPowerInfoEXT(capacity: Int): VkDisplayPowerInfoEXT.Buffer = VkDisplayPowerInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_POWER_INFO_EXT }
fun MemoryStack.DisplayPowerInfoEXT(capacity: Int, block: VkDisplayPowerInfoEXT.Buffer.() -> Unit): VkDisplayPowerInfoEXT.Buffer = DisplayPowerInfoEXT(capacity).also(block)

fun MemoryStack.DisplayPresentInfoKHR(): VkDisplayPresentInfoKHR = VkDisplayPresentInfoKHR.callocStack(this).apply { type = VkStructureType.DISPLAY_PRESENT_INFO_KHR }
fun MemoryStack.DisplayPresentInfoKHR(block: VkDisplayPresentInfoKHR.() -> Unit): VkDisplayPresentInfoKHR = DisplayPresentInfoKHR().also(block)
fun MemoryStack.DisplayPresentInfoKHR(capacity: Int): VkDisplayPresentInfoKHR.Buffer = VkDisplayPresentInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_PRESENT_INFO_KHR }
fun MemoryStack.DisplayPresentInfoKHR(capacity: Int, block: VkDisplayPresentInfoKHR.Buffer.() -> Unit): VkDisplayPresentInfoKHR.Buffer = DisplayPresentInfoKHR(capacity).also(block)

fun MemoryStack.DisplayPropertiesKHR(): VkDisplayPropertiesKHR = VkDisplayPropertiesKHR.callocStack(this)
fun MemoryStack.DisplayPropertiesKHR(block: VkDisplayPropertiesKHR.() -> Unit): VkDisplayPropertiesKHR = DisplayPropertiesKHR().also(block)
fun MemoryStack.DisplayPropertiesKHR(capacity: Int): VkDisplayPropertiesKHR.Buffer = VkDisplayPropertiesKHR.callocStack(capacity, this)
fun MemoryStack.DisplayPropertiesKHR(capacity: Int, block: VkDisplayPropertiesKHR.Buffer.() -> Unit): VkDisplayPropertiesKHR.Buffer = DisplayPropertiesKHR(capacity).also(block)

fun MemoryStack.DisplayProperties2KHR(): VkDisplayProperties2KHR = VkDisplayProperties2KHR.callocStack(this).apply { type = VkStructureType.DISPLAY_PROPERTIES_2_KHR }
fun MemoryStack.DisplayProperties2KHR(block: VkDisplayProperties2KHR.() -> Unit): VkDisplayProperties2KHR = DisplayProperties2KHR().also(block)
fun MemoryStack.DisplayProperties2KHR(capacity: Int): VkDisplayProperties2KHR.Buffer = VkDisplayProperties2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_PROPERTIES_2_KHR }
fun MemoryStack.DisplayProperties2KHR(capacity: Int, block: VkDisplayProperties2KHR.Buffer.() -> Unit): VkDisplayProperties2KHR.Buffer = DisplayProperties2KHR(capacity).also(block)

fun MemoryStack.DisplaySurfaceCreateInfoKHR(): VkDisplaySurfaceCreateInfoKHR = VkDisplaySurfaceCreateInfoKHR.callocStack(this).apply { type = VkStructureType.DISPLAY_SURFACE_CREATE_INFO_KHR }
fun MemoryStack.DisplaySurfaceCreateInfoKHR(block: VkDisplaySurfaceCreateInfoKHR.() -> Unit): VkDisplaySurfaceCreateInfoKHR = DisplaySurfaceCreateInfoKHR().also(block)
fun MemoryStack.DisplaySurfaceCreateInfoKHR(capacity: Int): VkDisplaySurfaceCreateInfoKHR.Buffer = VkDisplaySurfaceCreateInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.DISPLAY_SURFACE_CREATE_INFO_KHR }
fun MemoryStack.DisplaySurfaceCreateInfoKHR(capacity: Int, block: VkDisplaySurfaceCreateInfoKHR.Buffer.() -> Unit): VkDisplaySurfaceCreateInfoKHR.Buffer = DisplaySurfaceCreateInfoKHR(capacity).also(block)

fun MemoryStack.DrawIndexedIndirectCommand(): VkDrawIndexedIndirectCommand = VkDrawIndexedIndirectCommand.callocStack(this)
fun MemoryStack.DrawIndexedIndirectCommand(block: VkDrawIndexedIndirectCommand.() -> Unit): VkDrawIndexedIndirectCommand = DrawIndexedIndirectCommand().also(block)
fun MemoryStack.DrawIndexedIndirectCommand(capacity: Int): VkDrawIndexedIndirectCommand.Buffer = VkDrawIndexedIndirectCommand.callocStack(capacity, this)
fun MemoryStack.DrawIndexedIndirectCommand(capacity: Int, block: VkDrawIndexedIndirectCommand.Buffer.() -> Unit): VkDrawIndexedIndirectCommand.Buffer = DrawIndexedIndirectCommand(capacity).also(block)

fun MemoryStack.DrawIndirectCommand(): VkDrawIndirectCommand = VkDrawIndirectCommand.callocStack(this)
fun MemoryStack.DrawIndirectCommand(block: VkDrawIndirectCommand.() -> Unit): VkDrawIndirectCommand = DrawIndirectCommand().also(block)
fun MemoryStack.DrawIndirectCommand(capacity: Int): VkDrawIndirectCommand.Buffer = VkDrawIndirectCommand.callocStack(capacity, this)
fun MemoryStack.DrawIndirectCommand(capacity: Int, block: VkDrawIndirectCommand.Buffer.() -> Unit): VkDrawIndirectCommand.Buffer = DrawIndirectCommand(capacity).also(block)

fun MemoryStack.DrawMeshTasksIndirectCommandNV(): VkDrawMeshTasksIndirectCommandNV = VkDrawMeshTasksIndirectCommandNV.callocStack(this)
fun MemoryStack.DrawMeshTasksIndirectCommandNV(block: VkDrawMeshTasksIndirectCommandNV.() -> Unit): VkDrawMeshTasksIndirectCommandNV = DrawMeshTasksIndirectCommandNV().also(block)
fun MemoryStack.DrawMeshTasksIndirectCommandNV(capacity: Int): VkDrawMeshTasksIndirectCommandNV.Buffer = VkDrawMeshTasksIndirectCommandNV.callocStack(capacity, this)
fun MemoryStack.DrawMeshTasksIndirectCommandNV(capacity: Int, block: VkDrawMeshTasksIndirectCommandNV.Buffer.() -> Unit): VkDrawMeshTasksIndirectCommandNV.Buffer = DrawMeshTasksIndirectCommandNV(capacity).also(block)

//fun MemoryStack.DrmFormatModifierPropertiesEXT(): VkDrmFormatModifierPropertiesEXT = VkDrmFormatModifierPropertiesEXT.callocStack(this)
//fun MemoryStack.DrmFormatModifierPropertiesEXT(block: VkDrmFormatModifierPropertiesEXT.() -> Unit): VkDrmFormatModifierPropertiesEXT = DrmFormatModifierPropertiesEXT().also(block)
//fun MemoryStack.DrmFormatModifierPropertiesEXT(capacity: Int): VkDrmFormatModifierPropertiesEXT.Buffer = VkDrmFormatModifierPropertiesEXT.callocStack(capacity, this)
//fun MemoryStack.DrmFormatModifierPropertiesEXT(capacity: Int, block: VkDrmFormatModifierPropertiesEXT.Buffer.() -> Unit): VkDrmFormatModifierPropertiesEXT.Buffer = DrmFormatModifierPropertiesEXT(capacity).also(block)
//
//fun MemoryStack.DrmFormatModifierPropertiesListEXT(): VkDrmFormatModifierPropertiesListEXT = VkDrmFormatModifierPropertiesListEXT.callocStack(this)
//fun MemoryStack.DrmFormatModifierPropertiesListEXT(block: VkDrmFormatModifierPropertiesListEXT.() -> Unit): VkDrmFormatModifierPropertiesListEXT = DrmFormatModifierPropertiesListEXT().also(block)
//fun MemoryStack.DrmFormatModifierPropertiesListEXT(capacity: Int): VkDrmFormatModifierPropertiesListEXT.Buffer = VkDrmFormatModifierPropertiesListEXT.callocStack(capacity, this)
//fun MemoryStack.DrmFormatModifierPropertiesListEXT(capacity: Int, block: VkDrmFormatModifierPropertiesListEXT.Buffer.() -> Unit): VkDrmFormatModifierPropertiesListEXT.Buffer = DrmFormatModifierPropertiesListEXT(capacity).also(block)

fun MemoryStack.D3D12FenceSubmitInfoKHR(): VkD3D12FenceSubmitInfoKHR = VkD3D12FenceSubmitInfoKHR.callocStack(this).apply { type = VkStructureType.D3D12_FENCE_SUBMIT_INFO_KHR }
fun MemoryStack.D3D12FenceSubmitInfoKHR(block: VkD3D12FenceSubmitInfoKHR.() -> Unit): VkD3D12FenceSubmitInfoKHR = D3D12FenceSubmitInfoKHR().also(block)
fun MemoryStack.D3D12FenceSubmitInfoKHR(capacity: Int): VkD3D12FenceSubmitInfoKHR.Buffer = VkD3D12FenceSubmitInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.D3D12_FENCE_SUBMIT_INFO_KHR }
fun MemoryStack.D3D12FenceSubmitInfoKHR(capacity: Int, block: VkD3D12FenceSubmitInfoKHR.Buffer.() -> Unit): VkD3D12FenceSubmitInfoKHR.Buffer = D3D12FenceSubmitInfoKHR(capacity).also(block)

fun MemoryStack.EventCreateInfo(): VkEventCreateInfo = VkEventCreateInfo.callocStack(this).apply { type = VkStructureType.EVENT_CREATE_INFO }
fun MemoryStack.EventCreateInfo(block: VkEventCreateInfo.() -> Unit): VkEventCreateInfo = EventCreateInfo().also(block)
fun MemoryStack.EventCreateInfo(capacity: Int): VkEventCreateInfo.Buffer = VkEventCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.EVENT_CREATE_INFO }
fun MemoryStack.EventCreateInfo(capacity: Int, block: VkEventCreateInfo.Buffer.() -> Unit): VkEventCreateInfo.Buffer = EventCreateInfo(capacity).also(block)

fun MemoryStack.ExportFenceCreateInfo(): VkExportFenceCreateInfo = VkExportFenceCreateInfo.callocStack(this).apply { type = VkStructureType.EXPORT_FENCE_CREATE_INFO }
fun MemoryStack.ExportFenceCreateInfo(block: VkExportFenceCreateInfo.() -> Unit): VkExportFenceCreateInfo = ExportFenceCreateInfo().also(block)
fun MemoryStack.ExportFenceCreateInfo(capacity: Int): VkExportFenceCreateInfo.Buffer = VkExportFenceCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.EXPORT_FENCE_CREATE_INFO }
fun MemoryStack.ExportFenceCreateInfo(capacity: Int, block: VkExportFenceCreateInfo.Buffer.() -> Unit): VkExportFenceCreateInfo.Buffer = ExportFenceCreateInfo(capacity).also(block)

fun MemoryStack.ExportFenceWin32HandleInfoKHR(): VkExportFenceWin32HandleInfoKHR = VkExportFenceWin32HandleInfoKHR.callocStack(this).apply { type = VkStructureType.EXPORT_FENCE_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ExportFenceWin32HandleInfoKHR(block: VkExportFenceWin32HandleInfoKHR.() -> Unit): VkExportFenceWin32HandleInfoKHR = ExportFenceWin32HandleInfoKHR().also(block)
fun MemoryStack.ExportFenceWin32HandleInfoKHR(capacity: Int): VkExportFenceWin32HandleInfoKHR.Buffer = VkExportFenceWin32HandleInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.EXPORT_FENCE_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ExportFenceWin32HandleInfoKHR(capacity: Int, block: VkExportFenceWin32HandleInfoKHR.Buffer.() -> Unit): VkExportFenceWin32HandleInfoKHR.Buffer = ExportFenceWin32HandleInfoKHR(capacity).also(block)

fun MemoryStack.ExportMemoryAllocateInfo(): VkExportMemoryAllocateInfo = VkExportMemoryAllocateInfo.callocStack(this).apply { type = VkStructureType.EXPORT_MEMORY_ALLOCATE_INFO }
fun MemoryStack.ExportMemoryAllocateInfo(block: VkExportMemoryAllocateInfo.() -> Unit): VkExportMemoryAllocateInfo = ExportMemoryAllocateInfo().also(block)
fun MemoryStack.ExportMemoryAllocateInfo(capacity: Int): VkExportMemoryAllocateInfo.Buffer = VkExportMemoryAllocateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.EXPORT_MEMORY_ALLOCATE_INFO }
fun MemoryStack.ExportMemoryAllocateInfo(capacity: Int, block: VkExportMemoryAllocateInfo.Buffer.() -> Unit): VkExportMemoryAllocateInfo.Buffer = ExportMemoryAllocateInfo(capacity).also(block)

fun MemoryStack.ExportMemoryAllocateInfoNV(): VkExportMemoryAllocateInfoNV = VkExportMemoryAllocateInfoNV.callocStack(this).apply { type = VkStructureType.EXPORT_MEMORY_ALLOCATE_INFO_NV }
fun MemoryStack.ExportMemoryAllocateInfoNV(block: VkExportMemoryAllocateInfoNV.() -> Unit): VkExportMemoryAllocateInfoNV = ExportMemoryAllocateInfoNV().also(block)
fun MemoryStack.ExportMemoryAllocateInfoNV(capacity: Int): VkExportMemoryAllocateInfoNV.Buffer = VkExportMemoryAllocateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.EXPORT_MEMORY_ALLOCATE_INFO_NV }
fun MemoryStack.ExportMemoryAllocateInfoNV(capacity: Int, block: VkExportMemoryAllocateInfoNV.Buffer.() -> Unit): VkExportMemoryAllocateInfoNV.Buffer = ExportMemoryAllocateInfoNV(capacity).also(block)

fun MemoryStack.ExportMemoryWin32HandleInfoKHR(): VkExportMemoryWin32HandleInfoKHR = VkExportMemoryWin32HandleInfoKHR.callocStack(this).apply { type = VkStructureType.EXPORT_MEMORY_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ExportMemoryWin32HandleInfoKHR(block: VkExportMemoryWin32HandleInfoKHR.() -> Unit): VkExportMemoryWin32HandleInfoKHR = ExportMemoryWin32HandleInfoKHR().also(block)
fun MemoryStack.ExportMemoryWin32HandleInfoKHR(capacity: Int): VkExportMemoryWin32HandleInfoKHR.Buffer = VkExportMemoryWin32HandleInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.EXPORT_MEMORY_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ExportMemoryWin32HandleInfoKHR(capacity: Int, block: VkExportMemoryWin32HandleInfoKHR.Buffer.() -> Unit): VkExportMemoryWin32HandleInfoKHR.Buffer = ExportMemoryWin32HandleInfoKHR(capacity).also(block)

fun MemoryStack.ExportMemoryWin32HandleInfoNV(): VkExportMemoryWin32HandleInfoNV = VkExportMemoryWin32HandleInfoNV.callocStack(this).apply { type = VkStructureType.EXPORT_MEMORY_WIN32_HANDLE_INFO_NV }
fun MemoryStack.ExportMemoryWin32HandleInfoNV(block: VkExportMemoryWin32HandleInfoNV.() -> Unit): VkExportMemoryWin32HandleInfoNV = ExportMemoryWin32HandleInfoNV().also(block)
fun MemoryStack.ExportMemoryWin32HandleInfoNV(capacity: Int): VkExportMemoryWin32HandleInfoNV.Buffer = VkExportMemoryWin32HandleInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.EXPORT_MEMORY_WIN32_HANDLE_INFO_NV }
fun MemoryStack.ExportMemoryWin32HandleInfoNV(capacity: Int, block: VkExportMemoryWin32HandleInfoNV.Buffer.() -> Unit): VkExportMemoryWin32HandleInfoNV.Buffer = ExportMemoryWin32HandleInfoNV(capacity).also(block)

fun MemoryStack.ExportSemaphoreCreateInfo(): VkExportSemaphoreCreateInfo = VkExportSemaphoreCreateInfo.callocStack(this).apply { type = VkStructureType.EXPORT_SEMAPHORE_CREATE_INFO }
fun MemoryStack.ExportSemaphoreCreateInfo(block: VkExportSemaphoreCreateInfo.() -> Unit): VkExportSemaphoreCreateInfo = ExportSemaphoreCreateInfo().also(block)
fun MemoryStack.ExportSemaphoreCreateInfo(capacity: Int): VkExportSemaphoreCreateInfo.Buffer = VkExportSemaphoreCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.EXPORT_SEMAPHORE_CREATE_INFO }
fun MemoryStack.ExportSemaphoreCreateInfo(capacity: Int, block: VkExportSemaphoreCreateInfo.Buffer.() -> Unit): VkExportSemaphoreCreateInfo.Buffer = ExportSemaphoreCreateInfo(capacity).also(block)

fun MemoryStack.ExportSemaphoreWin32HandleInfoKHR(): VkExportSemaphoreWin32HandleInfoKHR = VkExportSemaphoreWin32HandleInfoKHR.callocStack(this).apply { type = VkStructureType.EXPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ExportSemaphoreWin32HandleInfoKHR(block: VkExportSemaphoreWin32HandleInfoKHR.() -> Unit): VkExportSemaphoreWin32HandleInfoKHR = ExportSemaphoreWin32HandleInfoKHR().also(block)
fun MemoryStack.ExportSemaphoreWin32HandleInfoKHR(capacity: Int): VkExportSemaphoreWin32HandleInfoKHR.Buffer = VkExportSemaphoreWin32HandleInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.EXPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ExportSemaphoreWin32HandleInfoKHR(capacity: Int, block: VkExportSemaphoreWin32HandleInfoKHR.Buffer.() -> Unit): VkExportSemaphoreWin32HandleInfoKHR.Buffer = ExportSemaphoreWin32HandleInfoKHR(capacity).also(block)

fun MemoryStack.ExtensionProperties(): VkExtensionProperties = VkExtensionProperties.callocStack(this)
fun MemoryStack.ExtensionProperties(block: VkExtensionProperties.() -> Unit): VkExtensionProperties = ExtensionProperties().also(block)
fun MemoryStack.ExtensionProperties(capacity: Int): VkExtensionProperties.Buffer = VkExtensionProperties.callocStack(capacity, this)
fun MemoryStack.ExtensionProperties(capacity: Int, block: VkExtensionProperties.Buffer.() -> Unit): VkExtensionProperties.Buffer = ExtensionProperties(capacity).also(block)

fun MemoryStack.Extent2D(): VkExtent2D = VkExtent2D.callocStack(this)
fun MemoryStack.Extent2D(block: VkExtent2D.() -> Unit): VkExtent2D = Extent2D().also(block)
fun MemoryStack.Extent2D(capacity: Int): VkExtent2D.Buffer = VkExtent2D.callocStack(capacity, this)
fun MemoryStack.Extent2D(capacity: Int, block: VkExtent2D.Buffer.() -> Unit): VkExtent2D.Buffer = Extent2D(capacity).also(block)

fun MemoryStack.Extent3D(): VkExtent3D = VkExtent3D.callocStack(this)
fun MemoryStack.Extent3D(block: VkExtent3D.() -> Unit): VkExtent3D = Extent3D().also(block)
fun MemoryStack.Extent3D(capacity: Int): VkExtent3D.Buffer = VkExtent3D.callocStack(capacity, this)
fun MemoryStack.Extent3D(capacity: Int, block: VkExtent3D.Buffer.() -> Unit): VkExtent3D.Buffer = Extent3D(capacity).also(block)

fun MemoryStack.ExternalBufferProperties(): VkExternalBufferProperties = VkExternalBufferProperties.callocStack(this).apply { type = VkStructureType.EXTERNAL_BUFFER_PROPERTIES }
fun MemoryStack.ExternalBufferProperties(block: VkExternalBufferProperties.() -> Unit): VkExternalBufferProperties = ExternalBufferProperties().also(block)
fun MemoryStack.ExternalBufferProperties(capacity: Int): VkExternalBufferProperties.Buffer = VkExternalBufferProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.EXTERNAL_BUFFER_PROPERTIES }
fun MemoryStack.ExternalBufferProperties(capacity: Int, block: VkExternalBufferProperties.Buffer.() -> Unit): VkExternalBufferProperties.Buffer = ExternalBufferProperties(capacity).also(block)

fun MemoryStack.ExternalFenceProperties(): VkExternalFenceProperties = VkExternalFenceProperties.callocStack(this).apply { type = VkStructureType.EXTERNAL_FENCE_PROPERTIES }
fun MemoryStack.ExternalFenceProperties(block: VkExternalFenceProperties.() -> Unit): VkExternalFenceProperties = ExternalFenceProperties().also(block)
fun MemoryStack.ExternalFenceProperties(capacity: Int): VkExternalFenceProperties.Buffer = VkExternalFenceProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.EXTERNAL_FENCE_PROPERTIES }
fun MemoryStack.ExternalFenceProperties(capacity: Int, block: VkExternalFenceProperties.Buffer.() -> Unit): VkExternalFenceProperties.Buffer = ExternalFenceProperties(capacity).also(block)

//fun MemoryStack.ExternalImageFormatProperties(): VkExternalImageFormatProperties = VkExternalImageFormatProperties.callocStack(this).apply { type = VkStructureType.EXTERNAL_IMAGE_FORMAT_PROPERTIES }
//fun MemoryStack.ExternalImageFormatProperties(block: VkExternalImageFormatProperties.() -> Unit): VkExternalImageFormatProperties = ExternalImageFormatProperties().also(block)
//fun MemoryStack.ExternalImageFormatProperties(capacity: Int): VkExternalImageFormatProperties.Buffer = VkExternalImageFormatProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.EXTERNAL_IMAGE_FORMAT_PROPERTIES }
//fun MemoryStack.ExternalImageFormatProperties(capacity: Int, block: VkExternalImageFormatProperties.Buffer.() -> Unit): VkExternalImageFormatProperties.Buffer = ExternalImageFormatProperties(capacity).also(block)

fun MemoryStack.ExternalImageFormatPropertiesNV(): VkExternalImageFormatPropertiesNV = VkExternalImageFormatPropertiesNV.callocStack(this)
fun MemoryStack.ExternalImageFormatPropertiesNV(block: VkExternalImageFormatPropertiesNV.() -> Unit): VkExternalImageFormatPropertiesNV = ExternalImageFormatPropertiesNV().also(block)
fun MemoryStack.ExternalImageFormatPropertiesNV(capacity: Int): VkExternalImageFormatPropertiesNV.Buffer = VkExternalImageFormatPropertiesNV.callocStack(capacity, this)
fun MemoryStack.ExternalImageFormatPropertiesNV(capacity: Int, block: VkExternalImageFormatPropertiesNV.Buffer.() -> Unit): VkExternalImageFormatPropertiesNV.Buffer = ExternalImageFormatPropertiesNV(capacity).also(block)

fun MemoryStack.ExternalMemoryBufferCreateInfo(): VkExternalMemoryBufferCreateInfo = VkExternalMemoryBufferCreateInfo.callocStack(this).apply { type = VkStructureType.EXTERNAL_MEMORY_BUFFER_CREATE_INFO }
fun MemoryStack.ExternalMemoryBufferCreateInfo(block: VkExternalMemoryBufferCreateInfo.() -> Unit): VkExternalMemoryBufferCreateInfo = ExternalMemoryBufferCreateInfo().also(block)
fun MemoryStack.ExternalMemoryBufferCreateInfo(capacity: Int): VkExternalMemoryBufferCreateInfo.Buffer = VkExternalMemoryBufferCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.EXTERNAL_MEMORY_BUFFER_CREATE_INFO }
fun MemoryStack.ExternalMemoryBufferCreateInfo(capacity: Int, block: VkExternalMemoryBufferCreateInfo.Buffer.() -> Unit): VkExternalMemoryBufferCreateInfo.Buffer = ExternalMemoryBufferCreateInfo(capacity).also(block)

fun MemoryStack.ExternalMemoryImageCreateInfo(): VkExternalMemoryImageCreateInfo = VkExternalMemoryImageCreateInfo.callocStack(this).apply { type = VkStructureType.EXTERNAL_MEMORY_IMAGE_CREATE_INFO }
fun MemoryStack.ExternalMemoryImageCreateInfo(block: VkExternalMemoryImageCreateInfo.() -> Unit): VkExternalMemoryImageCreateInfo = ExternalMemoryImageCreateInfo().also(block)
fun MemoryStack.ExternalMemoryImageCreateInfo(capacity: Int): VkExternalMemoryImageCreateInfo.Buffer = VkExternalMemoryImageCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.EXTERNAL_MEMORY_IMAGE_CREATE_INFO }
fun MemoryStack.ExternalMemoryImageCreateInfo(capacity: Int, block: VkExternalMemoryImageCreateInfo.Buffer.() -> Unit): VkExternalMemoryImageCreateInfo.Buffer = ExternalMemoryImageCreateInfo(capacity).also(block)

fun MemoryStack.ExternalMemoryImageCreateInfoNV(): VkExternalMemoryImageCreateInfoNV = VkExternalMemoryImageCreateInfoNV.callocStack(this).apply { type = VkStructureType.EXTERNAL_MEMORY_IMAGE_CREATE_INFO_NV }
fun MemoryStack.ExternalMemoryImageCreateInfoNV(block: VkExternalMemoryImageCreateInfoNV.() -> Unit): VkExternalMemoryImageCreateInfoNV = ExternalMemoryImageCreateInfoNV().also(block)
fun MemoryStack.ExternalMemoryImageCreateInfoNV(capacity: Int): VkExternalMemoryImageCreateInfoNV.Buffer = VkExternalMemoryImageCreateInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.EXTERNAL_MEMORY_IMAGE_CREATE_INFO_NV }
fun MemoryStack.ExternalMemoryImageCreateInfoNV(capacity: Int, block: VkExternalMemoryImageCreateInfoNV.Buffer.() -> Unit): VkExternalMemoryImageCreateInfoNV.Buffer = ExternalMemoryImageCreateInfoNV(capacity).also(block)

//fun MemoryStack.ExternalMemoryProperties(): VkExternalMemoryProperties = VkExternalMemoryProperties.callocStack(this)
//fun MemoryStack.ExternalMemoryProperties(block: VkExternalMemoryProperties.() -> Unit): VkExternalMemoryProperties = ExternalMemoryProperties().also(block)
//fun MemoryStack.ExternalMemoryProperties(capacity: Int): VkExternalMemoryProperties.Buffer = VkExternalMemoryProperties.callocStack(capacity, this)
//fun MemoryStack.ExternalMemoryProperties(capacity: Int, block: VkExternalMemoryProperties.Buffer.() -> Unit): VkExternalMemoryProperties.Buffer = ExternalMemoryProperties(capacity).also(block)

fun MemoryStack.ExternalSemaphoreProperties(): VkExternalSemaphoreProperties = VkExternalSemaphoreProperties.callocStack(this).apply { type = VkStructureType.EXTERNAL_SEMAPHORE_PROPERTIES }
fun MemoryStack.ExternalSemaphoreProperties(block: VkExternalSemaphoreProperties.() -> Unit): VkExternalSemaphoreProperties = ExternalSemaphoreProperties().also(block)
fun MemoryStack.ExternalSemaphoreProperties(capacity: Int): VkExternalSemaphoreProperties.Buffer = VkExternalSemaphoreProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.EXTERNAL_SEMAPHORE_PROPERTIES }
fun MemoryStack.ExternalSemaphoreProperties(capacity: Int, block: VkExternalSemaphoreProperties.Buffer.() -> Unit): VkExternalSemaphoreProperties.Buffer = ExternalSemaphoreProperties(capacity).also(block)

fun MemoryStack.FenceCreateInfo(): VkFenceCreateInfo = VkFenceCreateInfo.callocStack(this).apply { type = VkStructureType.FENCE_CREATE_INFO }
fun MemoryStack.FenceCreateInfo(block: VkFenceCreateInfo.() -> Unit): VkFenceCreateInfo = FenceCreateInfo().also(block)
fun MemoryStack.FenceCreateInfo(capacity: Int): VkFenceCreateInfo.Buffer = VkFenceCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.FENCE_CREATE_INFO }
fun MemoryStack.FenceCreateInfo(capacity: Int, block: VkFenceCreateInfo.Buffer.() -> Unit): VkFenceCreateInfo.Buffer = FenceCreateInfo(capacity).also(block)

fun MemoryStack.FenceGetFdInfoKHR(): VkFenceGetFdInfoKHR = VkFenceGetFdInfoKHR.callocStack(this).apply { type = VkStructureType.FENCE_GET_FD_INFO_KHR }
fun MemoryStack.FenceGetFdInfoKHR(block: VkFenceGetFdInfoKHR.() -> Unit): VkFenceGetFdInfoKHR = FenceGetFdInfoKHR().also(block)
fun MemoryStack.FenceGetFdInfoKHR(capacity: Int): VkFenceGetFdInfoKHR.Buffer = VkFenceGetFdInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.FENCE_GET_FD_INFO_KHR }
fun MemoryStack.FenceGetFdInfoKHR(capacity: Int, block: VkFenceGetFdInfoKHR.Buffer.() -> Unit): VkFenceGetFdInfoKHR.Buffer = FenceGetFdInfoKHR(capacity).also(block)

fun MemoryStack.FenceGetWin32HandleInfoKHR(): VkFenceGetWin32HandleInfoKHR = VkFenceGetWin32HandleInfoKHR.callocStack(this).apply { type = VkStructureType.FENCE_GET_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.FenceGetWin32HandleInfoKHR(block: VkFenceGetWin32HandleInfoKHR.() -> Unit): VkFenceGetWin32HandleInfoKHR = FenceGetWin32HandleInfoKHR().also(block)
fun MemoryStack.FenceGetWin32HandleInfoKHR(capacity: Int): VkFenceGetWin32HandleInfoKHR.Buffer = VkFenceGetWin32HandleInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.FENCE_GET_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.FenceGetWin32HandleInfoKHR(capacity: Int, block: VkFenceGetWin32HandleInfoKHR.Buffer.() -> Unit): VkFenceGetWin32HandleInfoKHR.Buffer = FenceGetWin32HandleInfoKHR(capacity).also(block)

//fun MemoryStack.FilterCubicImageViewImageFormatPropertiesEXT(): VkFilterCubicImageViewImageFormatPropertiesEXT = VkFilterCubicImageViewImageFormatPropertiesEXT.callocStack(this).apply { type = VkStructureType.FENCE_GET_WIN32_HANDLE_INFO_KHR }
//fun MemoryStack.FilterCubicImageViewImageFormatPropertiesEXT(block: VkFilterCubicImageViewImageFormatPropertiesEXT.() -> Unit): VkFilterCubicImageViewImageFormatPropertiesEXT = FilterCubicImageViewImageFormatPropertiesEXT().also(block)
//fun MemoryStack.FilterCubicImageViewImageFormatPropertiesEXT(capacity: Int): VkFilterCubicImageViewImageFormatPropertiesEXT.Buffer = VkFilterCubicImageViewImageFormatPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.FENCE_GET_WIN32_HANDLE_INFO_KHR }
//fun MemoryStack.FilterCubicImageViewImageFormatPropertiesEXT(capacity: Int, block: VkFilterCubicImageViewImageFormatPropertiesEXT.Buffer.() -> Unit): VkFilterCubicImageViewImageFormatPropertiesEXT.Buffer = FilterCubicImageViewImageFormatPropertiesEXT(capacity).also(block)

fun MemoryStack.FormatProperties(): VkFormatProperties = VkFormatProperties.callocStack(this)
fun MemoryStack.FormatProperties(block: VkFormatProperties.() -> Unit): VkFormatProperties = FormatProperties().also(block)
fun MemoryStack.FormatProperties(capacity: Int): VkFormatProperties.Buffer = VkFormatProperties.callocStack(capacity, this)
fun MemoryStack.FormatProperties(capacity: Int, block: VkFormatProperties.Buffer.() -> Unit): VkFormatProperties.Buffer = FormatProperties(capacity).also(block)

fun MemoryStack.FormatProperties2(): VkFormatProperties2 = VkFormatProperties2.callocStack(this).apply { type = VkStructureType.FORMAT_PROPERTIES_2 }
fun MemoryStack.FormatProperties2(block: VkFormatProperties2.() -> Unit): VkFormatProperties2 = FormatProperties2().also(block)
fun MemoryStack.FormatProperties2(capacity: Int): VkFormatProperties2.Buffer = VkFormatProperties2.callocStack(capacity, this).onEach { it.type = VkStructureType.FORMAT_PROPERTIES_2 }
fun MemoryStack.FormatProperties2(capacity: Int, block: VkFormatProperties2.Buffer.() -> Unit): VkFormatProperties2.Buffer = FormatProperties2(capacity).also(block)

fun MemoryStack.FramebufferCreateInfo(): VkFramebufferCreateInfo = VkFramebufferCreateInfo.callocStack(this).apply { type = VkStructureType.FRAMEBUFFER_CREATE_INFO }
fun MemoryStack.FramebufferCreateInfo(block: VkFramebufferCreateInfo.() -> Unit): VkFramebufferCreateInfo = FramebufferCreateInfo().also(block)
fun MemoryStack.FramebufferCreateInfo(capacity: Int): VkFramebufferCreateInfo.Buffer = VkFramebufferCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.FRAMEBUFFER_CREATE_INFO }
fun MemoryStack.FramebufferCreateInfo(capacity: Int, block: VkFramebufferCreateInfo.Buffer.() -> Unit): VkFramebufferCreateInfo.Buffer = FramebufferCreateInfo(capacity).also(block)

fun MemoryStack.GeometryAABBNV(): VkGeometryAABBNV = VkGeometryAABBNV.callocStack(this).apply { type = VkStructureType.GEOMETRY_AABB_NV }
fun MemoryStack.GeometryAABBNV(block: VkGeometryAABBNV.() -> Unit): VkGeometryAABBNV = GeometryAABBNV().also(block)
fun MemoryStack.GeometryAABBNV(capacity: Int): VkGeometryAABBNV.Buffer = VkGeometryAABBNV.callocStack(capacity, this).onEach { it.type = VkStructureType.GEOMETRY_AABB_NV }
fun MemoryStack.GeometryAABBNV(capacity: Int, block: VkGeometryAABBNV.Buffer.() -> Unit): VkGeometryAABBNV.Buffer = GeometryAABBNV(capacity).also(block)

fun MemoryStack.GeometryDataNV(): VkGeometryDataNV = VkGeometryDataNV.callocStack(this)
fun MemoryStack.GeometryDataNV(block: VkGeometryDataNV.() -> Unit): VkGeometryDataNV = GeometryDataNV().also(block)
fun MemoryStack.GeometryDataNV(capacity: Int): VkGeometryDataNV.Buffer = VkGeometryDataNV.callocStack(capacity, this)
fun MemoryStack.GeometryDataNV(capacity: Int, block: VkGeometryDataNV.Buffer.() -> Unit): VkGeometryDataNV.Buffer = GeometryDataNV(capacity).also(block)

fun MemoryStack.GeometryNV(): VkGeometryNV = VkGeometryNV.callocStack(this).apply { type = VkStructureType.GEOMETRY_NV }
fun MemoryStack.GeometryNV(block: VkGeometryNV.() -> Unit): VkGeometryNV = GeometryNV().also(block)
fun MemoryStack.GeometryNV(capacity: Int): VkGeometryNV.Buffer = VkGeometryNV.callocStack(capacity, this).onEach { it.type = VkStructureType.GEOMETRY_NV }
fun MemoryStack.GeometryNV(capacity: Int, block: VkGeometryNV.Buffer.() -> Unit): VkGeometryNV.Buffer = GeometryNV(capacity).also(block)

fun MemoryStack.GeometryTrianglesNV(): VkGeometryTrianglesNV = VkGeometryTrianglesNV.callocStack(this).apply { type = VkStructureType.GEOMETRY_TRIANGLES_NV }
fun MemoryStack.GeometryTrianglesNV(block: VkGeometryTrianglesNV.() -> Unit): VkGeometryTrianglesNV = GeometryTrianglesNV().also(block)
fun MemoryStack.GeometryTrianglesNV(capacity: Int): VkGeometryTrianglesNV.Buffer = VkGeometryTrianglesNV.callocStack(capacity, this).onEach { it.type = VkStructureType.GEOMETRY_TRIANGLES_NV }
fun MemoryStack.GeometryTrianglesNV(capacity: Int, block: VkGeometryTrianglesNV.Buffer.() -> Unit): VkGeometryTrianglesNV.Buffer = GeometryTrianglesNV(capacity).also(block)

fun MemoryStack.GraphicsPipelineCreateInfo(): VkGraphicsPipelineCreateInfo = VkGraphicsPipelineCreateInfo.callocStack(this).apply { type = VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO }
fun MemoryStack.GraphicsPipelineCreateInfo(block: VkGraphicsPipelineCreateInfo.() -> Unit): VkGraphicsPipelineCreateInfo = GraphicsPipelineCreateInfo().also(block)
fun MemoryStack.GraphicsPipelineCreateInfo(capacity: Int): VkGraphicsPipelineCreateInfo.Buffer = VkGraphicsPipelineCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.GRAPHICS_PIPELINE_CREATE_INFO }
fun MemoryStack.GraphicsPipelineCreateInfo(capacity: Int, block: VkGraphicsPipelineCreateInfo.Buffer.() -> Unit): VkGraphicsPipelineCreateInfo.Buffer = GraphicsPipelineCreateInfo(capacity).also(block)

fun MemoryStack.HdrMetadataEXT(): VkHdrMetadataEXT = VkHdrMetadataEXT.callocStack(this).apply { type = VkStructureType.HDR_METADATA_EXT }
fun MemoryStack.HdrMetadataEXT(block: VkHdrMetadataEXT.() -> Unit): VkHdrMetadataEXT = HdrMetadataEXT().also(block)
fun MemoryStack.HdrMetadataEXT(capacity: Int): VkHdrMetadataEXT.Buffer = VkHdrMetadataEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.HDR_METADATA_EXT }
fun MemoryStack.HdrMetadataEXT(capacity: Int, block: VkHdrMetadataEXT.Buffer.() -> Unit): VkHdrMetadataEXT.Buffer = HdrMetadataEXT(capacity).also(block)

fun MemoryStack.ImageBlit(): VkImageBlit = VkImageBlit.callocStack(this)
fun MemoryStack.ImageBlit(block: VkImageBlit.() -> Unit): VkImageBlit = ImageBlit().also(block)
fun MemoryStack.ImageBlit(capacity: Int): VkImageBlit.Buffer = VkImageBlit.callocStack(capacity, this)
fun MemoryStack.ImageBlit(capacity: Int, block: VkImageBlit.Buffer.() -> Unit): VkImageBlit.Buffer = ImageBlit(capacity).also(block)

fun MemoryStack.ImageCopy(): VkImageCopy = VkImageCopy.callocStack(this)
fun MemoryStack.ImageCopy(block: VkImageCopy.() -> Unit): VkImageCopy = ImageCopy().also(block)
fun MemoryStack.ImageCopy(capacity: Int): VkImageCopy.Buffer = VkImageCopy.callocStack(capacity, this)
fun MemoryStack.ImageCopy(capacity: Int, block: VkImageCopy.Buffer.() -> Unit): VkImageCopy.Buffer = ImageCopy(capacity).also(block)

fun MemoryStack.ImageCreateInfo(): VkImageCreateInfo = VkImageCreateInfo.callocStack(this)
fun MemoryStack.ImageCreateInfo(block: VkImageCreateInfo.() -> Unit): VkImageCreateInfo = ImageCreateInfo().also(block)
fun MemoryStack.ImageCreateInfo(capacity: Int): VkImageCreateInfo.Buffer = VkImageCreateInfo.callocStack(capacity, this)
fun MemoryStack.ImageCreateInfo(capacity: Int, block: VkImageCreateInfo.Buffer.() -> Unit): VkImageCreateInfo.Buffer = ImageCreateInfo(capacity).also(block)

fun MemoryStack.ImageDrmFormatModifierExplicitCreateInfoEXT(): VkImageDrmFormatModifierExplicitCreateInfoEXT = VkImageDrmFormatModifierExplicitCreateInfoEXT.callocStack(this).apply { type = VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_EXPLICIT_CREATE_INFO_EXT }
fun MemoryStack.ImageDrmFormatModifierExplicitCreateInfoEXT(block: VkImageDrmFormatModifierExplicitCreateInfoEXT.() -> Unit): VkImageDrmFormatModifierExplicitCreateInfoEXT = ImageDrmFormatModifierExplicitCreateInfoEXT().also(block)
fun MemoryStack.ImageDrmFormatModifierExplicitCreateInfoEXT(capacity: Int): VkImageDrmFormatModifierExplicitCreateInfoEXT.Buffer = VkImageDrmFormatModifierExplicitCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_EXPLICIT_CREATE_INFO_EXT }
fun MemoryStack.ImageDrmFormatModifierExplicitCreateInfoEXT(capacity: Int, block: VkImageDrmFormatModifierExplicitCreateInfoEXT.Buffer.() -> Unit): VkImageDrmFormatModifierExplicitCreateInfoEXT.Buffer = ImageDrmFormatModifierExplicitCreateInfoEXT(capacity).also(block)

fun MemoryStack.ImageDrmFormatModifierListCreateInfoEXT(): VkImageDrmFormatModifierListCreateInfoEXT = VkImageDrmFormatModifierListCreateInfoEXT.callocStack(this).apply { type = VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_LIST_CREATE_INFO_EXT }
fun MemoryStack.ImageDrmFormatModifierListCreateInfoEXT(block: VkImageDrmFormatModifierListCreateInfoEXT.() -> Unit): VkImageDrmFormatModifierListCreateInfoEXT = ImageDrmFormatModifierListCreateInfoEXT().also(block)
fun MemoryStack.ImageDrmFormatModifierListCreateInfoEXT(capacity: Int): VkImageDrmFormatModifierListCreateInfoEXT.Buffer = VkImageDrmFormatModifierListCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_LIST_CREATE_INFO_EXT }
fun MemoryStack.ImageDrmFormatModifierListCreateInfoEXT(capacity: Int, block: VkImageDrmFormatModifierListCreateInfoEXT.Buffer.() -> Unit): VkImageDrmFormatModifierListCreateInfoEXT.Buffer = ImageDrmFormatModifierListCreateInfoEXT(capacity).also(block)

fun MemoryStack.ImageDrmFormatModifierPropertiesEXT(): VkImageDrmFormatModifierPropertiesEXT = VkImageDrmFormatModifierPropertiesEXT.callocStack(this).apply { type = VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_PROPERTIES_EXT }
fun MemoryStack.ImageDrmFormatModifierPropertiesEXT(block: VkImageDrmFormatModifierPropertiesEXT.() -> Unit): VkImageDrmFormatModifierPropertiesEXT = ImageDrmFormatModifierPropertiesEXT().also(block)
fun MemoryStack.ImageDrmFormatModifierPropertiesEXT(capacity: Int): VkImageDrmFormatModifierPropertiesEXT.Buffer = VkImageDrmFormatModifierPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_PROPERTIES_EXT }
fun MemoryStack.ImageDrmFormatModifierPropertiesEXT(capacity: Int, block: VkImageDrmFormatModifierPropertiesEXT.Buffer.() -> Unit): VkImageDrmFormatModifierPropertiesEXT.Buffer = ImageDrmFormatModifierPropertiesEXT(capacity).also(block)

fun MemoryStack.ImageFormatListCreateInfoKHR(): VkImageFormatListCreateInfoKHR = VkImageFormatListCreateInfoKHR.callocStack(this).apply { type = VkStructureType.IMAGE_FORMAT_LIST_CREATE_INFO_KHR }
fun MemoryStack.ImageFormatListCreateInfoKHR(block: VkImageFormatListCreateInfoKHR.() -> Unit): VkImageFormatListCreateInfoKHR = ImageFormatListCreateInfoKHR().also(block)
fun MemoryStack.ImageFormatListCreateInfoKHR(capacity: Int): VkImageFormatListCreateInfoKHR.Buffer = VkImageFormatListCreateInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_FORMAT_LIST_CREATE_INFO_KHR }
fun MemoryStack.ImageFormatListCreateInfoKHR(capacity: Int, block: VkImageFormatListCreateInfoKHR.Buffer.() -> Unit): VkImageFormatListCreateInfoKHR.Buffer = ImageFormatListCreateInfoKHR(capacity).also(block)

fun MemoryStack.ImageFormatProperties(): VkImageFormatProperties = VkImageFormatProperties.callocStack(this)
fun MemoryStack.ImageFormatProperties(block: VkImageFormatProperties.() -> Unit): VkImageFormatProperties = ImageFormatProperties().also(block)
fun MemoryStack.ImageFormatProperties(capacity: Int): VkImageFormatProperties.Buffer = VkImageFormatProperties.callocStack(capacity, this)
fun MemoryStack.ImageFormatProperties(capacity: Int, block: VkImageFormatProperties.Buffer.() -> Unit): VkImageFormatProperties.Buffer = ImageFormatProperties(capacity).also(block)

fun MemoryStack.ImageFormatProperties2(): VkImageFormatProperties2 = VkImageFormatProperties2.callocStack(this).apply { type = VkStructureType.IMAGE_FORMAT_PROPERTIES_2 }
fun MemoryStack.ImageFormatProperties2(block: VkImageFormatProperties2.() -> Unit): VkImageFormatProperties2 = ImageFormatProperties2().also(block)
fun MemoryStack.ImageFormatProperties2(capacity: Int): VkImageFormatProperties2.Buffer = VkImageFormatProperties2.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_FORMAT_PROPERTIES_2 }
fun MemoryStack.ImageFormatProperties2(capacity: Int, block: VkImageFormatProperties2.Buffer.() -> Unit): VkImageFormatProperties2.Buffer = ImageFormatProperties2(capacity).also(block)

fun MemoryStack.ImageMemoryBarrier(): VkImageMemoryBarrier = VkImageMemoryBarrier.callocStack(this).apply { type = VkStructureType.IMAGE_MEMORY_BARRIER }
fun MemoryStack.ImageMemoryBarrier(block: VkImageMemoryBarrier.() -> Unit): VkImageMemoryBarrier = ImageMemoryBarrier().also(block)
fun MemoryStack.ImageMemoryBarrier(capacity: Int): VkImageMemoryBarrier.Buffer = VkImageMemoryBarrier.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_MEMORY_BARRIER }
fun MemoryStack.ImageMemoryBarrier(capacity: Int, block: VkImageMemoryBarrier.Buffer.() -> Unit): VkImageMemoryBarrier.Buffer = ImageMemoryBarrier(capacity).also(block)

fun MemoryStack.ImageMemoryRequirementsInfo2(): VkImageMemoryRequirementsInfo2 = VkImageMemoryRequirementsInfo2.callocStack(this).apply { type = VkStructureType.IMAGE_MEMORY_REQUIREMENTS_INFO_2 }
fun MemoryStack.ImageMemoryRequirementsInfo2(block: VkImageMemoryRequirementsInfo2.() -> Unit): VkImageMemoryRequirementsInfo2 = ImageMemoryRequirementsInfo2().also(block)
fun MemoryStack.ImageMemoryRequirementsInfo2(capacity: Int): VkImageMemoryRequirementsInfo2.Buffer = VkImageMemoryRequirementsInfo2.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_MEMORY_REQUIREMENTS_INFO_2 }
fun MemoryStack.ImageMemoryRequirementsInfo2(capacity: Int, block: VkImageMemoryRequirementsInfo2.Buffer.() -> Unit): VkImageMemoryRequirementsInfo2.Buffer = ImageMemoryRequirementsInfo2(capacity).also(block)

fun MemoryStack.ImagePlaneMemoryRequirementsInfo(): VkImagePlaneMemoryRequirementsInfo = VkImagePlaneMemoryRequirementsInfo.callocStack(this).apply { type = VkStructureType.IMAGE_PLANE_MEMORY_REQUIREMENTS_INFO }
fun MemoryStack.ImagePlaneMemoryRequirementsInfo(block: VkImagePlaneMemoryRequirementsInfo.() -> Unit): VkImagePlaneMemoryRequirementsInfo = ImagePlaneMemoryRequirementsInfo().also(block)
fun MemoryStack.ImagePlaneMemoryRequirementsInfo(capacity: Int): VkImagePlaneMemoryRequirementsInfo.Buffer = VkImagePlaneMemoryRequirementsInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_PLANE_MEMORY_REQUIREMENTS_INFO }
fun MemoryStack.ImagePlaneMemoryRequirementsInfo(capacity: Int, block: VkImagePlaneMemoryRequirementsInfo.Buffer.() -> Unit): VkImagePlaneMemoryRequirementsInfo.Buffer = ImagePlaneMemoryRequirementsInfo(capacity).also(block)

fun MemoryStack.ImageResolve(): VkImageResolve = VkImageResolve.callocStack(this)
fun MemoryStack.ImageResolve(block: VkImageResolve.() -> Unit): VkImageResolve = ImageResolve().also(block)
fun MemoryStack.ImageResolve(capacity: Int): VkImageResolve.Buffer = VkImageResolve.callocStack(capacity, this)
fun MemoryStack.ImageResolve(capacity: Int, block: VkImageResolve.Buffer.() -> Unit): VkImageResolve.Buffer = ImageResolve(capacity).also(block)

fun MemoryStack.ImageSparseMemoryRequirementsInfo2(): VkImageSparseMemoryRequirementsInfo2 = VkImageSparseMemoryRequirementsInfo2.callocStack(this).apply { type = VkStructureType.IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2 }
fun MemoryStack.ImageSparseMemoryRequirementsInfo2(block: VkImageSparseMemoryRequirementsInfo2.() -> Unit): VkImageSparseMemoryRequirementsInfo2 = ImageSparseMemoryRequirementsInfo2().also(block)
fun MemoryStack.ImageSparseMemoryRequirementsInfo2(capacity: Int): VkImageSparseMemoryRequirementsInfo2.Buffer = VkImageSparseMemoryRequirementsInfo2.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2 }
fun MemoryStack.ImageSparseMemoryRequirementsInfo2(capacity: Int, block: VkImageSparseMemoryRequirementsInfo2.Buffer.() -> Unit): VkImageSparseMemoryRequirementsInfo2.Buffer = ImageSparseMemoryRequirementsInfo2(capacity).also(block)

fun MemoryStack.ImageStencilUsageCreateInfoEXT(): VkImageStencilUsageCreateInfoEXT = VkImageStencilUsageCreateInfoEXT.callocStack(this).apply { type = VkStructureType.IMAGE_STENCIL_USAGE_CREATE_INFO_EXT }
fun MemoryStack.ImageStencilUsageCreateInfoEXT(block: VkImageStencilUsageCreateInfoEXT.() -> Unit): VkImageStencilUsageCreateInfoEXT = ImageStencilUsageCreateInfoEXT().also(block)
fun MemoryStack.ImageStencilUsageCreateInfoEXT(capacity: Int): VkImageStencilUsageCreateInfoEXT.Buffer = VkImageStencilUsageCreateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_STENCIL_USAGE_CREATE_INFO_EXT }
fun MemoryStack.ImageStencilUsageCreateInfoEXT(capacity: Int, block: VkImageStencilUsageCreateInfoEXT.Buffer.() -> Unit): VkImageStencilUsageCreateInfoEXT.Buffer = ImageStencilUsageCreateInfoEXT(capacity).also(block)

fun MemoryStack.ImageSubresource(): VkImageSubresource = VkImageSubresource.callocStack(this)
fun MemoryStack.ImageSubresource(block: VkImageSubresource.() -> Unit): VkImageSubresource = ImageSubresource().also(block)
fun MemoryStack.ImageSubresource(capacity: Int): VkImageSubresource.Buffer = VkImageSubresource.callocStack(capacity, this)
fun MemoryStack.ImageSubresource(capacity: Int, block: VkImageSubresource.Buffer.() -> Unit): VkImageSubresource.Buffer = ImageSubresource(capacity).also(block)

fun MemoryStack.ImageSubresourceLayers(): VkImageSubresourceLayers = VkImageSubresourceLayers.callocStack(this)
fun MemoryStack.ImageSubresourceLayers(block: VkImageSubresourceLayers.() -> Unit): VkImageSubresourceLayers = ImageSubresourceLayers().also(block)
fun MemoryStack.ImageSubresourceLayers(capacity: Int): VkImageSubresourceLayers.Buffer = VkImageSubresourceLayers.callocStack(capacity, this)
fun MemoryStack.ImageSubresourceLayers(capacity: Int, block: VkImageSubresourceLayers.Buffer.() -> Unit): VkImageSubresourceLayers.Buffer = ImageSubresourceLayers(capacity).also(block)

fun MemoryStack.ImageSubresourceRange(): VkImageSubresourceRange = VkImageSubresourceRange.callocStack(this)
fun MemoryStack.ImageSubresourceRange(block: VkImageSubresourceRange.() -> Unit): VkImageSubresourceRange = ImageSubresourceRange().also(block)
fun MemoryStack.ImageSubresourceRange(capacity: Int): VkImageSubresourceRange.Buffer = VkImageSubresourceRange.callocStack(capacity, this)
fun MemoryStack.ImageSubresourceRange(capacity: Int, block: VkImageSubresourceRange.Buffer.() -> Unit): VkImageSubresourceRange.Buffer = ImageSubresourceRange(capacity).also(block)

fun MemoryStack.ImageSwapchainCreateInfoKHR(): VkImageSwapchainCreateInfoKHR = VkImageSwapchainCreateInfoKHR.callocStack(this).apply { type = VkStructureType.IMAGE_SWAPCHAIN_CREATE_INFO_KHR }
fun MemoryStack.ImageSwapchainCreateInfoKHR(block: VkImageSwapchainCreateInfoKHR.() -> Unit): VkImageSwapchainCreateInfoKHR = ImageSwapchainCreateInfoKHR().also(block)
fun MemoryStack.ImageSwapchainCreateInfoKHR(capacity: Int): VkImageSwapchainCreateInfoKHR.Buffer = VkImageSwapchainCreateInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_SWAPCHAIN_CREATE_INFO_KHR }
fun MemoryStack.ImageSwapchainCreateInfoKHR(capacity: Int, block: VkImageSwapchainCreateInfoKHR.Buffer.() -> Unit): VkImageSwapchainCreateInfoKHR.Buffer = ImageSwapchainCreateInfoKHR(capacity).also(block)

fun MemoryStack.ImageViewASTCDecodeModeEXT(): VkImageViewASTCDecodeModeEXT = VkImageViewASTCDecodeModeEXT.callocStack(this).apply { type = VkStructureType.IMAGE_VIEW_ASTC_DECODE_MODE_EXT }
fun MemoryStack.ImageViewASTCDecodeModeEXT(block: VkImageViewASTCDecodeModeEXT.() -> Unit): VkImageViewASTCDecodeModeEXT = ImageViewASTCDecodeModeEXT().also(block)
fun MemoryStack.ImageViewASTCDecodeModeEXT(capacity: Int): VkImageViewASTCDecodeModeEXT.Buffer = VkImageViewASTCDecodeModeEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_VIEW_ASTC_DECODE_MODE_EXT }
fun MemoryStack.ImageViewASTCDecodeModeEXT(capacity: Int, block: VkImageViewASTCDecodeModeEXT.Buffer.() -> Unit): VkImageViewASTCDecodeModeEXT.Buffer = ImageViewASTCDecodeModeEXT(capacity).also(block)

fun MemoryStack.ImageViewCreateInfo(): VkImageViewCreateInfo = VkImageViewCreateInfo.callocStack(this).apply { type = VkStructureType.IMAGE_VIEW_CREATE_INFO }
fun MemoryStack.ImageViewCreateInfo(block: VkImageViewCreateInfo.() -> Unit): VkImageViewCreateInfo = ImageViewCreateInfo().also(block)
fun MemoryStack.ImageViewCreateInfo(capacity: Int): VkImageViewCreateInfo.Buffer = VkImageViewCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_VIEW_CREATE_INFO }
fun MemoryStack.ImageViewCreateInfo(capacity: Int, block: VkImageViewCreateInfo.Buffer.() -> Unit): VkImageViewCreateInfo.Buffer = ImageViewCreateInfo(capacity).also(block)

fun MemoryStack.ImageViewUsageCreateInfo(): VkImageViewUsageCreateInfo = VkImageViewUsageCreateInfo.callocStack(this).apply { type = VkStructureType.IMAGE_VIEW_USAGE_CREATE_INFO }
fun MemoryStack.ImageViewUsageCreateInfo(block: VkImageViewUsageCreateInfo.() -> Unit): VkImageViewUsageCreateInfo = ImageViewUsageCreateInfo().also(block)
fun MemoryStack.ImageViewUsageCreateInfo(capacity: Int): VkImageViewUsageCreateInfo.Buffer = VkImageViewUsageCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.IMAGE_VIEW_USAGE_CREATE_INFO }
fun MemoryStack.ImageViewUsageCreateInfo(capacity: Int, block: VkImageViewUsageCreateInfo.Buffer.() -> Unit): VkImageViewUsageCreateInfo.Buffer = ImageViewUsageCreateInfo(capacity).also(block)

fun MemoryStack.ImportFenceFdInfoKHR(): VkImportFenceFdInfoKHR = VkImportFenceFdInfoKHR.callocStack(this).apply { type = VkStructureType.IMPORT_FENCE_FD_INFO_KHR }
fun MemoryStack.ImportFenceFdInfoKHR(block: VkImportFenceFdInfoKHR.() -> Unit): VkImportFenceFdInfoKHR = ImportFenceFdInfoKHR().also(block)
fun MemoryStack.ImportFenceFdInfoKHR(capacity: Int): VkImportFenceFdInfoKHR.Buffer = VkImportFenceFdInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.IMPORT_FENCE_FD_INFO_KHR }
fun MemoryStack.ImportFenceFdInfoKHR(capacity: Int, block: VkImportFenceFdInfoKHR.Buffer.() -> Unit): VkImportFenceFdInfoKHR.Buffer = ImportFenceFdInfoKHR(capacity).also(block)

fun MemoryStack.ImportFenceWin32HandleInfoKHR(): VkImportFenceWin32HandleInfoKHR = VkImportFenceWin32HandleInfoKHR.callocStack(this).apply { type = VkStructureType.IMPORT_FENCE_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ImportFenceWin32HandleInfoKHR(block: VkImportFenceWin32HandleInfoKHR.() -> Unit): VkImportFenceWin32HandleInfoKHR = ImportFenceWin32HandleInfoKHR().also(block)
fun MemoryStack.ImportFenceWin32HandleInfoKHR(capacity: Int): VkImportFenceWin32HandleInfoKHR.Buffer = VkImportFenceWin32HandleInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.IMPORT_FENCE_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ImportFenceWin32HandleInfoKHR(capacity: Int, block: VkImportFenceWin32HandleInfoKHR.Buffer.() -> Unit): VkImportFenceWin32HandleInfoKHR.Buffer = ImportFenceWin32HandleInfoKHR(capacity).also(block)

fun MemoryStack.ImportMemoryFdInfoKHR(): VkImportMemoryFdInfoKHR = VkImportMemoryFdInfoKHR.callocStack(this).apply { type = VkStructureType.IMPORT_MEMORY_FD_INFO_KHR }
fun MemoryStack.ImportMemoryFdInfoKHR(block: VkImportMemoryFdInfoKHR.() -> Unit): VkImportMemoryFdInfoKHR = ImportMemoryFdInfoKHR().also(block)
fun MemoryStack.ImportMemoryFdInfoKHR(capacity: Int): VkImportMemoryFdInfoKHR.Buffer = VkImportMemoryFdInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.IMPORT_MEMORY_FD_INFO_KHR }
fun MemoryStack.ImportMemoryFdInfoKHR(capacity: Int, block: VkImportMemoryFdInfoKHR.Buffer.() -> Unit): VkImportMemoryFdInfoKHR.Buffer = ImportMemoryFdInfoKHR(capacity).also(block)

fun MemoryStack.ImportMemoryHostPointerInfoEXT(): VkImportMemoryHostPointerInfoEXT = VkImportMemoryHostPointerInfoEXT.callocStack(this).apply { type = VkStructureType.IMPORT_MEMORY_HOST_POINTER_INFO_EXT }
fun MemoryStack.ImportMemoryHostPointerInfoEXT(block: VkImportMemoryHostPointerInfoEXT.() -> Unit): VkImportMemoryHostPointerInfoEXT = ImportMemoryHostPointerInfoEXT().also(block)
fun MemoryStack.ImportMemoryHostPointerInfoEXT(capacity: Int): VkImportMemoryHostPointerInfoEXT.Buffer = VkImportMemoryHostPointerInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.IMPORT_MEMORY_HOST_POINTER_INFO_EXT }
fun MemoryStack.ImportMemoryHostPointerInfoEXT(capacity: Int, block: VkImportMemoryHostPointerInfoEXT.Buffer.() -> Unit): VkImportMemoryHostPointerInfoEXT.Buffer = ImportMemoryHostPointerInfoEXT(capacity).also(block)

fun MemoryStack.ImportMemoryWin32HandleInfoKHR(): VkImportMemoryWin32HandleInfoKHR = VkImportMemoryWin32HandleInfoKHR.callocStack(this).apply { type = VkStructureType.IMPORT_MEMORY_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ImportMemoryWin32HandleInfoKHR(block: VkImportMemoryWin32HandleInfoKHR.() -> Unit): VkImportMemoryWin32HandleInfoKHR = ImportMemoryWin32HandleInfoKHR().also(block)
fun MemoryStack.ImportMemoryWin32HandleInfoKHR(capacity: Int): VkImportMemoryWin32HandleInfoKHR.Buffer = VkImportMemoryWin32HandleInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.IMPORT_MEMORY_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ImportMemoryWin32HandleInfoKHR(capacity: Int, block: VkImportMemoryWin32HandleInfoKHR.Buffer.() -> Unit): VkImportMemoryWin32HandleInfoKHR.Buffer = ImportMemoryWin32HandleInfoKHR(capacity).also(block)

fun MemoryStack.ImportMemoryWin32HandleInfoNV(): VkImportMemoryWin32HandleInfoNV = VkImportMemoryWin32HandleInfoNV.callocStack(this).apply { type = VkStructureType.IMPORT_MEMORY_WIN32_HANDLE_INFO_NV }
fun MemoryStack.ImportMemoryWin32HandleInfoNV(block: VkImportMemoryWin32HandleInfoNV.() -> Unit): VkImportMemoryWin32HandleInfoNV = ImportMemoryWin32HandleInfoNV().also(block)
fun MemoryStack.ImportMemoryWin32HandleInfoNV(capacity: Int): VkImportMemoryWin32HandleInfoNV.Buffer = VkImportMemoryWin32HandleInfoNV.callocStack(capacity, this).onEach { it.type = VkStructureType.IMPORT_MEMORY_WIN32_HANDLE_INFO_NV }
fun MemoryStack.ImportMemoryWin32HandleInfoNV(capacity: Int, block: VkImportMemoryWin32HandleInfoNV.Buffer.() -> Unit): VkImportMemoryWin32HandleInfoNV.Buffer = ImportMemoryWin32HandleInfoNV(capacity).also(block)

fun MemoryStack.ImportSemaphoreFdInfoKHR(): VkImportSemaphoreFdInfoKHR = VkImportSemaphoreFdInfoKHR.callocStack(this).apply { type = VkStructureType.IMPORT_SEMAPHORE_FD_INFO_KHR }
fun MemoryStack.ImportSemaphoreFdInfoKHR(block: VkImportSemaphoreFdInfoKHR.() -> Unit): VkImportSemaphoreFdInfoKHR = ImportSemaphoreFdInfoKHR().also(block)
fun MemoryStack.ImportSemaphoreFdInfoKHR(capacity: Int): VkImportSemaphoreFdInfoKHR.Buffer = VkImportSemaphoreFdInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.IMPORT_SEMAPHORE_FD_INFO_KHR }
fun MemoryStack.ImportSemaphoreFdInfoKHR(capacity: Int, block: VkImportSemaphoreFdInfoKHR.Buffer.() -> Unit): VkImportSemaphoreFdInfoKHR.Buffer = ImportSemaphoreFdInfoKHR(capacity).also(block)

fun MemoryStack.ImportSemaphoreWin32HandleInfoKHR(): VkImportSemaphoreWin32HandleInfoKHR = VkImportSemaphoreWin32HandleInfoKHR.callocStack(this).apply { type = VkStructureType.IMPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ImportSemaphoreWin32HandleInfoKHR(block: VkImportSemaphoreWin32HandleInfoKHR.() -> Unit): VkImportSemaphoreWin32HandleInfoKHR = ImportSemaphoreWin32HandleInfoKHR().also(block)
fun MemoryStack.ImportSemaphoreWin32HandleInfoKHR(capacity: Int): VkImportSemaphoreWin32HandleInfoKHR.Buffer = VkImportSemaphoreWin32HandleInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.IMPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.ImportSemaphoreWin32HandleInfoKHR(capacity: Int, block: VkImportSemaphoreWin32HandleInfoKHR.Buffer.() -> Unit): VkImportSemaphoreWin32HandleInfoKHR.Buffer = ImportSemaphoreWin32HandleInfoKHR(capacity).also(block)

fun MemoryStack.IndirectCommandsLayoutCreateInfoNVX(): VkIndirectCommandsLayoutCreateInfoNVX = VkIndirectCommandsLayoutCreateInfoNVX.callocStack(this).apply { type = VkStructureType.INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_NVX }
fun MemoryStack.IndirectCommandsLayoutCreateInfoNVX(block: VkIndirectCommandsLayoutCreateInfoNVX.() -> Unit): VkIndirectCommandsLayoutCreateInfoNVX = IndirectCommandsLayoutCreateInfoNVX().also(block)
fun MemoryStack.IndirectCommandsLayoutCreateInfoNVX(capacity: Int): VkIndirectCommandsLayoutCreateInfoNVX.Buffer = VkIndirectCommandsLayoutCreateInfoNVX.callocStack(capacity, this).onEach { it.type = VkStructureType.INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_NVX }
fun MemoryStack.IndirectCommandsLayoutCreateInfoNVX(capacity: Int, block: VkIndirectCommandsLayoutCreateInfoNVX.Buffer.() -> Unit): VkIndirectCommandsLayoutCreateInfoNVX.Buffer = IndirectCommandsLayoutCreateInfoNVX(capacity).also(block)

fun MemoryStack.IndirectCommandsLayoutTokenNVX(): VkIndirectCommandsLayoutTokenNVX = VkIndirectCommandsLayoutTokenNVX.callocStack(this)
fun MemoryStack.IndirectCommandsLayoutTokenNVX(block: VkIndirectCommandsLayoutTokenNVX.() -> Unit): VkIndirectCommandsLayoutTokenNVX = IndirectCommandsLayoutTokenNVX().also(block)
fun MemoryStack.IndirectCommandsLayoutTokenNVX(capacity: Int): VkIndirectCommandsLayoutTokenNVX.Buffer = VkIndirectCommandsLayoutTokenNVX.callocStack(capacity, this)
fun MemoryStack.IndirectCommandsLayoutTokenNVX(capacity: Int, block: VkIndirectCommandsLayoutTokenNVX.Buffer.() -> Unit): VkIndirectCommandsLayoutTokenNVX.Buffer = IndirectCommandsLayoutTokenNVX(capacity).also(block)

fun MemoryStack.IndirectCommandsTokenNVX(): VkIndirectCommandsTokenNVX = VkIndirectCommandsTokenNVX.callocStack(this)
fun MemoryStack.IndirectCommandsTokenNVX(block: VkIndirectCommandsTokenNVX.() -> Unit): VkIndirectCommandsTokenNVX = IndirectCommandsTokenNVX().also(block)
fun MemoryStack.IndirectCommandsTokenNVX(capacity: Int): VkIndirectCommandsTokenNVX.Buffer = VkIndirectCommandsTokenNVX.callocStack(capacity, this)
fun MemoryStack.IndirectCommandsTokenNVX(capacity: Int, block: VkIndirectCommandsTokenNVX.Buffer.() -> Unit): VkIndirectCommandsTokenNVX.Buffer = IndirectCommandsTokenNVX(capacity).also(block)

fun MemoryStack.InputAttachmentAspectReference(): VkInputAttachmentAspectReference = VkInputAttachmentAspectReference.callocStack(this)
fun MemoryStack.InputAttachmentAspectReference(block: VkInputAttachmentAspectReference.() -> Unit): VkInputAttachmentAspectReference = InputAttachmentAspectReference().also(block)
fun MemoryStack.InputAttachmentAspectReference(capacity: Int): VkInputAttachmentAspectReference.Buffer = VkInputAttachmentAspectReference.callocStack(capacity, this)
fun MemoryStack.InputAttachmentAspectReference(capacity: Int, block: VkInputAttachmentAspectReference.Buffer.() -> Unit): VkInputAttachmentAspectReference.Buffer = InputAttachmentAspectReference(capacity).also(block)

fun MemoryStack.InstanceCreateInfo(): VkInstanceCreateInfo = VkInstanceCreateInfo.callocStack(this).apply { type = VkStructureType.INSTANCE_CREATE_INFO }
fun MemoryStack.InstanceCreateInfo(block: VkInstanceCreateInfo.() -> Unit): VkInstanceCreateInfo = InstanceCreateInfo().also(block)
fun MemoryStack.InstanceCreateInfo(capacity: Int): VkInstanceCreateInfo.Buffer = VkInstanceCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.INSTANCE_CREATE_INFO }
fun MemoryStack.InstanceCreateInfo(capacity: Int, block: VkInstanceCreateInfo.Buffer.() -> Unit): VkInstanceCreateInfo.Buffer = InstanceCreateInfo(capacity).also(block)

fun MemoryStack.LayerProperties(): VkLayerProperties = VkLayerProperties.callocStack(this)
fun MemoryStack.LayerProperties(block: VkLayerProperties.() -> Unit): VkLayerProperties = LayerProperties().also(block)
fun MemoryStack.LayerProperties(capacity: Int): VkLayerProperties.Buffer = VkLayerProperties.callocStack(capacity, this)
fun MemoryStack.LayerProperties(capacity: Int, block: VkLayerProperties.Buffer.() -> Unit): VkLayerProperties.Buffer = LayerProperties(capacity).also(block)

fun MemoryStack.MacOSSurfaceCreateInfoMVK(): VkMacOSSurfaceCreateInfoMVK = VkMacOSSurfaceCreateInfoMVK.callocStack(this).apply { type = VkStructureType.MACOS_SURFACE_CREATE_INFO_MVK }
fun MemoryStack.MacOSSurfaceCreateInfoMVK(block: VkMacOSSurfaceCreateInfoMVK.() -> Unit): VkMacOSSurfaceCreateInfoMVK = MacOSSurfaceCreateInfoMVK().also(block)
fun MemoryStack.MacOSSurfaceCreateInfoMVK(capacity: Int): VkMacOSSurfaceCreateInfoMVK.Buffer = VkMacOSSurfaceCreateInfoMVK.callocStack(capacity, this).onEach { it.type = VkStructureType.MACOS_SURFACE_CREATE_INFO_MVK }
fun MemoryStack.MacOSSurfaceCreateInfoMVK(capacity: Int, block: VkMacOSSurfaceCreateInfoMVK.Buffer.() -> Unit): VkMacOSSurfaceCreateInfoMVK.Buffer = MacOSSurfaceCreateInfoMVK(capacity).also(block)

fun MemoryStack.Offset2D(): VkOffset2D = VkOffset2D.callocStack(this)
fun MemoryStack.Offset2D(block: VkOffset2D.() -> Unit): VkOffset2D = Offset2D().also(block)
fun MemoryStack.Offset2D(capacity: Int): VkOffset2D.Buffer = VkOffset2D.callocStack(capacity, this)
fun MemoryStack.Offset2D(capacity: Int, block: VkOffset2D.Buffer.() -> Unit): VkOffset2D.Buffer = Offset2D(capacity).also(block)

fun MemoryStack.Offset3D(): VkOffset3D = VkOffset3D.callocStack(this)
fun MemoryStack.Offset3D(block: VkOffset3D.() -> Unit): VkOffset3D = Offset3D().also(block)
fun MemoryStack.Offset3D(capacity: Int): VkOffset3D.Buffer = VkOffset3D.callocStack(capacity, this)
fun MemoryStack.Offset3D(capacity: Int, block: VkOffset3D.Buffer.() -> Unit): VkOffset3D.Buffer = Offset3D(capacity).also(block)

fun MemoryStack.MappedMemoryRange(): VkMappedMemoryRange = VkMappedMemoryRange.callocStack(this).apply { type = VkStructureType.MAPPED_MEMORY_RANGE }
fun MemoryStack.MappedMemoryRange(block: VkMappedMemoryRange.() -> Unit): VkMappedMemoryRange = MappedMemoryRange().also(block)
fun MemoryStack.MappedMemoryRange(capacity: Int): VkMappedMemoryRange.Buffer = VkMappedMemoryRange.callocStack(capacity, this).onEach { it.type = VkStructureType.MAPPED_MEMORY_RANGE }
fun MemoryStack.MappedMemoryRange(capacity: Int, block: VkMappedMemoryRange.Buffer.() -> Unit): VkMappedMemoryRange.Buffer = MappedMemoryRange(capacity).also(block)

fun MemoryStack.MemoryAllocateFlagsInfo(): VkMemoryAllocateFlagsInfo = VkMemoryAllocateFlagsInfo.callocStack(this).apply { type = VkStructureType.MEMORY_ALLOCATE_FLAGS_INFO }
fun MemoryStack.MemoryAllocateFlagsInfo(block: VkMemoryAllocateFlagsInfo.() -> Unit): VkMemoryAllocateFlagsInfo = MemoryAllocateFlagsInfo().also(block)
fun MemoryStack.MemoryAllocateFlagsInfo(capacity: Int): VkMemoryAllocateFlagsInfo.Buffer = VkMemoryAllocateFlagsInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_ALLOCATE_FLAGS_INFO }
fun MemoryStack.MemoryAllocateFlagsInfo(capacity: Int, block: VkMemoryAllocateFlagsInfo.Buffer.() -> Unit): VkMemoryAllocateFlagsInfo.Buffer = MemoryAllocateFlagsInfo(capacity).also(block)

fun MemoryStack.MemoryAllocateInfo(): VkMemoryAllocateInfo = VkMemoryAllocateInfo.callocStack(this).apply { type = VkStructureType.MEMORY_ALLOCATE_INFO }
fun MemoryStack.MemoryAllocateInfo(block: VkMemoryAllocateInfo.() -> Unit): VkMemoryAllocateInfo = MemoryAllocateInfo().also(block)
fun MemoryStack.MemoryAllocateInfo(capacity: Int): VkMemoryAllocateInfo.Buffer = VkMemoryAllocateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_ALLOCATE_INFO }
fun MemoryStack.MemoryAllocateInfo(capacity: Int, block: VkMemoryAllocateInfo.Buffer.() -> Unit): VkMemoryAllocateInfo.Buffer = MemoryAllocateInfo(capacity).also(block)

fun MemoryStack.MemoryBarrier(): VkMemoryBarrier = VkMemoryBarrier.callocStack(this).apply { type = VkStructureType.MEMORY_BARRIER }
fun MemoryStack.MemoryBarrier(block: VkMemoryBarrier.() -> Unit): VkMemoryBarrier = MemoryBarrier().also(block)
fun MemoryStack.MemoryBarrier(capacity: Int): VkMemoryBarrier.Buffer = VkMemoryBarrier.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_BARRIER }
fun MemoryStack.MemoryBarrier(capacity: Int, block: VkMemoryBarrier.Buffer.() -> Unit): VkMemoryBarrier.Buffer = MemoryBarrier(capacity).also(block)

fun MemoryStack.MemoryDedicatedAllocateInfo(): VkMemoryDedicatedAllocateInfo = VkMemoryDedicatedAllocateInfo.callocStack(this).apply { type = VkStructureType.MEMORY_DEDICATED_ALLOCATE_INFO }
fun MemoryStack.MemoryDedicatedAllocateInfo(block: VkMemoryDedicatedAllocateInfo.() -> Unit): VkMemoryDedicatedAllocateInfo = MemoryDedicatedAllocateInfo().also(block)
fun MemoryStack.MemoryDedicatedAllocateInfo(capacity: Int): VkMemoryDedicatedAllocateInfo.Buffer = VkMemoryDedicatedAllocateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_DEDICATED_ALLOCATE_INFO }
fun MemoryStack.MemoryDedicatedAllocateInfo(capacity: Int, block: VkMemoryDedicatedAllocateInfo.Buffer.() -> Unit): VkMemoryDedicatedAllocateInfo.Buffer = MemoryDedicatedAllocateInfo(capacity).also(block)

//fun MemoryStack.MemoryDedicatedRequirements(): VkMemoryDedicatedRequirements = VkMemoryDedicatedRequirements.callocStack(this).apply { type = VkStructureType.MEMORY_DEDICATED_ALLOCATE_INFO }
//fun MemoryStack.MemoryDedicatedRequirements(block: VkMemoryDedicatedRequirements.() -> Unit): VkMemoryDedicatedRequirements = MemoryDedicatedRequirements().also(block)
//fun MemoryStack.MemoryDedicatedRequirements(capacity: Int): VkMemoryDedicatedRequirements.Buffer = VkMemoryDedicatedRequirements.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_DEDICATED_ALLOCATE_INFO }
//fun MemoryStack.MemoryDedicatedRequirements(capacity: Int, block: VkMemoryDedicatedRequirements.Buffer.() -> Unit): VkMemoryDedicatedRequirements.Buffer = MemoryDedicatedRequirements(capacity).also(block)

fun MemoryStack.MemoryFdPropertiesKHR(): VkMemoryFdPropertiesKHR = VkMemoryFdPropertiesKHR.callocStack(this).apply { type = VkStructureType.MEMORY_FD_PROPERTIES_KHR }
fun MemoryStack.MemoryFdPropertiesKHR(block: VkMemoryFdPropertiesKHR.() -> Unit): VkMemoryFdPropertiesKHR = MemoryFdPropertiesKHR().also(block)
fun MemoryStack.MemoryFdPropertiesKHR(capacity: Int): VkMemoryFdPropertiesKHR.Buffer = VkMemoryFdPropertiesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_FD_PROPERTIES_KHR }
fun MemoryStack.MemoryFdPropertiesKHR(capacity: Int, block: VkMemoryFdPropertiesKHR.Buffer.() -> Unit): VkMemoryFdPropertiesKHR.Buffer = MemoryFdPropertiesKHR(capacity).also(block)

fun MemoryStack.MemoryGetFdInfoKHR(): VkMemoryGetFdInfoKHR = VkMemoryGetFdInfoKHR.callocStack(this).apply { type = VkStructureType.MEMORY_GET_FD_INFO_KHR }
fun MemoryStack.MemoryGetFdInfoKHR(block: VkMemoryGetFdInfoKHR.() -> Unit): VkMemoryGetFdInfoKHR = MemoryGetFdInfoKHR().also(block)
fun MemoryStack.MemoryGetFdInfoKHR(capacity: Int): VkMemoryGetFdInfoKHR.Buffer = VkMemoryGetFdInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_GET_FD_INFO_KHR }
fun MemoryStack.MemoryGetFdInfoKHR(capacity: Int, block: VkMemoryGetFdInfoKHR.Buffer.() -> Unit): VkMemoryGetFdInfoKHR.Buffer = MemoryGetFdInfoKHR(capacity).also(block)

fun MemoryStack.MemoryGetWin32HandleInfoKHR(): VkMemoryGetWin32HandleInfoKHR = VkMemoryGetWin32HandleInfoKHR.callocStack(this).apply { type = VkStructureType.MEMORY_GET_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.MemoryGetWin32HandleInfoKHR(block: VkMemoryGetWin32HandleInfoKHR.() -> Unit): VkMemoryGetWin32HandleInfoKHR = MemoryGetWin32HandleInfoKHR().also(block)
fun MemoryStack.MemoryGetWin32HandleInfoKHR(capacity: Int): VkMemoryGetWin32HandleInfoKHR.Buffer = VkMemoryGetWin32HandleInfoKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_GET_WIN32_HANDLE_INFO_KHR }
fun MemoryStack.MemoryGetWin32HandleInfoKHR(capacity: Int, block: VkMemoryGetWin32HandleInfoKHR.Buffer.() -> Unit): VkMemoryGetWin32HandleInfoKHR.Buffer = MemoryGetWin32HandleInfoKHR(capacity).also(block)

//fun MemoryStack.MemoryHeap(): VkMemoryHeap = VkMemoryHeap.callocStack(this)
//fun MemoryStack.MemoryHeap(block: VkMemoryHeap.() -> Unit): VkMemoryHeap = MemoryHeap().also(block)
//fun MemoryStack.MemoryHeap(capacity: Int): VkMemoryHeap.Buffer = VkMemoryHeap.callocStack(capacity, this)
//fun MemoryStack.MemoryHeap(capacity: Int, block: VkMemoryHeap.Buffer.() -> Unit): VkMemoryHeap.Buffer = MemoryHeap(capacity).also(block)

fun MemoryStack.MemoryHostPointerPropertiesEXT(): VkMemoryHostPointerPropertiesEXT = VkMemoryHostPointerPropertiesEXT.callocStack(this).apply { type = VkStructureType.MEMORY_HOST_POINTER_PROPERTIES_EXT }
fun MemoryStack.MemoryHostPointerPropertiesEXT(block: VkMemoryHostPointerPropertiesEXT.() -> Unit): VkMemoryHostPointerPropertiesEXT = MemoryHostPointerPropertiesEXT().also(block)
fun MemoryStack.MemoryHostPointerPropertiesEXT(capacity: Int): VkMemoryHostPointerPropertiesEXT.Buffer = VkMemoryHostPointerPropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_HOST_POINTER_PROPERTIES_EXT }
fun MemoryStack.MemoryHostPointerPropertiesEXT(capacity: Int, block: VkMemoryHostPointerPropertiesEXT.Buffer.() -> Unit): VkMemoryHostPointerPropertiesEXT.Buffer = MemoryHostPointerPropertiesEXT(capacity).also(block)

fun MemoryStack.MemoryPriorityAllocateInfoEXT(): VkMemoryPriorityAllocateInfoEXT = VkMemoryPriorityAllocateInfoEXT.callocStack(this).apply { type = VkStructureType.MEMORY_PRIORITY_ALLOCATE_INFO_EXT }
fun MemoryStack.MemoryPriorityAllocateInfoEXT(block: VkMemoryPriorityAllocateInfoEXT.() -> Unit): VkMemoryPriorityAllocateInfoEXT = MemoryPriorityAllocateInfoEXT().also(block)
fun MemoryStack.MemoryPriorityAllocateInfoEXT(capacity: Int): VkMemoryPriorityAllocateInfoEXT.Buffer = VkMemoryPriorityAllocateInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_PRIORITY_ALLOCATE_INFO_EXT }
fun MemoryStack.MemoryPriorityAllocateInfoEXT(capacity: Int, block: VkMemoryPriorityAllocateInfoEXT.Buffer.() -> Unit): VkMemoryPriorityAllocateInfoEXT.Buffer = MemoryPriorityAllocateInfoEXT(capacity).also(block)

fun MemoryStack.MemoryRequirements(): VkMemoryRequirements = VkMemoryRequirements.callocStack(this)
fun MemoryStack.MemoryRequirements(block: VkMemoryRequirements.() -> Unit): VkMemoryRequirements = MemoryRequirements().also(block)
fun MemoryStack.MemoryRequirements(capacity: Int): VkMemoryRequirements.Buffer = VkMemoryRequirements.callocStack(capacity, this)
fun MemoryStack.MemoryRequirements(capacity: Int, block: VkMemoryRequirements.Buffer.() -> Unit): VkMemoryRequirements.Buffer = MemoryRequirements(capacity).also(block)

fun MemoryStack.MemoryRequirements2(): VkMemoryRequirements2 = VkMemoryRequirements2.callocStack(this).apply { type = VkStructureType.MEMORY_REQUIREMENTS_2 }
fun MemoryStack.MemoryRequirements2(block: VkMemoryRequirements2.() -> Unit): VkMemoryRequirements2 = MemoryRequirements2().also(block)
fun MemoryStack.MemoryRequirements2(capacity: Int): VkMemoryRequirements2.Buffer = VkMemoryRequirements2.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_REQUIREMENTS_2 }
fun MemoryStack.MemoryRequirements2(capacity: Int, block: VkMemoryRequirements2.Buffer.() -> Unit): VkMemoryRequirements2.Buffer = MemoryRequirements2(capacity).also(block)

//fun MemoryStack.MemoryType(): VkMemoryType = VkMemoryType.callocStack(this)
//fun MemoryStack.MemoryType(block: VkMemoryType.() -> Unit): VkMemoryType = MemoryType().also(block)
//fun MemoryStack.MemoryType(capacity: Int): VkMemoryType.Buffer = VkMemoryType.callocStack(capacity, this)
//fun MemoryStack.MemoryType(capacity: Int, block: VkMemoryType.Buffer.() -> Unit): VkMemoryType.Buffer = MemoryType(capacity).also(block)

fun MemoryStack.MemoryWin32HandlePropertiesKHR(): VkMemoryWin32HandlePropertiesKHR = VkMemoryWin32HandlePropertiesKHR.callocStack(this).apply { type = VkStructureType.MEMORY_WIN32_HANDLE_PROPERTIES_KHR }
fun MemoryStack.MemoryWin32HandlePropertiesKHR(block: VkMemoryWin32HandlePropertiesKHR.() -> Unit): VkMemoryWin32HandlePropertiesKHR = MemoryWin32HandlePropertiesKHR().also(block)
fun MemoryStack.MemoryWin32HandlePropertiesKHR(capacity: Int): VkMemoryWin32HandlePropertiesKHR.Buffer = VkMemoryWin32HandlePropertiesKHR.callocStack(capacity, this).onEach { it.type = VkStructureType.MEMORY_WIN32_HANDLE_PROPERTIES_KHR }
fun MemoryStack.MemoryWin32HandlePropertiesKHR(capacity: Int, block: VkMemoryWin32HandlePropertiesKHR.Buffer.() -> Unit): VkMemoryWin32HandlePropertiesKHR.Buffer = MemoryWin32HandlePropertiesKHR(capacity).also(block)

fun MemoryStack.MultisamplePropertiesEXT(): VkMultisamplePropertiesEXT = VkMultisamplePropertiesEXT.callocStack(this).apply { type = VkStructureType.MULTISAMPLE_PROPERTIES_EXT }
fun MemoryStack.MultisamplePropertiesEXT(block: VkMultisamplePropertiesEXT.() -> Unit): VkMultisamplePropertiesEXT = MultisamplePropertiesEXT().also(block)
fun MemoryStack.MultisamplePropertiesEXT(capacity: Int): VkMultisamplePropertiesEXT.Buffer = VkMultisamplePropertiesEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.MULTISAMPLE_PROPERTIES_EXT }
fun MemoryStack.MultisamplePropertiesEXT(capacity: Int, block: VkMultisamplePropertiesEXT.Buffer.() -> Unit): VkMultisamplePropertiesEXT.Buffer = MultisamplePropertiesEXT(capacity).also(block)

fun MemoryStack.ObjectTableCreateInfoNVX(): VkObjectTableCreateInfoNVX = VkObjectTableCreateInfoNVX.callocStack(this).apply { type = VkStructureType.OBJECT_TABLE_CREATE_INFO_NVX }
fun MemoryStack.ObjectTableCreateInfoNVX(block: VkObjectTableCreateInfoNVX.() -> Unit): VkObjectTableCreateInfoNVX = ObjectTableCreateInfoNVX().also(block)
fun MemoryStack.ObjectTableCreateInfoNVX(capacity: Int): VkObjectTableCreateInfoNVX.Buffer = VkObjectTableCreateInfoNVX.callocStack(capacity, this).onEach { it.type = VkStructureType.OBJECT_TABLE_CREATE_INFO_NVX }
fun MemoryStack.ObjectTableCreateInfoNVX(capacity: Int, block: VkObjectTableCreateInfoNVX.Buffer.() -> Unit): VkObjectTableCreateInfoNVX.Buffer = ObjectTableCreateInfoNVX(capacity).also(block)

fun MemoryStack.ObjectTableEntryNVX(): VkObjectTableEntryNVX = VkObjectTableEntryNVX.callocStack(this)
fun MemoryStack.ObjectTableEntryNVX(block: VkObjectTableEntryNVX.() -> Unit): VkObjectTableEntryNVX = ObjectTableEntryNVX().also(block)
fun MemoryStack.ObjectTableEntryNVX(capacity: Int): VkObjectTableEntryNVX.Buffer = VkObjectTableEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTableEntryNVX(capacity: Int, block: VkObjectTableEntryNVX.Buffer.() -> Unit): VkObjectTableEntryNVX.Buffer = ObjectTableEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTableDescriptorSetEntryNVX(): VkObjectTableDescriptorSetEntryNVX = VkObjectTableDescriptorSetEntryNVX.callocStack(this)
fun MemoryStack.ObjectTableDescriptorSetEntryNVX(block: VkObjectTableDescriptorSetEntryNVX.() -> Unit): VkObjectTableDescriptorSetEntryNVX = ObjectTableDescriptorSetEntryNVX().also(block)
fun MemoryStack.ObjectTableDescriptorSetEntryNVX(capacity: Int): VkObjectTableDescriptorSetEntryNVX.Buffer = VkObjectTableDescriptorSetEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTableDescriptorSetEntryNVX(capacity: Int, block: VkObjectTableDescriptorSetEntryNVX.Buffer.() -> Unit): VkObjectTableDescriptorSetEntryNVX.Buffer = ObjectTableDescriptorSetEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTableIndexBufferEntryNVX(): VkObjectTableIndexBufferEntryNVX = VkObjectTableIndexBufferEntryNVX.callocStack(this)
fun MemoryStack.ObjectTableIndexBufferEntryNVX(block: VkObjectTableIndexBufferEntryNVX.() -> Unit): VkObjectTableIndexBufferEntryNVX = ObjectTableIndexBufferEntryNVX().also(block)
fun MemoryStack.ObjectTableIndexBufferEntryNVX(capacity: Int): VkObjectTableIndexBufferEntryNVX.Buffer = VkObjectTableIndexBufferEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTableIndexBufferEntryNVX(capacity: Int, block: VkObjectTableIndexBufferEntryNVX.Buffer.() -> Unit): VkObjectTableIndexBufferEntryNVX.Buffer = ObjectTableIndexBufferEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTablePipelineEntryNVX(): VkObjectTablePipelineEntryNVX = VkObjectTablePipelineEntryNVX.callocStack(this)
fun MemoryStack.ObjectTablePipelineEntryNVX(block: VkObjectTablePipelineEntryNVX.() -> Unit): VkObjectTablePipelineEntryNVX = ObjectTablePipelineEntryNVX().also(block)
fun MemoryStack.ObjectTablePipelineEntryNVX(capacity: Int): VkObjectTablePipelineEntryNVX.Buffer = VkObjectTablePipelineEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTablePipelineEntryNVX(capacity: Int, block: VkObjectTablePipelineEntryNVX.Buffer.() -> Unit): VkObjectTablePipelineEntryNVX.Buffer = ObjectTablePipelineEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTablePushConstantEntryNVX(): VkObjectTablePushConstantEntryNVX = VkObjectTablePushConstantEntryNVX.callocStack(this)
fun MemoryStack.ObjectTablePushConstantEntryNVX(block: VkObjectTablePushConstantEntryNVX.() -> Unit): VkObjectTablePushConstantEntryNVX = ObjectTablePushConstantEntryNVX().also(block)
fun MemoryStack.ObjectTablePushConstantEntryNVX(capacity: Int): VkObjectTablePushConstantEntryNVX.Buffer = VkObjectTablePushConstantEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTablePushConstantEntryNVX(capacity: Int, block: VkObjectTablePushConstantEntryNVX.Buffer.() -> Unit): VkObjectTablePushConstantEntryNVX.Buffer = ObjectTablePushConstantEntryNVX(capacity).also(block)

fun MemoryStack.ObjectTableVertexBufferEntryNVX(): VkObjectTableVertexBufferEntryNVX = VkObjectTableVertexBufferEntryNVX.callocStack(this)
fun MemoryStack.ObjectTableVertexBufferEntryNVX(block: VkObjectTableVertexBufferEntryNVX.() -> Unit): VkObjectTableVertexBufferEntryNVX = ObjectTableVertexBufferEntryNVX().also(block)
fun MemoryStack.ObjectTableVertexBufferEntryNVX(capacity: Int): VkObjectTableVertexBufferEntryNVX.Buffer = VkObjectTableVertexBufferEntryNVX.callocStack(capacity, this)
fun MemoryStack.ObjectTableVertexBufferEntryNVX(capacity: Int, block: VkObjectTableVertexBufferEntryNVX.Buffer.() -> Unit): VkObjectTableVertexBufferEntryNVX.Buffer = ObjectTableVertexBufferEntryNVX(capacity).also(block)
// qui
fun MemoryStack.PipelineColorBlendAttachmentState(): VkPipelineColorBlendAttachmentState = VkPipelineColorBlendAttachmentState.callocStack(this)
fun MemoryStack.PipelineColorBlendAttachmentState(block: VkPipelineColorBlendAttachmentState.() -> Unit): VkPipelineColorBlendAttachmentState = PipelineColorBlendAttachmentState().also(block)
fun MemoryStack.PipelineColorBlendAttachmentState(capacity: Int): VkPipelineColorBlendAttachmentState.Buffer = VkPipelineColorBlendAttachmentState.callocStack(capacity, this)
fun MemoryStack.PipelineColorBlendAttachmentState(capacity: Int, block: VkPipelineColorBlendAttachmentState.Buffer.() -> Unit): VkPipelineColorBlendAttachmentState.Buffer = PipelineColorBlendAttachmentState(capacity).also(block)

fun MemoryStack.PipelineColorBlendStateCreateInfo(): VkPipelineColorBlendStateCreateInfo = VkPipelineColorBlendStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO }
fun MemoryStack.PipelineColorBlendStateCreateInfo(block: VkPipelineColorBlendStateCreateInfo.() -> Unit): VkPipelineColorBlendStateCreateInfo = PipelineColorBlendStateCreateInfo().also(block)
fun MemoryStack.PipelineColorBlendStateCreateInfo(capacity: Int): VkPipelineColorBlendStateCreateInfo.Buffer = VkPipelineColorBlendStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO }
fun MemoryStack.PipelineColorBlendStateCreateInfo(capacity: Int, block: VkPipelineColorBlendStateCreateInfo.Buffer.() -> Unit): VkPipelineColorBlendStateCreateInfo.Buffer = PipelineColorBlendStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineDepthStencilStateCreateInfo(): VkPipelineDepthStencilStateCreateInfo = VkPipelineDepthStencilStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO }
fun MemoryStack.PipelineDepthStencilStateCreateInfo(block: VkPipelineDepthStencilStateCreateInfo.() -> Unit): VkPipelineDepthStencilStateCreateInfo = PipelineDepthStencilStateCreateInfo().also(block)
fun MemoryStack.PipelineDepthStencilStateCreateInfo(capacity: Int): VkPipelineDepthStencilStateCreateInfo.Buffer = VkPipelineDepthStencilStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO }
fun MemoryStack.PipelineDepthStencilStateCreateInfo(capacity: Int, block: VkPipelineDepthStencilStateCreateInfo.Buffer.() -> Unit): VkPipelineDepthStencilStateCreateInfo.Buffer = PipelineDepthStencilStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineDynamicStateCreateInfo(): VkPipelineDynamicStateCreateInfo = VkPipelineDynamicStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO }
fun MemoryStack.PipelineDynamicStateCreateInfo(block: VkPipelineDynamicStateCreateInfo.() -> Unit): VkPipelineDynamicStateCreateInfo = PipelineDynamicStateCreateInfo().also(block)
fun MemoryStack.PipelineDynamicStateCreateInfo(capacity: Int): VkPipelineDynamicStateCreateInfo.Buffer = VkPipelineDynamicStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO }
fun MemoryStack.PipelineDynamicStateCreateInfo(capacity: Int, block: VkPipelineDynamicStateCreateInfo.Buffer.() -> Unit): VkPipelineDynamicStateCreateInfo.Buffer = PipelineDynamicStateCreateInfo(capacity).also(block)

fun MemoryStack.PhysicalDeviceFeatures(): VkPhysicalDeviceFeatures = VkPhysicalDeviceFeatures.callocStack(this)
fun MemoryStack.PhysicalDeviceFeatures(block: VkPhysicalDeviceFeatures.() -> Unit): VkPhysicalDeviceFeatures = PhysicalDeviceFeatures().also(block)
fun MemoryStack.PhysicalDeviceFeatures(capacity: Int): VkPhysicalDeviceFeatures.Buffer = VkPhysicalDeviceFeatures.callocStack(capacity, this)
fun MemoryStack.PhysicalDeviceFeatures(capacity: Int, block: VkPhysicalDeviceFeatures.Buffer.() -> Unit): VkPhysicalDeviceFeatures.Buffer = PhysicalDeviceFeatures(capacity).also(block)

fun MemoryStack.PhysicalDeviceGroupProperties(): VkPhysicalDeviceGroupProperties = VkPhysicalDeviceGroupProperties.callocStack(this).apply { type = VkStructureType.PHYSICAL_DEVICE_GROUP_PROPERTIES }
fun MemoryStack.PhysicalDeviceGroupProperties(block: VkPhysicalDeviceGroupProperties.() -> Unit): VkPhysicalDeviceGroupProperties = PhysicalDeviceGroupProperties().also(block)
fun MemoryStack.PhysicalDeviceGroupProperties(capacity: Int): VkPhysicalDeviceGroupProperties.Buffer = VkPhysicalDeviceGroupProperties.callocStack(capacity, this).onEach { it.type = VkStructureType.PHYSICAL_DEVICE_GROUP_PROPERTIES }
fun MemoryStack.PhysicalDeviceGroupProperties(capacity: Int, block: VkPhysicalDeviceGroupProperties.Buffer.() -> Unit): VkPhysicalDeviceGroupProperties.Buffer = PhysicalDeviceGroupProperties(capacity).also(block)

fun MemoryStack.PipelineInputAssemblyStateCreateInfo(): VkPipelineInputAssemblyStateCreateInfo = VkPipelineInputAssemblyStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO }
fun MemoryStack.PipelineInputAssemblyStateCreateInfo(block: VkPipelineInputAssemblyStateCreateInfo.() -> Unit): VkPipelineInputAssemblyStateCreateInfo = PipelineInputAssemblyStateCreateInfo().also(block)
fun MemoryStack.PipelineInputAssemblyStateCreateInfo(capacity: Int): VkPipelineInputAssemblyStateCreateInfo.Buffer = VkPipelineInputAssemblyStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO }
fun MemoryStack.PipelineInputAssemblyStateCreateInfo(capacity: Int, block: VkPipelineInputAssemblyStateCreateInfo.Buffer.() -> Unit): VkPipelineInputAssemblyStateCreateInfo.Buffer = PipelineInputAssemblyStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineMultisampleStateCreateInfo(): VkPipelineMultisampleStateCreateInfo = VkPipelineMultisampleStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO }
fun MemoryStack.PipelineMultisampleStateCreateInfo(block: VkPipelineMultisampleStateCreateInfo.() -> Unit): VkPipelineMultisampleStateCreateInfo = PipelineMultisampleStateCreateInfo().also(block)
fun MemoryStack.PipelineMultisampleStateCreateInfo(capacity: Int): VkPipelineMultisampleStateCreateInfo.Buffer = VkPipelineMultisampleStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO }
fun MemoryStack.PipelineMultisampleStateCreateInfo(capacity: Int, block: VkPipelineMultisampleStateCreateInfo.Buffer.() -> Unit): VkPipelineMultisampleStateCreateInfo.Buffer = PipelineMultisampleStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineRasterizationStateCreateInfo(): VkPipelineRasterizationStateCreateInfo = VkPipelineRasterizationStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO }
fun MemoryStack.PipelineRasterizationStateCreateInfo(block: VkPipelineRasterizationStateCreateInfo.() -> Unit): VkPipelineRasterizationStateCreateInfo = PipelineRasterizationStateCreateInfo().also(block)
fun MemoryStack.PipelineRasterizationStateCreateInfo(capacity: Int): VkPipelineRasterizationStateCreateInfo.Buffer = VkPipelineRasterizationStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO }
fun MemoryStack.PipelineRasterizationStateCreateInfo(capacity: Int, block: VkPipelineRasterizationStateCreateInfo.Buffer.() -> Unit): VkPipelineRasterizationStateCreateInfo.Buffer = PipelineRasterizationStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineShaderStageCreateInfo(): VkPipelineShaderStageCreateInfo = VkPipelineShaderStageCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO }
fun MemoryStack.PipelineShaderStageCreateInfo(block: VkPipelineShaderStageCreateInfo.() -> Unit): VkPipelineShaderStageCreateInfo = PipelineShaderStageCreateInfo().also(block)
fun MemoryStack.PipelineShaderStageCreateInfo(capacity: Int): VkPipelineShaderStageCreateInfo.Buffer = VkPipelineShaderStageCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO }
fun MemoryStack.PipelineShaderStageCreateInfo(capacity: Int, block: VkPipelineShaderStageCreateInfo.Buffer.() -> Unit): VkPipelineShaderStageCreateInfo.Buffer = PipelineShaderStageCreateInfo(capacity).also(block)

fun MemoryStack.PipelineTessellationStateCreateInfo(): VkPipelineTessellationStateCreateInfo = VkPipelineTessellationStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_TESSELLATION_STATE_CREATE_INFO }
fun MemoryStack.PipelineTessellationStateCreateInfo(block: VkPipelineTessellationStateCreateInfo.() -> Unit): VkPipelineTessellationStateCreateInfo = PipelineTessellationStateCreateInfo().also(block)
fun MemoryStack.PipelineTessellationStateCreateInfo(capacity: Int): VkPipelineTessellationStateCreateInfo.Buffer = VkPipelineTessellationStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_TESSELLATION_STATE_CREATE_INFO }
fun MemoryStack.PipelineTessellationStateCreateInfo(capacity: Int, block: VkPipelineTessellationStateCreateInfo.Buffer.() -> Unit): VkPipelineTessellationStateCreateInfo.Buffer = PipelineTessellationStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineVertexInputStateCreateInfo(): VkPipelineVertexInputStateCreateInfo = VkPipelineVertexInputStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO }
fun MemoryStack.PipelineVertexInputStateCreateInfo(block: VkPipelineVertexInputStateCreateInfo.() -> Unit): VkPipelineVertexInputStateCreateInfo = PipelineVertexInputStateCreateInfo().also(block)
fun MemoryStack.PipelineVertexInputStateCreateInfo(capacity: Int): VkPipelineVertexInputStateCreateInfo.Buffer = VkPipelineVertexInputStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO }
fun MemoryStack.PipelineVertexInputStateCreateInfo(capacity: Int, block: VkPipelineVertexInputStateCreateInfo.Buffer.() -> Unit): VkPipelineVertexInputStateCreateInfo.Buffer = PipelineVertexInputStateCreateInfo(capacity).also(block)

fun MemoryStack.PipelineViewportStateCreateInfo(): VkPipelineViewportStateCreateInfo = VkPipelineViewportStateCreateInfo.callocStack(this).apply { type = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO }
fun MemoryStack.PipelineViewportStateCreateInfo(block: VkPipelineViewportStateCreateInfo.() -> Unit): VkPipelineViewportStateCreateInfo = PipelineViewportStateCreateInfo().also(block)
fun MemoryStack.PipelineViewportStateCreateInfo(capacity: Int): VkPipelineViewportStateCreateInfo.Buffer = VkPipelineViewportStateCreateInfo.callocStack(capacity, this).onEach { it.type = VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO }
fun MemoryStack.PipelineViewportStateCreateInfo(capacity: Int, block: VkPipelineViewportStateCreateInfo.Buffer.() -> Unit): VkPipelineViewportStateCreateInfo.Buffer = PipelineViewportStateCreateInfo(capacity).also(block)

fun MemoryStack.QueueFamilyProperties(): VkQueueFamilyProperties = VkQueueFamilyProperties.callocStack(this)
fun MemoryStack.QueueFamilyProperties(block: VkQueueFamilyProperties.() -> Unit): VkQueueFamilyProperties = QueueFamilyProperties().also(block)
fun MemoryStack.QueueFamilyProperties(capacity: Int): VkQueueFamilyProperties.Buffer = VkQueueFamilyProperties.callocStack(capacity, this)
fun MemoryStack.QueueFamilyProperties(capacity: Int, block: VkQueueFamilyProperties.Buffer.() -> Unit): VkQueueFamilyProperties.Buffer = QueueFamilyProperties(capacity).also(block)

fun MemoryStack.QueueFamilyProperties2(): VkQueueFamilyProperties2 = VkQueueFamilyProperties2.callocStack(this).apply { type = VkStructureType.QUEUE_FAMILY_PROPERTIES_2 }
fun MemoryStack.QueueFamilyProperties2(block: VkQueueFamilyProperties2.() -> Unit): VkQueueFamilyProperties2 = QueueFamilyProperties2().also(block)
fun MemoryStack.QueueFamilyProperties2(capacity: Int): VkQueueFamilyProperties2.Buffer = VkQueueFamilyProperties2.callocStack(capacity, this).onEach { it.type = VkStructureType.QUEUE_FAMILY_PROPERTIES_2 }
fun MemoryStack.QueueFamilyProperties2(capacity: Int, block: VkQueueFamilyProperties2.Buffer.() -> Unit): VkQueueFamilyProperties2.Buffer = QueueFamilyProperties2(capacity).also(block)

fun MemoryStack.Rect2D(): VkRect2D = VkRect2D.callocStack(this)
fun MemoryStack.Rect2D(block: VkRect2D.() -> Unit): VkRect2D = Rect2D().also(block)
fun MemoryStack.Rect2D(capacity: Int): VkRect2D.Buffer = VkRect2D.callocStack(capacity, this)
fun MemoryStack.Rect2D(capacity: Int, block: VkRect2D.Buffer.() -> Unit): VkRect2D.Buffer = Rect2D(capacity).also(block)

fun MemoryStack.SampleLocationEXT(): VkSampleLocationEXT = VkSampleLocationEXT.callocStack(this)
fun MemoryStack.SampleLocationEXT(block: VkSampleLocationEXT.() -> Unit): VkSampleLocationEXT = SampleLocationEXT().also(block)
fun MemoryStack.SampleLocationEXT(capacity: Int): VkSampleLocationEXT.Buffer = VkSampleLocationEXT.callocStack(capacity, this)
fun MemoryStack.SampleLocationEXT(capacity: Int, block: VkSampleLocationEXT.Buffer.() -> Unit): VkSampleLocationEXT.Buffer = SampleLocationEXT(capacity).also(block)

fun MemoryStack.SampleLocationsInfoEXT(): VkSampleLocationsInfoEXT = VkSampleLocationsInfoEXT.callocStack(this).apply { type = VkStructureType.SAMPLE_LOCATIONS_INFO_EXT }
fun MemoryStack.SampleLocationsInfoEXT(block: VkSampleLocationsInfoEXT.() -> Unit): VkSampleLocationsInfoEXT = SampleLocationsInfoEXT().also(block)
fun MemoryStack.SampleLocationsInfoEXT(capacity: Int): VkSampleLocationsInfoEXT.Buffer = VkSampleLocationsInfoEXT.callocStack(capacity, this).onEach { it.type = VkStructureType.SAMPLE_LOCATIONS_INFO_EXT }
fun MemoryStack.SampleLocationsInfoEXT(capacity: Int, block: VkSampleLocationsInfoEXT.Buffer.() -> Unit): VkSampleLocationsInfoEXT.Buffer = SampleLocationsInfoEXT(capacity).also(block)

fun MemoryStack.SparseBufferMemoryBindInfo(): VkSparseBufferMemoryBindInfo = VkSparseBufferMemoryBindInfo.callocStack(this)
fun MemoryStack.SparseBufferMemoryBindInfo(block: VkSparseBufferMemoryBindInfo.() -> Unit): VkSparseBufferMemoryBindInfo = SparseBufferMemoryBindInfo().also(block)
fun MemoryStack.SparseBufferMemoryBindInfo(capacity: Int): VkSparseBufferMemoryBindInfo.Buffer = VkSparseBufferMemoryBindInfo.callocStack(capacity, this)
fun MemoryStack.SparseBufferMemoryBindInfo(capacity: Int, block: VkSparseBufferMemoryBindInfo.Buffer.() -> Unit): VkSparseBufferMemoryBindInfo.Buffer = SparseBufferMemoryBindInfo(capacity).also(block)

fun MemoryStack.SparseImageFormatProperties(): VkSparseImageFormatProperties = VkSparseImageFormatProperties.callocStack(this)
fun MemoryStack.SparseImageFormatProperties(block: VkSparseImageFormatProperties.() -> Unit): VkSparseImageFormatProperties = SparseImageFormatProperties().also(block)
fun MemoryStack.SparseImageFormatProperties(capacity: Int): VkSparseImageFormatProperties.Buffer = VkSparseImageFormatProperties.callocStack(capacity, this)
fun MemoryStack.SparseImageFormatProperties(capacity: Int, block: VkSparseImageFormatProperties.Buffer.() -> Unit): VkSparseImageFormatProperties.Buffer = SparseImageFormatProperties(capacity).also(block)

fun MemoryStack.SparseImageFormatProperties2(): VkSparseImageFormatProperties2 = VkSparseImageFormatProperties2.callocStack(this).apply { type = VkStructureType.SPARSE_IMAGE_FORMAT_PROPERTIES_2 }
fun MemoryStack.SparseImageFormatProperties2(block: VkSparseImageFormatProperties2.() -> Unit): VkSparseImageFormatProperties2 = SparseImageFormatProperties2().also(block)
fun MemoryStack.SparseImageFormatProperties2(capacity: Int): VkSparseImageFormatProperties2.Buffer = VkSparseImageFormatProperties2.callocStack(capacity, this).onEach { it.type = VkStructureType.SPARSE_IMAGE_FORMAT_PROPERTIES_2 }
fun MemoryStack.SparseImageFormatProperties2(capacity: Int, block: VkSparseImageFormatProperties2.Buffer.() -> Unit): VkSparseImageFormatProperties2.Buffer = SparseImageFormatProperties2(capacity).also(block)

fun MemoryStack.SparseImageMemoryBind(): VkSparseImageMemoryBind = VkSparseImageMemoryBind.callocStack(this)
fun MemoryStack.SparseImageMemoryBind(block: VkSparseImageMemoryBind.() -> Unit): VkSparseImageMemoryBind = SparseImageMemoryBind().also(block)
fun MemoryStack.SparseImageMemoryBind(capacity: Int): VkSparseImageMemoryBind.Buffer = VkSparseImageMemoryBind.callocStack(capacity, this)
fun MemoryStack.SparseImageMemoryBind(capacity: Int, block: VkSparseImageMemoryBind.Buffer.() -> Unit): VkSparseImageMemoryBind.Buffer = SparseImageMemoryBind(capacity).also(block)

fun MemoryStack.SparseImageMemoryBindInfo(): VkSparseImageMemoryBindInfo = VkSparseImageMemoryBindInfo.callocStack(this)
fun MemoryStack.SparseImageMemoryBindInfo(block: VkSparseImageMemoryBindInfo.() -> Unit): VkSparseImageMemoryBindInfo = SparseImageMemoryBindInfo().also(block)
fun MemoryStack.SparseImageMemoryBindInfo(capacity: Int): VkSparseImageMemoryBindInfo.Buffer = VkSparseImageMemoryBindInfo.callocStack(capacity, this)
fun MemoryStack.SparseImageMemoryBindInfo(capacity: Int, block: VkSparseImageMemoryBindInfo.Buffer.() -> Unit): VkSparseImageMemoryBindInfo.Buffer = SparseImageMemoryBindInfo(capacity).also(block)

fun MemoryStack.SparseImageOpaqueMemoryBindInfo(): VkSparseImageOpaqueMemoryBindInfo = VkSparseImageOpaqueMemoryBindInfo.callocStack(this)
fun MemoryStack.SparseImageOpaqueMemoryBindInfo(block: VkSparseImageOpaqueMemoryBindInfo.() -> Unit): VkSparseImageOpaqueMemoryBindInfo = SparseImageOpaqueMemoryBindInfo().also(block)
fun MemoryStack.SparseImageOpaqueMemoryBindInfo(capacity: Int): VkSparseImageOpaqueMemoryBindInfo.Buffer = VkSparseImageOpaqueMemoryBindInfo.callocStack(capacity, this)
fun MemoryStack.SparseImageOpaqueMemoryBindInfo(capacity: Int, block: VkSparseImageOpaqueMemoryBindInfo.Buffer.() -> Unit): VkSparseImageOpaqueMemoryBindInfo.Buffer = SparseImageOpaqueMemoryBindInfo(capacity).also(block)

fun MemoryStack.SparseMemoryBind(): VkSparseMemoryBind = VkSparseMemoryBind.callocStack(this)
fun MemoryStack.SparseMemoryBind(block: VkSparseMemoryBind.() -> Unit): VkSparseMemoryBind = SparseMemoryBind().also(block)
fun MemoryStack.SparseMemoryBind(capacity: Int): VkSparseMemoryBind.Buffer = VkSparseMemoryBind.callocStack(capacity, this)
fun MemoryStack.SparseMemoryBind(capacity: Int, block: VkSparseMemoryBind.Buffer.() -> Unit): VkSparseMemoryBind.Buffer = SparseMemoryBind(capacity).also(block)

fun MemoryStack.SpecializationInfo(): VkSpecializationInfo = VkSpecializationInfo.callocStack(this)
fun MemoryStack.SpecializationInfo(block: VkSpecializationInfo.() -> Unit): VkSpecializationInfo = SpecializationInfo().also(block)
fun MemoryStack.SpecializationInfo(capacity: Int): VkSpecializationInfo.Buffer = VkSpecializationInfo.callocStack(capacity, this)
fun MemoryStack.SpecializationInfo(capacity: Int, block: VkSpecializationInfo.Buffer.() -> Unit): VkSpecializationInfo.Buffer = SpecializationInfo(capacity).also(block)

fun MemoryStack.SpecializationMapEntry(): VkSpecializationMapEntry = VkSpecializationMapEntry.callocStack(this)
fun MemoryStack.SpecializationMapEntry(block: VkSpecializationMapEntry.() -> Unit): VkSpecializationMapEntry = SpecializationMapEntry().also(block)
fun MemoryStack.SpecializationMapEntry(capacity: Int): VkSpecializationMapEntry.Buffer = VkSpecializationMapEntry.callocStack(capacity, this)
fun MemoryStack.SpecializationMapEntry(capacity: Int, block: VkSpecializationMapEntry.Buffer.() -> Unit): VkSpecializationMapEntry.Buffer = SpecializationMapEntry(capacity).also(block)

fun MemoryStack.StencilOpState(): VkStencilOpState = VkStencilOpState.callocStack(this)
fun MemoryStack.StencilOpState(block: VkStencilOpState.() -> Unit): VkStencilOpState = StencilOpState().also(block)
fun MemoryStack.StencilOpState(capacity: Int): VkStencilOpState.Buffer = VkStencilOpState.callocStack(capacity, this)
fun MemoryStack.StencilOpState(capacity: Int, block: VkStencilOpState.Buffer.() -> Unit): VkStencilOpState.Buffer = StencilOpState(capacity).also(block)

fun MemoryStack.SubresourceLayout(): VkSubresourceLayout = VkSubresourceLayout.callocStack(this)
fun MemoryStack.SubresourceLayout(block: VkSubresourceLayout.() -> Unit): VkSubresourceLayout = SubresourceLayout().also(block)
fun MemoryStack.SubresourceLayout(capacity: Int): VkSubresourceLayout.Buffer = VkSubresourceLayout.callocStack(capacity, this)
fun MemoryStack.SubresourceLayout(capacity: Int, block: VkSubresourceLayout.Buffer.() -> Unit): VkSubresourceLayout.Buffer = SubresourceLayout(capacity).also(block)

fun MemoryStack.SurfaceFormat2KHR(): VkSurfaceFormat2KHR = VkSurfaceFormat2KHR.callocStack(this).apply { type = VkStructureType.SURFACE_FORMAT_2_KHR }
fun MemoryStack.SurfaceFormat2KHR(block: VkSurfaceFormat2KHR.() -> Unit): VkSurfaceFormat2KHR = SurfaceFormat2KHR().also(block)
fun MemoryStack.SurfaceFormat2KHR(capacity: Int): VkSurfaceFormat2KHR.Buffer = VkSurfaceFormat2KHR.callocStack(capacity, this).onEach { it.type = VkStructureType.SURFACE_FORMAT_2_KHR }
fun MemoryStack.SurfaceFormat2KHR(capacity: Int, block: VkSurfaceFormat2KHR.Buffer.() -> Unit): VkSurfaceFormat2KHR.Buffer = SurfaceFormat2KHR(capacity).also(block)

fun MemoryStack.SurfaceFormatKHR(): VkSurfaceFormatKHR = VkSurfaceFormatKHR.callocStack(this)
fun MemoryStack.SurfaceFormatKHR(block: VkSurfaceFormatKHR.() -> Unit): VkSurfaceFormatKHR = SurfaceFormatKHR().also(block)
fun MemoryStack.SurfaceFormatKHR(capacity: Int): VkSurfaceFormatKHR.Buffer = VkSurfaceFormatKHR.callocStack(capacity, this)
fun MemoryStack.SurfaceFormatKHR(capacity: Int, block: VkSurfaceFormatKHR.Buffer.() -> Unit): VkSurfaceFormatKHR.Buffer = SurfaceFormatKHR(capacity).also(block)

fun MemoryStack.VertexInputAttributeDescription(): VkVertexInputAttributeDescription = VkVertexInputAttributeDescription.callocStack(this)
fun MemoryStack.VertexInputAttributeDescription(block: VkVertexInputAttributeDescription.() -> Unit): VkVertexInputAttributeDescription = VertexInputAttributeDescription().also(block)
fun MemoryStack.VertexInputAttributeDescription(capacity: Int): VkVertexInputAttributeDescription.Buffer = VkVertexInputAttributeDescription.callocStack(capacity, this)
fun MemoryStack.VertexInputAttributeDescription(capacity: Int, block: VkVertexInputAttributeDescription.Buffer.() -> Unit): VkVertexInputAttributeDescription.Buffer = VertexInputAttributeDescription(capacity).also(block)

fun MemoryStack.VertexInputBindingDescription(): VkVertexInputBindingDescription = VkVertexInputBindingDescription.callocStack(this)
fun MemoryStack.VertexInputBindingDescription(block: VkVertexInputBindingDescription.() -> Unit): VkVertexInputBindingDescription = VertexInputBindingDescription().also(block)
fun MemoryStack.VertexInputBindingDescription(capacity: Int): VkVertexInputBindingDescription.Buffer = VkVertexInputBindingDescription.callocStack(capacity, this)
fun MemoryStack.VertexInputBindingDescription(capacity: Int, block: VkVertexInputBindingDescription.Buffer.() -> Unit): VkVertexInputBindingDescription.Buffer = VertexInputBindingDescription(capacity).also(block)

fun MemoryStack.Viewport(): VkViewport = VkViewport.callocStack(this)
fun MemoryStack.Viewport(block: VkViewport.() -> Unit): VkViewport = Viewport().also(block)
fun MemoryStack.Viewport(capacity: Int): VkViewport.Buffer = VkViewport.callocStack(capacity, this)
fun MemoryStack.Viewport(capacity: Int, block: VkViewport.Buffer.() -> Unit): VkViewport.Buffer = Viewport(capacity).also(block)

fun MemoryStack.XYColorEXT(): VkXYColorEXT = VkXYColorEXT.callocStack(this)
fun MemoryStack.XYColorEXT(block: VkXYColorEXT.() -> Unit): VkXYColorEXT = XYColorEXT().also(block)
fun MemoryStack.XYColorEXT(capacity: Int): VkXYColorEXT.Buffer = VkXYColorEXT.callocStack(capacity, this)
fun MemoryStack.XYColorEXT(capacity: Int, block: VkXYColorEXT.Buffer.() -> Unit): VkXYColorEXT.Buffer = XYColorEXT(capacity).also(block)

