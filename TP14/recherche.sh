#!/bin/bash
exec >> /home/user/tp-r504/TP14/log-cron.txt
echo "Recherche de vulnérabilités le $(date)"
if $(debsecan --suite bullseye --only-fixed | wc -l) != 0
then
	echo "Des vulnérabilités ont été détectées !"
else
	echo "Aucune vulnérabilité détectée."
fi
