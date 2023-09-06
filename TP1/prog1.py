import fonctions as f
print("Hello, World!")
while True :
	nombre1 = input("Donnez une valeur numérique : ")
	nombre2 = input("Donnez une valeur numérique pour l'exposant : ")
	print("La valeur est",f.puissance(int(nombre1),int(nombre2)))
