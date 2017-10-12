package clases;

import java.util.Comparator;

/*
 * Criterio de comparación que se usa para comparar dos objetos
 * de tipo Usuario. Compara si pts del usuario1 es menor que pts del usuario2
 */
public class ClaseComparacion implements Comparator<Usuario>
{
	public int compare(Usuario d1, Usuario d2)
	{
		Integer item1= d1.getPuntos();
		Integer item2= d2.getPuntos();
		return item2.compareTo(item1);
	}
}
