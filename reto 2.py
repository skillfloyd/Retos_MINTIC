#:dict)-> dict:
def cliente(informacion):
    if informacion['edad'] > 18:
        atraccion = 'X-Treme'
        apto = True
        if informacion['primer_ingreso'] == True:
            valor_bol = 20000 * 0.95
        else:
            valor_bol = 20000
    elif informacion['edad'] >= 15:
        atraccion = 'Carros chocones'
        apto = True
        if informacion['primer_ingreso'] == True:
            valor_bol = 5000 * 0.93
        else:
            valor_bol = 5000        
        
    elif informacion['edad'] >= 7:
        atraccion = 'Sillas voladoras'
        apto = True
        if informacion['primer_ingreso'] == True:
            valor_bol = 10000 * 0.95
        else:
            valor_bol = 10000        
    else:
        atraccion = 'N/A'
        apto = False
        if informacion['primer_ingreso'] == True:
            valor_bol = 'N/A'
        else:
            valor_bol = 'N/A'          
    
    mensaje = {
        'nombre' : informacion['nombre'],
        'edad' : informacion['edad'],
        'atraccion' : atraccion,
        'apto' : apto,
        'primer_ingreso': informacion['primer_ingreso'],
        'total_boleta' : valor_bol,
    }
    return mensaje


informacion={
    'id_cliente':1,
    'nombre':'Johana Fernandez',
    'edad':20,
    'primer_ingreso':False
}
print(cliente(informacion)) 

