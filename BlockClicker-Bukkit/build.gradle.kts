plugins {
    java
}

group = "de.sirywell"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public")
    }
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    }
}

dependencies {
    implementation(project(":BlockClicker-Core"))
    implementation("org.spigotmc:spigot-api:1.16.4-R0.1-SNAPSHOT")
    implementation("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT")
    implementation("net.kyori:adventure-api:4.3.0")
    testImplementation("junit", "junit", "4.12")
}
