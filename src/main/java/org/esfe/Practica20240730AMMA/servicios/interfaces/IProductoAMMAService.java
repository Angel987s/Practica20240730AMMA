package org.esfe.Practica20240730AMMA.servicios.interfaces;

import org.esfe.Practica20240730AMMA.modelos.ProductoAMMA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductoAMMAService {
    Page<ProductoAMMA> buscarTodosPaginados(Pageable pageable);

    List<ProductoAMMA> obtenerTodos();

    Optional<ProductoAMMA> buscarPorId(Long id);

    ProductoAMMA crearOEditar(ProductoAMMA productoAMMA);

    void eliminarPorId(Long id);
}
