plugins {
    kotlin("jvm") version "2.1.0"
    `maven-publish`
}

group = "com.sizealike"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(11)
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.sizealike"
            artifactId = "size-alike"
            version = project.version.toString()
        }
    }
}