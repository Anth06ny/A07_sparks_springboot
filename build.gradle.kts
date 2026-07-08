import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "4.1.0"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm")
    kotlin("plugin.spring") version "2.3.21"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"
description = "A07_sparks_springboot"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

//Si on souhaite modifier les paramètre de notre executable
tasks.named<BootJar>("bootJar") {
    archiveFileName.set("monChatServer.jar")
    destinationDirectory.set(file("$rootDir")) //pour le mettre à la racine
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf" )
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
    testImplementation("org.springframework.security:spring-security-test")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-thymeleaf-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    runtimeOnly("com.h2database:h2")
    testCompileOnly("org.projectlombok:lombok")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testAnnotationProcessor("org.projectlombok:lombok")
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.+")



}

tasks.withType<Test> {
    useJUnitPlatform()
}
