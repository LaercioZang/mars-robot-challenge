# Imagem base do JDK para compilar e executar o aplicativo
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado para o diretório de trabalho
COPY target/marsrobot-1.0.0.jar app.jar

# Expõe a porta em que o serviço Spring Boot vai rodar
EXPOSE 8080

# Comando para iniciar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]