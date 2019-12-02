package vkk._11.structs

import vkk.VkDescriptorUpdateTemplateType
import vkk.VkPipelineBindPoint
import vkk.VkStructureType
import vkk.entities.VkDescriptorSetLayout
import vkk.entities.VkPipelineLayout

/**
 * Structure specifying parameters of a newly created descriptor update template.
 *
 * <h5>Valid Usage</h5>
 *
 * <ul>
 * <li>If {@code templateType} is {@link VK11#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET}, {@code descriptorSetLayout} <b>must</b> be a valid {@code VkDescriptorSetLayout} handle</li>
 * <li>If {@code templateType} is {@link KHRPushDescriptor#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR}, {@code pipelineBindPoint} <b>must</b> be a valid {@code VkPipelineBindPoint} value</li>
 * <li>If {@code templateType} is {@link KHRPushDescriptor#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR}, {@code pipelineLayout} <b>must</b> be a valid {@code VkPipelineLayout} handle</li>
 * <li>If {@code templateType} is {@link KHRPushDescriptor#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR}, {@code set} <b>must</b> be the unique set number in the pipeline layout that uses a descriptor set layout that was created with {@link KHRPushDescriptor#VK_DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR}</li>
 * </ul>
 *
 * <h5>Valid Usage (Implicit)</h5>
 *
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK11#VK_STRUCTURE_TYPE_DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO STRUCTURE_TYPE_DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO}</li>
 * <li>{@code pNext} <b>must</b> be {@code NULL}</li>
 * <li>{@code flags} <b>must</b> be 0</li>
 * <li>{@code pDescriptorUpdateEntries} <b>must</b> be a valid pointer to an array of {@code descriptorUpdateEntryCount} valid {@link VkDescriptorUpdateTemplateEntry} structures</li>
 * <li>{@code templateType} <b>must</b> be a valid {@code VkDescriptorUpdateTemplateType} value</li>
 * <li>If {@code descriptorSetLayout} is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, {@code descriptorSetLayout} <b>must</b> be a valid {@code VkDescriptorSetLayout} handle</li>
 * <li>{@code descriptorUpdateEntryCount} <b>must</b> be greater than 0</li>
 * <li>Both of {@code descriptorSetLayout}, and {@code pipelineLayout} that are valid handles <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
 * </ul>
 *
 * <h5>See Also</h5>
 *
 * <p>{@link VkDescriptorUpdateTemplateEntry}, {@link VK11#vkCreateDescriptorUpdateTemplate CreateDescriptorUpdateTemplate}, {@link KHRDescriptorUpdateTemplate#vkCreateDescriptorUpdateTemplateKHR CreateDescriptorUpdateTemplateKHR}</p>
 *
 * <h3>Member documentation</h3>
 *
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code flags} &ndash; reserved for future use.</li>
 * <li>{@code descriptorUpdateEntryCount} &ndash; the number of elements in the {@code pDescriptorUpdateEntries} array.</li>
 * <li>{@code pDescriptorUpdateEntries} &ndash; a pointer to an array of {@link VkDescriptorUpdateTemplateEntry} structures describing the descriptors to be updated by the descriptor update template.</li>
 * <li>{@code templateType} &ndash; Specifies the type of the descriptor update template. If set to {@link VK11#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET} it <b>can</b> only be used to update descriptor sets with a fixed {@code descriptorSetLayout}. If set to {@link KHRPushDescriptor#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR} it <b>can</b> only be used to push descriptor sets using the provided {@code pipelineBindPoint}, {@code pipelineLayout}, and {@code set} number.</li>
 * <li>{@code descriptorSetLayout} &ndash; the descriptor set layout the parameter update template will be used with. All descriptor sets which are going to be updated through the newly created descriptor update template <b>must</b> be created with this layout. {@code descriptorSetLayout} is the descriptor set layout used to build the descriptor update template. All descriptor sets which are going to be updated through the newly created descriptor update template <b>must</b> be created with a layout that matches (is the same as, or defined identically to) this layout. This parameter is ignored if {@code templateType} is not {@link VK11#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET}.</li>
 * <li>{@code pipelineBindPoint} &ndash; a {@code VkPipelineBindPoint} indicating whether the descriptors will be used by graphics pipelines or compute pipelines. This parameter is ignored if {@code templateType} is not {@link KHRPushDescriptor#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR}</li>
 * <li>{@code pipelineLayout} &ndash; a {@code VkPipelineLayout} object used to program the bindings. This parameter is ignored if {@code templateType} is not {@link KHRPushDescriptor#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR}</li>
 * <li>{@code set} &ndash; the set number of the descriptor set in the pipeline layout that will be updated. This parameter is ignored if {@code templateType} is not {@link KHRPushDescriptor#VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR}</li>
 * </ul>
 *
 * <h3>Layout</h3>
 *
 * <pre><code>
 * struct VkDescriptorUpdateTemplateCreateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDescriptorUpdateTemplateCreateFlags flags;
 *     uint32_t descriptorUpdateEntryCount;
 *     {@link VkDescriptorUpdateTemplateEntry VkDescriptorUpdateTemplateEntry} const * pDescriptorUpdateEntries;
 *     VkDescriptorUpdateTemplateType templateType;
 *     VkDescriptorSetLayout descriptorSetLayout;
 *     VkPipelineBindPoint pipelineBindPoint;
 *     VkPipelineLayout pipelineLayout;
 *     uint32_t set;
 * }</code></pre>
 */
class DescriptorUpdateTemplateCreateInfo(
        var descriptorUpdateEntries: Array<DescriptorUpdateTemplateEntry>,
        var templateType: VkDescriptorUpdateTemplateType,
        var descriptorSetLayout: VkDescriptorSetLayout,
        var pipelineBindPoint: VkPipelineBindPoint,
        var pipelineLayout: VkPipelineLayout,
        var set: Int
) {

    val type get() = VkStructureType.DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO
}