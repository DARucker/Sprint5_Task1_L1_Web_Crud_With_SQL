package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.service;

import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.domain.Branch;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.dto.Branchdto;

import java.util.List;
import java.util.Optional;

public interface IBranchService {

    List<Branchdto> listAll();
    Branch save (Branch branch);
    Branch update (Branch branch);
    Branchdto findById(int id);
    void delete(Branchdto branchdto);

}
