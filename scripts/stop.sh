motion=$(ps aux | grep motion | grep -v grep | grep -v "images" | awk '{print $2}')

if [ "$motion" != "" ]
then
	echo "No es vacio"
	kill -9 $(echo $motion)
fi
