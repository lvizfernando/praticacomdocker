FROM mysql

LABEL maintainer="carloseduardo, luizfernando"

ENV MYSQL_ROOT_PASSWORD secret
ENV MYSQL_DATABASE LifeCare
ENV MYSQL_USER lifecareuser
ENV MYSQL_PASSWORD lifecarepwd

COPY teste.sql /docker-entrypoint-initdb.d

EXPOSE 3306