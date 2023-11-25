package ada.tech.tenthirty.tvpackages.infra.repository;

import ada.tech.tenthirty.tvpackages.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
