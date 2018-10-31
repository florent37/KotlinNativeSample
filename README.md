# KotlinNative Sample

Sample project for my Medium Story : **My first experience with kotlin native**

[**My first experience with kotlin native**](https://medium.com/@champigny.florent/my-first-experience-with-kotlin-native-988e96f26657)

[![screen](https://raw.githubusercontent.com/florent37/KotlinNativeSample/master/medias/iphone_android.png)](https://www.github.com/florent37/KotlinNativeSample)

# How to build 

Just run
```
./gradlew build
```

It will generate kotlin `common` module implementation for Android/JVM and for iOS/Native

# XCode project

Inside the `appios/` directory you'll find the xcode workspace, bound to the kotlin-native framework generated from the `common` module

Open the xcode project to generate the iPhone app.

[![screen](https://raw.githubusercontent.com/florent37/KotlinNativeSample/master/medias/xcode_code.png)](https://www.github.com/florent37/KotlinNativeSample)

# Android project

Inside the `android/` directory you'll find the android app code

Add an android configuration on your IDE to push the application to your phone.

[![screen](https://raw.githubusercontent.com/florent37/KotlinNativeSample/master/medias/android_code.png)](https://www.github.com/florent37/KotlinNativeSample)
