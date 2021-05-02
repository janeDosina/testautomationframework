FROM gradle:6.8.3-jdk11

WORKDIR /work

COPY ./api-module/src /work/api-module/src
COPY ./ui-module/src/ /work/ui-module/src

COPY build.gradle /work/build.gradle
COPY build.gradle /work/api-module/build.gradle
COPY build.gradle /work/ui-module/build.gradle

CMD gradle test