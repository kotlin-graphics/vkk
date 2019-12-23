package vkk._11.api

import glm_.vec3.Vec3i
import vkk.identifiers.CapabilitiesDevice
import kool.adr
import org.lwjgl.system.JNI.callPV
import org.lwjgl.system.Pointer

interface CommandBuffer_vk11 : Pointer {

    val capabilities: CapabilitiesDevice

    // --- [ vkCmdSetDeviceMask ] ---
    infix fun setDeviceMask(deviceMask: Int) =
            callPV(adr, deviceMask, capabilities.vkCmdSetDeviceMask)

    // --- [ vkCmdDispatchBase ] ---

    fun dispatchBase(baseGroupX: Int, baseGroupY: Int, baseGroupZ: Int, groupCountX: Int, groupCountY: Int, groupCountZ: Int) =
            nDispatchBase(baseGroupX, baseGroupY, baseGroupZ, groupCountX, groupCountY, groupCountZ)

    fun dispatchBase(baseGroup: Vec3i, groupCount: Vec3i) =
            nDispatchBase(baseGroup.x, baseGroup.y, baseGroup.z, groupCount.x, groupCount.y, groupCount.z)
}

inline fun CommandBuffer_vk11.nDispatchBase(baseGroupX: Int, baseGroupY: Int, baseGroupZ: Int, groupCountX: Int, groupCountY: Int, groupCountZ: Int) =
        callPV(adr, baseGroupX, baseGroupY, baseGroupZ, groupCountX, groupCountY, groupCountZ, capabilities.vkCmdDispatchBase)