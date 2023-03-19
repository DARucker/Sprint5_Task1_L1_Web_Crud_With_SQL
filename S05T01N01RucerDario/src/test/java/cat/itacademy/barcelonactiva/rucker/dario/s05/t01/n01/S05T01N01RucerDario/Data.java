package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario;

import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.dto.Branchdto;

import java.util.Optional;

public class Data {

    public static Optional<Branchdto> createBranch1(){
        return Optional.of(new Branchdto(1, "Ma1", "spain", "UE ok"));
    }

}
