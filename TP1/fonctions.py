def puissance(valeur,exposant):
	carre = 0
	if not type(valeur) is int:
		raise TypeError("Only integers are allowed.")
	for loop in range(0,exposant-1):
		carre+=valeur*valeur
	if exposant == 0:
		carre = 1
	return carre
