package com.olzhas.justforfun.service;

import com.olzhas.justforfun.dao.ItemDao;
import com.olzhas.justforfun.dto.ItemDto;
import com.olzhas.justforfun.entity.Item;
import com.olzhas.justforfun.exception.NotFoundException;
import com.olzhas.justforfun.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemMapper itemMapper;
    final ItemDao itemDao;

    @Transactional
    public void save(ItemDto itemDto) {
        itemDao.save(itemMapper.toItem(itemDto));
    }

    @Transactional
    public void update(ItemDto itemDto, Long id) {
        Item item = itemDao.findById(id)
                .orElseThrow(() -> new NotFoundException("Item not found"));
        if (item.getName()!=null){
            item.setName(itemDto.getName());
        }
        if (item.getDescription()!=null){
            item.setDescription(itemDto.getDescription());
        }
        if (item.getPrice()!=null){
            item.setPrice(itemDto.getPrice());
        }
        itemDao.save(item);
    }

    @Transactional
    public void delete(Long id) {
        Item item = itemDao.findById(id)
                .orElseThrow(() -> new NotFoundException("Item not found"));
        itemDao.delete(item);
    }

    @Transactional(readOnly = true)
    public ItemDto getItem(Long id) {
        Item item = itemDao.findById(id)
                .orElseThrow(() -> new NotFoundException("Item not found"));
        return itemMapper.toItemDto(item);
    }

    @Transactional(readOnly = true)
    public List<ItemDto> findAll() {
        return itemMapper.toItemDtoList(itemDao.findAll());
    }
}
