package org.zerock.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookServiceTest {
    @Autowired
    GuestbookService guestbookService;

//    @Test
//    void register() {
//        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
//                .title("title on GuestbookService")
//                .content("content on GuestbookService")
//                .writer("writer on GuestbookService").build();
//        System.out.println("gno :: >>>"+guestbookService.register(guestbookDTO));
//    }
//    @Test
//    void testList() {
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().
//                page(1).size(10).build();
//        PageResultDTO<GuestbookDTO, Guestbook> requestDTO =
//                guestbookService.getList(pageRequestDTO);
//        for (GuestbookDTO dto : requestDTO.getDtoList()) {
//            System.out.println(dto);
//        }
//    }

    @Test
    public void testPageNumberList() {
        PageRequestDTO pageResultDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO =
                guestbookService.getList(pageResultDTO);
        System.out.println("prev :: " + resultDTO.isPrev());
        System.out.println("next :: " + resultDTO.isNext());
        System.out.println("total :: " + resultDTO.getTotalPage());
        System.out.println("--------------------------------------");
        for (GuestbookDTO dto : resultDTO.getDtoList()) {
            System.out.println(dto);
        }
        System.out.println("page number---------------------------");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}