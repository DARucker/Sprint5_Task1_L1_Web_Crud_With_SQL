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

    //public BranchServiceMockTest() {
    //}

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        branchService = new BranchServiceImpl(branchRepository);

            // Given
            Branch branch01 = Branch.builder()
                    .id(1)
                    .name("Ar2")
                    .country("Argentina")
                    .build();
            // When
            Mockito.when(branchRepository.findById(1)).thenReturn(Optional.of(branch01));
        }

        @Test
        public void whenFindById_ThenReturnBrach () {

            Branchdto found = branchService.findById(1);
            // Then
            Assertions.assertThat(found.getName()).isEqualTo("Ar2");

        }

        @Test
        public void WhenFindById_ThenTestEntityToDtoMethod() {
            Branchdto found = branchService.findById(1);
            Assertions.assertThat(found.getBranchType()).isEqualTo("no EU");
        }
    }
