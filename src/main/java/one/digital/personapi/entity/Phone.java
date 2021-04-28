package one.digital.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.personapi.entity.enums.PhoneType;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
