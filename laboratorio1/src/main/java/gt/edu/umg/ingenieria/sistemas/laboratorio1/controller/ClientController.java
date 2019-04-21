package gt.edu.umg.ingenieria.sistemas.laboratorio1.controller;

import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.service.ClientService;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clientes")

public class ClientController {

    @Autowired
    //private ReportService reportService;
    private ClientService clientService;
    
    @GetMapping ("/buscarTodos")
    public List<Client> getAll(){
        return this.clientService.getClientAll();
        
    }
      
    @GetMapping ("/obtenerReporte")
    public List<Client> obtenerReporte(){
        return this.clientService.obtenerReporteria();
        
    }
    
    @GetMapping ("/buscarPorNit")
    public Client getByNit(@RequestParam(name = "nit",required= true)String nit){
        return this.clientService.getClientByNit(nit);
    
}
        
    @GetMapping ("/buscarPorNombre")
    public Client findClientByLastName(@RequestParam(name = "nombre",required= true)String nombre){
        return this.clientService.getClientByName(nombre);
    
}
    
    @PostMapping("/crearCliente")
    public String create(@RequestBody(required = true) Client newClient) {
        return this.clientService.createClient(newClient);
        
       
    }
    
    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello world!!!";
    }
        @PutMapping("/actualizarCliente/{id}")
    public Client update(@PathVariable(required = true) int id, @RequestBody(required = true) Client studentToUpdate) {
        return this.clientService.updateClient(studentToUpdate);
    }   
    
    
    
}
