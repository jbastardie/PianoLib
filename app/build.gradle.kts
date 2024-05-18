plugins {
    id("com.android.library")
    `maven-publish`
}

android {
    namespace = "com.jbastardie.pianolib"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
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
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("ReleaseAar") {
                artifact("$buildDir/outputs/aar/${artifactId}-release.aar")
                groupId = "com.github.jbastardie"
                artifactId = "app"
                version = "1.7"
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