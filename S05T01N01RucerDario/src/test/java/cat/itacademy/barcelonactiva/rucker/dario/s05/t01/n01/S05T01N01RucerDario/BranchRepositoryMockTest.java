package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario;

import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.domain.Branch;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.repository.BranchRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @DataJpaTest works with H2 Database
 * @AutoConfigureTestDataBase works with MySQL
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BranchRepositoryMockTest {

    @Autowired
    private BranchRepository branchRepository;

    @Test
    public void WhenSave_ThenReturnNotNull(){
        Branch branch = new Branch(1,"Sp3", "Spain");
        Branch found = branchRepository.save(branch);
        assertNotNull(found);
    }

    /**
     * This test doesnt work with MySQL because the execution of other test modifies
     * the id count even if the rollback clause is true
     */
    @Test
    @Rollback(false)
    public void WhenFindById_ThenReturnBranch(){

        Branch branch1 = new Branch(1, "Sp3", "France");
        branchRepository.save(branch1);
        Branch found1 = branchRepository.findById(1).orElse(null);
        Assertions.assertTrue(found1.getCountry().equalsIgnoreCase("France"));
    }
    @Test
    public void WhenList_ThenReturnSize(){

        Branch branch2 = new Branch(1, "Sp1", "Spain");
        Branch branch3 = new Branch(2, "Sp2", "Spain");
        branchRepository.save(branch2);
        branchRepository.save(branch3);

        List<Branch> found2 = branchRepository.findAll();
        Assertions.assertTrue(found2.size() == 6);
    }

    @Test
    public void WhenDelete_thenReturnTrue(){
        int id = 1;
        boolean existBeforDeleting = branchRepository.findById(id).isPresent();
        branchRepository.deleteById(id);
        boolean NoExistAfeterDelete  = branchRepository.findById(id).isPresent();

        assertFalse(existBeforDeleting);
        assertFalse(NoExistAfeterDelete);
    }

}
