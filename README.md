- Cálculo del camino más corto entre dos vértices de un grafo.

Para calcularlo utilizo un mapa que le llamo camino y dos colas porvisitar, donde guardo los que no he pasado y visitados, donde guardo los que ya he pasado. También creo una lista donde devuelvo el camino más corto. Primero compruebo con un condicional que el vértice de llegada y de destino no sean null. Después con otro condicional compruebo que estén contenidos en el grafo y hago un bucle while que tiene como parada hasta que porvisitar esté vacío. Dentro del bucle cogeré el primer nodo de la cola porvisitar y lo añadiré a la de visitados. Después con un bucle foreach llamo al método obteneradyacentes para que me los de uno por uno y con un condicional hago que solo se añadan a por visitar y a camino sino están en visitados ni en porvisitar. Añado el nodo de destino a la lista de que tengo que devolver y utilizo un bucle while que tiene como parada hasta que vaux sea igual al v1 para recorrer el camino (mapa) y reordeno la lista.

- Autor: Ignacio Tirado Meza.

- Licencia: Copyright [2024] [Ignacio Tirado Meza]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.