package br.com.blecaute.store.dto.order;

import br.com.blecaute.store.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class OrderUpdateDTO {

    private OrderStatus orderStatus;

}
