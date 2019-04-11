echo off
SET mypath=%~dp0
SET JAVA_HOME=%mypath%jdk-12
echo JAVA_HOME=%JAVA_HOME%

%mypath%\eclipse\eclipse -vm %JAVA_HOME%\bin -data %mypath%\ws