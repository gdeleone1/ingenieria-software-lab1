package gt.edu.umg.ingenieria.sistemas.laboratorio1.service;

import gt.edu.umg.ingenieria.sistemas.laboratorio1.dao.ClientRepository;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josué Barillas (jbarillas)
 */
@Service
public class ClientService {
      @Autowired
    private ClientRepository ClientRepositorVar; // variable del repositorio
    //se crean todos los metos crear ,actualizar eliminar 
    private Object clientRepository;
    
  
    
    //crear cliente 
    public String createClient (Client cliente){
        
       
         if (cliente.age>17){
             if( cliente.nit.length()<11){
                    ClientRepositorVar.save(cliente);
              return "Cliente guardado con exito";
             }else {  return "Error....nit demasiado grande";
                 
             }
        
         } else{
          return "Error... cliente menor de edad";
        }
        
        /*
        if (cliente.age>17){
              return this.ClientRepositorVar.save(cliente);
        }
        else {
            return null;
        }
        */
        
    }
    
        
    //buscar cliente por nit
    public Client getClientByNit (String nit){
        return this.ClientRepositorVar.findClientByNit(nit);
        
    }
        
    //buscar todos los clientes en una lista
    public List<Client> getClientAll (){
        return(List<Client>)this.ClientRepositorVar.findAll();
        
    }
    
    //buscar cliente por nombre
    
    public Client getClientByName (String firstName){
     return this.ClientRepositorVar.findClientByFirstName(firstName);   
   
    }
    //actualizar cliente
      public Client updateClient(Client cliente) {
          
        return this.ClientRepositorVar.save(cliente);        
    }
     
      public List<Client> obtenerReporteria() {
       
          //abrir archivo
       FileOutputStream archivo;
        //escribir en archivo
        PrintStream p;
        List<Client> lista = (List<Client>) this.ClientRepositorVar.findAll();
        //buffer que guarda la cadena de datos
        StringBuffer sb = new StringBuffer("");
        int no = 1;
        int dia = Calendar.DAY_OF_MONTH;
        int mes = Calendar.MONTH;
        int anio = Calendar.YEAR;
        int hora = Calendar.HOUR_OF_DAY;
        String fecha = ""+dia+mes+anio+hora;
        //html
        sb.append("<html> <html>\n" +
                    "<head>\n" +
                    "<title>\n" +
                    "Reporte\n" +
                    "</title>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body> <h1>Reporte de clientes</h1>");
        //encabezados
        sb.append("<table border='2' bgcolor='red'>\n" +
                    "<tr>\n" +
                    "<td>ID</td>\n" +
                    "<td>NOMBRE</td>\n" +
                    "<td>APELLIDO</td>\n" +
                    "<td>DIRECCION</td>\n" +
                    "<td>EDAD</td>\n" +
                    "<td>NIT</td>\n" +
                    "<td>TELEFONO</td>\n" +
                    "</tr>");
        
        
        int i=0;
        int j= lista.size();
        while(i<j)
        {
            
        Client cliente = lista.get(i);
        sb.append("<tr>\n");
        sb.append("<t2d>"+cliente.getId()+"</td>");
        //sb.append("\t");
        sb.append("<td>"+cliente.getFirstName()+"</td>");
        //sb.append("\t");
        sb.append("<td>"+cliente.getLastName()+"</td>");
       // sb.append("\t");
        sb.append("<td>"+cliente.getAddress()+"</td>");
       // sb.append("\t");
        sb.append("<td>"+cliente.getAge()+"</td>");
       // sb.append("\t");
        sb.append("<td>"+cliente.getNit()+"</td>");
       // sb.append("\t");
        sb.append("<td>"+cliente.getPhone()+"</td> <tr>");
       // sb.append("\n");
        i++;
        
        }
        
        
        
	try {
		//archivo= new FileOutputStream("pagina.html");
		archivo= new FileOutputStream("Clientes "+fecha+".html");
		p= new PrintStream(archivo);
		p.println(sb.toString());
		p.close();
	} catch (FileNotFoundException e) {		
        }
       
       
        
        no++;
        return (List<Client>) this.ClientRepositorVar.findAll();
    }
    
    

}
