package uz.pdp.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appclickup.entity.Icon;

public interface IconRepository extends JpaRepository<Icon, Long> {
}
