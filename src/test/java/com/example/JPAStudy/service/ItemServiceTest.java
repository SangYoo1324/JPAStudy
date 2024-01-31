package com.example.JPAStudy.service;

import com.example.JPAStudy.entity.CompleteItemConfig;
import com.example.JPAStudy.entity.ConfigOption;
import com.example.JPAStudy.entity.Item;
import com.example.JPAStudy.repo.CompleteItemConfigRepository;
import com.example.JPAStudy.repo.ConfigOptionRepository;
import com.example.JPAStudy.repo.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ItemServiceTest {

    @Autowired
    private  ItemRepository itemRepository;
    @Autowired
    private ConfigOptionRepository configOptionRepository;
    @Autowired
    private CompleteItemConfigRepository completeItemConfigRepository;

    @Test
    void testSequence() {
        persistTest();
        fetchingTest();
//        cascadeRemovalTest();

    }







    // item이 지워지면 연관된 configOption도 지워지는지 테스트
    @Test
    void cascadeRemovalTest(){
        // item은 연관관계의 주인이 아니기 때문에 삭제 쿼리 불가능
//        itemRepository.delete(itemRepository.findById(1000l).orElse(null));

        // configOption에서는 삭제가 가능하다
        completeItemConfigRepository.delete(completeItemConfigRepository.findById(1l).orElse(null));
    }

    @Test
    void persistTest(){

        completeItemConfigRepository.save(CompleteItemConfig.builder()
                        .item(Item.builder().name("itemTest").build())
                        .configOption(ConfigOption.builder().name("configTest").build())
                .build());

    }

    @Test
    void fetchingTest(){
        itemRepository.findById(1000l).orElse(null).getCompleteItemConfigs().stream().forEach(e->{
            log.info(e.getId().toString());
        });
    }
}