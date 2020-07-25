Tabelka ze statystykami wykonana w Excelu:

	Warunki symulacji:
	-Rozmiar dysku: 100,
	-Iloœæ zg³oszeñ: 10 000,
	-W pêtli generuj¹cej procesy warunek:
		a)if(Math.random()>0,05)-warunek pojawienia siê zg³oszenia w jednej iteracji pêtli (niska czêstotliwoœæ),
		b)if(Math.random()>0,3)-warunek pojawienia siê zg³oszenia w jednej iteracji pêtli (wysoka czêstotliwoœæ),
	a wewn¹trz if'a kolejny decyduj¹cy o szansie na to, ¿e bêdzie to zg³oszenie real-time
		if(Math.random()>0,3)  -  w obu przypadkach,
	-Deadline w zakresie 20-80.

Najwiêksze ró¿nice s¹ zauwa¿alne w³aœnie po zmianie czêstotliwoœci pojawiania siê zg³oszeñ. 
