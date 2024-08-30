plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.chatguru"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.chatguru"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("com.google.firebase:firebase-auth-ktx:22.1.2")
    implementation("com.google.firebase:firebase-auth:22.1.2")
    implementation("com.google.firebase:firebase-database-ktx:20.2.2")
    implementation("com.google.firebase:firebase-database:20.2.2")
    implementation("com.google.firebase:firebase-firestore-ktx:24.8.1")
    implementation("com.google.firebase:firebase-firestore:24.8.1")
    implementation("com.google.firebase:firebase-storage-ktx:20.2.1")
    implementation("com.google.firebase:firebase-storage:20.2.1")
    implementation("com.google.firebase:firebase-functions-ktx:20.3.1")
    implementation("com.google.firebase:firebase-messaging-ktx:23.2.1")
    implementation("com.google.firebase:firebase-messaging:23.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // FirebaseUI for Firebase Realtime Database
    implementation ("com.firebaseui:firebase-ui-database:8.0.2")

    // FirebaseUI for Cloud Firestore
    implementation ("com.firebaseui:firebase-ui-firestore:8.0.2")

    // FirebaseUI for Firebase Auth
    implementation ("com.firebaseui:firebase-ui-auth:8.0.2")

    // FirebaseUI for Cloud Storage
    implementation ("com.firebaseui:firebase-ui-storage:8.0.2")



    //country code picker dependency
    implementation("com.hbb20:ccp:2.5.0")
}