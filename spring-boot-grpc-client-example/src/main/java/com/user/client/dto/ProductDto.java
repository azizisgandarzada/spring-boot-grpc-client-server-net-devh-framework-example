package com.user.client.dto;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    String name;
    Double price;
    Integer quantity;
    List<String> colors;
    String status;
    Map<String, String> specifications;

}
