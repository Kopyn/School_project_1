Tabelka ze statystykami wykonana w Excelu:

	Warunki symulacji:
	-Rozmiar dysku: 100,
	-Ilo�� zg�osze�: 10 000,
	-W p�tli generuj�cej procesy warunek:
		a)if(Math.random()>0,05)-warunek pojawienia si� zg�oszenia w jednej iteracji p�tli (niska cz�stotliwo��),
		b)if(Math.random()>0,3)-warunek pojawienia si� zg�oszenia w jednej iteracji p�tli (wysoka cz�stotliwo��),
	a wewn�trz if'a kolejny decyduj�cy o szansie na to, �e b�dzie to zg�oszenie real-time
		if(Math.random()>0,3)  -  w obu przypadkach,
	-Deadline w zakresie 20-80.

Najwi�ksze r�nice s� zauwa�alne w�a�nie po zmianie cz�stotliwo�ci pojawiania si� zg�osze�. 
