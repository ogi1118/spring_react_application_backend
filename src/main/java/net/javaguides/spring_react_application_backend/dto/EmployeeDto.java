package net.javaguides.spring_react_application_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Dtoクラス：Service-Controller-Client間でデータをやり取りするためのクラス。
// エンティティ(データ実体、DBテーブルのレコード)全体を持たずに必要なデータのみやり取りできるようにする目的がある
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
