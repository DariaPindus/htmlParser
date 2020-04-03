FROM jetty
COPY htmlParser-1.0-SNAPSHOT.war /var/lib/jetty/webapps/ROOT.war
EXPOSE 8080
