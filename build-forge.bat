@echo off
set JAVA_HOME=Z:\svo\jdk-17\jdk-17.0.11+9
set PATH=%JAVA_HOME%\bin;%PATH%
set GRADLE_OPTS=-Dhttps.protocols=TLSv1.2,TLSv1.3 -Dhttps.cipherSuites=TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384
echo JAVA_HOME=%JAVA_HOME%
Z:/svo/gradle-dist/gradle-7.6.3/bin/gradle.bat -p Z:/svo-forge clean build