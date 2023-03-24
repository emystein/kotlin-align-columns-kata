# Align Columns Kata
Dado un texto con varias líneas, donde cada línea está separada en columnas por el caracter $, y las líneas están separadas entre si por el caracter \n, escribir un programa que alinee cada columna de cada línea.

La alineación puede ser a izquierda, al centro o a derecha dentro de la columna.

Las líneas de texto de entrada de ejemplo pueden o tener caracteres $ al final.

Todas las columnas deben compartir la misma alineación.

# Ejemplo

Entrada: 

<pre>
'Bienvenidos$a\nDiseño$a$la$Gorra'
</pre>

Salida:

<pre>
*-----------*-*--*-----*
|Bienvenidos|a|  |     |
|Diseño     |a|la|Gorra|
*-----------*-*--*-----*
</pre>

