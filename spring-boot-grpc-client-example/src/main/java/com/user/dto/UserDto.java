package com.user.dto;

import com.user.client.dto.ProductDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String surname;
    private String birthdate;
    private List<ProductDto> products;


}
