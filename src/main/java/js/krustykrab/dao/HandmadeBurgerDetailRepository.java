package js.krustykrab.dao;

import js.krustykrab.domain.handmadeBurger.HandmadeBurgerOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HandmadeBurgerDetailRepository extends JpaRepository<HandmadeBurgerOrderDetail, Long> {

    HandmadeBurgerOrderDetail save(HandmadeBurgerOrderDetail handmadeBurgerOrderDetail);

    List<HandmadeBurgerOrderDetail> findAll();
}
