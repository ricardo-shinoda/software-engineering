package repositories;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos personalizados do repositório podem ser adicionados aqui, se necessário
}
