package br.com.blecaute.store.service;

import br.com.blecaute.store.dto.order.OrderCreateDTO;
import br.com.blecaute.store.dto.order.OrderUpdateDTO;
import br.com.blecaute.store.exception.address.AddressNotFoundException;
import br.com.blecaute.store.exception.order.OrderNotFoundException;
import br.com.blecaute.store.exception.product.ProductNotFoundException;
import br.com.blecaute.store.exception.user.UserNotFoundException;
import br.com.blecaute.store.model.Order;
import br.com.blecaute.store.model.OrderStatus;
import br.com.blecaute.store.model.User;
import br.com.blecaute.store.repository.AddressRepository;
import br.com.blecaute.store.repository.OrderRepository;
import br.com.blecaute.store.repository.ProductRepository;
import br.com.blecaute.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class OrderService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findByUserId(long userId) {
        return userRepository.findById(userId)
                .map(User::getOrders)
                .orElseThrow(UserNotFoundException::new);
    }

    public Order save(OrderCreateDTO order) {
        final var user = userRepository.findById(order.getUserId()).orElseThrow(UserNotFoundException::new);
        final var address = addressRepository.findByIdAndUserId(order.getAddressId(), user.getId())
                .orElseThrow(AddressNotFoundException::new);

        final var products = productRepository.findAllById(order.getProducts());
        if (products.size() != order.getProducts().size()) {
            throw new ProductNotFoundException();
        }

        return orderRepository.save(Order.builder()
                .user(user)
                .address(address)
                .products(products)
                .status(OrderStatus.WAITING_PAYMENT)
                .createdAt(new Date())
                .build());
    }

    public Order update(long id, OrderUpdateDTO dto) {
        final var order = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);

        if (dto.getOrderStatus() != null) {
            order.setStatus(dto.getOrderStatus());
        }

        return orderRepository.save(order);
    }

    public void delete(long id) {
        orderRepository.delete(orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new));
    }

}
