buildscript {
    dependencies {
        classpath(libs.google.services)
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
   // id ("com.android.application' version '8.0.2") apply false
  //  id ("com.android.library' version '8.0.2") apply false
 //   id ("org.jetbrains.kotlin.android' version '1.7.20") apply false
  //  id ("com.google.dagger.hilt.android' version '2.44") apply false
  //  id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin' version '2.0.1") apply false

}