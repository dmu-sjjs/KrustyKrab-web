package js.krustykrab.dto.order;

import js.krustykrab.domain.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper mapper = Mappers.getMapper(OrderMapper.class);


    OrderDto orderEntityToDto(Order order);

}
