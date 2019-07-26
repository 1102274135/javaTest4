FROM registry.saas.hand-china.com/tools/mysql:5.6
MAINTAINER "BAI"
WORKDIR /usr/sql
ADD sakila-schema.sql /sakila-schema.sql
ADD sakila-data.sql /sakila-data.sql

RUN cat /sakila-schema.sql > /docker-entrypoint-initdb.d/dump.sql
RUN cat /sakila-data.sql >> /docker-entrypoint-initdb.d/dump.sql