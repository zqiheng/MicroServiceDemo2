FROM java:8
MAINTAINER Eric qiheng.zhang@fa-software.com
ENV LANG zh_CN.utf8
ENV LANGUAGE zh_CN.utf8
ENV LC_ALL zh_CN.utf8
WORKDIR /root
ADD ./target/config_server-0.0.1-SNAPSHOT.jar /app/
ADD ./src/main/resources/application.yml /app/config/
EXPOSE 10003
ENTRYPOINT ["java","-Djava.net.preferIPv4Stack=true","-Duser.timezone=UTC","-Djava.security.egd=file:/dev/./urandom","-jar","/app/config_server-0.0.1-SNAPSHOT.jar"]
