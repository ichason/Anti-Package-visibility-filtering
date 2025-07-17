plugins {
    id("com.android.application")
}

// 获取Git提交信息用于版本号
fun getGitCommitCount(): String {
    return try {
        val process = Runtime.getRuntime().exec("git rev-list --count HEAD")
        process.inputStream.bufferedReader().readText().trim()
    } catch (e: Exception) {
        "1"
    }
}

fun getGitCommitHash(): String {
    return try {
        val process = Runtime.getRuntime().exec("git rev-parse --short HEAD")
        process.inputStream.bufferedReader().readText().trim()
    } catch (e: Exception) {
        "unknown"
    }
}

android {
    namespace = "com.chason.anti_package_visibility_filtering"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.chason.anti_package_visibility_filtering"
        minSdk = 24
        targetSdk = 34
        versionCode = getGitCommitCount().toInt()
        versionName = "1.0.${getGitCommitCount()}-${getGitCommitHash()}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    compileOnly(files("libs\\api-82.jar"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    
    // 解决Kotlin依赖冲突
    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.22") {
            because "kotlin-stdlib-jdk7 is now a part of kotlin-stdlib"
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.22") {
            because "kotlin-stdlib-jdk8 is now a part of kotlin-stdlib"
        }
    }
}