FROM wiremock/wiremock:latest
COPY ../translation-wiremock-stubs/files /home/wiremock/__files/
COPY ../translation-wiremock-stubs/mappings /home/wiremock/mappings/
EXPOSE 8083
CMD ["--port","8083","--verbose","--global-response-templating"]