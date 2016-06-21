#!/bin/sh

clear
echo --------------------------------------------------------------------
echo Starting dashboard-rest using $SPRING_PROFILE profile
echo --------------------------------------------------------------------
cd dashboard-rest && mvn spring-boot:run