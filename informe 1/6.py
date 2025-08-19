def convertir_a_segundos(horas, minutos, segundos):
    return horas * 3600 + minutos * 60 + segundos

h = int(input("Ingrese las horas: "))
m = int(input("Ingrese los minutos: "))
s = int(input("Ingrese los segundos: "))

print("El equivalente en segundos es:", convertir_a_segundos(h,m,s))