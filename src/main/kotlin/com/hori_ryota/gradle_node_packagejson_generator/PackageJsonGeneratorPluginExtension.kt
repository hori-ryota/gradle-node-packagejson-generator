package com.hori_ryota.gradle_node_packagejson_generator

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
open class PackageJsonGeneratorPluginExtension {
    var name: String = ""
    var version: String = ""
    var description: String? = null
    var keywords: List<String>? = null
    var homepage: String? = null

    @Serializable
    class Bugs {
        var url: String? = null
        var email: String? = null
    }

    var bugs: Bugs? = null

    var license: String? = null
    var author: Person? = null
    var contributors: List<Person>? = null

    @Serializable
    class Person {
        var name: String? = null
        var email: String? = null
        var url: String? = null
    }

    var files: List<String>? = null
    var main: String? = null
    var browser: String? = null
    var bin: Map<String, String>? = null
    var man: List<String>? = null

    var directories: Directories? = null

    @Serializable
    class Directories {
        var lib: String? = null
        var bin: String? = null
        var man: String? = null
        var doc: String? = null
        var example: String? = null
        var test: String? = null
    }

    var repository: Repository? = null

    @Serializable
    class Repository {
        var type: String? = null
        var url: String? = null
        var directory: String? = null
    }

    var scripts: Map<String, String>? = null
    var config: Map<String, String>? = null
    var dependencies: Map<String, String>? = null
    var devDependencies: Map<String, String>? = null
    var peerDependencies: Map<String, String>? = null
    var bundledDependencies: Map<String, String>? = null
    var optionalDependencies: Map<String, String>? = null
    var engines: Map<String, String>? = null
    var os: List<String>? = null
    var cpu: List<String>? = null
    var private: Boolean? = null
    var publishConfig: Map<String, String>? = null

    @Transient
    var dstDir: String = "."
}
