#!/bin/sh





SERVER_NAME=blog


DEPLOY_DIR=`pwd`


echo ${DEPLOY_DIR}

LOGS_DIR=${DEPLOY_DIR}/
if [ ! -d ${LOGS_DIR} ]; then
    mkdir ${LOGS_DIR}
fi


STDOUT_FILE=${LOGS_DIR}/stdout.log

tpid=`ps -ef | grep java | grep $SERVER_NAME | grep -v grep | awk '{print $2}'`
if [ -n "$tpid" ]; then
    echo "ERROR: The $SERVER_NAME already started!"
    echo "PID: $tpid"
    exit 1
fi

rm -f tpid

JAVA_OPTS=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "

JAVA_MEM_OPTS=" -server -Xmx2g -Xms2g -Xmn1g -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "


echo "Starting the $SERVER_NAME ..."

JAVA_DEBUG_OPTS=""
if [[ "$1" = "debug" ]]; then
     JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=9888,server=y,suspend=n "
fi



nohup java  ${JAVA_OPTS}   ${JAVA_MEM_OPTS}  ${JAVA_DEBUG_OPTS}   -jar  blog.jar >> ${STDOUT_FILE} 2>&1 &
sleep 1
echo "Please check the STDOUT file: $STDOUT_FILE"
echo $! > tpid