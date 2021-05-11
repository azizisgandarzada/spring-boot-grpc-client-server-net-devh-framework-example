package com.user.mapper;

import com.user.client.dto.ProductDto;
import com.user.dto.UserDto;
import com.user.entity.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(source = "products", target = "products")
    UserDto toDto(User user, List<ProductDto> products);

}
