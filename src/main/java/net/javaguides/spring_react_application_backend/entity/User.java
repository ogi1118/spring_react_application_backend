package net.javaguides.spring_react_application_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToMany/*多対多を表す(中間テーブルも自動生成、変数の型を参照して自動でどのエンティティと紐づけるかまで拾う)*/(
            fetch = FetchType.EAGER /*データ取得タイミング(EAGER：即時)*/,
            cascade = CascadeType.ALL /*紐づいたエンティティにした操作が紐づけ先にも同様に行われる(ALL：全ての操作)*/)
    @JoinTable(/*中間テーブルの詳細設定(無い場合は自動で規則的に決まる)*/
            name = "users_roles",
            joinColumns = @JoinColumn/*これが記述されている側のカラム*/(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn/*紐づけ先のカラム*/(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles; // 1人が複数ロール持つこともある(権限は独立している設計のため)
}
