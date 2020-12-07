plugins {
    java
}

group = "de.sirywell"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.kyori:adventure-api:4.3.0")

    testImplementation("junit", "junit", "4.12")
}
