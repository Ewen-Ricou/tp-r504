import pytest
import fonctions as f

def test_1():
	assert f.puissance(2,3) == 8
	assert f.puissance(2,2) == 4

#def test_2():
#	assert f.puissance(5,2) == -25
#	assert f.puissance(3,2) == -9

def test_3():
	assert f.puissance(-2,2) == 4
	assert f.puissance(2,0) == 1
	assert f.puissance(-2,0) == 1
	assert f.puissance(0,3) == 0
	try :
		f.puissance(0,0)
		assert False
	except TypeError :
		assert True
	assert f.puissance(2,-2) == 0.25
