package com.product.service;

import com.product.entity.Product;
import com.product.grpc.ProductRequest;
import com.product.grpc.ProductResponse;
import com.product.grpc.ProductServiceGrpc;
import com.product.grpc.Status;
import com.product.repository.ProductRepository;
import io.grpc.stub.StreamObserver;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository productRepository;

    @PostConstruct
    public void createProducts() {
        productRepository.saveAll(List.of(
                Product.builder()
                        .name("Iphone X")
                        .price(1000D)
                        .quantity(10)
                        .colors("White,Black")
                        .userId(1)
                        .build(),
                Product.builder()
                        .name("Iphone 11")
                        .price(1500D)
                        .quantity(5)
                        .colors("White,Black,Purple")
                        .userId(1)
                        .build()
        ));
    }

    @Override
    public void getProducts(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        List<com.product.grpc.Product> products = productRepository.findAllByUserId(request.getUserId())
                .stream()
                .map(this::getProduct)
                .collect(Collectors.toList());
        responseObserver.onNext(ProductResponse.newBuilder()
                .addAllProducts(products)
                .build());
        responseObserver.onCompleted();
    }

    private com.product.grpc.Product getProduct(Product product) {
        return com.product.grpc.Product.newBuilder()
                .setStatus(Status.STOCK_IN)
                .setName(product.getName())
                .setPrice(product.getPrice())
                .setQuantity(product.getQuantity())
                .addAllColors(Arrays.stream(product.getColors().split(",")).collect(Collectors.toList()))
                .putSpecifications("RAM", "128MB")
                .putSpecifications("Internal Storage", "4GB")
                .build();
    }

}
