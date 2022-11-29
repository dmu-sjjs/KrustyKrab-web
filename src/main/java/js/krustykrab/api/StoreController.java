package js.krustykrab.api;

import js.krustykrab.dto.StoreDto;
import js.krustykrab.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("store")
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/add")
    public String addStore(StoreDto storeDto) {
        StoreDto store = storeService.addStore(storeDto);
        return "redirect:storePage";
    }

    @GetMapping("/all")
    public String findAllStore(Model model) {
        List<StoreDto> stores = storeService.findAllStore();
        model.addAttribute("stores", stores);

        return "storePage"; // 임시 return 값
    }

    @GetMapping("/{storeName}")
    public String findStoreByName(@PathVariable String storeName, Model model) {
        List<StoreDto> stores = storeService.findStoreByName(storeName);
        model.addAttribute("stores", stores);

        return "storePage"; // 임시 return 값
    }

    @GetMapping("/{storeId}")
    public String findStoreByName(@PathVariable Long storeId, Model model) {
        StoreDto store = storeService.findStoreById(storeId);
        model.addAttribute("store", store);

        return "storePage"; // 임시 return 값
    }
}
