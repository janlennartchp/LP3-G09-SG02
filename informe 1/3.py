import random

frecuencia = [0]*6

for _ in range(20000):
    cara = random.randint(1, 6) # 1 a 6
    frecuencia[cara-1] += 1

print("Frecuencia de cada cara:")
for i, f in enumerate(frecuencia, start=1):
    print(f"Cara {i}: {f}")