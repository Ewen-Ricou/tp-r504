def puissance(valeur,exposant):
	puissance = 1
	if not type(valeur) is int:
		raise TypeError("Only integers are allowed.")
	if not type(exposant) is int:
		raise TypeError("Only integers are allowed.")
	for _ in range(exposant):
		puissance *= valeur
	return puissance
