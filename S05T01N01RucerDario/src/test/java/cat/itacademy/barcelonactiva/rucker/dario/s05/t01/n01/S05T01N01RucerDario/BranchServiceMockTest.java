package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario;

import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.domain.Branch;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.dto.Branchdto;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.repository.BranchRepository;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.service.BranchServiceImpl;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.service.IBranchService;
import org.springframework.boot.test.context.SpringBootTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;


@SpringBootTest
public class BranchServiceMockTest {

    @Mock
    private BranchRepository branchRepository;

    private IBranchService branchService;

    public BranchServiceMockTest() {
    }

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        branchService = new BranchServiceImpl(branchRepository);

        Branchdto branchdto01 = Branchdto.builder()
                .id(1)
                .name("Ar1")
                .country("Argentina")
                .branchType("no EU")
                .build();

        Mockito.when(branchRepository.findById(1))
                .thenReturn(Optional.of(branch01));

        Mockito.when(branchRepository.save(branchdto01))
                .thenReturn(branchdto01);

    }
    @Test
    public void whenFindById_ThenReturnBrach(){
        Branch found = branchService.findById(1);
        Assertions.assertThat(found.getName()).isEqualTo("Ar1");
    }
    @Test
    public void WhenUpdateCantKilos_ThenReturnNewCantKilos(){
        Fruit fruta = new Fruit(1, "apple", 20);
        Fruit newCantKilos = iFruitService.updateFruit(fruta);
        Assertions.assertThat(newCantKilos.getCantidadkilos()).isEqualTo(20);
    }
}
