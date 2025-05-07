# Usamos una imagen base oficial de Java 21 proporcionada por eclipse temurin.
FROM eclipse-temurin:21-jdk
#Establecemos el directorio de trabajo dentro del contenedor.
# Aqui, se copiarán los archivos y se ejecutará la app.
WORKDIR /app
#Copiamos el archivo .jar generado por Maven desde la carpeta ''target'' al contenedor (debe existir previamente)
COPY target/mikrotik-dhcp-viewer-1.0-SNAPSHOT.jar app.jar
# Comando que se ejecutara cuando el contenedor se inicie, ejecuta el archivo .jar usando Java.
ENTRYPOINT ["java", "-jar", "app.jar"]
