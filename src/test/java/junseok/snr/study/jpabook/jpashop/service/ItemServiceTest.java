package junseok.snr.study.jpabook.jpashop.service;

import junseok.snr.study.jpabook.jpashop.domain.item.Album;
import junseok.snr.study.jpabook.jpashop.domain.item.Item;
import junseok.snr.study.jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    void 상품_등록_테스트() {
        final Item item = new Album();
        final Long savedId = itemService.saveItem(item);
        final Item savedItem = itemRepository.findOne(savedId);

        assertEquals(item, savedItem);
    }

}