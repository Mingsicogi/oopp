package mins.study.oopp.theater;

import lombok.Getter;

@Getter
public class Employee {

    private Long id;

    private String name;
    private String phone;
    private Integer age;

    public Employee(String name, String phone, Integer age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }
}
