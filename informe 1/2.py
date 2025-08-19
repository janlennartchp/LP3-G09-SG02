numeros = []
entrada = input("Ingrese el primer número (o '.' para terminar): ")

if entrada == ".":
    print("No se ingresaron números.")
else:
    numeros.append(int(entrada))
    while True:
        entrada = input(f"Ingrese un número mayor que {numeros[-1]} : ")
        if entrada == ".":
            break
        siguiente = int(entrada)
        if siguiente > numeros[-1]:
            numeros.append(siguiente)
        else:
            print("El número debe ser mayor. Intente de nuevo.")

    print("\nArreglo ingresado:", numeros)