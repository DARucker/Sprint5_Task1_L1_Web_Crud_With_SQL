package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.service;

import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.domain.Branch;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.dto.Branchdto;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements IBranchService{

    @Autowired
    private BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
    }

    @Override
    public List<Branchdto> listAll() {

        return branchRepository.findAll().stream()
                .map(x -> entityToDto(x)) // Another option using reference method: .map(this::entityToDto)
                .collect(Collectors.toList());
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
    public Branchdto findById(int id) {

        return entityToDto(branchRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(Branchdto branchto) {
       branchRepository.delete(dtoToEntity(branchto));

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
    public Branch dtoToEntity (Branchdto branchdto){
        Branch branch = new Branch();
        branch.setId(branchdto.getId());
        branch.setName(branchdto.getName());
        branch.setCountry(branchdto.getCountry());
        return branch;
    }
}
