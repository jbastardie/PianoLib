plugins {
    alias(libs.plugins.androidApplication)
    `maven-publish`
}

android {
    namespace = "com.jbastardie.pianolib"
    compileSdk = 34

    defaultConfig {

        applicationId = "com.jbastardie.pianolib"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.jbastardie.pianolib"
            artifactId = "pianolib"
            version = "1.6"
            pom {
                packaging = "sources"
            }
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}