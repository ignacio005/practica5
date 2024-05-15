import java.util.*;

public class Graph <V>{
    //Lista de adyacencia.
    private Map<V, Set<V>> adjacencyList = new HashMap<>();
/******************************************************************
 * Añade el vértice ` v` al grafo.
 *
 * @param v vértice a añadir.
 * @return ` true` si no estaba anteriormente y ` false` en caso
 * contrario.
 ******************************************************************/
public boolean addVertex(V v){
    if (adjacencyList.containsKey(v)){ // este condicional, comprueba que el grafo contenga v.
        return false;
    }else{ // este else, me permite añadir un vértice v al grafo.
        adjacencyList.put(v, new HashSet<>());
        return true;
    }

}
    /******************************************************************
     * Añade un arco entre los vértices ` v1` y ` v2` al grafo. En
     * caso de que no exista alguno de los vértices, lo añade
     * también.
     **
     @param v1 el origen del arco.
      * @param v2 el destino del arco.
     * @return ` true` si no existía el arco y ` false` en caso contrario.
     ******************************************************************/
    public boolean addEdge(V v1, V v2){
        addVertex(v1);
        addVertex(v2);
        adjacencyList.get(v1).add(v2); // obtengo el conjunto de vértices a los que apunto desde el v1 y añado v2 al conjunto para obtener un arco.
        return true; //Este código hay que modificarlo.
    }
    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a ` v`.
     **
     @param v vértice del que se obtienen los adyacentes.
      * @return conjunto de vértices adyacentes.
     ******************************************************************/
    public Set<V> obtainAdjacents(V v){
        if (adjacencyList.containsKey(v)){ // este condicional, comprueba si v está contenido en los adyacentes.
            return adjacencyList.get(v); // retorno el conjunto al que apunta v.
        }else{
            return new HashSet<>();
        }
    }
    /******************************************************************
     * Comprueba si el grafo contiene el vértice dado.
     **
     @param v vértice para el que se realiza la comprobación.
      * @return ` true` si ` v` es un vértice del grafo.
     ******************************************************************/
    public boolean containsVertex(V v){
        if (adjacencyList.containsKey(v)){ // este codicional comprueba si v es adyacente.
            return true;
        }else {
            return false;
        }
    }
/******************************************************************
 * Método ` toString()` reescrito para la clase ` Grafo.java`.
 * @return una cadena de caracteres con la lista de
 * adyacencia.
 ******************************************************************/
@Override
public String toString(){
    String str = "Estos son los conjuntos adyacentes: \n";
    for (V v : adjacencyList.keySet()){ // bucle, que recorre la lista de adyacencia y muestra los elementos del conjunto al que apunta v.
        adjacencyList.get(v);
    }
    return str;
}
    /**
     * Obtiene, en caso de que exista, el camino más corto entre
     * ` v1` y ` v2`. En caso contrario, devuelve ` null`.
     **
     @param v1 el vértice origen.
      * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices del camino más corto
     * entre ` v1` y ` v2`
     */
    public List<V> shortestPath(V v1, V v2){
        Map<V,V> camino = new HashMap<>();
        Queue<V> porvisitar = new LinkedList<>();
        Queue<V> visitados = new LinkedList<>();
        List<V> lista = new ArrayList<>();
        if (v1== null || v2 == null){ // comprueba que no sean null.
            throw new NullPointerException("v1 o v2 es null.");

        }
        if (containsVertex(v1) && containsVertex(v2)) { // comproba si existen los vertices en el grafo.
            porvisitar.add(v1); // añado el primer elemento para no tener vacia la cola
            while (!porvisitar.isEmpty()){ // para parar en vacio
                V nodoactual = porvisitar.poll(); // quito el primero de porvisitar
                   visitados.add(nodoactual);
                    for (V adyacente : obtainAdjacents(nodoactual)){ // obtengo los adjacentes del nodo.
                        if (!visitados.contains(adyacente) && !porvisitar.contains(adyacente)){ // para no tener duplicados colas y si el nodo esta en alguna de las colas significa q en el q estoy es mas largo.
                            porvisitar.add(adyacente);
                            camino.put(adyacente,nodoactual);
                        }
                    }

                }

            V vaux= v2; // guarda el nodo destino.
            lista.add(vaux); // lo añado al camino
            while (vaux != v1){ // recorro las claves del mapa con los valores q se añadieron durante el recorrido del grafo hasta llegar al inicio del camino (v1).
                // Paro cuando vaux sea igual al origen.
                vaux =camino.get(vaux);
                lista.add(0,vaux); // anado los elementos al inicio para tener el nodo origen al principio de la lista.

            }


        }




    return lista;
    }
}//pon aUTOR EN EL README

