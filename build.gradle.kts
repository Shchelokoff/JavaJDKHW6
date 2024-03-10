plugins {
    application
    kotlin("kapt") // Добавленный плагин Kotlin Kapt
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("io.projectlombok:lombok:1.18.20") // Исправленная зависимость Lombok
    kapt("io.projectlombok:lombok:1.18.20") // Исправленная зависимость Lombok для Kapt
    implementation("org.apache.commons:commons-math3:3.6.1")
}

application {
    mainClass.set("org.example.Main") // Замените на полное имя вашего основного класса
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
