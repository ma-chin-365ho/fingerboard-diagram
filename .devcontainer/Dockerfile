FROM mcr.microsoft.com/devcontainers/java:1-21-bullseye

RUN apt-get update && apt-get -y install libxext6 libxrender1 libxtst6 fontconfig

ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"