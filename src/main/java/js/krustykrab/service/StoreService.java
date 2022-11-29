package js.krustykrab.service;

import js.krustykrab.dao.StoreRepository;
import js.krustykrab.domain.Store;
import js.krustykrab.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreDto addStore(StoreDto storeDto){
        storeRepository.save(storeDto.toEntity());
        return storeDto;
    }
    public List<StoreDto> findAllStore() {
        List<Store> stores = storeRepository.findAll();
        return storeListToDto(stores);
    }

    public List<StoreDto> findStoreByName(String storeName) {
        List<Store> stores = storeRepository.findStoreByName(addPercentChar(storeName));
        return storeListToDto(stores);
    }

    public StoreDto findStoreById(Long id){
        Optional<Store> optionalStore = storeRepository.findById(id);
        if(optionalStore.isPresent())
            return optionalStore.get().toDto();
        return null;

    }

    private String addPercentChar(String storeName) {
        StringBuffer sb = new StringBuffer();
        sb.append("%");
        sb.append(storeName);
        sb.append("%");

        return sb.toString();
    }

    private List<StoreDto> storeListToDto(List<Store> stores) {
        List<StoreDto> storeDtos = new ArrayList<>();

        stores.forEach(store -> {
            storeDtos.add(store.toDto());
        });

        return storeDtos;
    }

}
