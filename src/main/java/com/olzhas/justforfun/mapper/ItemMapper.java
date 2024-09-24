package com.olzhas.justforfun.mapper;

import com.olzhas.justforfun.dto.ItemDto;
import com.olzhas.justforfun.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto toItemDto(Item item);
    Item toItem(ItemDto item);
    List<ItemDto> toItemDtoList(List<Item> items);
    List<Item> toItemList(List<ItemDto> itemDtos);
}
