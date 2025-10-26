@echo off
REM Script para compilar y ejecutar el proyecto en Windows

echo =========================================
echo   Compilando proyecto...
echo =========================================

REM Crear directorio bin si no existe
if not exist bin mkdir bin

REM Compilar el proyecto
javac -d bin -cp "lib/sqlite-jdbc-3.45.0.0.jar;lib/slf4j-api-2.0.9.jar;lib/slf4j-simple-2.0.9.jar" src/main/java/com/proyecto/*.java

if %errorlevel% equ 0 (
    echo.
    echo =========================================
    echo   Compilacion exitosa!
    echo   Ejecutando aplicacion...
    echo =========================================
    echo.

    REM Ejecutar el programa
    java -cp "bin;lib/sqlite-jdbc-3.45.0.0.jar;lib/slf4j-api-2.0.9.jar;lib/slf4j-simple-2.0.9.jar" com.proyecto.Main
) else (
    echo.
    echo =========================================
    echo   Error en la compilacion
    echo =========================================
)

pause
