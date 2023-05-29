package com.farmer.service;

import com.farmer.exception.ItemNotFoundException;
import com.farmer.model.Item;
import com.farmer.repository.ItemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

  private final ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public Item getItem(long id) {
    Optional<Item> itemOptional = itemRepository.findById(id);
    if (itemOptional.isPresent()) {
      return itemOptional.get();
    }
    throw new ItemNotFoundException("Item not Found for Id" + id);
  }

  public Item saveItem(Item item) {
    return itemRepository.save(item);
  }

  public Item updateItem(Item item) {
    return itemRepository.save(item);
  }

  public List<Item> getAllItem() {
    return itemRepository.findAll();
  }
}
