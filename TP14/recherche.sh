#!/bin/bash
exec >> /var/log/log-cron.txt
echo "Recherche de vulnérabilités le $(date)"
if [ $(debsecan --suite bullseye --only-fixed | wc -l) -ne 0 ]
then
	echo "Des vulnérabilités ont été détectées !"
else
	echo "Aucune vulnérabilité détectée."
fi
