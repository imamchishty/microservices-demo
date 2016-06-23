#!/bin/sh

if [ ! -z $1 ]; then
    SPRING_PROFILE=$1
else
    SPRING_PROFILE="development"
fi

if [ "$2" == "skip" ]; then
    SKIP_TESTS="-DskipTests"
else
    SKIP_TESTS=""
fi

clear
echo --------------------------------------------------------------------
echo Starting product-rest using $SPRING_PROFILE profile
echo --------------------------------------------------------------------
mvn clean package $SKIP_TESTS && java -Xms128m -Xmx256m -jar  product-rest/target/product-rest.jar --spring.profiles.active=$SPRING_PROFILE
