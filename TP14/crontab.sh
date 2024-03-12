if $(crontab -l | grep recherche.sh) != ""
then
	(crontab -l; echo "30 2 * * * /home/user/tp-r504/TP14/recherche.sh") | crontab -
else
	echo "Le script est déjà utilisé"
fi
