package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.controller;

import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.domain.Branch;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.service.IBranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchController {

    private static Logger LOG = LoggerFactory.getLogger(BranchController.class);

    @Autowired
    private IBranchService branchService;

    @GetMapping ("/add")
    public String addBranch(Model model){
        Branch branch = new Branch();
        model.addAttribute("title", "CREATE NEW BRANCH");
        model.addAttribute("branch", branch);
        return "/branches/add";
    }



    @GetMapping("/getAll")
    public String getAllBranches(Model model){

        List<Branch> branchList = branchService.listAll(); // cambiar a DTO
        LOG.info("List requested by client" + branchList);
        model.addAttribute("title", "Branch list");
        model.addAttribute("branchList", branchList);
        return "/branches/getAll";


    }





}
