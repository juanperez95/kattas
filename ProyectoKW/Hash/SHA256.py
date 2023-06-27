import hashlib, sys

texto = sys.argv[1].encode('utf--8')
encriptada = hashlib.sha256(texto).hexdigest()

print(encriptada)

