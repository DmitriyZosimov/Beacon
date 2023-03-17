FROM amazoncorretto:11-alpine
RUN apk update && apk add bash
COPY cicd/entrypoint.sh /entrypoint.sh
RUN chmod a+x /entrypoint.sh
COPY build/libs/search-0.0.1.jar /app.jar
EXPOSE 8080
ENV ENVIRONMENT local
ENTRYPOINT ["sh", "-c", "/entrypoint.sh"]