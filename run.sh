#!/bin/sh
export JAVA_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
java $JAVA_OPTS -jar target/javateam-project.jar
