#!/bin/sh

clear
echo --------------------------------------------------------------------
echo Starting product-rest using $SPRING_PROFILE profile
echo --------------------------------------------------------------------
cd product-rest && mvn spring-boot:run