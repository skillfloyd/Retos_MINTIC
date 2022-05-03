#reto 1


def CDT(usuario:str,capital:int,tiempo:int):
    
    porcentaje_interes=0.03 #3%
    porcentaje_perder=0.02 #2%

    if (tiempo>2):
        valor_intereses=(capital*porcentaje_interes*tiempo)/12
        valor_total=valor_intereses+capital
        a=f"Para el usuario {usuario} La cantidad de dinero a recibir, según el monto inicial {capital} para un tiempo de {tiempo} meses es: {valor_total}" # f (formatear) para imprimir por fuera con {}
        return a
    else:
        valor_a_perder=capital*porcentaje_perder
        valor_total=capital - valor_a_perder
        
        b=f"Para el usuario {usuario} La cantidad de dinero a recibir, según el monto inicial {capital} para un tiempo de {tiempo} meses es: {valor_total}" # f (formatear) para imprimir por fuera con {}
        return b
    
print(CDT("AB1012",1000000,2))
