package org.esfe.Practica20240730AMMA.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.esfe.Practica20240730AMMA.modelos.ProductoAMMA;
import org.esfe.Practica20240730AMMA.repositorios.IProductosAMMARepository;
import org.esfe.Practica20240730AMMA.servicios.interfaces.IProductoAMMAService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoAMMAService implements IProductoAMMAService{
@Autowired
    private IProductosAMMARepository productoRepository;

    @Override
    public Page<ProductoAMMA> buscarTodosPaginados(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public List<ProductoAMMA> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<ProductoAMMA> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public ProductoAMMA crearOEditar(ProductoAMMA productoAMMA) {
        return productoRepository.save(productoAMMA);
    }

    @Override
    public void eliminarPorId(Long id) {
        productoRepository.deleteById(id);
    }
}
