package org.esfe.servicios.interfaces;

import org.esfe.modelos.ProductoAMMA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductoAMMAService {
    Page<ProductoAMMA> buscarTodosPaginados(Pageable pageable);

    List<ProductoAMMA> obtenerTodos();

    Optional<ProductoAMMA> buscarPorId(Integer id);

    ProductoAMMA crearOEditar(ProductoAMMA productoAMMA);

    void eliminarPorId(Integer id);
}
