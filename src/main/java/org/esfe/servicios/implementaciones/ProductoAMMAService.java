package org.esfe.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.esfe.modelos.ProductoAMMA;
import org.esfe.repositorios.IProductosAMMARepository;
import org.esfe.servicios.interfaces.IProductoAMMAService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public class ProductoAMMAService implements IProductoAMMAService{
@Autowired
    private IProductosAMMARepository grupoRepository;

    @Override
    public Page<ProductoAMMA> buscarTodosPaginados(Pageable pageable) {
        return grupoRepository.findAll(pageable);
    }

    @Override
    public List<ProductoAMMA> obtenerTodos() {
        return grupoRepository.findAll();
    }

    @Override
    public Optional<ProductoAMMA> buscarPorId(Integer id) {
        return grupoRepository.findById(id);
    }

    @Override
    public ProductoAMMA crearOEditar(ProductoAMMA productoAMMA) {
        return grupoRepository.save(productoAMMA);
    }

    @Override
    public void eliminarPorId(Integer id) {
        grupoRepository.deleteById(id);
    }
}
