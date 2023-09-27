def puissance(valeur,exposant):
	if not type(valeur) is int:
		raise TypeError("Only integers are allowed.")
	if not type(exposant) is int:
		raise TypeError("Only integers are allowed.")
	if valeur > 0 :
		puissance = 1
	elif valeur < 0 :
		puissance = -1
	else:
		puissance = 0
	for _ in range(exposant):
		puissance *= valeur
	return puissance
