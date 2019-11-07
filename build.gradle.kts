version = "1.0.0"

plugins {
    kotlin("jvm") version "1.3.50"
    id("kotlinx-serialization") version "1.3.50"
    id("com.gradle.plugin-publish") version "0.10.1"
    `java-gradle-plugin`
}

repositories {
    jcenter()
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.13.0")
}

gradlePlugin {
    plugins {
        create("gradle-node-packagejson-generator") {
            id = "com.hori-ryota.gradle-node-packagejson-generator"
            implementationClass = "com.hori_ryota.gradle_node_packagejson_generator.PackageJsonGeneratorPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/hori-ryota/gradle-node-packagejson-generator"
    vcsUrl = "https://github.com/hori-ryota/gradle-node-packagejson-generator"
    description = "Generator for package.json"
    (plugins) {
        "gradle-node-packagejson-generator" {
            displayName = "Gradle Generating package.json plugin"
            tags = listOf("package.json", "Node.js", "nodejs", "npm")
            version = project.version.toString()
        }
    }
}
