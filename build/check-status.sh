#!/bin/bash
modules=(%MODULES%)

. func.sh

logPath=`getModuleItem "./nuls.ncf" "logPath"`

check(){
    echo `awk 'BEGIN{ s=0 } {
        if($0 ~ /'"$3"'$/){s=1}
        if($0 ~ /RUN MODULE:'"$2"'$/){s=0}
    } END{ print s }' $1`
}
#if [ ! -d "$1" ]; then
#    echo "必须指定logs目录: ./check-status.sh <log path>"
#    exit 0;
#fi
clear
echoRed() { echo $'\e[0;31m'$1$'\e[0m'; }
echoGreen() { echo $'\e[0;32m'$1$'\e[0m'; }
while [ 1 == 1 ]
do
echo "==================RPC REDAY MODULE=================="
for module in ${modules[@]}
do
	#echo ${module}
	#grep -n 'RMB:module rpc is ready' Modules/Nuls/${module}/1.0.0/log/stdout.log
#	if [ -n "`grep -n 'RMB:module rpc is ready' $logPath/${module}/stdout.log`" ];
	if [ "1" == `check $logPath/${module}/common.log $module 'RMB:module rpc is ready'` ];
	then
		echoGreen "${module} RPC READY"
		else
		echoRed "${module} RPC NOT READY"	
	fi
done

echo "==================REDAY MODULE=================="
for module in ${modules[@]}
do
	if [ "1" == `check $logPath/${module}/common.log $module 'RMB:module is READY'` ];
	then
		echoGreen "${module} STATE IS READY"
		else
		echoRed "${module} STATE NOT READY"	
	fi
done

echo "==================TRY RUNNING MODULE=================="
for module in ${modules[@]}
do
	if [ "1" == `check $logPath/${module}/common.log $module 'RMB:module try running'` ];
	then
		echoGreen "${module} TRY RUNNING"
		else
		echoRed "${module} NOT TRY RUNNING"	
	fi
done

echo "==================RUNNING MODULE=================="
isReady=1
for module in ${modules[@]}
do
	if [ "1" == `check $logPath/${module}/common.log $module 'RMB:module state : Running'` ];
	then
		echoGreen "${module} STATE IS RUNNING"
		else
		isReady=0
		echoRed "${module} STATE NOT RUNNING"	
	fi
done
echo "==================NULS WALLET STATE=================="
if [ $isReady == 1 ];
then
    echoGreen "=========================="
    echoGreen "NULS WALLET IS RUNNING"
    echoGreen "=========================="
    exit 0;
else
    echoRed "NULS WALLET NOT RUNNING"
    sleep 2
    clear;
fi
done



