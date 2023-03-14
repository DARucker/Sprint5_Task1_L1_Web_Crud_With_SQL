package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.service;

import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.domain.Branch;

import java.util.List;
import java.util.Optional;

public interface IBranchService {

    List<Branch> listAll();
    Branch save (Branch branch);
    Branch update (Branch branch);
    Branch findById(int id);
    void delete(Branch branch);

}
