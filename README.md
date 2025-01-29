This is the girlfriend mod from Tommyinnit (https://www.youtube.com/watch?v=TRigGOh-_ys), made by Vini2003. I can't get it to work, there seems to be errors in gradle. I'm very new to Github and don't really know any Java or Gradle. So if you know what your doing you can make a fork of it working or make a pull request or something. If anyone has found any files in some of the deleted repositories please upload them here (I'm trying to compile them all): https://www.dropbox.com/request/N19bwKETJRDn0nVWx2BO

# Commands
* Press `f` to fire tnt
* Type `/gf` for Girlfriend overlay messages
* Type `/summongf` to summon a villager that can be interacted with the GF overlay (via rightclick)

# Requirements to build
- Java 16 or higher
  - Required by: `Girlfriend-master/build.gradle`, `Girlfriend-master/gradle.properties`, `Girlfriend-master/src/main/resources/girlfriend.mixins.json`
- Gradle 7.0 or higher
  - Required by: `Girlfriend-master/gradle/wrapper/gradle-wrapper.properties`, `Girlfriend-master/gradlew`, `Girlfriend-master/gradlew.bat`
- Fabric Loader 0.11.6 or higher
  - Required by: `Girlfriend-master/gradle.properties`, `Girlfriend-master/src/main/resources/fabric.mod.json`
- Fabric API 0.35.1+1.17 or higher
  - Required by: `Girlfriend-master/gradle.properties`, `Girlfriend-master/src/main/resources/fabric.mod.json`
- Minecraft 1.17
  - Required by: `Girlfriend-master/gradle.properties`, `Girlfriend-master/src/main/resources/fabric.mod.json`
- LibGui 4.0.0+1.17
  - Required by: `Girlfriend-master/gradle.properties`, `Girlfriend-master/build.gradle`