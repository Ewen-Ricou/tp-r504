def puissance(valeur,exposant):
	carre = 0
	if not type(valeur) is int:
		raise TypeError("Only integers are allowed.")
	for loop in range(1,exposant):
		carre+=valeur*valeur
	if exposant == 0:
		carre = 1
	return carre
