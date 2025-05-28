# Usamos una imagen base oficial de Java 21 proporcionada por Eclipse Temurin
FROM eclipse-temurin:21-jdk

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo .jar generado por Maven desde la carpeta 'target' al contenedor
# Asegúramos de que este archivo exista (ejecutando 'mvn package' antes de construir la imagen)
COPY target/mikrotik-dhcp-viewer-1.0-SNAPSHOT.jar app.jar

# Comando que se ejecutará cuando el contenedor se inicie
# Ejecutamos el .jar directamente, debe tener el Main-Class definido en el MANIFEST.MF
ENTRYPOINT ["java", "-jar", "app.jar"]
