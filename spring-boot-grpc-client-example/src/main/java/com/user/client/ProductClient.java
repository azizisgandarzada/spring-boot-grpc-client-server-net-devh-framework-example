package com.user.client;

import com.user.client.dto.ProductDto;
import com.user.grpc.ProductRequest;
import com.user.grpc.ProductResponse;
import com.user.grpc.ProductServiceGrpc;
import java.util.List;
import java.util.stream.Collectors;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ProductClient {

    @GrpcClient("product-service")
    private ProductServiceGrpc.ProductServiceBlockingStub stub;

    public List<ProductDto> getProducts(Integer userId) {
        ProductResponse productResponse = this.stub.getProducts(ProductRequest.newBuilder()
                .setUserId(userId)
                .build());
        return productResponse.getProductsList()
                .stream()
                .map(product -> ProductDto.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .colors(product.getColorsList())
                        .specifications(product.getSpecificationsMap())
                        .status(product.getStatus().name())
                        .build())
                .collect(Collectors.toList());
    }

}
