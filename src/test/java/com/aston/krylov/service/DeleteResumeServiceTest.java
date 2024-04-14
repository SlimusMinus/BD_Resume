package com.aston.krylov.service;

import com.aston.krylov.repository.DeleteResume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class DeleteResumeServiceTest {
    @Mock
    private DeleteResume deleteResume;
    @InjectMocks
    private DeleteResumeService deleteResumeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDeleteResume() {
        Long id = 123L;
        deleteResumeService.deleteResume(id);

        // Проверяем, что метод delete был вызван с правильным аргументом
        verify(deleteResume).delete(id);
    }
}