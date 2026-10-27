@echo off
setlocal
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.9.10-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%
Z:/svo/gradle-dist/gradle-8.10.2/bin/gradle.bat -p Z:/svo-forge clean build