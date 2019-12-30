FROM openjdk:8-alpine
# 作用是创建在本地主机或其他容器可以挂载的数据卷，用来存放数据。
VOLUME /tmp
# 定义一个变量
ARG JAR_FILE
COPY ${JAR_FILE} /usr/local/app/share-discovery-master.jar
ENTRYPOINT [
                "java",
                "-Djava.security.egd=file:/dev/./urandom",
                "-Dspring.profiles.active=dev",
                "-jar",
                "/usr/local/app/share-discovery-master.jar"
           ]
