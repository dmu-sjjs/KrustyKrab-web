package js.krustykrab.service;


import js.krustykrab.dao.HandmadeBurgerDetailRepository;
import js.krustykrab.domain.handmadeBurger.HandmadeBurgerOrderDetail;
import js.krustykrab.domain.order.Order;
import js.krustykrab.domain.user.User;
import js.krustykrab.dto.HandmadeBurgerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HandmadeBurgerDetailService {
    private final HandmadeBurgerDetailRepository handmadeRepository;

    public void saveHandmadeOrderDetail (HandmadeBurgerDto handmadeBurgerDto, Order order) {
        HandmadeBurgerOrderDetail handmadeBurgerOrderDetail = handmadeBurgerDto.toEntity(order.getUser(), order);

        handmadeRepository.save(handmadeBurgerOrderDetail);
    }
}

