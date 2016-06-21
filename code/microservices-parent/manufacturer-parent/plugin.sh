#!/bin/sh

clear
echo --------------------------------------------------------------------
echo Starting manufacturer-rest using $SPRING_PROFILE profile
echo --------------------------------------------------------------------
cd manufacturer-rest && mvn spring-boot:run