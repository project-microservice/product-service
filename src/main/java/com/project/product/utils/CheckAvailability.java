package com.project.product.utils;

import com.project.product.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public class CheckAvailability {
    public static <T, U, R extends JpaRepository<T, U>> T checkOptionalEntity(
            R repository,
            U id,
            String resourceName,
            String fieldName
    ) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(resourceName, fieldName, id.toString()));
    }
}
