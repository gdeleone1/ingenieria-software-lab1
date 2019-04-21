package gt.edu.umg.ingenieria.sistemas.laboratorio1.dao;


import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ClientRepository extends CrudRepository<Client,Integer> { // importo el modelo
    public Client findClientByFirstName(String firstName);
    public Client findClientByNit(String nit);
    
}