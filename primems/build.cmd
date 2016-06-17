cls
call mvn eclipse:clean
call mvn clean
call mvn install
call mvn eclipse:eclipse -Dwtpversion=2.0