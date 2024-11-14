package com.spring.crud_carros.controllers;

//coe Sabrina ou Kaynan corrige com carinho nmrl
import com.spring.crud_carros.models.ProdutoDTO;
import com.spring.crud_carros.models.Produtos;
import com.spring.crud_carros.services.RepositorioProdutos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private RepositorioProdutos repo;

    @GetMapping({"","/"})
    public String showListaProdutos (Model model){
        List<Produtos> produtos = repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
        model.addAttribute("produtos",produtos);
        return "produtos/carros";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        model.addAttribute("produtoDTO",produtoDTO);
        return  "produtos/criacao";
    }

    @PostMapping("/create")
    public String criarProduto(
            @Valid @ModelAttribute ProdutoDTO produtoDTO,
            BindingResult result
    ){
        if(result.hasErrors()){
            return "produtos/criacao";
        }

        Produtos produto = new Produtos();
        produto.setModelo(produtoDTO.getModelo());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setAno(produtoDTO.getAno());
        produto.setMarca(produtoDTO.getMarca());
        produto.setMotor(produtoDTO.getMotor());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidade(produtoDTO.getQuantidade());
        repo.save(produto);


        return "redirect:/produtos";
    }
    @GetMapping("/edit")
    public String showPaginaEdicao(
            Model model,
            @RequestParam int id){
        try{
            Produtos produtos = repo.findById(id).get();
            model.addAttribute("produto", produtos);

            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setModelo(produtos.getModelo());
            produtoDTO.setDescricao(produtos.getDescricao());
            produtoDTO.setAno(produtos.getAno());
            produtoDTO.setMarca(produtos.getMarca());
            produtoDTO.setMotor(produtos.getMotor());
            produtoDTO.setPreco(produtos.getPreco());
            produtoDTO.setQuantidade(produtos.getQuantidade());

            model.addAttribute("produtoDTO",produtoDTO);


        }
        catch (Exception ex){
            System.out.println("Exception" + ex.getMessage());
            return "redirect:/produtos";
        }
        return "produtos/edicao";
    }

    @PostMapping("/edit")
    public String editarProduto(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute ProdutoDTO produtoDTO,
            BindingResult result
    ){
        try{
            Produtos produtos = repo.findById(id).get();
            model.addAttribute("produto",produtos);

            if (result.hasErrors()){
                return "produtos/edicao";
            }
            produtos.setModelo(produtoDTO.getModelo());
            produtos.setDescricao(produtoDTO.getDescricao());
            produtos.setAno(produtoDTO.getAno());
            produtos.setMarca(produtoDTO.getMarca());
            produtos.setMotor(produtoDTO.getMotor());
            produtos.setPreco(produtoDTO.getPreco());
            produtos.setQuantidade(produtoDTO.getQuantidade());
            repo.save(produtos);
        }catch (Exception ex){
            System.out.println("Exception" + ex.getMessage());
        }

        return "redirect:/produtos";
    }

    @GetMapping("/delete")
    public String deletarCarro(
            @RequestParam int id
    ){

        try {
            Produtos produtos = repo.findById(id).get();
            repo.delete(produtos);
        } catch (Exception ex) {
            System.out.println("Exception" + ex.getMessage());
        }
        return "redirect:/produtos";
    }
}
