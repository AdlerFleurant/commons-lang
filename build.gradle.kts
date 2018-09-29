group = "org.apache.commons"
version = "3.9-SNAPSHOT"

plugins {
    `java-library`
}

val jmhVersion = "1.21"
val junitVersion = "5.3.1"

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

tasks.withType<JavaCompile>{
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks{
    "test"(Test::class){
        useJUnitPlatform()
    }
}

repositories {
    jcenter()
}

dependencies {
    testCompile("org.junit.jupiter", "junit-jupiter-api", junitVersion)
    testCompile("org.junit.jupiter", "junit-jupiter-params", junitVersion)
    testCompile("junit:junit:4.12")
    testRuntime("org.junit.jupiter", "junit-jupiter-engine", junitVersion)
    testRuntime("org.junit.vintage", "junit-vintage-engine", junitVersion)
    testCompile("org.hamcrest", "hamcrest-all", "1.3")
    testCompile("org.easymock", "easymock", "3.6")
    testCompile("org.openjdk.jmh", "jmh-core", jmhVersion)
    testCompile("org.openjdk.jmh", "jmh-generator-annprocess", jmhVersion)
}

tasks.register("wrapper", Wrapper::class){
    gradleVersion = "4.10.2"
    distributionType = Wrapper.DistributionType.ALL
}