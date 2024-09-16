# Use uma imagem base com JDK 17
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar o JAR gerado pela aplicação para o container
COPY target/*.jar app.jar

# Definir a variável de ambiente para o fuso horário (opcional)
ENV TZ=America/Sao_Paulo

# Expõe a porta 8080 (porta padrão do Spring Boot)
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
