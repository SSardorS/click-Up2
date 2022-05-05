package uz.pdp.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appclickup.entity.Space;

import java.util.UUID;

public interface SpaceRepository extends JpaRepository<Space, UUID> {
}
