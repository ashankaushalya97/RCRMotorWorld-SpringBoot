package lk.ijse.dep.rcrmoto.dao;

import lk.ijse.dep.rcrmoto.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminDAO extends JpaRepository<Admin,String> {

    @Query(value = "SELECT COUNT(username) FROM Admin WHERE username=?#{[0]} AND password=?#{[1]}",nativeQuery = true)
    int authentication(String usernmae,String password);
}
