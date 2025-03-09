package org.teamvoided.scriptor_shush

import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("unused")
object ScriptorShush {
    const val MODID = "scriptor_shush"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(ScriptorShush::class.simpleName)

    fun init() = log.info("Silencing spell casters since 1998")

    fun id(path: String) = ResourceLocation.fromNamespaceAndPath(MODID, path)
}
