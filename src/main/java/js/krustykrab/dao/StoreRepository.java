package js.krustykrab.dao;

import js.krustykrab.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Store save(Store store);

    List<Store> findAll();

    @Query("SELECT s FROM Store s WHERE s.storeName LIKE ?1")
    List<Store> findStoreByName(String storeName);
}
