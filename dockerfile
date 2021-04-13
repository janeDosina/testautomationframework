FROM gradle:6.8.3-jdk11
WORKDIR /sample
COPY api-module/src /sample/api-module/
COPY ui-module/src/ /sample/ui-module/
COPY build.gradle /sample
COPY build.gradle /sample/api-module
COPY build.gradle /sample/ui-module

EXPOSE 4040
RUN gradle test