package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.service;

import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.domain.Branch;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.dto.Branchdto;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements IBranchService{

    @Autowired
    private BranchRepository branchRepository;


    @Override
    public List<Branch> listAll() {
        return (List<Branch>) branchRepository.findAll();
    }

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch update(Branch branch) {
        return null;
    }

    @Override
    public Branch findById(int id) {
        return branchRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Branch branch) {
        branchRepository.delete(branch);
    }

    public Branchdto entityToDto(Branch branch){

        Branchdto branchdto = new Branchdto();
        branchdto.setId(branch.getId());
        branchdto.setName(branch.getName());
        branchdto.setCountry(branch.getCountry());

        boolean eu = branchdto.getCountrys().stream()
                .anyMatch(x -> x.equalsIgnoreCase(branch.getCountry()));
        if(eu){
            branchdto.setBranchType("EU");
        }else {
            branchdto.setBranchType("no EU");
        }
        return branchdto;
    }

}
