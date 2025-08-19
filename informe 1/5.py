def calcular_cargo(horas):
    if horas <= 1:
        cargo = 3.0
    else:
        cargo = 3.0 + (horas - 1) * 0.5
    return min(cargo, 12.0)

h = int(input("Ingrese el número de horas: "))
print("El cargo es: S/", calcular_cargo(h))