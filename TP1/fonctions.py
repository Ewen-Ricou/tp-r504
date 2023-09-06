def puissance(valeur,exposant):
	if not type(valeur) is int:
		raise TypeError("Only integers are allowed.")
	return valeur**exposant
