package uz.pdp.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.entity.Workspace;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    boolean existsByOwnerIdAndName(UUID owner_id, String name);

    Optional<Workspace> findByIdAndOwner(Long id, User owner);

    List<Workspace> findByOwner_Email(String owner_email);
}
