package org.esfe.Practica20240730AMMA.controladores;

import org.esfe.Practica20240730AMMA.modelos.ProductoAMMA;
import org.esfe.Practica20240730AMMA.servicios.interfaces.IProductoAMMAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/productos")
public class ProductoAMMAController {

    @Autowired
    private IProductoAMMAService productoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<ProductoAMMA> productos = productoService.buscarTodosPaginados(pageable);
        model.addAttribute("productos", productos);

        int totalPages = productos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "productos/index";
    }



    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("producto", new ProductoAMMA());
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("producto") ProductoAMMA producto, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("producto", producto);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "productos/create";
        }

        productoService.crearOEditar(producto);
        attributes.addFlashAttribute("msg", "Producto creado correctamente");
        return "redirect:/productos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Optional<ProductoAMMA> producto = productoService.buscarPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "productos/details";
        } else {
            return "redirect:/productos";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Optional<ProductoAMMA> producto = productoService.buscarPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "productos/edit";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("producto") ProductoAMMA producto, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("producto", producto);
            return "productos/edit";
        }

        productoService.crearOEditar(producto);
        attributes.addFlashAttribute("msg", "Producto actualizado correctamente");
        return "redirect:/productos";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<ProductoAMMA> producto = productoService.buscarPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "productos/delete";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes attributes) {
        productoService.eliminarPorId(id);
        attributes.addFlashAttribute("msg", "Producto eliminado correctamente");
        return "redirect:/productos";
    }
}
