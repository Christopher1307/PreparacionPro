def ImprimirNumeros(numero):
  # Seguirá llamándose recursivamente hasta que llegue a 1, y ahi empezará a imprimirlos
  if numero > 0:
    ImprimirNumeros(numero - 1) # Llamada recursiva hasta que se cumpla la condicion de arriba
    print(numero, end=" ")



#En otro lenguaje esto será una cosntante pero en python no existen xd
numero = int(input("Introduce el numero al que quieres llegar: "))
ImprimirNumeros(numero)