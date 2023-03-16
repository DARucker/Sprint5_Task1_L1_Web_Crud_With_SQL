package cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.controller;

import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.domain.Branch;
import cat.itacademy.barcelonactiva.rucker.dario.s05.t01.n01.S05T01N01RucerDario.service.IBranchService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchController {

    private static Logger LOG = LoggerFactory.getLogger(BranchController.class);

    @Autowired
    private IBranchService branchService;

   @GetMapping ("/create")
    public String addBranch(Model model){
        Branch branch = new Branch();
        model.addAttribute("title", "CREATE NEW BRANCH");
        model.addAttribute("branch", branch);
        return "/branches/add";
    }

    @PostMapping ("/add")
    public String addBranch(@Valid @ModelAttribute Branch branch, BindingResult result, Model model, RedirectAttributes attribute){
       if(result.hasErrors()){
           model.addAttribute("title", "CREATE NEW BRANCH");
           model.addAttribute("branch", branch);
           LOG.error("please check the data");
           return "/branches/add";
       }
        LOG.info("Branch to insert into database: " + branch);
        branchService.save(branch);
        attribute.addFlashAttribute("success", "Branch created succefully");
        return "redirect:/branch/getAll";
    }


    @GetMapping("/getAll")
    public String getAllBranches(Model model){

        List<Branch> branchList = branchService.listAll(); // cambiar a DTO
        LOG.info("List requested by client" + branchList);
        model.addAttribute("title", "Branch list");
        model.addAttribute("branchList", branchList);
        return "/branches/getAll";
    }

    @GetMapping ("/edit/{id}")
    public String editBranch(@PathVariable ("id") int branchId, Model model, RedirectAttributes attribute){

        Branch branch = null;
        if(branchId > 0 ){
            branch = branchService.findById(branchId);
            if(branch == null){
                attribute.addFlashAttribute("error", "the branch does not exist");
                LOG.info("Branch does not exist ");
                return "redirect:/branch/getAll";
            }
        }

        LOG.info("Branch to edit " + branch);
        model.addAttribute("title", "EDIT BRANCH");
        model.addAttribute("branch", branch);
        return "/branches/add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ("id") int branchId, RedirectAttributes attribute){

        Branch branch = null;
        if(branchId > 0 ){
            branch = branchService.findById(branchId);
            if(branch == null){
                attribute.addFlashAttribute("error", "the branch does not exist");
                LOG.info("Branch does not exist ");
                return "redirect:/branch/getAll";
            }
        }
        attribute.addFlashAttribute("warning", "the branch was deleted");
        LOG.info("Branch to delete " + branch);
        branchService.delete(branch);
        return "redirect:/branch/getAll";
    }

}
