package br.com.springboot.tgs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.springboot.tgs.entities.models.Patient;
import br.com.springboot.tgs.interfaces.RepositoriesModel;

public interface PatientRepository extends RepositoriesModel<Patient>, JpaRepository<Patient, String> {
  /**
   * Busca todos os pacientes
   * 
   * @param status - Recebe o status do paciente
   * @return - Busca a lista de pacientes referentes ao status recebido
   */
  @Query("SELECT u from Patient u where u.status = :status")
  public List<Patient> findAllByStatus(@Param("status") Boolean status);
}
