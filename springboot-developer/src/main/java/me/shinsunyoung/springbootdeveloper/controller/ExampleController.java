package me.shinsunyoung.springbootdeveloper.controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller //컨트롤러 라는 것을 명시적으로 표시
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model) { // 뷰로 데이터를 넘겨주는 모델 객체
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("도건우");
        examplePerson.setAge(24);
        examplePerson.setHobbies(List.of("운동", "코딩"));

        model.addAttribute("person", examplePerson); //person 객체 저장
        model.addAttribute("today", LocalDate.now());

        return "example"; //exmaple.html라는 뷰 조회
    }

    @Getter
    @Setter
    private class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}
