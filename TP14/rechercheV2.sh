#!/bin/bash
exec >> /var/log/log-cronV2.txt
echo "Recherche de vulnérabilités le $(date +"%F") à $(date +"%T") :"
if [ $(debsecan --suite $(lsb_release --codename --short) --only-fixed | wc -l) -ne 0 ]
then
	debsecan --suite $(lsb_release --codename --short) --only-fixed --format report --mailto root
	echo "Des vulnérabilités ont été détectées !"
	echo "Il y a $(debsecan --suite bullseye --only-fixed | wc -l) mises à jour en attente. Un rapport vous a été envoyé par mail."
	echo "Pour vous mettre à jour lancez la commande : sudo apt update && sudo apt upgrade -y"
else
	echo "Aucune vulnérabilité détectée. Vous êtes à jour."
fi

