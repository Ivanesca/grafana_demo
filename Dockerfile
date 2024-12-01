# Используем базовый образ с JDK
FROM openjdk:17-jdk-slim

# Указываем рабочую директорию
WORKDIR /app

# Копируем собранный JAR файл в контейнер
COPY target/grafana_demo-0.1.jar app.jar

# Открываем порт для приложения
EXPOSE 8080

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
