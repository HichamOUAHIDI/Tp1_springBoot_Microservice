package org.ms;

import org.ms.entites.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
// vous n'avez pas de droit d'envoyer une requet d'un domine pour recupere une page deployer dans un aure domaine 
// avec cette annotation cet api rest exposé par n'import quel domaine 
public interface FormationRepository extends JpaRepository<Formation, Long> {

}
