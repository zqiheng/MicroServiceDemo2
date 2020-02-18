FROM java:8
MAINTAINER Eric qiheng.zhang@fa-software.com
ENV LANG zh_CN.utf8
ENV LANGUAGE zh_CN.utf8
ENV LC_ALL zh_CN.utf8
WORKDIR /root
ADD ./target/service_order-0.0.1-SNAPSHOT.jar /app/
ADD ./src/main/resources/bootstrap.yml /app/config/
EXPOSE 10030
ENTRYPOINT ["java","-Djava.net.preferIPv4Stack=true","-Duser.timezone=UTC","-Djava.security.egd=file:/dev/./urandom","-jar","/app/service_order-0.0.1-SNAPSHOT.jar"]
