package com.hori_ryota.gradle_node_packagejson_generator

import java.io.File
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.gradle.api.Plugin
import org.gradle.api.Project

open class PackageJsonGeneratorPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create("packageJson", PackageJsonGeneratorPluginExtension::class.java)
        project.task("generatePackageJson") { task ->
            task.description = "Generate package.json"
            task.doLast {
                val json = Json(JsonConfiguration(
                        encodeDefaults = false,
                        strictMode = true,
                        prettyPrint = true,
                        indent = "  "
                )).stringify(PackageJsonGeneratorPluginExtension.serializer(), extension)
                val dir = File(extension.dstDir)
                dir.mkdirs()
                File(dir, "package.json").writeText(json)
            }
        }
    }
}

