package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity @Builder
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Pattern(regexp = "[A-Z]{1}[a-z]{1}[0-9]{1}")
    private String name;
    @NotEmpty
    private String country;


}
