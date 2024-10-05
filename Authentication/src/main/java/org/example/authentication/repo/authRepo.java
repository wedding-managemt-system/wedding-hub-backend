package org.example.authentication.repo;

import org.example.authentication.model.authModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface authRepo extends JpaRepository<authModel, String> {
  @Query(value = "SELECT * FROM authModel WHERE id=?1" , nativeQuery = true)

  authModel getAuthModel(String id);
  authModel findByEmail(String email);

}
