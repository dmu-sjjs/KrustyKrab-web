package js.krustykrab.dto.order;

import js.krustykrab.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper mapper = Mappers.getMapper(OrderMapper.class);


    OrderDto orderEntityToDto(Order order);
    Order orderDtoToEntity(OrderDto orderDto);

}
